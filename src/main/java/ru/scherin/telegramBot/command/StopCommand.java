package ru.scherin.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.telegramBot.service.SendBotMessageService;

public class StopCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    public static final String STOP_MESSAGE = "Я МОЛЧУ";

    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
