import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeveloperTest {
    Developer developer;

    @Before
    public void before() {
        developer = new Developer("Jussi", "JJ889901C", 21000.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Jussi", developer.getName());
    }

    @Test
    public void canGetniNumber() {
        assertEquals("JJ889901C", developer.getNiNumber());
    }

    @Test
    public void canGetSalary() {
        assertEquals(21000.00, developer.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary() {
        developer.raiseSalary(2000.00);
        assertEquals(23000.00, developer.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(210.00, developer.payBonus(), 0.01);
    }
}
