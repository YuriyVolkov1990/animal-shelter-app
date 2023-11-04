package com.animalshelter.animalshelterapp.listener;

import com.animalshelter.animalshelterapp.configuration.ShelterBotConfiguration;
import com.animalshelter.animalshelterapp.entity.CatShelter;
import com.animalshelter.animalshelterapp.keyboard.ReplyKeyboardMaker;
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
    private ReplyKeyboardMaker replyKeyboardMaker;
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private CatShelter catShelter;
    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Autowired
    public ShelterBotConfiguration shelterBotConfiguration;

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equalsIgnoreCase(text)) {
                SendMessage sendMessage = new SendMessage(chatId, "Выберите приют");
                sendMessage.replyMarkup(replyKeyboardMaker.getMainMenuKeyboard());
                telegramBot.execute(sendMessage);
            }
            switch (text) {
                case "Выбрать приют для кошек" -> catMenu(updates);
                case "Выбрать приют для собак" -> dogMenu(updates);
            }
//            if ("/cat".equalsIgnoreCase(text)) {
//                SendMessage catMessage = new SendMessage(chatId,
//                        "Вы выбрали приют для котов. Чтобы получить расписание работы приюта, адрес, и схему проезда, введите /info." + "\n\n" +
//                        " Чтобы получить контактные данные охраны для оформления пропуска на машину, введите /guard." + "\n\n" +
//                        " Чтобы получить общие рекомендации о технике безопасности на территории приюта, введите /recommend." + "\n\n" +
//                        " Чтобы принять и записать контактные данные для связи, введите /contact." + "\n\n" +
//                        " Если бот не может ответить на вопросы клиента, то можно позвать волонтера /volunteer");
//                telegramBot.execute(catMessage);
//            } else if ("/dog".equalsIgnoreCase(text)) {
//                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали приют для собак. Чтобы узнать информацию о приюте, нажмите /info");
//                telegramBot.execute(dogMessage);
//            }
            //                String textcat = update.message().text();
//                Long chatIdcat = update.message().chat().id();
//                    if (textcat.equalsIgnoreCase("/info")) {
//                        shelter.setAddress("MYYYYYYYAAAAADRES");
//                        String adres = shelter.getAddress();
//                        SendMessage adresMessage = new SendMessage(chatIdcat, adres);
//                        telegramBot.execute(adresMessage);
//                    }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void catMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage catMessage = new SendMessage(chatId, "Вы выбрали кошачий приют");
                catMessage.replyMarkup(replyKeyboardMaker.getCatMenuKeyboard());
                telegramBot.execute(catMessage);
            }
            menuChanger(updates);
//            CatShelter catShelter1 = new CatShelter(0L, "aaaaa", "bbbbb", "ccccc", "ddsdgsdgsd");
//            System.out.println("===================================================================");
//            infoMenu(chatId);
//            System.out.println("===================================================================");

        });
    }

    private void menuChanger(List<Update> updates) {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        updates.forEach(update -> {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            System.out.println("/////////////////////////////////////////////////");
            switch (text) {
                case "Инфо про кошачий приют" -> {
                    System.out.println("****************************************");
                    infoMenu(chatId);
                }
            }
        });
    }

    private void infoMenu(Long chatId) {
        String info = shelterBotConfiguration.catShelter().getInfo();
        System.out.println("------------------------------------------------");
        System.out.println(info);
        System.out.println("------------------------------------------------");
        SendMessage infoMessage = new SendMessage(chatId, info);
        telegramBot.execute(infoMessage);
    }

    private void dogMenu(List<Update> updates) {
        updates.forEach(update -> {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("Выбрать приют для кошек".equalsIgnoreCase(text)) {
                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали собачий приют");
                dogMessage.replyMarkup(replyKeyboardMaker.getDogMenuKeyboard());
                telegramBot.execute(dogMessage);
            }
        });
    }
}
//    private void catMenuDown (List<Update> updates) {
//        CatShelter catShelter1 = new CatShelter(null, "aaaaa", "bbbbb", "ccccc","ddsdgsdgsd");
//        updates.forEach(update -> {
//            String text = update.message().text();
//            Long chatId = update.message().chat().id();
//        switch (text) {
//            case "Инфо про кошачий приют" -> {
//                String info = catShelter1.getInfo();
//                System.out.println("------------------------------------------------");
//                System.out.println(info);
//                System.out.println("------------------------------------------------");
//                SendMessage infoMessage = new SendMessage(chatId,info);
//                telegramBot.execute(infoMessage);
//            }
//        }
//        });
