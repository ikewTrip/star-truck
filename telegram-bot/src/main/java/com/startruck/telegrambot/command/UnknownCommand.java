package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * Unknown {@link Command}.
 */
@AllArgsConstructor
public class UnknownCommand implements Command {

    public static final String UNKNOWN_MESSAGE =
            "Sorry, this is not supported \uD83D\uDE1F, type /help to see the list of supported commands.";

    private final BotSendMessageService botSendMessageService;

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, UNKNOWN_MESSAGE);
    }
}
