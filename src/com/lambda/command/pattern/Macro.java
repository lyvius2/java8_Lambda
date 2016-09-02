package com.lambda.command.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhwang131 on 2016-08-01.
 */
public class Macro {
    private final List<Action> actions;

    public Macro(){
        actions = new ArrayList<>();
    }

    public void record(Action action){
        actions.add(action);
    }

    public void run(){
        actions.forEach(Action::perform);
    }
}
