import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {

    Manager manager;

    @Before
    public void before() {
        manager = new Manager("Kate", "JM123456A", 30000.00, "Cheese tsar");
    }

    @Test
    public void canGetName() {
        assertEquals("Kate", manager.getName());
    }

    @Test
    public void canGetniNumber() {
        assertEquals("JM123456A", manager.getNiNumber());
    }

    @Test
    public void canGetSalary() {
        assertEquals(30000.00, manager.getSalary(), 0.01);
    }

    @Test
    public void canGetDeptName() {
        assertEquals("Cheese tsar", manager.getDeptName());
    }

    @Test
    public void canRaiseSalary() {
        manager.raiseSalary(5000.00);
        assertEquals(35000.00, manager.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(300.00, manager.payBonus(), 0.01);
    }
}
