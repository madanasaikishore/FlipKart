package day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartPage1 extends BaseClass {
	public FlipKartPage1() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	private WebElement click;
	
	public WebElement getClick() {
		return click;
	}
	@FindBy(name="q")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}
	@FindBy(xpath="//button[@type='submit']")
	private WebElement find;

	public WebElement getFind() {
		return find;
	}
	@FindBy(xpath="//div[text()='APPLE iPhone 11 (Black, 64 GB)']")
	private WebElement first;

	public WebElement getFirst() {
		return first;
	}
	@FindBy(xpath="//button[text()='Add to Cart']")
	private WebElement add;

	public WebElement getAdd() {
		return add;
	}





















}
