
package finalProject;
/**
 * This class is used to gather info for the main driver, to share between windows
 */
public class PlayerSettings {
    // Members
    private boolean isOnePlayer;
    private Army PlayerOneArmy;
    private Army PlayerTwoArmy;
    private Battle BattleResults;
    // Getters / Setters
    public Battle getBattleResults() {
        return BattleResults;
    }
    public void setBattleResults(Battle BattleResults) {
        this.BattleResults = BattleResults;
    }
    public boolean getIsOnePlayer() {
        return isOnePlayer;
    }
    public void setIsOnePlayer(boolean isOnePlayer) {
        this.isOnePlayer = isOnePlayer;
    }
    public Army getPlayerOneArmy() {
        return PlayerOneArmy;
    }
    public void setPlayerOneArmy(Army PlayerOneArmy) {
        this.PlayerOneArmy = PlayerOneArmy;
    }
    public Army getPlayerTwoArmy() {
        return PlayerTwoArmy;
    }
    public void setPlayerTwoArmy(Army PlayerTwoArmy) {
        this.PlayerTwoArmy = PlayerTwoArmy;
    }
}
