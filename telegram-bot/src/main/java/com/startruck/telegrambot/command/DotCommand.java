package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * DOT {@link Command}.
 */
@AllArgsConstructor
public class DotCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    private final static String DOT_MESSAGE = """
            The owner of the truck <b>has been notified</b> that a DOT inspection <b>has stopped you</b>.

            <b>Good luck!</b>
            """;

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, DOT_MESSAGE);
    }
}
