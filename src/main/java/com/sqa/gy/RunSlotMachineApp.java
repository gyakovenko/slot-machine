/**
 *   File Name: RunSlotMachineApp.java<br>
 *
 *   Yakovenko, Galina<br>
 *   Created: Jan 23, 2017
 *
 */

package com.sqa.gy;

import com.sqa.gy.helpers.*;

/**
 * RunSlotMachineApp
 *
 * @author Yakovenko, Galina
 *
 */
public class RunSlotMachineApp {

	public static double userBalance = 0;

	public static void main(String[] args) {
		// calls the methods that will run my slot machine

		// Greet
		AppBasics.greetNoUserName("Slot Machine");
		// Give Basic info
		// ^----option to get more details info
		MethodsForSlotMachine.displayBasicInfo();
		System.out.println("\n");

		// User "inserts money" = balance & print
		userBalance = MethodsForSlotMachine.acceptsUserDeposit(userBalance);
		System.out.println("\n");

		// GameLoop
		userBalance = GameLoop.gameLoop(userBalance);

		// Cashing out when done
		MethodsForSlotMachine.printCashingOutMessage(userBalance);
	}
}
