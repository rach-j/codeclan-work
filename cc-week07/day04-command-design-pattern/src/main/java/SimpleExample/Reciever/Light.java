package SimpleExample.Reciever;

public class Light {

    boolean isOn;

    public Light() {
        this.isOn = false;
    }

    public void switchOn() {
        this.isOn = true;
    }

    public void switchOff() {
        this.isOn = false;
    }

    public boolean getIsOn() {
        return this.isOn;
    }
}
