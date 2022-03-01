package com.jp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class CustomizedPopUp extends BaseClass
{
	
	@FindBy(xpath = "//*[@id=\"Booking_modal_alltrips_1\"]/div/div/div[2]/div/form/div[3]/button[2]")
	WebElement Popcustomizedbtn;
	

	///Method
	public CustomizedPopUp()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Packagedetailpage clikCus_Btn() throws InterruptedException
	{
	
		Thread.sleep(5000);
		Reporter.log(Status.INFO, "In the pop up clicking on the customize button");
		Popcustomizedbtn.click();
		Reporter.log(Status.PASS, "Successfully clicked on the customize button in the pop up and redirects to package detail page");
		return new Packagedetailpage();
	}

}
