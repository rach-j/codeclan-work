public abstract class Vehicle implements IGettersForVehicleAndBuilding, IActionsForVehicle {
    private String type;
    private int healthValue;

    public Vehicle(String type, int healthValue) {
        this.type = type;
        this.healthValue = healthValue;
    }

    public String getType() {
        return this.type;
    }

    public int getHealthValue() {
        return this.healthValue;
    }

    public void setHealthValue(int number) {
        this.healthValue = number;
    }

    public void reduceHealthValue(int number) {
        if (number > this.healthValue) {
            this.healthValue = 0;
        } else {
            this.healthValue -= number;
        }
    }

    public void attackWithTearGas(Kaiju kaiju) {
        kaiju.reduceHealthValue(20);
    }

    public void attackWithGrenades(Kaiju kaiju) {
        kaiju.reduceHealthValue(40);
    }
}
