package ru.scherin.telegramBot.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.scherin.telegramBot.command.CommandContainer;
import ru.scherin.telegramBot.service.SendBotMessageServiceImpl;

import static ru.scherin.telegramBot.command.CommandEnum.NO;

@Component
@PropertySource("classpath:application.properties")
public class TestBot extends TelegramLongPollingBot {
    public static String COMMAND_PREFIX = "/";
    @Value("${bot.token}")
    private String token;
    @Value("${bot.username}")
    private String username;
    private final CommandContainer commandContainer;

    public TestBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
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
