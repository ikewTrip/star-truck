package com.startruck.telegrambot.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration for {@link Command}'s.
 */
@Getter
@AllArgsConstructor
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("/no"),

    UPDATE_LOGBOOK("/update_logbook"),
    DOT("/dot"),
    SUBSCRIPTION("/subscription"),
    MANUAL("/manual"),
    UPDATED_LOGBOOK("/updated_logbook");

    private final String commandName;

}

