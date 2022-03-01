package com.jp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class ChangeHotelPopUp extends BaseClass 
{

	@FindBy(xpath="//*[@id=\"Change_Hotel\"]/div/div/div/button/span")  
	WebElement crossBtnpopup;
	
	@FindBy(id="7640")
	WebElement RadioBtn;
	
	@FindBy(xpath="//a[@text='Update Packages' or @class='btn button-green-hover']")
	WebElement Updatebtn;

	public ChangeHotelPopUp()
	{
		super();
		PageFactory.initElements(driver, this);
	}

	public void changeHotelRadio_selected() throws InterruptedException
	{
		Thread.sleep(2000);
		Reporter.log(Status.INFO, "Clicking on the radio button for selecting the different hotel");
		RadioBtn.click();
		Reporter.log(Status.PASS ,"Radio button clicked successfully");
		Thread.sleep(2000);
		Reporter.log(Status.INFO,"Clicking on the update button for change the hotel");
		Updatebtn.click();
		Reporter.log(Status.PASS, "Hotel changed successfully");
		
	}
	
	@SuppressWarnings("deprecation")
	public WebElement crossPopUp() throws InterruptedException
	{
		Reporter.log(Status.INFO, "Clicking on the cross button");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, 120); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"Change_Hotel\"]/div/div/div/button/span"))); 
		crossBtnpopup.click();
		Reporter.log(Status.PASS, "Successfully clicked on the cross button and show package detail page");
		Thread.sleep(3000);	
		return crossBtnpopup;
	}

}