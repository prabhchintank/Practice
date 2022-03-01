package com.jp.qa.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jp.qa.base.BaseClass;
import com.jp.qa.pages.ChangeHotelPopUp;
import com.jp.qa.pages.CustomizedPopUp;
import com.jp.qa.pages.Homepage;
import com.jp.qa.pages.PackageListing;
import com.jp.qa.pages.Packagedetailpage;

public class ChangeHotelPopupsTest extends BaseClass
{
	Homepage homepage;
	PackageListing packagelisting;
	CustomizedPopUp cutomizedpopup;
	ChangeHotelPopUp changehotelbtn;
	Packagedetailpage detailpage;
	
	public ChangeHotelPopupsTest()
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
		detailpage=new Packagedetailpage();
		changehotelbtn=new ChangeHotelPopUp();
	}
	
	
	@Test(priority=1)
	public void withoutflight_changeHotel() throws InterruptedException
	{
		Reporter=extent.createTest("withoutflight_changeHotel");
		homepage.searching_with_des(prop.getProperty("desCity"));
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);	
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.changeHotelPopup();
		Thread.sleep(3000);
		changehotelbtn.changeHotelRadio_selected();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void withflight_changeHotel() throws InterruptedException
	{
		Reporter=extent.createTest("withflight_changeHotel");
		homepage.searching_with_ori_des(prop.getProperty("orgincity","desCity"), browser);
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.changeHotelPopup();
		Thread.sleep(3000);
		changehotelbtn.changeHotelRadio_selected();
		Thread.sleep(3000);
	}
	
	
	@Test(priority=3)
	public void withoutflight_crossbtn() throws InterruptedException
	{
		Reporter=extent.createTest("withoutflight_crossbtn");
		homepage.searching_with_des(prop.getProperty("desCity"));
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);	
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.changeHotelPopup();
		Thread.sleep(3000);
		changehotelbtn.crossPopUp();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void withflight_crossbtn() throws InterruptedException
	{
		Reporter=extent.createTest("withflight_crossbtn");
		homepage.searching_with_ori_des(prop.getProperty("orgincity","desCity"), browser);
		Thread.sleep(3000);
		packagelisting.verifyClickCustomizedBtn();
		Thread.sleep(5000);
		cutomizedpopup.clikCus_Btn();
		Thread.sleep(5000);
		detailpage.changeHotelPopup();
		Thread.sleep(3000);
		changehotelbtn.crossPopUp();
		Thread.sleep(3000);
	}
}
