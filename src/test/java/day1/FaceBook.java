package day1;

public class FaceBook extends BaseClass {
	public static void main(String[] args) {
		
		browserLaunch("chrome");
		urlLaunch("https://www.facebook.com/");
		LoginPage l = new LoginPage();
		sendkeys(l.getTxtUser(),"saikishore");
		sendkeys(l.getTxtPass(),"123456");
		refresh();
		sendkeys(l.getTxtUser(),"madanasai");
		
		
	}

}
