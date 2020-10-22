package testnglearn;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Test {
	 public ExtentTest Test;    
	 public ExtentReports report;
	 public ExtentHtmlReporter repo;
public static Logger l= Logger.getLogger("devpinoyLogger");
	public  static WebDriver driver;

 @org.testng.annotations. BeforeTest
  public void start(){
	   repo= new ExtentHtmlReporter("./report/extent2.html");
	   repo.config().setEncoding("utf-8");
	   repo.config().setDocumentTitle("testngreports");
	   repo.config().setReportName("functional test");
	    repo.config().setTheme(Theme.DARK);
	    report= new ExtentReports();
	     report.attachReporter(repo);
	      report.setSystemInfo(" learning", "ExtentReport");
	      report.setSystemInfo("bulid no 1", " extentreports");
  }
 
 
 
 
	@org.testng.annotations.Test(priority=1)
	 public void launching(){
		Test= report.createTest("launching browser");
		//WebDriverManager.chromedriver().setup();
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
	     driver= new ChromeDriver();
	     l.debug("opening the browser");
		 
	}
	@org.testng.annotations.Test(priority=2)
	 public void navigating(){
		Test= report.createTest("navigating");
		 l.debug("navigating the link");
		  driver.get("E://google.html");
		   driver.manage().window().maximize();
		   l.debug("maximum");
		   
	 }
	@org.testng.annotations.Test(priority=4)
	 public void senddata(){
		Test= report.createTest("skiped");
		  throw new SkipException("skipped");
	 }
	
	
	@org.testng.annotations.Test(priority=3)
	 public void data(){
		Test= report.createTest("data");
		Assert.fail();
	 }	 

	@org.testng.annotations.AfterMethod
	 public void quit( ITestResult result){
	  
		 if(result.getStatus()==ITestResult.FAILURE){
			 
			 l.debug("failed");
			 String longText=Arrays.toString(result.getThrowable().getStackTrace());
			 Test.fail("<details"+"<summary>"+"<b>"+"<font color='red'>"+ "exception occur"+"</font></b>"+"</summary>"+longText.replace(",", "<br>")+"</details>"+"/n");
				Markup m= MarkupHelper.createLabel(longText, ExtentColor.RED);
				 Test.log(Status.FAIL, m);
			 
		 }else if(result.getStatus()==ITestResult.SKIP){
			 l.debug("skiped");
			 String longText=Arrays.toString(result.getThrowable().getStackTrace());
			 Test.skip("<details"+"<summary>"+"<b>"+"<font color='red'>"+ "exception occur"+"</font></b>"+"</summary>"+longText.replace(",", "<br>")+"</details>"+"/n");
				Markup m= MarkupHelper.createLabel(longText, ExtentColor.YELLOW);
				 Test.log(Status.SKIP, m);
			 
		 }else if(result.getStatus()==ITestResult.SUCCESS){
			 l.debug("passed");
			 String longText="<p>"+result.getMethod().getMethodName()+" passed</p>";
			Markup m= MarkupHelper.createLabel(longText, ExtentColor.GREEN);
			 Test.pass(m);
			 
			 
			 
		 }
		
		 }
	 @org.testng.annotations.AfterTest
	 public void create(){
		 report.flush();
	 }

}
	 






//@org.testng.annotations.Test
// public void senddata(){
//	  System.out.println(" no found");
//	   Assert.fail();
// }
//
//
//@org.testng.annotations.Test
// public void data(){
//	 
//	   throw new SkipException("exception");
// }

//@AfterTest
// public void quit( ITestResult result){
//  
//	 if(result.getStatus()==ITestResult.FAILURE){
//		 
//		 l.debug("failed");
//		 String longText="<p>"+result.getMethod().getMethodName()+"  is failed</p>";
//			Markup m= MarkupHelper.createLabel(longText, ExtentColor.RED);
//			 Test.fail(m);
//		 
//	 }else if(result.getStatus()==ITestResult.SKIP){
//		 l.debug("skiped");
//		 String longText="<p>"+result.getMethod().getMethodName()+" is skiped </p>";
//			Markup m= MarkupHelper.createLabel(longText, ExtentColor.YELLOW);
//			 Test.skip(m);
//		 
//	 }else if(result.getStatus()==ITestResult.SUCCESS){
//		 l.debug("passed");
//		 String longText="<p>"+result.getMethod().getMethodName()+" passed</p>";
//		Markup m= MarkupHelper.createLabel(longText, ExtentColor.GREEN);
//		 Test.pass(m);
//		 
//		 
//		 
//	 }
//	
//	 }