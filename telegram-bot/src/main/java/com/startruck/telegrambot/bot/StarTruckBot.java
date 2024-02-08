package com.startruck.telegrambot.bot;

import com.startruck.telegrambot.command.CommandContainer;
import com.startruck.telegrambot.service.BotSendMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

import static com.startruck.telegrambot.command.CommandName.NO;

@Component
public class StarTruckBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private final CommandContainer commandContainer;

    public StarTruckBot() {
        this.commandContainer = new CommandContainer(new BotSendMessageServiceImpl(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.findCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.findCommand(NO.getCommandName()).execute(update);
            }
        } else if (update.hasCallbackQuery()) {
            //commandContainer.findCommand(update.getCallbackQuery().getData()).execute(update);
            System.out.println("CallbackQuery: " + update.getCallbackQuery().getData());
            List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
            if (arr.contains(Integer.parseInt(update.getCallbackQuery().getData()))) {
                commandContainer.findCommand("/updated_logbook").execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
