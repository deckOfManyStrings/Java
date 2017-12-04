/**
 * Bobby Kingsada
 * 11/3/2017
 * This driver will take in the program1 text file
 * ABCDriver.java
 * 
 */
package test;

import abc.ABCMachine;

/**
 * This diver will get the needed text file.
 * @author Bobby Kingsada
 * @version 1.0
 */

public class ABCDriver
{
	public static void main(String[] args)
	{
		//create a new ABCMachine and pass it a new program to run
		ABCMachine abcMachine = new ABCMachine("programs/program1.abc");
		abcMachine.runProgram();
		ABCMachine abcMachine2 = new ABCMachine("programs/program2.abc");
		abcMachine2.runProgram();
		//print out the registers and memory after the program runs
	}
}
