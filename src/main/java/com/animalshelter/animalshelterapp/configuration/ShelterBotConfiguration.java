package com.animalshelter.animalshelterapp.configuration;

import com.animalshelter.animalshelterapp.model.Shelter;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.DeleteMyCommands;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;

@Configuration
@EnableStateMachineFactory
public class ShelterBotConfiguration extends EnumStateMachineConfigurerAdapter<CommandState, CommandEvent> {

    @Value("${telegram.bot.token}")
    private String token;

    @Bean
    public TelegramBot telegramBot() {
        TelegramBot bot = new TelegramBot(token);
        bot.execute(new DeleteMyCommands());
        return bot;
    }

    @Bean
    public Shelter shelter() {
        return new Shelter("dgknknfa");
    }

}
