import java.text.*;

import com.sqa.gy.helpers.*;

/**
 *   File Name: RunSlotMachine.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 21, 2017
 *
 */

/**
 * RunSlotMachine
 *
 * @author Yakovenko, Galina
 */
public class RunSlotMachine {

	public static String[] itemsForMatching = { "-BELL-", "GRAPE-", "CHERRY" };
	// for each spin:
	public static String[] row1 = new String[3];

	public static String[] row2 = new String[3];

	public static String[] row3 = new String[3];

	public static String[][] rowsOnMachine = { row1, row2, row3 };
	public static double userBalance = 0;
	public static boolean userPlaying = true;;

	public static void main(String[] args) {
		// call the methods that will run my slot machine

		// Greet
		AppBasics.greetNoUserName("Slot Machine");
		// Give Basic info
		// ^----option to get more details info
		MethodsToRunSlotMachine.displayBasicInfo();
		System.out.println("\n");

		// User "inserts money" = balance & print
		userBalance = MethodsToRunSlotMachine.acceptsUserDeposit(userBalance);
		System.out.println("\n");

		// Play the game
		SlotTurnLoop.executesSlotTurnLoop(userBalance, userPlaying);

		// Displays "cashing out: " balance and Thanks for playing!
		MethodsToRunSlotMachine.printCashingOutMessage(userBalance);
	}

	DecimalFormat dfDollarsCents = new DecimalFormat("#.##");

}
