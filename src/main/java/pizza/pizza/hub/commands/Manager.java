package pizza.pizza.hub.commands;

import pizza.pizza.hub.interfaces.Commands;

import java.util.ArrayList;

public class Manager {
    private ArrayList<Commands> commandQueue = new ArrayList<>();

    public void addCommand(Commands command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        for (Commands command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}
