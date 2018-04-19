import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BattleTankTest {

    BattleTank battleTank;
    Godzilla godzilla;
    Mothra mothra;
    Rodan rodan;

    @Before
    public void before() {
        battleTank = new BattleTank("Challenger 2", 50);
        godzilla = new Godzilla("Gerald",120, 20 );
        mothra = new Mothra("Molly",90, 12 );
        rodan = new Rodan("Rodney", 20, 5);
    }

    @Test
    public void canGetType() {
        assertEquals("Challenger 2", battleTank.getType());
    }

    @Test
    public void canGetHealthValue() {
        assertEquals(50, battleTank.getHealthValue());
    }

    @Test
    public void canSetHealthValue() {
        battleTank.setHealthValue(100);
        assertEquals(100, battleTank.getHealthValue());
    }

    @Test
    public void canReduceHealthValueWhereRemainingHealthValueGreaterThanZero() {
        battleTank.reduceHealthValue(10);
        assertEquals(40, battleTank.getHealthValue());
    }

    @Test
    public void doesNotReduceHealthValueBelowZero() {
        battleTank.reduceHealthValue(100);
        assertEquals(0, battleTank.getHealthValue());
    }

    @Test
    public void canAttackGodzillaWithTearGas() {
        battleTank.attackWithTearGas(godzilla);
        assertEquals(100, godzilla.getHealthValue());
    }

    @Test
    public void canAttackMothraWithTearGas() {
        battleTank.attackWithTearGas(mothra);
        assertEquals(70, mothra.getHealthValue());
    }
    @Test
    public void canAttackRodanWithTearGas() {
        battleTank.attackWithTearGas(rodan);
        assertEquals(0, rodan.getHealthValue());
    }

    @Test
    public void canAttackGodzillaWithGrenades() {
        battleTank.attackWithGrenades(godzilla);
        assertEquals(80, godzilla.getHealthValue());
    }

    @Test
    public void canAttackMothraWithGrenades() {
        battleTank.attackWithGrenades(mothra);
        assertEquals(50, mothra.getHealthValue());
    }

    @Test
    public void canAttackRodanWithGrenades() {
        battleTank.attackWithGrenades(rodan);
        assertEquals(0, rodan.getHealthValue());
    }

}
