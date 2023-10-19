package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.model.Shelter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class ShelterBotUpdatesListener implements UpdatesListener {
    private final Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private Shelter shelter;

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
                SendMessage sendMessage = new SendMessage(chatId, "Привет! Это чат-бот приюта для животных. Если хотите взять кошку, напишите /cat, собаку - /dog");
                telegramBot.execute(sendMessage);
            }
            if ("/cat".equalsIgnoreCase(text)) {
                SendMessage catMessage = new SendMessage(chatId,
                        "Вы выбрали приют для котов. Чтобы получить расписание работы приюта, адрес, и схему проезда, введите /info." +
                        " Чтобы получить контактные данные охраны для оформления пропуска на машину, введите /guard." +
                        " Чтобы получить общие рекомендации о технике безопасности на территории приюта, введите /recomend." +
                        " Чтобы принять и записать контактные данные для связи, введите /contact." +
                        " Если бот не может ответить на вопросы клиента, то можно позвать волонтера /volunteer");
                telegramBot.execute(catMessage);
                if ("/info".equalsIgnoreCase(text)) {
                    shelter.setAddress("MYYYYYYYAAAAADRES");
                    String adres = shelter.getAddress();
                    SendMessage adresMessage = new SendMessage(chatId, adres);
                    telegramBot.execute(adresMessage);
                }
            } else if ("/dog".equalsIgnoreCase(text)) {
                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали приют для собак. Чтобы узнать информацию о приюте, нажмите /info");
                telegramBot.execute(dogMessage);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }
    }