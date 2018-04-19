import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MothraTest {

    Mothra mothra;
    BattleTank battleTank;
    InfantryFightingVehicle infantryFightingVehicle;
    Building building;

    @Before
    public void before() {
        mothra = new Mothra("Molly",90, 12 );
        battleTank = new BattleTank("Challenger 2", 50);
        infantryFightingVehicle = new InfantryFightingVehicle("Warrior", 30);
        building = new Building("house", 25);
    }

    @Test
    public void canGetName() {
        assertEquals("Molly", mothra.getName());
    }

    @Test
    public void canGetDescription() {
        assertEquals("Colossal sentient month", mothra.getDescription());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(90, mothra.getHealthValue());
    }

    @Test
    public void canGetGetAttackValue() {
        assertEquals(12, mothra.getAttackValue());
    }

    @Test
    public void canRoar() {
        assertEquals("Molly gives a high-pitched whirring roar as Mothra are wont to do", mothra.roar());
    }

    @Test
    public void canAttackbattleTank() {
        mothra.attack(battleTank);
        assertEquals(38, battleTank.getHealthValue());
    }

    @Test
    public void canAttackInfantryFightingVehicle() {
        mothra.attack(infantryFightingVehicle);
        assertEquals(18, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canMove() {
        assertEquals("Molly soars high up in the air ready to pounce on unsuspecting humans", mothra.move());
    }

    @Test
    public void canReduceHealthValue() {
        mothra.reduceHealthValue(5);
        assertEquals(85, mothra.getHealthValue());
    }

    @Test
    public void canAttackBuilding() {
        mothra.attack(building);
        assertEquals(13, building.getHealthValue());
    }
}
