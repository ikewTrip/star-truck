package com.startruck.telegrambot.command;

import com.startruck.telegrambot.service.BotSendMessageService;

import java.util.Map;

import static com.startruck.telegrambot.command.CommandName.*;

/**
 * Container of the {@link Command}s, which are using for handling telegram commands.
 */
public class CommandContainer {

    private final Map<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(BotSendMessageService botSendMessageService) {

        commandMap = Map.ofEntries(
                Map.entry(START.getCommandName(), new StartCommand(botSendMessageService)),
                Map.entry(STOP.getCommandName(), new StopCommand(botSendMessageService)),
                Map.entry(HELP.getCommandName(), new HelpCommand(botSendMessageService)),
                Map.entry(NO.getCommandName(), new NoCommand(botSendMessageService)));

        unknownCommand = new UnknownCommand(botSendMessageService);
    }

    public Command findCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }

}
