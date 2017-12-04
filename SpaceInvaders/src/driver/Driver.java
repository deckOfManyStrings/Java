/**
 * Bobby Kingsada
 * 10/23/2017
 * This class will display prompts and will allow the user to select the images to show
 * Driver.java
 * 
 */

package driver;

import masking.*;
import java.util.Scanner;

/**
 *  This is the driver that will give the user prompts.
 * @author Bobby Kingsada
 * @version 1.0
 */

public class Driver {

	private static final int EXTRADEM = 5;
	private static Scanner sc;
	private static final int COL = 16;
	private static final int ROWS = 8;
	private static byte[] data;
	private static byte[] extraData;

	public static void main(String[] args) 
	{
		sc = new Scanner(System.in);

		drive();
	}
	
	/**
	 * this class creates the images then displays the images based on the selection of the user
	 */
	
	private static void drive(){
		int choice;
		int picture = 1;

		data = BinaryNumberBuilder.getInput("files/spaceinvaders.txt", ROWS, COL);
		extraData = BinaryNumberBuilder.getInput("ExtarCredit", EXTRADEM, EXTRADEM);

		DisplayImage DisImage = new DisplayImage(data, ROWS, COL);
		DisplayImage ExtraDisImage = new DisplayImage(extraData, EXTRADEM, EXTRADEM);

		System.out.println("Choose from homework images (0) or extra credit (1)");
		choice = sc.nextInt();
		sc.nextLine(); // clear buffer
		
		while(picture != 0) {
			if (choice == 1) {
				System.out.println("Choose an image (1-4) or enter 0 to exit");
				picture = sc.nextInt();
				sc.nextLine(); // clear buffer

				if (picture == 0) System.out.println("EXIT");
				else ExtraDisImage.showExtraImage(picture);
			}
		}
		
		while(picture != 0) {
			if (choice == 0) {
				System.out.println("Choose an image (1-8) or enter 0 to exit");
				picture = sc.nextInt();
				sc.nextLine(); // clear buffer

				if (picture == 0) System.out.println("EXIT");
				else DisImage.showImage(picture);
			}
		}

	}
}
