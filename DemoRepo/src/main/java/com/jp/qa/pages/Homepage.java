package com.jp.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class Homepage extends BaseClass
{

	//---------------------PageFactory  /Object Repository------------------------
	
	

	@FindBy(xpath = "//img[contains(@alt,\'TravelRide\')]")
	WebElement Logoimage;
		
	@FindBy(id="origincityid")
	WebElement Origin_city;
	
	@FindBy(css="#mat-autocomplete-0") 
	WebElement selectCityOrigin;
	    
	@FindBy(id="destinationscityid")
	WebElement Desitination_city;
	    
	@FindBy(css="#mat-autocomplete-1")
	WebElement Selectcitydes;
	    
	@FindBy(id ="our-start-end")
	WebElement Bookdate_Calendar;
		
	@FindBy(xpath ="//*[@id=\"mat-datepicker-0\"]/div/mat-month-view/table/tbody/tr[6]/td[2]")
	WebElement Date_Select_from_calendar;
	    
	@FindBy(id ="IsAirPackages")
	WebElement Flight_checkbox;
	    
	@FindBy(name ="trip_type")
	WebElement Trip_type;
	    
	@FindBy(css ="#current > app-home > app-banner > section > div > div.tour-search.tour-wrapper2 > div > app-search > div > div > form > div > div.col-item.search--bar.align-self > div > button")
	WebElement Search_button;
	    
	//Initializing the objects
	public Homepage()
	{
		PageFactory.initElements(driver, this);    //All the above variable initialize by driver---this means pointing to current class object means Homepage
	}	
	    
	// Action/Method 
	public static String validateHomePageTitle() 
	{
		return driver.getTitle();

	}
	    
	public boolean validate_image() 
	{
		Reporter.log(Status.INFO, "Verifying the Logo image in the Homepage");
		return Logoimage.isDisplayed();
	}
	    
	public void selectdestination(String desCity) throws InterruptedException
	{
		Thread.sleep(5000);
		Reporter.log(Status.INFO, "Clicking on the destination field");
		Desitination_city.click();
		Reporter.log(Status.PASS, "Clicked successfully on destination field");
		Thread.sleep(5000);
		
		
		Reporter.log(Status.INFO, "Select the option from the destination dropdown by firstly entering the text");
		Desitination_city.sendKeys(prop.getProperty("desCity"));
		Reporter.log(Status.PASS,"Destination selected from the dropdown");
		Thread.sleep(3000);
		
	
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(Selectcitydes).click().perform();
		Thread.sleep(5000);    	
		Reporter.log(Status.PASS, "Clicked successfully on destination field");		
	}
	    
	public void selectorigin(String orgincity) throws InterruptedException
	{
		Thread.sleep(5000);
		Reporter.log(Status.INFO, "Clicking on the origin field");
		Origin_city.click();
		Thread.sleep(5000);
		Reporter.log(Status.INFO,"Select the option from the origin dropdown"); 
		Origin_city.sendKeys(prop.getProperty("orgincity"));
		Reporter.log(Status.PASS,"Origin selected from the dropdown");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(selectCityOrigin).click().perform();
		Thread.sleep(5000);    	
	}
	
	public void calendarDate() throws InterruptedException
	{
		Thread.sleep(3000);
		Bookdate_Calendar.click();
		Thread.sleep(5000);
		Reporter.log(Status.INFO,"Clicking on the calendar");
		Date_Select_from_calendar.click(); 
		Reporter.log(Status.PASS,"Particular date selected" +Bookdate_Calendar);
		Thread.sleep(5000);        
	}
	    
	public void flightbox() throws InterruptedException
	{	
		Thread.sleep(3000);    	
		Actions action = new Actions(driver);
		Thread.sleep(3000);
		action.moveToElement(Flight_checkbox).click().perform();
		Thread.sleep(5000);    	
	}	    

	public void trip()
	{
		Select mydrpdwn= new Select(Trip_type);
		mydrpdwn.selectByValue("1");   
		Reporter.log(Status.PASS,"Trip type selected ----" +mydrpdwn);
	}
	    
	public void searchbuttonclick() throws InterruptedException
	{
		Thread.sleep(3000);
		Reporter.log(Status.INFO,"Clicking  on the search button");
		Search_button.click();
		Reporter.log(Status.PASS,"Successfully click on the search button");
		Thread.sleep(3000);
	}
	    	
	
	///Business Method
	public PackageListing searching_with_des(String desCity) throws InterruptedException
	{		
		selectdestination(desCity); 
		Thread.sleep(5000);
	
		calendarDate();
		Thread.sleep(5000);
			
		searchbuttonclick(); 
		Thread.sleep(5000);
	
		return new PackageListing();  /////as after search redirect to package listing page so returning here
	}

	public PackageListing searching_with_ori_des(String orgincity,String desCity) throws InterruptedException
	{
		selectorigin(orgincity);
		Thread.sleep(5000);
			
		selectdestination(desCity); 
		Thread.sleep(5000);
	
		calendarDate();
		Thread.sleep(5000);
			
		flightbox();
		Thread.sleep(5000);
	
		searchbuttonclick(); 
		Thread.sleep(5000);
	
		return new PackageListing();  /////as after search redirect to package listing page so returing here
	}

	

}
