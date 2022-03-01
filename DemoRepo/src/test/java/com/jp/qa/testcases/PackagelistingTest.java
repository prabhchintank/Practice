package com.jp.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.Homepage;
import com.jp.qa.pages.PackageListing;

public class PackagelistingTest extends BaseClass
{
	Homepage homepage;
	PackageListing packagelisting;
	
	 public PackagelistingTest()                          //create constructor
	 { 
		 super();
		 PageFactory.initElements(driver, this);
	 }
	 
	 @BeforeMethod
	 public void setup() throws Exception                              //Call one method to fetch the object of Homepage class
	 {
		 homepage =new Homepage() ;
		 packagelisting=new PackageListing();
	 }
	 
	 @Test(priority=1)
	 public void customizedpopup_redirectwithoutflight() throws InterruptedException
	 {
		 Reporter=extent.createTest("customizedpopup_redirectwithoutflight");
		 homepage.searching_with_des(prop.getProperty("desCity"));
		 Thread.sleep(3000);
		 packagelisting.verifyClickCustomizedBtn();
		 Thread.sleep(5000);
	 } 
	 
	 @Test(priority=2)
	 public void customizedpopup_redirectwithflight() throws InterruptedException
	 {
		 Reporter=extent.createTest("customizedpopup_redirectwithflight");
		 homepage.searching_with_ori_des(prop.getProperty("orgincity","desCity"), browser);
		 Thread.sleep(3000);
		 packagelisting.verifyClickCustomizedBtn();
		 Thread.sleep(5000);
	 } 
}