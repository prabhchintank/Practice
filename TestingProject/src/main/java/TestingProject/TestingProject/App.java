package TestingProject.TestingProject;

import org.openqa.selenium.WebDriver;

import com.tp.qa.util.Xls_Reader;

/**
 * Hello world!
 *
 */
public class App 
{
	public static WebDriver driver=null;
	
    public static void main( String[] args )
    {
//    	WebDriverManager.chromedriver().setup();
//    	driver=new ChromeDriver();
//    	driver.get("https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror");
//      System.out.println( "Hello World!" );
//     
        Xls_Reader reader= new Xls_Reader("E:\\Eclipse\\Eclipse Projects\\TestingProject\\src\\main\\java\\com\\testData\\newxg.xlsx"); 
        String name="Sample";   /// sheet name under excel file must be same
      
      String data = reader.getCellData(name, 2, 2);   //sheet name, row, column     
     System.out.println("My data "+ data);
  
        int rowcount= reader.getRowCount(name);
        System.out.println("No of rows +" + rowcount);
    }
}
