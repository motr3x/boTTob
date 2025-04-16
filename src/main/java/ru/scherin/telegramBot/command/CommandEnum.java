package ru.scherin.telegramBot.command;

public enum CommandEnum {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("/no");
    private final String commandName;
    CommandEnum(String commandName) {
        this.commandName = commandName;
    }
    public String getCommandName() {
        return commandName;
    }
}
