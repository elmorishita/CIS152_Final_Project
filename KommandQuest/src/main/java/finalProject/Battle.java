package finalProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Battle {
	// Members
	private boolean IsPlayerFirst = false;
	private boolean DidPlayerWin = false;
	private boolean IsTie = false;
	private int PlayerWinCount;
	private int EnemyWinCount;
	private boolean BattleIsOngoing = true;
	// Methods
	public String SizeMessage(int playerArmySize, int enemyArmySize) {
		if(playerArmySize > enemyArmySize) {
			return " ... whew ... only ";
		} else {
			return " ... uh oh ... ";
		}
	}
	public String DetermineWhoStrikesFirst(String playerName) {
		Random rand = new Random();
		final int MIN = 1;
		final int MAX = 10;
		int coinToss = rand.nextInt(MAX + 1 - MIN) + MIN;
		// If random number is even then Player Strikes first
		if(coinToss % 2 == 0) {
			setIsPlayerFirst(true);
			return playerName + " wins the toss and receives the honor of first strike.";
		}
		return "ENEMY wins the toss and receives the honor of first strike.";
	}
	public String BeginBattle(ArrayList<Soldier> playerArmy, ArrayList<Soldier> enemyArmy, String playerName) {
		LinkedList<Soldier> playerArmyInOrder = OrderArmy(playerArmy);
		LinkedList<Soldier> enemyArmyInOrder = OrderArmy(enemyArmy);
		final int FINISHED = 0;
		// Player gets turn on even turn number, enemy on odd turns.
		// If the Player won the coin toss then the Player gets the first turn.
		int turn = 1;
		if(getIsPlayerFirst()) {
			turn = 0;
		}
		while(playerArmyInOrder.size() != FINISHED && enemyArmyInOrder.size() != FINISHED) {
			if(!playerArmyInOrder.isEmpty() && !enemyArmyInOrder.isEmpty()) {
				if(isPlayerTurn(turn)) {
					if(IsStrikeEffective(playerArmyInOrder.getFirst(), enemyArmyInOrder.getFirst())) {
						enemyArmyInOrder.removeFirst();
					}
				} else {
					if(IsStrikeEffective(enemyArmyInOrder.getFirst(), playerArmyInOrder.getFirst())) {
						playerArmyInOrder.removeFirst();
					}
				}
			}
			turn++;
			CheckForVictor(playerArmyInOrder.size(), enemyArmyInOrder.size(), FINISHED);
		}
		return DisplayResults(playerArmyInOrder.size(), enemyArmyInOrder.size(), turn, playerName);
	}
	private String DisplayResults(int playerArmyLeft, int enemyArmyLeft, int turns, String playerName) {
		String combatNoise = "   CLASH\n\n                CLANG\n\n      BOOM\n";
		String results = combatNoise + " " + playerName + " army remaining: " + playerArmyLeft + "\n Enemy army remaining: " + enemyArmyLeft + "\n Total turns taken: " + turns;
		if(getIsTie()) {
			return results + "\n\n ** :\\ TIE **\n";
		}
		if(getDidPlayerWin()) {
			return results + "\n\n ** :) VICTORY **\n";
		} else {
			return results + "\n\n ** :( DEFEAT **\n";
		}
	}
	private boolean IsStrikeEffective(Soldier attacker, Soldier defender) {
		final int DEATH = 0;
		defender.setDef(defender.getDef() - attacker.getAtk());
		if(defender.getDef() <= DEATH) {
			return true;
		} else {
			return false;
		}
	}
	private boolean isPlayerTurn(int turn) {
		return turn % 2 == 0;
	}
	private void CheckForVictor(int playersLeft, int enemiesLeft, int finished) {
		if(playersLeft == finished && enemiesLeft == finished) {
			setIsTie(true);
		}
		if(playersLeft == finished) {
			setDidPlayerWin(false);
		}
		if(enemiesLeft == finished) {
			setDidPlayerWin(true);
		}
	}
	private LinkedList<Soldier> OrderArmy(ArrayList<Soldier> army) {
		LinkedList<Soldier> newOrder = new LinkedList<Soldier>();
		selectionSort(army);
		for(Soldier soldier : army) {
			newOrder.add(soldier);
		}
		return newOrder;
	}
	/**Using the Selection Sort algorithm, selectionSort sets the army in order by comparing each soldiers rank
	 * @param army
	 */
	private static void selectionSort(ArrayList<Soldier> army){  
        for (int i = 0; i < army.size() - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < army.size(); j++){  
                if (army.get(j).compareTo(army.get(index)) < 0){  
                    index = j;//searching for lowest index  
                }  
            }  
            Soldier smallerSoldier = army.get(index);   
            army.set(index,  army.get(i));  
            army.set(i, smallerSoldier);  
        } 
	}
	public boolean continueGame(char playerChoice) {
		if(playerChoice == 'n' || playerChoice == 'N') {
			return false;
		} else {
			return true;
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
	public boolean getDidPlayerWin() {
		return DidPlayerWin;
	}
	/**
	 * @param didPlayerWin the didPlayerWin to set
	 */
	public void setDidPlayerWin(boolean didPlayerWin) {
		DidPlayerWin = didPlayerWin;
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

