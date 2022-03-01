package com.jp.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.jp.util.TestUtil;

//import atu.testrecorder.ATUTestRecorder;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass
{
	public static WebDriver driver=null;
	//ATUTestRecorder recorder;
	protected String browser;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest Reporter;
	public BaseClass()
	{ 
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("E:\\Eclipse\\Eclipse Projects\\DemoRepo\\src\\main\\java\\com\\jp\\qa\\config\\Config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	@BeforeSuite
	public void extendreport()
	{
		extent=new ExtentReports();
		ExtentSparkReporter reporter =new ExtentSparkReporter("C:\\Users\\pratikshya\\.jenkins\\workspace\\GitProject\\target\\surefire-reports\\JustPackage_ExtentReport.html");
		extent.attachReporter(reporter);    //by version 5
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Just Packages");
		
		
		/*ExtentHtmlReporter reporter=new ExtentHtmlReporter("E:\\Eclipse\\Eclipse Projects\\JP\\test-output\\JustPackage_ExtentReport.html");   ///code for custom extend report with logs
		extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		reporter.setAppendExisting(true); 	*/      //   by version 3
	}

	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void browsersetup()throws Exception  //String browser
	{  
	/*	Reporter.log("Recording Start");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");                                       //For video recording set date and time
		Date date = new Date();
		recorder = new ATUTestRecorder("E:\\Eclipse\\Eclipse Projects\\JP\\ScriptsVideos","TestVideo-" +dateFormat.format(date),false);

		//***************************************************To start video recording.************************************************************
		recorder.start(); */
		
		browser=prop.getProperty("browser");  // by config file
		if(browser.equalsIgnoreCase("firefox"))  // If the browser is Firefox, then do this 
		{ 
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) // If browser is Chrome, then do this	  
		{ 	
			WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();  
		}
		
		else
		{
			Assert.assertTrue(false,"No browser type sent");
		}	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Page_implicit_Wait, TimeUnit.SECONDS);	
		driver.get(prop.getProperty("baseurl")); 
	}
	

	@AfterMethod
		public void AfterMethod(ITestResult result) {

		    if (result.getStatus() == ITestResult.FAILURE) {
		    	Reporter.log(Status.FAIL,
		                MarkupHelper.createLabel(result.getName()
		                        + " Test case FAILED due to below issues:",
		                        ExtentColor.RED));
		    	Reporter.fail(result.getThrowable());
		    } else if (result.getStatus() == ITestResult.SUCCESS) {
		    	Reporter.log(
		                Status.PASS,
		                MarkupHelper.createLabel(result.getName()
		                        + " Test Case PASSED", ExtentColor.GREEN));
		    } else {
		    	Reporter.log(
		                Status.SKIP,
		                MarkupHelper.createLabel(result.getName()
		                        + " Test Case SKIPPED", ExtentColor.ORANGE));
		    	Reporter.skip(result.getThrowable());
		    }
		


		if(driver!=null) 
		{
			System.out.println("Closing Page");
		
			driver.quit();              //close Browser after whole package run
		} 
		//recorder.stop();;	
	}

	@AfterTest
	public void flush()
	{
		extent.flush();       //to generate report   
	}
}

