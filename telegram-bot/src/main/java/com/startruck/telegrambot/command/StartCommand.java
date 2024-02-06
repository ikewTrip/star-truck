package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * Start {@link Command}.
 */
@AllArgsConstructor
public class StartCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    public final static String START_MESSAGE =
            "Some start message. Enjoy the Bot \uD83D\uDE0A. If you need help, just type /help.";

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
