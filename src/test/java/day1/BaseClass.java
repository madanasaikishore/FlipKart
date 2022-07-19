package day1;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriver ChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver browserlaunch(String bname) {
		switch(bname) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static WebDriver browserLaunch(String bname) {
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	public static void urlLaunch(String url) {										// URL Launch
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void implicitlyWait(int a) {										// Implicitly Wait
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	
	public static void sendkeys(WebElement e, String Value) {						// Send Keys
		e.sendKeys(Value);
	}
	
	public static void click(WebElement e) {										// click
		e.click();
	}
	
	public static String getCurrentUrl() {											// Get Current URL
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	public static String getTitle() {												// Get Title
		String title = driver.getTitle();
		return title;
	}
	
	public static void quit() {														// Quit
		driver.quit();
	}
	
	public static String getText(WebElement e) {									// Get Text
		String text = e.getText();
		return text;
	}
	
	public static String getAttribute(WebElement e) {								// Get Attribute
		String attribute = e.getAttribute("Value");
		return attribute;
	}
	
	public static void close() {													// Close
		driver.close();
	}
	
	public static void moveToElement(WebElement e) {								// Move to Element using Actions
		Actions a = new Actions (driver);
		a.moveToElement(e).perform();
	}
	
	public static void dragAndDrop(WebElement first, WebElement last) {				// Drag and Drop using Actions
		Actions a = new Actions (driver);
		a.dragAndDrop(first, last).perform();
	}
	
	public static void selectByIndex(WebElement e,int a) {							// select by Index
		Select s = new Select(e);
		s.selectByIndex(a);
	}
	
	public static void selectByValue(WebElement e,String t) {						// select by Value
		Select s = new Select(e);
		s.selectByValue(t);
	}
	
	public static void selectByVisibleText(WebElement e,String t) {					// select by Visible Text
		Select s = new Select(e);
		s.selectByVisibleText(t);
	}
	
	public static void deselectAll(WebElement e) {									// De select All
		Select s = new Select(e);
		s.deselectAll();
	}
	
	public static void deselectByIndex(WebElement e,int a) {						// De select by Index
		Select s = new Select(e);
		s.deselectByIndex(a);
	}
	
	public static void deselectByValue(WebElement e,String t) {						// De select by Value
		Select s = new Select(e);
		s.deselectByValue(t);
	}
	
	public static void deselectByVisibleText(WebElement e,String t) {				// De select by Visible Text
		Select s = new Select(e);
		s.deselectByVisibleText(t);
	}
	
	public static void contextClick(WebElement e) {									// Context Click using Actions
		Actions a = new Actions (driver);
		a.contextClick(e).perform();
	}
	
	public static void doubleClick(WebElement e) {									// Double Click using Actions
		Actions a = new Actions (driver);
		a.doubleClick(e).perform();
	}
	
	public static void click1(WebElement e) {										// Click using Actions
		Actions a = new Actions (driver);
		a.click(e).perform();
	}
	
	public static void keyPress(int a) throws AWTException {						// Key press Robot
		Robot r = new Robot();
		r.keyPress(a);
	}
	
	public static void keyRelease(int a) throws AWTException {						// Key Release Robot
		Robot r = new Robot();
		r.keyRelease(a);
	}
	
	public static List<WebElement> getOptions(WebElement e) {						// Get Options
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		for (WebElement x:options) {
			x.getText();
		}
		return options;
	}
	
	public static void to(String url) {												// To
		driver.navigate().to(url);
	}
	
	public static void back() {														// Back
		driver.navigate().back();
	}
	
	public static void forward() {													// Forward
		driver.navigate().forward();
	}
	
	public static void refresh() {													// refresh							
		driver.navigate().refresh();
	}
	
	public static Dimension getSize(WebElement e) {									// Get Size
		Dimension size = e.getSize();
		return size;
	}
	
	public static void accept() {													// Accept Alert
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	public static void dismiss() {													// Dismiss Alert
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}
	
	public static void sendKeys(String value) {										// SendKeys Alert
		Alert al = driver.switchTo().alert();
		al.sendKeys(value);
	}
	
	public static String getText() {												// Get Text Alert
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		return text;
	}
	
	public static void getScreenshotAs(String location) throws IOException {		//ScreenShot
		TakesScreenshot ss =(TakesScreenshot)driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
		FileUtils.copyFile(source, dest);
	}
	
	public static void string(String value) {										// Frame using String
		driver.switchTo().frame(value);
	}
	
	public static void index(int a) {												// Frame using Index
		driver.switchTo().frame(a);
	}
	
	public static void executeScript(String first, String second) {					// JS Execute Script
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(first, second);
	}
	
	public static String getWindowHandle() {										// Get Window Handle
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public static void switchToWindow(int w) {										// Switch To Window
		Set<String> allID = driver.getWindowHandles();								// Get Window handles
		List<String> li = new LinkedList<>();	
		li.addAll(allID);
		driver.switchTo().window(li.get(w));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
