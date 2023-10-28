package com.animalshelter.animalshelterapp.configuration;

import com.animalshelter.animalshelterapp.model.Shelter;
import com.animalshelter.animalshelterapp.statemachine.event.CommandEvent;
import com.animalshelter.animalshelterapp.statemachine.state.CommandState;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class ShelterBotConfiguration extends EnumStateMachineConfigurerAdapter<CommandState, CommandEvent> {

    @Value("${telegram.bot.token}")
    private String token;

    public ShelterBotConfiguration() {
    }

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

    @Bean
    public Shelter shelter() {
        return new Shelter("CatShelterAddress");
    }
    @Override
    public void configure(StateMachineConfigurationConfigurer<CommandState, CommandEvent> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(listener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<CommandState, CommandEvent> states)
            throws Exception {
        states
                .withStates()
                .initial(CommandState.INFO)
                .states(EnumSet.allOf(CommandState.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<CommandState, CommandEvent> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(CommandState.INFO).target(CommandState.GUARD).event(CommandEvent.GET_INFO)
                .and()
                .withExternal()
                .source(CommandState.GUARD).target(CommandState.RECOMMEND).event(CommandEvent.GET_GUARD);
    }

    @Bean
    public StateMachineListener<CommandState, CommandEvent> listener() {
        return new StateMachineListenerAdapter<CommandState, CommandEvent>() {
            @Override
            public void stateChanged(State<CommandState, CommandEvent> from, State<CommandState, CommandEvent> to) {
                System.out.println("State change to " + to.getId());
            }
        };
    }
    }


