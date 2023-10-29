package com.animalshelter.animalshelterapp.statemachine.action;

import com.animalshelter.animalshelterapp.statemachine.event.CommandEvent;
import com.animalshelter.animalshelterapp.statemachine.state.CommandState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;

public class InfoAction implements Action<CommandState, CommandEvent> {
    @Override
    public void execute(StateContext<CommandState, CommandEvent> context) {
        System.out.println("INFO");
    }
}
