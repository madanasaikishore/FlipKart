package day1;

public class FlipKart extends BaseClass {
	
	public static void main(String[] args) throws InterruptedException {
		
		browserLaunch("chrome");
		urlLaunch("https://www.flipkart.com/");
		FlipKartPage1 fk = new FlipKartPage1();
		click(fk.getClick());
		sendkeys(fk.getSearch(),"IPhone");
		click(fk.getFind());
		Thread.sleep(3000);
		click(fk.getFirst());
		Thread.sleep(3000);
		switchToWindow(1);
		click(fk.getAdd());
		
	}

}
