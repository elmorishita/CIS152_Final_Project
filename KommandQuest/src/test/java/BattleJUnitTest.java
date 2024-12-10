
import finalProject.Army;
import finalProject.Battle;
import finalProject.Soldier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing for Battle class
 */
public class BattleJUnitTest {
    
    @Test
    void testOrderArmy() {
        Battle battle = new Battle();
        ArrayList<Soldier> army = new ArrayList<>();
        army.add(new Soldier(10, 50));
        army.add(new Soldier(20, 40));
        army.add(new Soldier(15, 60));
        LinkedList<Soldier> orderedArmy = battle.OrderArmy(army);
        // Verify the army is sorted by the selectionSort (Least is first)
        assertEquals(10, orderedArmy.getFirst().getAtk());
    }

    @Test
    void testIsPlayerTurn() {
        // Player gets the even turns (for context)
        Battle battle = new Battle();
        assertTrue(battle.isPlayerTurn(2));  // Even turn
        assertFalse(battle.isPlayerTurn(3)); // Odd turn
    }

    @Test
    void testIsStrikeEffective() {
        Soldier attacker = new Soldier(10, 50); // Attacker with attack 10
        Soldier defender = new Soldier(5, 10);  // Defender with defense 10
        Battle battle = new Battle();
        boolean result = battle.IsStrikeEffective(attacker, defender);
        assertTrue(result);
        assertEquals(0, defender.getDef());
    }

    @Test
    void testBeginBattle_PlayerWins() {
        Army playerArmy = new Army("Jedi", 100); // Much stronger
        Army enemyArmy = new Army("Skeletons", 2); // much weaker plus lower count
        Battle battle = new Battle();
        boolean isPlayerFirst = true;
        LinkedHashMap<Integer, Integer> remainingSoldiers = battle.BeginBattle(playerArmy, enemyArmy, isPlayerFirst);
        // Assert that the player beats the enemy
        int finalPlayerCount = remainingSoldiers.entrySet().stream().reduce((first, second) -> second).get().getKey(); // Get final player count
        int finalEnemyCount = remainingSoldiers.entrySet().stream().reduce((first, second) -> second).get().getValue(); // Get final enemy count
        assertTrue(finalPlayerCount > finalEnemyCount);
    }
}
