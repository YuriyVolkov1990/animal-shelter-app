package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.repository.ShelterRepository;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class ShelterBotUpdatesListener implements UpdatesListener {
    private Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    private static Pattern PATTERN = Pattern.compile("(\\d{2}\\.\\d{2}\\.\\d{4} \\d{2}:\\d{2})\\s+(.*)");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private ShelterRepository repository;
    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }
    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "HI");
                telegramBot.execute(sendMessage);
            }
        });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

}
