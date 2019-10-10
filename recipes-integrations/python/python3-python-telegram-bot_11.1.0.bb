# N.B. Before trying to upgrade to more recent version please
# check that the integration does support it
# At the moment stay at v11.1.0 because of the following error:
# .../homeassistant/components/telegram_bot/polling.py:79:
# TelegramDeprecationWarning: Old Handler API is deprecated
# see https://github.com/python-telegram-bot/python-telegram-bot/wiki/Transition-guide-to-Version-12.0

inherit setuptools3
require python-python-telegram-bot.inc
