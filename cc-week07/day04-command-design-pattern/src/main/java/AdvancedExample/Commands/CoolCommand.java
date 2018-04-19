package AdvancedExample.Commands;

import AdvancedExample.Reciever.ITemperature;

public class CoolCommand implements ICommand {
    ITemperature temperature;

    public  CoolCommand(ITemperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        this.temperature.cool();
    }
}
