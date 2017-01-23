/**
 *   File Name: SlotTurnLoop.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 21, 2017
 *
 */

/**
 * SlotTurnLoop //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Yakovenko, Galina
 * @version 1.0.0
 * @since 1.0
 *
 */
public class SlotTurnLoop {

	public static double executesSlotTurnLoop(double userBalance, boolean userPlaying) {

		while (userPlaying) {
			// Check if user can still play
			int maxLines = MethodsToRunSlotMachine.findMaxLinestoRun(userBalance);
			if (maxLines == 0) {
				MethodsToRunSlotMachine.askDepositMoreOrDone(userBalance);
			}
			// If has money, then get user's bet:
			else {
				System.out.println("Let's play!");
				MethodsToRunSlotMachine.retrievesUsersBet(userBalance, maxLines);
			}
			// Have user type spin
			// Display the spin w waits
			// Find the winnings
			// Display the winnings
			// Display the balance

		}

		return userBalance;
	}

	// ^----user: lines and bets
	// *******unless user enters "cash out" or "exit" in line or bet
	// ^----user: subtracts lines x bet from balance
	// ^---- print balance
	// ^----populate with random values 1-4 which equal bell, cherry, grape,
	// X
	// ^----display spin
	// ^----display winning
	// -----^----display "No Winning Lines"
	// -----^----display spin with winning lines, winnings $
	// -----^----add winnings to new balance
	// ^----display spin display new balance
}
