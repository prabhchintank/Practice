package com.jp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class PackageListing extends BaseClass
{
	

	@FindBy(xpath = "//*[@id=\"alltrips\"]/div/div[1]/div/div/div/div[1]/div/div/div[3]/div/div/div[2]/a[2]")
	WebElement customizedButton;
	
	
	////Mehod
	public PackageListing()
	{
		PageFactory.initElements(driver, this);
	}
	
	public CustomizedPopUp verifyClickCustomizedBtn()
	{
		Reporter.log(Status.INFO, "Clicking on the cutomized button");
		customizedButton.click();
		Reporter.log(Status.PASS, "Cutomized button clicked successfully");
		return new CustomizedPopUp();
	}
	
}
