package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandName.*;
import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * Help {@link Command}.
 */
@AllArgsConstructor
public class HelpCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    public static final String HELP_MESSAGE = String.format("""
            ✨<b>Available commands</b>✨

            <b>Start\\Stop Bot</b>
            %s - start using
            %s - stop using

            %s - help section
            """, START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, HELP_MESSAGE);
    }

}
