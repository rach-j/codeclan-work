public interface IActionsForKaiju {
    public String roar();
    public void attack(Vehicle vehicle);
    public void attack(Building building);
    public String move();
    public void reduceHealthValue(int number);
}
