package finalProject;

import java.util.ArrayList;
import java.util.Random;

public class Army {
	// Members
	private ArrayList<Soldier> Army;
	private int ArmySize;
	private String ArmyName;
	// Methods
	public void setEnemyArmySize() {
		Random rand = new Random();
		final int MIN = 5;
		final int MAX = 20;
		setArmySize(rand.nextInt(MAX + 1 - MIN) + MIN);
	}
	public void setAttributes(int size) {
		Random rand = new Random();
		final int MIN = 5;
		final int MAX = 226;
		ArrayList<Soldier> tempArmy = new ArrayList<Soldier>();
		for(int i = 0; i < size; i++) {
			Soldier soldier = new Soldier(rand.nextInt(MAX + 1 - MIN) + MIN, rand.nextInt(MAX + 1 - MIN) + MIN);
			tempArmy.add(soldier);
		}
		setArmy(tempArmy);
	}
	public String printAverageAttributes(ArrayList<Soldier> army) {
		try {
			if(!army.isEmpty()) {
				int allAtk = 0, allDef = 0;
				for(Soldier soldier : this.getArmy()) {
					allAtk += soldier.getAtk();
					allDef += soldier.getDef();
				}
				return "  Average Attack: " + (allAtk / army.size()) + "\n  Average Defence: " + (allDef / army.size());
			} else {
				throw new IllegalArgumentException("List cannot be null");
			}
		} catch (IllegalArgumentException ex){
			return ex.getMessage();
		}
	}
	// Getters/Setters
	/**
	 * @return the armyName
	 */
	public String getArmyName() {
		return ArmyName;
	}
	/**
	 * @param armyName the armyName to set
	 */
	public void setArmyName(String armyName) {
		ArmyName = armyName;
	}
	/**
	 * @return the army
	 */
	public ArrayList<Soldier> getArmy() {
		return Army;
	}
	/**
	 * @param army the army to set
	 */
	public void setArmy(ArrayList<Soldier> army) {
		Army = army;
	}
	/**
	 * @return the armySize
	 */
	public int getArmySize() {
		return ArmySize;
	}
	/**
	 * @param armySize the armySize to set
	 */
	public void setArmySize(int armySize) {
		ArmySize = armySize;
	}
}
