
public class StoryBook implements Runnable{
	
	public void run() {
		System.out.println("Welcome to my storybook");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("The Story began long long ago,");
		for(int i = 0; i <= 10;i++) {
			System.out.print(".");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\n");
	}
}
