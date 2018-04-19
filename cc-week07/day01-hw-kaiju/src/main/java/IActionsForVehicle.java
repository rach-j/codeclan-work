public interface IActionsForVehicle {

    public void setHealthValue(int number);

    public void reduceHealthValue(int number);

    public void attackWithTearGas(Kaiju kaiju);

    public void attackWithGrenades(Kaiju kaiju);
}
