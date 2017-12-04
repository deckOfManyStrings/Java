
public class MainStory {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		StoryBook runnable = new StoryBook();
		Thread thread = new Thread(runnable);
		
		System.out.println(" and they lived happily ever after.");
		
		thread.start();
		thread.join();
	}

}
