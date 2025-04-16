package ru.scherin.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.telegramBot.service.SendBotMessageService;

public class StartCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE ="ПРИВЕТ АНТОН) ТЫ) ";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
