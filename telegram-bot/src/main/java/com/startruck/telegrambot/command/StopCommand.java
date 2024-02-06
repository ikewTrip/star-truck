package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * Stop {@link Command}.
 */
@AllArgsConstructor
public class StopCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    public final static String STOP_MESSAGE =
            "Some stop message \uD83D\uDE1F. If you want to use the bot again, just type /start.";

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, STOP_MESSAGE);
    }
}
