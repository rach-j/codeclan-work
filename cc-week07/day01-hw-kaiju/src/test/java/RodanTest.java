import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RodanTest {
    Rodan rodan;
    BattleTank battleTank;
    InfantryFightingVehicle infantryFightingVehicle;
    Building building;

    @Before
    public void before() {
        rodan = new Rodan("Rodney",10, 5 );
        battleTank = new BattleTank("Challenger 2", 50);
        infantryFightingVehicle = new InfantryFightingVehicle("Warrior", 30);
        building = new Building("house", 25);
    }

    @Test
    public void canGetName() {
        assertEquals("Rodney", rodan.getName());
    }

    @Test
    public void canGetDescription() {
        assertEquals("Large pteranodon", rodan.getDescription());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(10, rodan.getHealthValue());
    }

    @Test
    public void canGetGetAttackValue() {
        assertEquals(5, rodan.getAttackValue());
    }

    @Test
    public void canRoar() {
        assertEquals("Rodney emits a screeching sound almost unbearable to the human ear", rodan.roar());
    }

    @Test
    public void canMove() {
        assertEquals("Rodney dives down to gauge the eyes out of its prey", rodan.move());
    }

    @Test
    public void canAttackbattleTank() {
        rodan.attack(battleTank);
        assertEquals(45, battleTank.getHealthValue());
    }

    @Test
    public void canAttackInfantryFightingVehicle() {
        rodan.attack(infantryFightingVehicle);
        assertEquals(25, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canReduceHealthValue() {
        rodan.reduceHealthValue(5);
        assertEquals(5, rodan.getHealthValue());
    }

    @Test
    public void canAttackBuilding() {
        rodan.attack(building);
        assertEquals(20, building.getHealthValue());
    }
}
