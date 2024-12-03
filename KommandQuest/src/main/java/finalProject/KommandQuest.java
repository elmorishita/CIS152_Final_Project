/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalProject;

import javax.swing.Timer;
/**
 *
 * @author Elijah Morishita
 */
public class KommandQuest {
    // Member
    private PlayerSettings playerSettings = new PlayerSettings();
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Create Driver Object
        KommandQuest driver = new KommandQuest();
        // Create Objects
        LaunchScreen launchScreen = new LaunchScreen();
        // Create and display the form GUI
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
    
    public PlayerSettings getPlayerSettings(){
        return playerSettings;
    }
}
