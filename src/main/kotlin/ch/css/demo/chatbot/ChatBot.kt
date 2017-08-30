/*
 * ChatBot – A demo of simple chat bot using the Telegram API.
 * Copyright (C) 2017 Marcus Fihlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package ch.css.demo.chatbot

import org.telegram.telegrambots.api.methods.send.SendMessage
import org.telegram.telegrambots.api.objects.Message
import org.telegram.telegrambots.api.objects.PhotoSize
import org.telegram.telegrambots.api.objects.Update
import org.telegram.telegrambots.bots.TelegramLongPollingBot

class ChatBot : TelegramLongPollingBot() {

    override fun getBotToken() = "" // TODO Ask BotFather for an API token and add it here!

    override fun getBotUsername() = "" // TODO Add the name of your bot here!

    override fun onUpdateReceived(update: Update?) {
        val message = update!!.message
        val text = if (message!!.text != null) message.text!!.toLowerCase() else null
        val photo = message.photo

        when {
            photo != null -> neueRechnung(message, photo)
            text!!.contains("rechnung") && text.contains("status") -> sendStatus(message)
            text.contains("rechnung") && text.contains("bezahlt") -> sendStatus(message)
            text.contains("rechnung") -> neueRechnung(message)
            text.contains("dank") -> danke(message)
            else -> sendHelp(message)
        }
    }

    fun danke(message: Message) {
        val response = SendMessage()
        response.setChatId(message.chatId)
        response.text = "Gern geschehen. Wenn du weitere Fragen hast, kannst du dich gerne jedereit an mich wenden."
        sendMessage(response)
    }

    fun neueRechnung(message: Message) {
        val response = SendMessage()
        response.setChatId(message.chatId)
        response.text = "Okay, du hast eine neue Rechnung für mich. Bitte mache ein Foto von der Rechnung und schicke es mir."
        sendMessage(response)
    }

    fun neueRechnung(message: Message, photo: List<PhotoSize>) {
        val response = SendMessage()
        response.setChatId(message.chatId)
        response.text = "Vielen Dank, ich habe dein Foto von der Rechnung bekommen. Ich werden sie bearbeiten und mich wieder bei dir melden!"
        sendMessage(response)
    }

    fun sendStatus(message: Message) {
        val response = SendMessage()
        response.setChatId(message.chatId)
        response.text = "Für deine vorletzte Rechnung 7364764736 vom 23. Juli 2017 habe ich dir am 3. August 2017 CHF 144.30 erstattet und auf dein Konto überwiesen."
        sendMessage(response)
        response.text = "Deine letzte Rechnung 8364529401 vom 21. August 2017 wird von mir gerade bearbeitet, bitte habe noch etwas Geduld."
        sendMessage(response)
    }

    fun sendHelp(message: Message) {
        val chat = message.chat
        val firstName = chat!!.firstName
        val response = SendMessage()
        response.setChatId(message.chatId)
        response.text = "Hallo ${firstName}, was kann ich für dich tun? Möchtest du mir eine neue Rechnung schicken oder den Status deiner aktuellen Rechnungen wissen?"
        sendMessage(response)
    }

}
