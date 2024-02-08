package com.startruck.telegrambot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

/**
 * Service for sending messages via telegram-bot.
 */
public interface BotSendMessageService {

    /**
     * Send message via telegram bot.
     *
     * @param chatId provided chatId in which messages would be sent.
     * @param message provided a message to be sent.
     */
    void sendMessage(Long chatId, String message);

    /**
     * Send messages via telegram bot.
     *
     * @param chatId  provided chatId in which would be sent.
     * @param message collection of provided messages to be sent.
     */
    void sendMessage(Long chatId, List<String> message);

    /**
     * Send a message with a menu via telegram bot.
     *
     * @param chatId provided chatId in which messages would be sent.
     * @param message provided a message to be sent.
     * @param menu provided an inline menu to be sent.
     */
    void sendMessage(Long chatId, String message, InlineKeyboardMarkup menu);

}
