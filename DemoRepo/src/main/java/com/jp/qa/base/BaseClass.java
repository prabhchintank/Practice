package com.jp.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.jp.qa.pages.Homepage;
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
		ExtentSparkReporter reporter =new ExtentSparkReporter("E:\\Eclipse\\Eclipse Projects\\DemoRepo\\target\\surefire-reports\\JustPackage_ExtentReport.html");
		extent.attachReporter(reporter);    //by version 5
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Just Packages");
		
		
		/*ExtentHtmlReporter reporter=new ExtentHtmlReporter("E:\\Eclipse\\Eclipse Projects\\JP\\test-output\\JustPackage_ExtentReport.html");   ///code for custom extend report with logs
		extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		reporter.setAppendExisting(true); 	*/      //   by version 3
	}
	
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
		//	TestUtil.CheckBrowserOS();
			System.setProperty("webdriver.gecko.driver","C:\\Webdriver\\geckodriver.exe");   //exe file for firefox will work
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
			
	
		//	WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) // If browser is Chrome, then do this	  
		{ 	
			//ChromeOptions options =new ChromeOptions();
			//options.addArguments("window-size=1400,800");          //some time this line need or some time not
			//options.addArguments("headless");
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();     //'options' text add in bracket when use headless command
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
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	

	@AfterMethod
		public void AfterMethod(ITestResult result) throws IOException, InterruptedException {
		    if (result.getStatus() == ITestResult.FAILURE) {
		    	Reporter.log(Status.FAIL,
		                MarkupHelper.createLabel(result.getName()
		                        + " Test case FAILED due to below issues:",
		                        ExtentColor.RED));
		    	Reporter.fail(result.getThrowable());
		    /*	try{
		    		// To create reference of TakesScreenshot
		    		TakesScreenshot screenshot=(TakesScreenshot)driver;
		    		// Call method to capture screenshot
		    		File src=screenshot.getScreenshotAs(OutputType.FILE);
		    		// Copy files to specific location
		    		// result.getName() will return name of test case so that screenshot name will be same as test case name
		    		FileUtils.copyFile(src, new File("D:\\"+result.getName()+".png"));
		    		System.out.println("Successfully captured a screenshot");
		    		}catch (Exception e){
		    		System.out.println("Exception while taking screenshot "+e.getMessage());
		    		}*/
		    	
		    	
		    	String screenshotPath = BaseClass.getScreenshot(driver, result.getName());
		    	Thread.sleep(3000);
		    	Reporter.log(Status.FAIL,"screenshot attached");
		    	Thread.sleep(1000);
		    	Reporter.addScreenCaptureFromPath(screenshotPath);
		     	Thread.sleep(5000);

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

