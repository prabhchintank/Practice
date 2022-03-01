package com.jp.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.CustomizedPopUp;
import com.jp.qa.pages.Homepage;
import com.jp.qa.pages.PackageListing;
import com.jp.qa.pages.Packagedetailpage;

public class PackageDetailPageTest extends BaseClass
{
	Homepage homepage;
	PackageListing packagelisting;
	CustomizedPopUp cutomizedpopup;
	Packagedetailpage detailpage;
	
	public PackageDetailPageTest()                          //create constructor
	{ 	
		super();
		PageFactory.initElements(driver, this);}
	
	@BeforeMethod
	public void setup() throws Exception                              //Call one method to fetch the object of Homepage class
	{
		homepage =new Homepage() ;
		packagelisting=new PackageListing(); 
		cutomizedpopup=new CustomizedPopUp();
		detailpage=new Packagedetailpage();
	}
	
	@Test(priority=1) 
	public void guestroomDropdown() throws InterruptedException
	{
		Reporter=extent.createTest("guestroomDropdown");
		homepage.searching_with_des(prop.getProperty("desCity"));
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.guest_dropdownClick();
	}
	
	@Test(priority=2) 
	public void hotelPopup() throws InterruptedException
	{
		Reporter=extent.createTest("hotelPopup");
		homepage.searching_with_ori_des(prop.getProperty("orgincity","desCity"), browser);
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.guest_dropdownClick();
		Thread.sleep(2000);
		detailpage.changeHotelPopup();
	}
}
