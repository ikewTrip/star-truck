package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * UpdatedLogbook {@link Command}.
 */
public class UpdatedLogbookCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    private int hours = 0;

    public final static String UPDATED_LOGBOOK_MESSAGE = """
                    Your log has been successfully updated for <b>%d hours</b> &#x2714.

                    <b>Please, make sure you are synchronized with your application.</b>
                    Have a good ride \uD83D\uDE09.
                    """;

    public UpdatedLogbookCommand(BotSendMessageService botSendMessageService) {
        this.botSendMessageService = botSendMessageService;
    }

    @Override
    public void execute(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();

        Long chatId = callbackQuery.getMessage().getChatId();
        this.hours = Integer.parseInt(callbackQuery.getData());

        botSendMessageService.sendMessage(chatId, getFormattedUpdatedLogbookMessage());
    }

    private String getFormattedUpdatedLogbookMessage() {
        return String.format(UPDATED_LOGBOOK_MESSAGE, this.hours);
    }
}
