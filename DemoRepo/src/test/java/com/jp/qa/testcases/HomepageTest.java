package com.jp.qa.testcases;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.Homepage;


public class HomepageTest extends BaseClass
{
	
	 Homepage homepage;
	 public HomepageTest()                          //create constructor
	 {	
		 super();
		 PageFactory.initElements(driver, this);
	 }
	 
	 @BeforeMethod
	 public void setup() throws Exception                              //Call one method to fetch the object of Homepage class
	 {
		 homepage =new Homepage() ;
	 }

	 
	@Test(priority=1)
	public void homePageTitleTest() throws InterruptedException
	{ 
		Reporter=extent.createTest("homePageTitleTest");
		Reporter.log(Status.INFO,"Verifying the title of the Homepage");
		String title= Homepage.validateHomePageTitle();
		Assert.assertEquals(title,"JustPackages","Homepage title not matched");
		Reporter.log(Status.INFO,"Title of Homepage --"+ title);
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void blanksearch() throws InterruptedException
	{
		Reporter=extent.createTest("blanksearch");
		String text = "Please select destination city.";
		Thread.sleep(5000);
		homepage.searchbuttonclick(); 
		Reporter.log(Status.INFO,"Validating message text on the blank input with click on the search  button");
		Assert.assertTrue(true,text);
		Reporter.log(Status.PASS, "validation text matched-----" +text);
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void searchTestWithoutFlight() throws InterruptedException
	{
		Reporter=extent.createTest("searchTestWithoutFlight");
		homepage.searching_with_des(prop.getProperty("desCity"));
	}
	
	@Test(priority=4)
	public void searchTestWithFlight() throws InterruptedException
	{
		Reporter=extent.createTest("searchTestWithFlight");
		homepage.searching_with_ori_des(browser, browser);
	}
}
