package AdvancedExample.Reciever;

public class AirConditioner implements ISwitchable, ITemperature {
    boolean isOn;
    String temperature;

    public AirConditioner() {
        this.isOn = false;
        this.temperature = "cooling";
    }

    @Override
    public void switchOn() {
        this.isOn = true;
    }

    @Override
    public void switchOff() {
        this.isOn = false;
    }

    @Override
    public void heat() {
        this.temperature = "heating";
    }

    @Override
    public void cool() {
        this.temperature = "cooling";
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public String getTemperature() {
        return temperature;
    }
}
