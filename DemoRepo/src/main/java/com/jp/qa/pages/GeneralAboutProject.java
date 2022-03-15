package com.jp.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.jp.qa.base.BaseClass;

public class GeneralAboutProject extends BaseClass
{
	@FindBy(css ="#current > app-home > app-banner > section > div > div.tour-search.tour-wrapper2 > div > app-search > div > form > div > div:nth-child(5) > input")

	WebElement Search_button;
	
	  public GeneralAboutProject()
	    {
	    	PageFactory.initElements(driver, this);    //All the above variable initialize by driver---this means pointing to current class object means Homepage
	    }	
	
	
	
	public static String validateTitle() 
	{
		return driver.getTitle();     				//Title of page
	}
	
	public static String URlofPage() 
	{
		return driver.getCurrentUrl();     	       //Current URL of page
	}
	
	public static String domainName()       	   //get domain
	{
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		String CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
		return CurrentURLUsingJS;
	}

	public  String  cssValuesGet() {
		// TODO Auto-generated method stub
		String fontsize = Search_button.getCssValue("font-size");
		Reporter.log(Status.PASS, "Successfully get the font-size---- " +fontsize);
		
		String color =Search_button.getCssValue("color");
		Reporter.log(Status.PASS, "Successfully get the color------ " +color);
		
		String fontfamily  =Search_button.getCssValue("font-family");
		Reporter.log(Status.PASS, "Successfully get the font-family---- " +fontfamily);
		
		String align = Search_button.getCssValue("text-align");
		Reporter.log(Status.PASS, "Successfully get the alignment--- " +align);
		return align;
		
		
	
	}
}
