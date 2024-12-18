package finalProject;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;

public class Battle {
    // Members
    private boolean IsPlayerFirst = false;
    private boolean DidPlayerOneWin = false;
    private boolean IsTie = false;
    private int PlayerWinCount;
    private int EnemyWinCount;
    private boolean BattleIsOngoing = true;
    // Methods
    /** BeginBattle
    * @return LinkedHashMap
    */
    public LinkedHashMap BeginBattle(Army playerArmy, Army enemyArmy, boolean IsPlayerFirst) {
        LinkedList<Soldier> playerArmyInOrder = OrderArmy(playerArmy.getArmy());
        LinkedList<Soldier> enemyArmyInOrder = OrderArmy(enemyArmy.getArmy());
        final int FINISHED = 0;
        // Player gets turn on even turn number, enemy on odd turns.
        // If the Player won the coin toss then the Player gets the first turn.
        int turn = 1;
        if (IsPlayerFirst) {
            turn = 0;
        }
        // Collected the remaining soldiers stats from both sides, is used to display results to the player(s)
        LinkedHashMap<Integer, Integer> remainingSoldiers = new LinkedHashMap<>();
        final int TURN_INTERVAL = 100;
        while (playerArmyInOrder.size() != FINISHED && enemyArmyInOrder.size() != FINISHED) {
            if (!playerArmyInOrder.isEmpty() && !enemyArmyInOrder.isEmpty()) {
                if (isPlayerTurn(turn)) {
                    if (IsStrikeEffective(playerArmyInOrder.getFirst(), enemyArmyInOrder.getFirst())) {
                        enemyArmyInOrder.removeFirst();
                    }
                } else {
                    if (IsStrikeEffective(enemyArmyInOrder.getFirst(), playerArmyInOrder.getFirst())) {
                        playerArmyInOrder.removeFirst();
                    }
                }
            }
            turn++;
            // Only add results every interval of turns and the final turn
            if(turn % TURN_INTERVAL == 0 || playerArmyInOrder.isEmpty() || enemyArmyInOrder.isEmpty()){
                remainingSoldiers.put(playerArmyInOrder.size(), enemyArmyInOrder.size());
            }
            CheckForVictor(playerArmyInOrder.size(), enemyArmyInOrder.size(), FINISHED);
        }
        return remainingSoldiers;
    }
    /** Determines if a soldier has been defeated via the difference of attackers atk and defenders def
    * @param Soldier attacker, Soldier defender
    * @return Boolean
    */
    public boolean IsStrikeEffective(Soldier attacker, Soldier defender) {
        final int DEATH = 0;
        defender.setDef(defender.getDef() - attacker.getAtk());
        if (defender.getDef() <= DEATH) {
            return true;
        } else {
            return false;
        }
    }
    /** isPlayerTurn checks for a players turn by using modulus to determine if the turn count is even or odd
    * @param int turn
    */
    public boolean isPlayerTurn(int turn) {
        return turn % 2 == 0;
    }
    /** CheckForVictor Checks to see which player/computer won or tied
    * @param int playersLeft, int enemiesLeft, int finished
    */
    private void CheckForVictor(int playersLeft, int enemiesLeft, int finished) {
        if (playersLeft == finished && enemiesLeft == finished) {
            setIsTie(true);
        }
        if (playersLeft == finished) {
            setDidPlayerOneWin(false);
        }
        if (enemiesLeft == finished) {
            setDidPlayerOneWin(true);
        }
    }
    /** Returns a linkedList of sorted soldiers.
     * @param ArrayList<Soldier>
     * @return LinkedList
     */
    public LinkedList<Soldier> OrderArmy(ArrayList<Soldier> army) {
        LinkedList<Soldier> newOrder = new LinkedList<Soldier>();
        selectionSort(army);
        for (Soldier soldier : army) {
            newOrder.add(soldier);
        }
        return newOrder;
    }
    /** Using the Selection Sort algorithm, selectionSort sets the army in order by comparing each soldiers rank
    * @param ArrayList<Soldier>
    */
    private static void selectionSort(ArrayList<Soldier> army) {
        for (int i = 0; i < army.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < army.size(); j++) {
                if (army.get(j).compareTo(army.get(index)) < 0) {
                    index = j;//searching for lowest index  
                }
            }
            Soldier smallerSoldier = army.get(index);
            army.set(index, army.get(i));
            army.set(i, smallerSoldier);
        }
    }
    // Getters/Setters
    /**
     * @return the battleIsOngoing
     */
    public boolean getBattleIsOngoing() {
        return BattleIsOngoing;
    }
    /**
     * @param battleIsOngoing the battleIsOngoing to set
     */
    public void setBattleIsOngoing(boolean battleIsOngoing) {
        BattleIsOngoing = battleIsOngoing;
    }
    /**
     * @return the isTie
     */
    public boolean getIsTie() {
        return IsTie;
    }
    /**
     * @param isTie the isTie to set
     */
    public void setIsTie(boolean isTie) {
        IsTie = isTie;
    }
    /**
     * @return the isPlayerFirst
     */
    public boolean getIsPlayerFirst() {
        return IsPlayerFirst;
    }
    /**
     * @param isPlayerFirst the isPlayerFirst to set
     */
    public void setIsPlayerFirst(boolean isPlayerFirst) {
        IsPlayerFirst = isPlayerFirst;
    }
    /**
     * @return the didPlayerWin
     */
    public boolean getDidPlayerOneWin() {
        return DidPlayerOneWin;
    }
    /**
     * @param didPlayerWin the didPlayerWin to set
     */
    public void setDidPlayerOneWin(boolean didPlayerOneWin) {
        DidPlayerOneWin = didPlayerOneWin;
    }
    /**
     * @return the playerWinCount
     */
    public int getPlayerWinCount() {
        return PlayerWinCount;
    }
    /**
     * @param playerWinCount the playerWinCount to set
     */
    public void setPlayerWinCount(int playerWinCount) {
        PlayerWinCount = playerWinCount;
    }
    /**
     * @return the enemyWinCount
     */
    public int getEnemyWinCount() {
        return EnemyWinCount;
    }
    /**
     * @param enemyWinCount the enemyWinCount to set
     */
    public void setEnemyWinCount(int enemyWinCount) {
        EnemyWinCount = enemyWinCount;
    }
}
