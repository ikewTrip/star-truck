package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

import static com.startruck.telegrambot.command.CommandUtils.getChatId;

/**
 * Subscription {@link Command}.
 */
@AllArgsConstructor
public class SubscriptionDetailsCommand implements Command {

    private final BotSendMessageService botSendMessageService;

    public final static String SUBSCRIPTION_MESSAGE = """
            <b>Subscription info</b> \uD83D\uDCB3

            Your current subscription plan is <b>Weekly</b> \uD83D\uDCC5.

            Submitted on <b>12-31-2025</b>.
            Expires on <b>01-07-2026</b>.
            """;

    @Override
    public void execute(Update update) {
        Long chatId = getChatId(update);
        botSendMessageService.sendMessage(chatId, SUBSCRIPTION_MESSAGE, getSubscriptionKeyboard());
    }

    private InlineKeyboardMarkup getSubscriptionKeyboard() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton weeklySubButton = new InlineKeyboardButton();
        weeklySubButton.setText("Renew your Weekly subscription");
        weeklySubButton.setCallbackData("renew_weekly");

        InlineKeyboardButton monthlySubButton = new InlineKeyboardButton();
        monthlySubButton.setText("Switch to a Monthly subscription");
        monthlySubButton.setCallbackData("renew_monthly");

        inlineKeyboardMarkup.setKeyboard(List.of(List.of(weeklySubButton), List.of(monthlySubButton)));

        return inlineKeyboardMarkup;
    }
}
