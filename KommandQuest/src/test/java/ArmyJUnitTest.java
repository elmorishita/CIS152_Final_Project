
import finalProject.Army;
import finalProject.Soldier;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing for Army class
 */
public class ArmyJUnitTest {
    
    @Test
    void testGetMinAttributeByType() {
        Army newArmy = new Army("Humans", 1);
        String humans = "Humans";
        // Assert that 10 is the minimum attribute for the Human army type
        assertEquals(10, newArmy.getMinAttributeByType(humans));
    }
    
    @Test
    void testGetAverageAtk(){
        ArrayList<Soldier> soldiers = new ArrayList();
        soldiers.add(new Soldier(10, 20));
        soldiers.add(new Soldier(10, 20));
        soldiers.add(new Soldier(10, 20));
        Army newArmy = new Army("Humans", 1);
        // Set army consisting of 3x soldiers from above
        newArmy.setArmy(soldiers);
        // Assert for average of 3x soldiers atk at 10 each (so 10 average)
        assertEquals("10", newArmy.getAverageAtk(soldiers));
    }
    
     @Test
    void testGetAverageDef(){
        ArrayList<Soldier> soldiers = new ArrayList();
        soldiers.add(new Soldier(10, 20));
        soldiers.add(new Soldier(10, 20));
        soldiers.add(new Soldier(10, 20));
        Army newArmy = new Army("Humans", 1);
        // Set army consisting of 3x soldiers from above
        newArmy.setArmy(soldiers);
        // Assert for average of 3x soldiers def at 20 each (so 20 average)
        assertEquals("20", newArmy.getAverageDef(soldiers));
    }
}
