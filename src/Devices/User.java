package Devices;

import java.util.ArrayList;


public class User{
    private int current;
    private ArrayList<Command> commands;

    public User(){
        current = 0;
        commands = new ArrayList<Command>();
    }

    public void Perform(Command command){
        command.Execute();
        commands.add(command);
        current++;
    }

    public void DisplayTheHistory(){
        if(commands.size() > 0){
            //commands.forEach((n) -> n.);
        }
    }
}

