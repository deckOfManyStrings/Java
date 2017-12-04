/**
 * Bobby Kingsada
 * 11/3/2017
 * The control unit does the fetch decode and execute
 * ControlUnit.java
 * 
 */
package abc;

import abc.ABCMachine;

/**
 * This control unit will run the cycle
 * @author Bobby Kingsada
 * @version 1.0
 */

public class ControlUnit
{
	private static final int JUMP = 7;
	private static final int BRANCH = 6;
	private static final int LOAD = 5;
	private static final int STORE = 4;
	private static final int COMPUTATION = 3;
	private static final int DEST_LOCATION = 4;
	private static final int ADDRESS_LOCATION = 0;
	private static final int SOURCE_TWO_LOCATION = 7;
	private static final int SOURCE_ONE_LOCATION = 10;
	private static final int OPCODELOCATION = 13;
	private static final int STARTINGMASK = 0b00000111;
	private static final int ADDRESSMASK = 0b00001111;
	
	private short dest;
	private short sourceTwo;
	private short sourceOne;
	private short address;
	private short opCode;
	
	private ABCMachine machine;
	
	/**
	 * This is the constructor
	 */
	public ControlUnit(ABCMachine machine)
	{
		this.machine = machine;
	}
	
	/**
	 * This method starts processing the fetch decode and execute cycle
	 */
	public void startProcessing()
	{
		/*
		 * Your program should loop here and continuously
		 * fetch, decode and execute instructions that are
		 * stored in the ABCMachine. The program should
		 * "halt" when it reaches an instruction that is
		 * zero in binary.
		 */
		
		while (true) 
		{
			fetch();
			if (machine.getIr() == 0) 
			{
				break;
			}
			else
			{
				decode();
				execute();	
			}
		}
		System.out.println("Registers");
		machine.printRegisters();
		System.out.println("Memory");
		machine.printMemory();
		
	}
	
	/**
	 * This method starts processing the fetch cycle
	 */
	public void fetch() 
	{
		//access the memory of the next instruction and load next instruction into the IR register
		short[] test = machine.getMemory();
		machine.setIr(test[machine.getPc()]);//get memory out of array
		
		//increment the PC register
		machine.setPc((byte)(machine.getPc() + 1));
		
	}
	
	/**
	 * This method starts processing the decode cycle
	 */
	
	public void decode()
	{		
		//HALT if current instruction is 0
		if(machine.getIr() == 0) 
		{
			System.exit(0);
		}

		opCode = (short) ((short) machine.getIr() >> OPCODELOCATION);
		opCode = (short) (opCode & STARTINGMASK);
		
		//identify first source
		sourceOne = (short) (machine.getIr() >> SOURCE_ONE_LOCATION);
		sourceOne = (short) (sourceOne & STARTINGMASK);
		
		//identify second source
		sourceTwo = (short) (machine.getIr() >> SOURCE_TWO_LOCATION);
		sourceTwo = (short) (sourceTwo & STARTINGMASK);
		
		//identify destination
		dest = (short) (machine.getIr() >> DEST_LOCATION);
		dest = (short) (dest & STARTINGMASK);
		
		//identify address
		address = (short) (machine.getIr() >> ADDRESS_LOCATION);
		address = (short) (address & ADDRESSMASK);
		

		
	}
	
	/**
	 * This method starts processing the execute cycle
	 */
	public void execute()
	{
		if (opCode <= COMPUTATION) {
			machine.getRegisters()[dest] = machine.getAlu().opcode(opCode, sourceOne, sourceTwo);
		}
		else if (opCode == STORE)
		{
			machine.getMemory()[address] = machine.getRegisters()[sourceOne];
		}
		else if (opCode == LOAD)
		{
			machine.getRegisters()[sourceOne] = machine.getMemory()[address]; 
		}
		else if (opCode == BRANCH)
		{
			byte nzp = machine.getAlu().getNZP();
			if ((nzp & sourceOne) != 0) 
			{
				machine.setPc((byte) address);
			}
		}
		else if (opCode == JUMP)
		{
			machine.setPc((byte) address);
		}
	}
}
