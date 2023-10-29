package com.animalshelter.animalshelterapp.statemachine.listener;

import com.animalshelter.animalshelterapp.entity.Shelter;
import com.animalshelter.animalshelterapp.service.impl.CatShelteringService;
import com.animalshelter.animalshelterapp.statemachine.event.CommandEvent;
import com.animalshelter.animalshelterapp.statemachine.state.CommandState;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class ShelterBotUpdatesListener implements UpdatesListener, StateMachineListener<CommandState, CommandEvent> {
    private final Logger logger = LoggerFactory.getLogger(ShelterBotUpdatesListener.class);
    @Autowired
    private TelegramBot telegramBot;
    @Autowired
    private Shelter shelter;
    @Autowired
    private CatShelteringService catShelteringService;
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
                        "Вы выбрали приют для котов. Чтобы получить расписание работы приюта, адрес, и схему проезда, введите /info." + "\n\n" +
                        " Чтобы получить контактные данные охраны для оформления пропуска на машину, введите /guard." + "\n\n" +
                        " Чтобы получить общие рекомендации о технике безопасности на территории приюта, введите /recommend." + "\n\n" +
                        " Чтобы принять и записать контактные данные для связи, введите /contact." + "\n\n" +
                        " Если бот не может ответить на вопросы клиента, то можно позвать волонтера /volunteer");
                telegramBot.execute(catMessage);

            } else if ("/dog".equalsIgnoreCase(text)) {
                SendMessage dogMessage = new SendMessage(chatId, "Вы выбрали приют для собак. Чтобы узнать информацию о приюте, нажмите /info");
                telegramBot.execute(dogMessage);
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
        }

    @Override
    public void stateChanged(State<CommandState, CommandEvent> from, State<CommandState, CommandEvent> to) {

    }

    @Override
    public void stateEntered(State<CommandState, CommandEvent> state) {

    }

    @Override
    public void stateExited(State<CommandState, CommandEvent> state) {

    }

    @Override
    public void eventNotAccepted(Message<CommandEvent> event) {

    }

    @Override
    public void transition(Transition<CommandState, CommandEvent> transition) {

    }

    @Override
    public void transitionStarted(Transition<CommandState, CommandEvent> transition) {

    }

    @Override
    public void transitionEnded(Transition<CommandState, CommandEvent> transition) {

    }

    @Override
    public void stateMachineStarted(StateMachine<CommandState, CommandEvent> stateMachine) {

    }

    @Override
    public void stateMachineStopped(StateMachine<CommandState, CommandEvent> stateMachine) {

    }

    @Override
    public void stateMachineError(StateMachine<CommandState, CommandEvent> stateMachine, Exception exception) {

    }

    @Override
    public void extendedStateChanged(Object key, Object value) {

    }

    @Override
    public void stateContext(StateContext<CommandState, CommandEvent> stateContext) {

    }
}