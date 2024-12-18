package finalProject;

import java.util.ArrayList;
import java.util.Random;

public class Army {
    // Members
    private ArrayList<Soldier> Army;
    private int ArmySize;
    private String ArmyType;
    // Constructor
    public Army(String armyType, int armySize){
        this.setArmyType(armyType);
        this.setAttributes(armySize, armyType);
    }
    // Methods
    /** setAttributes sets the atk and def for each soldier in an army
    * @param int size
    */
    public void setAttributes(int size, String armyType) {
        Random rand = new Random();
        final int MIN = getMinAttributeByType(armyType);
        final int MAX = 226;
        ArrayList<Soldier> tempArmy = new ArrayList<Soldier>();
        for(int i = 0; i < size; i++) {
            Soldier soldier = new Soldier(rand.nextInt(MAX + 1 - MIN) + MIN, rand.nextInt(MAX + 1 - MIN) + MIN);
            tempArmy.add(soldier);
        }
        setArmy(tempArmy);
    }
    /** Gets the minimum attribute for each army type, with humans being the default.  
     *  Also learned that Java doesn't like break; statements in combination with return; statements
    * @param String armyType
    * @return int 
    */
    public int getMinAttributeByType(String armyType){
        final int HUMAN_MIN = 10;
        final int SKELETON_MIN = 2;
        final int ALIEN_MIN = 20;
        final int ZOMBIE_MIN = 4;
        final int ORC_MIN = 8;
        final int GOBLIN_MIN = 6;
        final int JEDI_MIN = 40;
        final int SITH_MIN = 35;
        switch(armyType){
            case "Humans": 
                return HUMAN_MIN; 
            case "Skeletons": 
                return SKELETON_MIN;
            case "Aliens": 
                return ALIEN_MIN;
            case "Zombies": 
                return ZOMBIE_MIN;
            case "Orcs": 
                return ORC_MIN;
            case "Goblins": 
                return GOBLIN_MIN;
            case "Jedi": 
                return JEDI_MIN;
            case "Sith": 
                return SITH_MIN;
        }
        return HUMAN_MIN; // default
    }
    /** Gets the average atk of an Army
    * @param ArrayList<Soldier>
    * @return String 
    */
    public String getAverageAtk(ArrayList<Soldier> army) {
        try {
            if(!army.isEmpty()) {
                int allAtk = 0;
                for(Soldier soldier : this.getArmy()) {
                        allAtk += soldier.getAtk();
                }
                return Integer.toString(allAtk / army.size());
            } else {
                throw new IllegalArgumentException("List cannot be null");
            }
        } catch (IllegalArgumentException ex){
            return ex.getMessage();
        }
    }
    /** Gets the average def of an Army
    * @param ArrayList<Soldier>
    * @return String 
    */
    public String getAverageDef(ArrayList<Soldier> army) {
        try {
            if(!army.isEmpty()) {
                int allDef = 0;
                for(Soldier soldier : this.getArmy()) {
                        allDef += soldier.getDef();
                }
                return Integer.toString(allDef / army.size());
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
    public String getArmyType() {
            return ArmyType;
    }
    /**
     * @param armyName the armyName to set
     */
    public void setArmyType(String armyType) {
            ArmyType = armyType;
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
