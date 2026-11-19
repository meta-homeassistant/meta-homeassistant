# Export validation inputs during a signature-only BitBake invocation.
addhandler ha_ci_signatures
ha_ci_signatures[eventmask] = "bb.event.DepTreeGenerated"
python ha_ci_signatures() {
    import json
    from pathlib import Path

    siggen = bb.parse.siggen
    tasks = {}
    for tid, taskhash in siggen.taskhash.items():
        mc, _, task, fn = bb.runqueue.split_tid_mcfn(tid)
        pn = siggen.datacaches[mc].pkg_fn[fn]
        name = ("%s.%s" % (pn, task)) if not mc else ("mc:%s:%s.%s" % (mc, pn, task))
        tasks[name] = (tid, taskhash)

    result = {}
    for target in d.getVar("HA_CI_SIGNATURE_TARGETS").split():
        name = target + ".do_testimage"
        image = target + ".do_image_complete"
        dependencies = e._depgraph["tdepends"].get(name, [])
        if name not in tasks or image not in dependencies:
            bb.fatal("Missing testimage/image dependency for CI target %s" % target)
        tid = tasks[name][0]
        # do_testimage is nostamp: its taskhash contains a new random taint on
        # every invocation. Keep its actual inputs, not that execution nonce.
        result[target] = {
            "basehash": siggen.basehash[tid],
            "file_checksums": sorted(siggen.file_checksum_values[tid]),
            "dependencies": {dep: tasks[dep][1] for dep in sorted(dependencies)},
        }

    path = Path(d.getVar("HA_CI_SIGNATURE_OUTPUT"))
    path.write_text(json.dumps(result, sort_keys=True))
}
