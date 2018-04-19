package SimpleExample.Commands;

import SimpleExample.Reciever.Light;

public class LightOnCommand implements ICommand{
    private Light light;

    public LightOnCommand (Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.switchOn();
    }
}
