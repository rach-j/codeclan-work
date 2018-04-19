public class Building implements IGettersForVehicleAndBuilding {

    private String type;
    private int healthValue;

    public Building(String type, int healthValue) {
        this.type = type;
        this.healthValue = healthValue;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public int getHealthValue() {
        return this.healthValue;
    }

    public void reduceHealthValue(int number) {
        if (number > this.healthValue) {
            this.healthValue = 0;
        } else {
            this.healthValue -= number;
        }
    }
}
