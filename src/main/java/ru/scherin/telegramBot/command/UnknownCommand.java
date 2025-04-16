package ru.scherin.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.telegramBot.service.SendBotMessageService;


public class UnknownCommand implements Command{
    public static final String NO_MESSAGE = "НЕ понимаю вас";
    private final SendBotMessageService sendBotMessageService;

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
