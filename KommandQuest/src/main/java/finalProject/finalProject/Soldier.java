package finalProject;

public class Soldier implements Comparable<Soldier>{
    // Members
    private int Atk;
    private int Def;
    private int Rank;
    // Constructor
    public Soldier(int atk, int def) {
        setAtk(atk);
        setDef(def);
        arrangeRank(atk, def);
    }
    // Methods
    /** compareTo compares the difference in rank, zero if the same, -1 if left value is less than right value, 1 for the opposite
    * @param Soldier another
    * @return int
    */
    @Override
    public int compareTo(Soldier another) {
        return Integer.compare(this.getRank(), another.getRank());
    }
    /** arrangeRank sets the rank for each soldier by combining atk and def
    * @param int atk, int def
    */
    private void arrangeRank(int atk, int def) {
        // Private...............1
        // Sergeant..............2
        // Staff Sergeant........3
        // Lieutenant............4
        // Captain...............5
        // Lieutenant Colonel....6
        // Colonel...............7
        // Major General.........8
        // Lieutenant General....9
        int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] associatedLevels = { 50, 100, 150, 200, 250, 300, 350, 400, 450 };
        int combinedLevels = atk + def;
        for (int i = 0; i < ranks.length; i++) {
            if(combinedLevels <= associatedLevels[i]) {
                setRank(ranks[i]);
                break;
            }
        }
    }
    // Getters/Setters
    /**
     * @return the rank
     */
    public int getRank() {
        return Rank;
    }
    /**
     * @param rank the rank to set
     */
    public void setRank(int rank) {
        Rank = rank;
    }
    /**
     * @return the atk
     */
    public int getAtk() {
        return Atk;
    }
    /**
     * @param atk the atk to set
     */
    public void setAtk(int atk) {
        Atk = atk;
    }
    /**
     * @return the def
     */
    public int getDef() {
        return Def;
    }
    /**
     * @param def the def to set
     */
    public void setDef(int def) {
        Def = def;
    }
}

