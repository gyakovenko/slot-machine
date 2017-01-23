import java.text.*;

import com.sqa.gy.helpers.*;

/**
 *   File Name: MethodsToRunSlotMachine.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 21, 2017
 *
 */

/**
 * MethodsToRunSlotMachine
 *
 * @author Yakovenko, Galina
 */
public class MethodsToRunSlotMachine {
	public static DecimalFormat dfDollarsCents = new DecimalFormat("#.##");

	public static double acceptsUserDeposit(double userBalance) {
		userBalance = userBalance + AppBasics
				.requestDoubleFromUser("Please enter the dollar ammount you would like to insert: $", 0, 100);
		return userBalance;
	}

	public static void askDepositMoreOrDone(double userBalance) {
		String response = AppBasics.requestUserInfo(
				"Your balance is: $" + dfDollarsCents.format(userBalance) + "\nYou do not have enough to play again."
						+ "\nPlease enter \'deposit\' to make a deposit or \'enter\' to exit the app.");
		if (response.equalsIgnoreCase("deposit")) {
			acceptsUserDeposit(userBalance);
		} else {
			printCashingOutMessage(userBalance);
		}
	}

	//// NEED to restructure so that i dont have these issues
	public static int checkIfUserHasEnoughToPlay(int userBalance) {
		int maxLines = MethodsToRunSlotMachine.findMaxLinestoRun(userBalance);
		if (maxLines == 0) {
			MethodsToRunSlotMachine.askDepositMoreOrDone(userBalance);
		} else {
			return maxLines;
		}
	}

	public static void displayBasicInfo() {
		try {
			String moreDeetsOrCont = AppBasics.requestUserInfo("\nOn each spin, you can bet on up to 7 lines."
					+ "\nMinimum bet is 25¢ per line and you can bet up for $1 in increments of 25¢."
					+ "\nWhen you are ready to end the game, simply enter \'cash out\' or \'exit\' to cash out." + "\n"
					+ "\nEnter \'more\' for more info or press \'enter\' to continue.");
			if (moreDeetsOrCont.equalsIgnoreCase("more")) {
				displayMoreDetails();
			}
		} catch (Exception e) {
		}

	}

	public static void displayMoreDetails() {
		System.out.println("\nThe format of the Items after spin is displayed here:"
				+ "\n\nRow 1	  [Item 1]--[Item 2]--[Item 3] " + "\n" + "                \\   /     \\   /" + "\n"
				+ "                  X         X" + "\n" + "               _/   \\_   _/   \\_" + "\n"
				+ "Row 2	  [Item 1]--[Item 2]--[Item 3]" + "\n" + "               \\_   _/     \\_   _/" + "\n"
				+ "                  X           X" + "\n" + "               _/   \\_     _/   \\_" + "\n"
				+ "Row 3	  [Item 1]--[Item 2]--[Item 3]" + "\n\n" + "Win lines are:" + "\n	-Across Row 2"
				+ "\n	-Across Row 1" + "\n	-Across Row 3" + "\n	-Diagonal Down from Row 1, Item 1"
				+ "\n	-Diagonal Up from Row 3, Item 1" + "\n	-Row 2, Item 1 -- Row 1, Item 2 -- Row 2, Item 3"
				+ "\n	-Row 2, Item 1 -- Row 3, Item 2 -- Row 2, Item 3"
				+ "\n\nWinning Combinations with Winnings Multipliers:" + "\n	-BELL, BELL, BELL 		x10"
				+ "\n	-CHERRY, CHERRY, CHERRY 	x7" + "\n	-GRAPE, GRAPE, GRAPE 		x5"
				+ "\n	-BELL, BELL, -ANY-	 	x3" + "\n	-BELL, -ANY-, BELL 		x3"
				+ "\n	--ANY-, BELL, BELL 		x3" + "\n	-CHERRY, CHERRY, -ANY-	 	x1"
				+ "\n	-CHERRY, -ANY-, CHERRY 		x1" + "\n	--ANY-, CHERRY, CHERRY 		x1\n");
		AppBasics.requestUserInfo("Press \'enter\' to begin!");
	}

	public static int findMaxBetPerLine(double userBalance, int linesRunning) {
		int times100userbalance = (int) (userBalance * 100);
		int maxBet = times100userbalance / (25 * linesRunning);
		return maxBet;
	}

	public static int findMaxLinestoRun(double userBalance) {
		int times100userbalance = (int) (userBalance * 100);
		int maxLines = times100userbalance / 25;
		return maxLines;
	}

	public static void printCashingOutMessage(double userBalance) {
		System.out.println(
				"Cashing out: $" + dfDollarsCents.format(userBalance) + "\n" + "Thanks for playing and goodbye now!");
		System.exit(0);
	}

	public static int[] retrievesUsersBet(double userBalance, int maxLines) {
		String questionNumOfLines = new StringBuilder().append("How many lines would you like to play(max ")
				.append(maxLines).append(")?").toString();
		int linesRunning = AppBasics.requestIntFromUserexptCASHOUTorEXIT(questionNumOfLines, 0, maxLines);
		if (linesRunning == -1) {
			askDepositMoreOrDone(userBalance);
			int[] noMoneyLeft = { 0, 0 };// NOTREALLYSUREIFTHISWILLWORK
			return noMoneyLeft;
		} else {
			int maxBet = MethodsToRunSlotMachine.findMaxBetPerLine(userBalance, linesRunning);
			String questionBet = new StringBuilder().append("How many lines would you like to play(max ").append(maxBet)
					.append(")?").toString();
			int betBetting = AppBasics.requestIntFromUser(questionBet, 0, maxBet);
			int[] userLinesAndBet = { linesRunning, betBetting };
			return userLinesAndBet;
		}
	}
}
