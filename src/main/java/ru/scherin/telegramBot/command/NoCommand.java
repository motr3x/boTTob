package ru.scherin.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.telegramBot.service.SendBotMessageService;

public class NoCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public static final String UNKNOWN_MESSAGE = "ТОЛЬКО КОМАНДЫ СО СЛЕШЕМ Б";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
