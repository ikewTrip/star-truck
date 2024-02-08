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

    public final static String START_MESSAGE = """
            Hello! I can help you do some logbook manipulations \uD83D\uDE0A. If you're new to this, please see the /manual.

            You can use the following commands:
            /update_logbook - update your logbook
            /dot - notify about DOT inspection
            /subscription - subscription details
                                
            If you have any questions, feel free to use /help command.\uD83D\uDE09
            """;

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
