
import finalProject.Soldier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing for Soldier class
 */
public class SoldierJUnitTest {
    
    @Test
    void testCompareTo() {
        Soldier soldierWeak = new Soldier(10, 10);
        Soldier soldierStrong = new Soldier(50, 60);
        // Assert that soldierStrong is ranked higher than soldierWeak (1)
        assertTrue(soldierStrong.compareTo(soldierWeak) > 0);
        // Assert that soldierWeak is NOT ranked higher than soldierStrong (-1)
        assertFalse(soldierWeak.compareTo(soldierStrong) > 0);
    }
}
