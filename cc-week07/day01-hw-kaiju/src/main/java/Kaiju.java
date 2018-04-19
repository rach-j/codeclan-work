public abstract class Kaiju implements IGettersForKaiju, IActionsForKaiju {
    private String name;
    private int healthValue;
    private int attackValue;

    public Kaiju(String name, int healthValue, int attackValue) {
        this.name = name;
        this.healthValue = healthValue;
        this.attackValue = attackValue;
    }

    public String getName() {
        return this.name;
    }

    public int getHealthValue() {
        return this.healthValue;
    }

    public int getAttackValue() {
        return this.attackValue;
    }

    public void attack(Vehicle vehicle) {
        vehicle.reduceHealthValue(this.attackValue);
    }

    public void attack(Building building) {
        building.reduceHealthValue(this.attackValue);
    }

    public void reduceHealthValue(int number) {
        if (number > this.healthValue) {
            this.healthValue = 0;
        } else {
            this.healthValue -= number;
        }

    }
}
