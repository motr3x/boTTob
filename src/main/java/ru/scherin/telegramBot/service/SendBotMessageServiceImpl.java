package ru.scherin.telegramBot.service;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.scherin.telegramBot.bot.TestBot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {
    private final TestBot testBot;

    public SendBotMessageServiceImpl(TestBot testBot) {
        this.testBot = testBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);
        try{
            testBot.execute(sendMessage);
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
