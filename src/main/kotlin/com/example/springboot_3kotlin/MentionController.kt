package com.example.springboot_3kotlin

import com.linecorp.bot.model.event.MessageEvent
import com.linecorp.bot.model.event.message.MessageContent
import com.linecorp.bot.model.event.message.TextMessageContent
import com.linecorp.bot.model.message.Message
import com.linecorp.bot.model.message.TextMessage
import com.linecorp.bot.spring.boot.annotation.EventMapping
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler
import org.springframework.stereotype.Controller


@LineMessageHandler
@Controller
class MessageController {

    @EventMapping
    fun handleMessage(event: MessageEvent<TextMessageContent>): Message {
        val messageText = event.message.text
        return TextMessage("あなたが送信したメッセージ: " + messageText);
    }

}