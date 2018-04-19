import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GodzillaTest {

    private Godzilla godzilla;
    private BattleTank battleTank;
    private InfantryFightingVehicle infantryFightingVehicle;
    private Building building;

    @Before
    public void before() {
        godzilla = new Godzilla("Gerald",120, 20 );
        battleTank = new BattleTank("Challenger 2", 50);
        infantryFightingVehicle = new InfantryFightingVehicle("Warrior", 30);
        building = new Building("house", 25);
    }

    @Test
    public void canGetName() {
        assertEquals("Gerald", godzilla.getName());
    }

    @Test
    public void canGetDescription() {
        assertEquals("Large prehistoric sea monster", godzilla.getDescription());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(120, godzilla.getHealthValue());
    }

    @Test
    public void canGetGetAttackValue() {
        assertEquals(20, godzilla.getAttackValue());
    }

    @Test
    public void canRoar() {
        assertEquals("Gerald roars in a way that only Godzillas can", godzilla.roar());
    }

    @Test
    public void canAttackbattleTank() {
        godzilla.attack(battleTank);
        assertEquals(30, battleTank.getHealthValue());
    }

    @Test
    public void canAttackInfantryFightingVehicle() {
        godzilla.attack(infantryFightingVehicle);
        assertEquals(10, infantryFightingVehicle.getHealthValue());
    }

    @Test
    public void canMove() {
        assertEquals("Gerald runs forward, crushing everything in its path", godzilla.move());
    }

    @Test
    public void canReduceHealthValue() {
        godzilla.reduceHealthValue(5);
        assertEquals(115, godzilla.getHealthValue());
    }

    @Test
    public void canAttackBuilding() {
        godzilla.attack(building);
        assertEquals(5, building.getHealthValue());
    }
}
