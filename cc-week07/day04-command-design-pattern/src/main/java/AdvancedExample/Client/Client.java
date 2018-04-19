package AdvancedExample.Client;

import AdvancedExample.Commands.CoolCommand;
import AdvancedExample.Commands.HeatCommand;
import AdvancedExample.Commands.SwitchOffCommand;
import AdvancedExample.Commands.SwitchOnCommand;
import AdvancedExample.Invoker.Button;
import AdvancedExample.Reciever.AirConditioner;
import AdvancedExample.Reciever.Laptop;
import AdvancedExample.Reciever.Light;

public class Client {

    public static void main(String[] args) {
        Light light = new Light();
        AirConditioner airConditioner = new AirConditioner();
        Laptop laptop = new Laptop("Jarrod's MacBook");

        Button button = new Button();

        SwitchOnCommand switchOnLightCommand = new SwitchOnCommand(light);
        SwitchOffCommand switchOffLightCommand = new SwitchOffCommand(light);
        SwitchOnCommand switchOnACCommand = new SwitchOnCommand(airConditioner);
        SwitchOffCommand switchOffACCommand = new SwitchOffCommand(airConditioner);
        SwitchOnCommand switchOnLaptop = new SwitchOnCommand(laptop);
        SwitchOffCommand switchOffLaptop = new SwitchOffCommand(laptop);

        HeatCommand heatCommand = new HeatCommand(airConditioner);
        CoolCommand coolCommand = new CoolCommand(airConditioner);


        button.setCommand(switchOnLightCommand);
        button.pressButton();
        System.out.println("Is light on? " + light.getIsOn());

        button.setCommand(switchOffLightCommand);
        button.pressButton();
        System.out.println("Is light on? " + light.getIsOn());

        button.setCommand(switchOnACCommand);
        button.pressButton();
        System.out.println("Is AC on? " + airConditioner.getIsOn());

        button.setCommand(switchOffACCommand);
        button.pressButton();
        System.out.println("Is AC on? " + airConditioner.getIsOn());

        button.setCommand(heatCommand);
        button.pressButton();
        System.out.println("The AC is now " + airConditioner.getTemperature());

        button.setCommand(coolCommand);
        button.pressButton();
        System.out.println("The AC is now " + airConditioner.getTemperature());

        button.setCommand(switchOnLaptop);
        button.pressButton();
        System.out.println("Is " + laptop.getName() + " on? " + laptop.getIsOn());

        button.setCommand(switchOffLaptop);
        button.pressButton();
        System.out.println("Is " + laptop.getName() + " on? " + laptop.getIsOn());
    }
}
