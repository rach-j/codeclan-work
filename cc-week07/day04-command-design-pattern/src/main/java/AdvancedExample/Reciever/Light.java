package AdvancedExample.Reciever;

public class Light implements ISwitchable {

    boolean isOn;

    public Light() {
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

    public boolean getIsOn() {
        return this.isOn;
    }
}
