package com.jp.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.GeneralAboutProject;
import com.jp.qa.pages.Homepage;

public class GeneralPointsTest extends BaseClass
{
	GeneralAboutProject General;
	 public GeneralPointsTest()                          //create constructor
	 {	
		 super();
		 PageFactory.initElements(driver, this);
	 }
	 
	 @BeforeMethod
	 public void setup() throws Exception                              //Call one method to fetch the object of Homepage class
	 {
		 General =new GeneralAboutProject() ;
	 }

	
	
	
	@Test(priority=1)
	public void Title_Test() throws InterruptedException
	{ 
		Reporter=extent.createTest("Title of page");
		Reporter.log(Status.INFO,"Verifying the title of the page");
		String title= GeneralAboutProject.validateTitle();
		Assert.assertEquals(title,"JustPackages","title not matched");
		Reporter.log(Status.PASS,"Title of page --"+ title);
		Thread.sleep(5000);
	}
	
	

	@Test(priority=2)
	public void URL_Test() throws InterruptedException
	{ 
		Reporter=extent.createTest("URL of page");
		Reporter.log(Status.INFO, "Verifying the URL of Current page");
		String URL= GeneralAboutProject.URlofPage();
		Assert.assertEquals(URL,"http://justpackages.cybraintech.com/","URL of page not matched");      //Assert equal use
		Reporter.log(Status.PASS,"URL of page --"+ URL);
		Thread.sleep(5000);
	}
	
	@Test(priority=3)
	public void domain_Test() throws InterruptedException
	{ 
		Reporter=extent.createTest("domain_Test");
		Reporter.log(Status.INFO, "Verifying the domain name");
		String domain= GeneralAboutProject.domainName();
		Assert.assertEquals(domain,"justpackages.cybraintech.com","domain not matched");      //Assert equal use
		Reporter.log(Status.PASS,"Domain name --"+ domain);
		Thread.sleep(5000);
	}

	@Test(priority=4)
	public String Cssvalue_searchbtn() throws InterruptedException       	 
	{
		Reporter=extent.createTest("CSS Values get for searchbtn");
		Reporter.log(Status.INFO, "Verifying the CSS Values get for search button");
		General.cssValuesGet();
		Thread.sleep(5000);
		Reporter.log(Status.PASS,"CSS Values get for search button");
		Thread.sleep(5000);
		return browser;
	}
	
	
}
	
	

