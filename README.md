*ChatBot Demo*
==============

[![Build Status](https://travis-ci.org/css-ch/chatbot.svg?branch=master)](https://travis-ci.org/css-ch/chatbot) [![Stories in Ready](https://badge.waffle.io/css-ch/chatbot.png?label=ready&title=ready)](http://waffle.io/css-ch/chatbot) [![gitmoji](https://img.shields.io/badge/gitmoji-%20😜%20😍-FFDD67.svg)](https://gitmoji.carloscuesta.me)

**A demo of a simple chat bot using the Telegram API.**

*Copyright (C) 2017 Marcus Fihlon*

This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License along with this program.  If not, see <http://www.gnu.org/licenses/>.

## How to start

You need to have [git](https://git-scm.com) and [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or newer installed on your development machine.

### Step 1: Clone this repository

In a terminal/console execute the following command to clone this repository:

```
git clone https://github.com/css-ch/chatbot.git
```

### Step 2: Obtain an API token

Open your Telegram client and send the message `/newbot` to the [BotFather](https://t.me/BotFather). Answer the questions and write down the username you have choosen and the HTTP API token you got from the [BotFather](https://t.me/BotFather). Open the file [ChatBot.kt](https://github.com/css-ch/chatbot/blob/master/src/main/kotlin/ch/css/demo/chatbot/ChatBot.kt) in an editor or IDE of your choice and add the HTTP API token and the username to the functions with the approbate name.

### Step 3: Run the chat bot

In a terminal/console enter the project directory and execute the following command to build, test, assemble and start the chat bot:

```
./gradlew run
```

The first start may need some time to download the dependencies. The chat bot will be ready if you see the following message on standard out:

```
Chat bot is ready to talk!
```

## Throughput

[![Throughput Graph](https://graphs.waffle.io/css-ch/chatbot/throughput.svg)](https://waffle.io/css-ch/chatbot/metrics/throughput)
