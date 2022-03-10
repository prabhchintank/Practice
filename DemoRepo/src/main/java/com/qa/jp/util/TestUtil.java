package com.qa.jp.util;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.jp.qa.base.BaseClass;

public class TestUtil extends BaseClass
	{
		
		public static final long IMPLICIT_WAIT = 0;
		public static long Page_load_timeout=50;
		public static long Page_implicit_Wait=50;
		
		
		
		/*public static void CheckBrowserOS()
		{
		 //Get Browser name and version.
		
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			String browserName = caps.getBrowserName();
			@SuppressWarnings("deprecation")
			String browserVersion = caps.getVersion();
		  
			//Get OS name.
			String os = System.getProperty("os.name").toLowerCase();
			System.out.println("OS = " + os + ", Browser = " + browserName + ", Browser Version "+ browserVersion);
		 } */
		
}