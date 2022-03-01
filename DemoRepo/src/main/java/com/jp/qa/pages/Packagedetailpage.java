package com.jp.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class Packagedetailpage extends BaseClass
{
	
	@FindBy(xpath="//input[contains(@placeholder,'0 Adults & 0 Child - 0 Rooms')]")
    WebElement Person_Infofield;
	
	@FindBy(xpath="//*[@id=\"customizemodal\"]/div/div/div[2]/div/form/div[1]/div[1]/div/div/div/select")
	WebElement RoomCountSelect;
	
	@FindBy(xpath="//*[@id=\"customizemodal\"]/div/div/div[2]/div/form/div[3]/button")
	WebElement DoneBtn;
	
	@FindBy(xpath="//a[contains(@data-target,'#Change_Hotel')]")
	WebElement changeHotelbtn;
	


    public Packagedetailpage()
    {
    	PageFactory.initElements(driver, this);    //All the above variable initialize by driver---this means pointing to current class object means Homepage
    }	

    public Object guest_dropdownClick() throws InterruptedException
    {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id=\"current\"]/app-package-detail/div[1]/section[1]/div/div/div/div/form/div/div[3]/div/div"));
    	Thread.sleep(3000);
    	Reporter.log(Status.INFO,"Clicking in the Guest field");
    	Person_Infofield.click();
    	Reporter.log(Status.PASS,"Succesfully clicked on the Guest field");
    	Thread.sleep(5000);    	
    	Reporter.log(Status.INFO,"Clicking on the selection of room drop down");
    	Select roomDropdown = new Select(RoomCountSelect);
    	roomDropdown.selectByValue("1: 2");
      	Reporter.log(Status.PASS,"Successfully select the no of rooms-----" +roomDropdown);
    	Thread.sleep(2000);
    	Reporter.log(Status.INFO,"Clicking on the done button");
    	DoneBtn.click();
    	Reporter.log(Status.PASS,"Done button clicked successfully and show package detail page");
    	Thread.sleep(5000);
    	return DoneBtn;
    }
    
   
	public ChangeHotelPopUp changeHotelPopup() throws InterruptedException
    { 	
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//div[contains(@class, 'col-2 col_custom_2')]"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		Thread.sleep(8000);
		Reporter.log(Status.INFO,"Clicking on the Hotel Change button");
    	changeHotelbtn.click();
    	Reporter.log(Status.PASS,"Successfully clicked on the Hotel Change button and show change hotel pop up");
    	Thread.sleep(3000);
    	return new ChangeHotelPopUp();
    }
}
