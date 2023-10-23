package com.animalshelter.animalshelterapp;

import com.animalshelter.animalshelterapp.configuration.CommandEvent;
import com.animalshelter.animalshelterapp.configuration.CommandState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class AnimalShelterAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AnimalShelterAppApplication.class, args);
	}

	@Autowired
	private StateMachine<CommandState, CommandEvent> stateMachine;
	@Override
	public void run(String... args) throws Exception {
		stateMachine.sendEvent(CommandEvent.GET_INFO);
		stateMachine.sendEvent(CommandEvent.GET_GUARD);
	}
}
