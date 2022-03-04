package com.jp.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.jp.qa.base.BaseClass;

public class GeneralAboutProject extends BaseClass
{
	@FindBy(css ="#current > app-home > app-banner > section > div > div.tour-search.tour-wrapper2 > div > app-search > div > div > form > div > div.col-item.search--bar.align-self > div > button")
	WebElement Search_button;
	
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
	
	public void cssValuesGet()       	   //get domain
	{
		Search_button.getCssValue("font-size");
		Search_button.getCssValue("color");
		Search_button.getCssValue("font-family");
		Search_button.getCssValue("text-align");
	}
	
	

}
