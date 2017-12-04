/**
 * Bobby Kingsada
 * 11/3/2017
 * The ALU will do all the computations 
 * ALU.java
 * 
 */
package abc;

/**
 * The ALU class will take care of the computations
 * @author bobby Kingsada
 *
 */
public class ALU
{	

	private static final int NEGATIVE = 4;
	private static final int ZERO = 2;
	private static final int POSITIVE = 1;
	byte nzp = 100;
	
	/**
	 * The opcode method will take care of the computations
	 * @param opCode takes in the opcode to define what operation to do
	 * @param src1 takes in the first source of the instruction set
	 * @param src2 takes in the seconds source of the instruction set
	 * @return result is the result of the computation
	 */
	public short opcode(short opCode, short src1,short src2)
	{
		short result = 0;
		switch (opCode) 
		{
		case 0: //ADD
			result = add(src1, src2);
			checkNZP(result);
			break;
		case 1: //SUB
			result = sub(src1, src2);
			checkNZP(result);
			break;
		case 2: //MULT
			result = mult(src1, src2);
			checkNZP(result);
			break;
		case 3: //DIV
			result = div(src1, src2);
			checkNZP(result);
			break;
		default:
			System.out.println("Error");
			break;
		}
		return result;
	}

	/**
	 * 
	 * @param result is the result of the computation
	 * @return nzp, returns the nzp so I can compare it later
	 */

	private byte checkNZP(short result) {
		if (result > 0) 
		{
			nzp = NEGATIVE;
		}
		else if (result == 0)
		{
			nzp = ZERO;
		}
		else if (result < 0)
		{
			nzp = POSITIVE;
		}
		return nzp;
	}



	private short add(short src1, short src2) 
	{
		short total = (short) (src1 + src2);
		return total;
	}

	private short sub(short src1, short src2) 
	{
		short total = (short) (src1 - src2);
		return total;
	}

	private short mult(short src1, short src2) 
	{
		short total = (short) (src1 * src2);
		return total;
	}

	private short div(short src1, short src2) 
	{
		short total = (short) (src1 / src2);
		return total;
	}
	
	/**
	 * getter for the nzp variable.
	 * @return nzp so I can compare it later
	 */
	public byte getNZP()
	{
		return nzp;
	}
}


