package finalProject;

public class InputValidation {

	public boolean isYesOrNo(char playerChoice) {
		return playerChoice == 'y' || playerChoice == 'Y' || playerChoice == 'n' || playerChoice == 'N';
	}
	public String invalidYesOrNo() {
		return "Invalid entry, please enter Y or N: ";
	}
}
