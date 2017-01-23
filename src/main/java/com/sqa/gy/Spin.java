/**
 *   File Name: Spin.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

/**
 * Spin //ADDD (description of class)
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
public class Spin {

	public static String[] itemsForMatching = { "-BELL-", "GRAPE-", "CHERRY" };
	// for each spin:
	public static String[] row1 = new String[3];

	public static String[] row2 = new String[3];

	public static String[] row3 = new String[3];

	public static String[][] rowsOnMachine = { row1, row2, row3 };

	public static double spin(double userBalance, int userNumOfLines, int userBetPerLine) {
		double winnings = 0;
		// fill my array of arrays with random 0-2 with correspond to
		// arrayOfOptions indexes

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

		return winnings;
	}
}
