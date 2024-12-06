package finalProject;

import java.util.Scanner;
// import javax.swing.*; 

/** Kommand Quest Simulator - a program which simulates the battle of two opposing sides.
 * Big-O Notation: O(n)
 * Citation:
 *  Javatpoint. (n.d.). Selection sort in Java. Javatpoint. Retrieved October 22, 2024, from 
 *  https://www.javatpoint.com/selection-sort-in-java
 * @author Elijah Morishita
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Win 11
* IDE: Eclipse
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/
public class KommandQuest {

	public static void main(String[] args) {
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
		// Implement player/enemy objects to store each army's soldiers
		Army playerArmy = new Army();
		Army enemyArmy = new Army();
		// Create a Battle object
		Battle battle = new Battle();
		// Create a Visuals object
		Visuals visual = new Visuals();
		// Create Input Validation class
		InputValidation LetsValidate = new InputValidation();
		// Create a new Scanner object
		Scanner sc = new Scanner(System.in);
		// Create 2nd scanner for ENTER button press
		Scanner scanner = new Scanner(System.in);
		System.out.printf(visual.title());
		while(battle.getBattleIsOngoing()) {
			System.out.printf("Please enter the name of your army: ");
			playerArmy.setArmyName(sc.next());
			System.out.printf("Please enter the size of your army: ");
			playerArmy.setArmySize(sc.nextInt());
			playerArmy.setAttributes(playerArmy.getArmySize());
			enemyArmy.setEnemyArmySize();
			System.out.println("Your enemy's army size is " + battle.SizeMessage(playerArmy.getArmySize(), enemyArmy.getArmySize()) + enemyArmy.getArmySize());
			enemyArmy.setAttributes(enemyArmy.getArmySize());
			// Display both army's attributes
			System.out.println(playerArmy.getArmyName() + " Army Attributes:\n" + playerArmy.printAverageAttributes(playerArmy.getArmy()));
			System.out.println("Enemy Army Attributes:\n" + enemyArmy.printAverageAttributes(enemyArmy.getArmy()));
			// Determine who strikes goes first
			System.out.printf(visual.coinToss());
			System.out.println(battle.DetermineWhoStrikesFirst(playerArmy.getArmyName()));
			System.out.printf(visual.pressEnterToBegin());
			scanner.nextLine();
			// Begin BATTLE
			System.out.println(battle.BeginBattle(playerArmy.getArmy(), enemyArmy.getArmy(), playerArmy.getArmyName()));
			System.out.printf("\nWould you like to play again? (Y/N): ");
			char playerChoice = sc.next().charAt(0);
			while(!LetsValidate.isYesOrNo(playerChoice)) {
				System.out.printf(LetsValidate.invalidYesOrNo());
				playerChoice = sc.next().charAt(0);
			}
			battle.setBattleIsOngoing(battle.continueGame(playerChoice));
			System.out.printf("\n");
		}
		sc.close();
		scanner.close();
		System.out.printf(visual.creditRoll());
	}
}
