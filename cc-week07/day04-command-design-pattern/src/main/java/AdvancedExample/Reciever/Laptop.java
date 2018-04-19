package AdvancedExample.Reciever;

public class Laptop implements ISwitchable {
    private String name;
    private boolean isOn;
    
    public Laptop(String name) {
        this.name = name;
        this.isOn = false;
    }

    @Override
    public void switchOn() {
        this.isOn = true;
    }

    @Override
    public void switchOff() {
        this.isOn = false;
    }

    public String getName() {
        return name;
    }

    public boolean getIsOn() {
        return isOn;
    }
}
