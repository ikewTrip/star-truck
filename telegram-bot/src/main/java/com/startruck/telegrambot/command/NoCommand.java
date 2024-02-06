package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * No {@link Command}.
 */
@AllArgsConstructor
public class NoCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, NO_MESSAGE);
    }
}
