import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DirectorTest {

    Director director;

    @Before
    public void before() {
        director = new Director("Darren", "RF131313Z", 999000.00, "The Rabbit Hole", 0.50);
    }

    @Test
    public void canGetName() {
        assertEquals("Darren", director.getName());
    }

    @Test
    public void canGetniNumber() {
        assertEquals("RF131313Z", director.getNiNumber());
    }

    @Test
    public void canGetSalary() {
        assertEquals(999000.00, director.getSalary(), 0.01);
    }

    @Test
    public void canGetDeptName() {
        assertEquals("The Rabbit Hole", director.getDeptName());
    }

    @Test
    public void getGetBudget() {
        assertEquals(0.50, director.getBudget(),0.01);
    }

    @Test
    public void canRaiseSalary() {
        director.raiseSalary(1000.00);
        assertEquals(1000000.00, director.getSalary(), 0.01);
    }

    @Test
    public void canPayBonus() {
        assertEquals(9990.000, director.payBonus(), 0.01);
    }

}
