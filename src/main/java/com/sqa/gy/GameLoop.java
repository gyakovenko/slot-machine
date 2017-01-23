/**
 *   File Name: GameLoop.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

/**
 * GameLoop
 *
 * @author Yakovenko, Galina
 *
 */
public class GameLoop {

	public static double gameLoop(double userBalance) {

		boolean isUserPlaying = true;

		// Check if user can still play
		int maxLines = MethodsForSlotMachine.findMaxLinestoRun(userBalance);
		if (maxLines == 0) {
			MethodsForSlotMachine.askDepositMoreOrDone(userBalance);
		} else {
			while (isUserPlaying) {
				System.out.println("Let's spin!");
				isUserPlaying = MethodsForSlotMachine.runWhileSpinTurn(userBalance, maxLines, isUserPlaying);

			}
		}
		return userBalance;
	}

}
