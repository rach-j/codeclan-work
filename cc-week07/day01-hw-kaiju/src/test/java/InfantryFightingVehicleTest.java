import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InfantryFightingVehicleTest {
    InfantryFightingVehicle infantryFightingVehicle;
    Godzilla godzilla;
    Mothra mothra;
    Rodan rodan;

    @Before
    public void before() {
        infantryFightingVehicle = new InfantryFightingVehicle("Warrior", 40);
        godzilla = new Godzilla("Gerald",120, 20 );
        mothra = new Mothra("Molly",90, 12 );
        rodan = new Rodan("Rodney", 20, 5);
    }

    @Test
    public void canGetType() {
        assertEquals("Warrior", infantryFightingVehicle.getType());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(40, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canSetHealthValue() {
        infantryFightingVehicle.setHealthValue(100);
        assertEquals(100, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canReduceHealthValueWhereRemainingHealthValueGreaterThanZero() {
        infantryFightingVehicle.reduceHealthValue(10);
        assertEquals(30, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void doesNotReduceHealthBelowZero() {
        infantryFightingVehicle.reduceHealthValue(50);
        assertEquals(0, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canAttackGodzillaWithTearGas() {
        infantryFightingVehicle.attackWithTearGas(godzilla);
        assertEquals(100, godzilla.getHealthValue());
    }

    @Test
    public void canAttackMothraWithTearGas() {
        infantryFightingVehicle.attackWithTearGas(mothra);
        assertEquals(70, mothra.getHealthValue());
    }

    @Test
    public void canAttackRodanWithTearGas() {
        infantryFightingVehicle.attackWithTearGas(rodan);
        assertEquals(0, rodan.getHealthValue());
    }

    @Test
    public void canAttackGodzillaWithGrenades() {
        infantryFightingVehicle.attackWithGrenades(godzilla);
        assertEquals(80, godzilla.getHealthValue());
    }

    @Test
    public void canAttackMothraWithGrenades() {
        infantryFightingVehicle.attackWithGrenades(mothra);
        assertEquals(50, mothra.getHealthValue());
    }

    @Test
    public void canAttackRodanWithGrenades() {
        infantryFightingVehicle.attackWithGrenades(rodan);
        assertEquals(0, rodan.getHealthValue());
    }
}
