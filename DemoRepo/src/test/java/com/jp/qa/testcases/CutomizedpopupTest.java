package com.jp.qa.testcases;
import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.CustomizedPopUp;
import com.jp.qa.pages.Homepage;
import com.jp.qa.pages.PackageListing;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CutomizedpopupTest extends BaseClass
{

	Homepage homepage;
	PackageListing packagelisting;
	CustomizedPopUp cutomizedpopup;
	
	public CutomizedpopupTest()
	{
		super();
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void setup() throws Exception                              //Call one method to fetch the object of Homepage class
	{
		homepage =new Homepage() ;
		packagelisting=new PackageListing(); 
		cutomizedpopup=new CustomizedPopUp();
	 }
	
	@Test(priority=1)
	public void  withoutflight_poptest() throws InterruptedException
	{
		Reporter=extent.createTest("withoutflight_poptest");
		homepage.searching_with_des(prop.getProperty("desCity"));
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
	}
	
	@Test(priority=2)
	public void withflight_poptest() throws InterruptedException
	{
		Reporter=extent.createTest("withoutflight_poptest");
		homepage.searching_with_ori_des(prop.getProperty("orgincity","desCity"), browser);
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
	}
}
