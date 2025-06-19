package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public  WebDriver driver;
	public Logger logger;
	public Properties prop;

	@BeforeMethod()	
	
	@Parameters({"Browser"})

	public void setup( @Optional("chrome")String browsername) throws IOException

	{
		 prop=new Properties();
		
		FileInputStream fs=new FileInputStream("./src//test//resources//data.properties");
		prop.load(fs);
		
		switch(browsername.toLowerCase())
		{
		case "chrome":
			 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();break;
			
		case "chromeheadless":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);break;
			
		case "firefox": driver=new FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default:System.out.println("No browser"); return;
		
		}
		
		 logger = LogManager.getLogger();
		
		// Maximize the browser
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("baseUrl"));

	}

	
	public String RandomStringGenerate()

	{
		return RandomStringUtils.randomAlphanumeric(6);
	}
	
	public String getScreenshot(String methodName,WebDriver driver) throws IOException {
		String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+currentTimeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilePath; 
	}

	@AfterMethod()	

	public void teardown()

	{

		driver.quit();
	}

}
