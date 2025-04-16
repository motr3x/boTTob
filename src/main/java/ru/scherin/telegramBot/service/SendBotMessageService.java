package ru.scherin.telegramBot.service;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
}
