package finalProject;

import javax.swing.Timer;
/** Kommand Quest - Final Project
 *  This program simulates a battle between two opponents.
 * Big-O Notation: O(N)
 * Citation: GeeksforGeeks. (n.d.). LinkedHashMap class in Java. 
 *       Retrieved December 5, 2024, from https://www.geeksforgeeks.org/linkedhashmap-class-in-java/
 * @author Elijah Morishita
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Win 11
* IDE: Apache NetBeans
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
public class KommandQuest {
    // Member
    private PlayerSettings playerSettings = new PlayerSettings();
    
    public static void main(String args[]) {
        // Create Driver Object
        KommandQuest driver = new KommandQuest();
        // Create Launch Screen Object
        LaunchScreen launchScreen = new LaunchScreen();
        // Open initial menu after launch screen timer ends
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                launchScreen.setVisible(true);
                // Timer to move from launch screen to main menu after 4sec
                new Timer(4000, e -> {
                    ((Timer) e.getSource()).stop(); // Stop the timer after it runs
                    launchScreen.setVisible(false);
                    driver.openMainMenu();
                }).start(); // Start the timer
            }
        });
    }
    
    /** 
    * GUI Windows
    */
    public void openMainMenu() {
        MainMenu mainMenu = new MainMenu(this);
        mainMenu.setVisible(true);
    }
    public void openArmySelection(){
        ArmySelection armySelection = new ArmySelection(this);
        armySelection.setVisible(true);
    }
    public void openBattleFront(){
        BattleFront battleFront = new BattleFront(this);
        battleFront.setVisible(true);
    }
    public void openPlayAgain(BattleFront battleFront){
        PlayAgain playAgain = new PlayAgain(this, battleFront);
        playAgain.setVisible(true);
    }
    /** 
    * PlayerSettings holds the KommandQuest data throughout the windows
    */
    public PlayerSettings getPlayerSettings(){
        return playerSettings;
    }
}
