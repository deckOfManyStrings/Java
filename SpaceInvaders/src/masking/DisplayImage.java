/**
 * Bobby Kingsada
 * 10/23/2017
 * DisplayImage.java
 * This class displays an image based on the selection of the user.
 * 
 */

package masking;

/**
 * This method takes in the data from variables to use later
 * @author Bobby Kingsada
 * @verison 1.0
 */
public class DisplayImage 
{
	
	private static final int TOTALBITS = 128;
	private byte[] data;
	private int rows;
	private int columns;
	
	/**
	 * This class builds image object
	 * @param data takes in the binary number
	 * @param rows takes in the number of rows
	 * @param columns takes in the number of colums
	 */
	
	public DisplayImage(byte[] data, int rows, int columns)
	{
		this.data = data;
		this.rows = rows;
		this.columns = columns;
	}
	
	/**
	 * This will show the images of the class using a loop
	 * @param choice takes in the selection of the user
	 */
	
	public void showImage(int choice) 
	{
		long mask = 1L << choice;
		
		for (int i=0; i<TOTALBITS; i++) 
		{
			if((data[i] & mask) == 0) System.out.print(" ");
			else System.out.print("X");
			if((i+1)%columns==0) System.out.println(); 
		}
		System.out.println();
	}
	/**
	 * This is my extra credit image. (does not work yet)
	 * @param choice takes in the selection of the user
	 */
	
	public void showExtraImage(int choice) 
	{
		long mask = 1L << choice;
		
		for (int i=0; i<25; i++) 
		{
			if((data[i] & mask) == 0) System.out.print(" ");
			else System.out.print("X");
			if((i+1)%columns==0) System.out.println(); 
		}
		System.out.println();
	}
	
}
