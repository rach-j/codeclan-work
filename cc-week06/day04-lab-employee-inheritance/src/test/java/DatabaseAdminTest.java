import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseAdminTest {
    DatabaseAdmin databaseAdmin;

    @Before
    public void before() {
        databaseAdmin = new DatabaseAdmin("Paul", "YC777880A", 100000.00);
    }

    @Test
    public void canGetName() {
        assertEquals("Paul", databaseAdmin.getName());
    }

    @Test
    public void canGetniNumber() {
        assertEquals("YC777880A", databaseAdmin.getNiNumber());
    }

    @Test
    public void canGetSalary() {
        assertEquals(100000.00, databaseAdmin.getSalary(), 0.01);
    }

    @Test
    public void canRaiseSalary() {
        databaseAdmin.raiseSalary(50000.00);
        assertEquals(150000.00, databaseAdmin.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(1000.00, databaseAdmin.payBonus(), 0.01);
    }
}
