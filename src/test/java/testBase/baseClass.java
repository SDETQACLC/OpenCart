package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.remote.RemoteWebDriver;

import static org.apache.commons.lang3.RandomStringUtils.*;

public class baseClass {
	
	
	
public  static WebDriver driver;
public Logger logger; //log4j
public Properties p;
	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})	
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
		
		//loading config.properties file
				FileReader file = new FileReader("./src//test//resources//config.properties");
				p=new Properties();
				p.load(file);
		
		
		
		
		
		
				if ("remote".equalsIgnoreCase(p.getProperty("execution_env"))) {
				    URL hubUrl = new URL("http://localhost:4444");

				    RemoteWebDriver rwd;
				    switch (br.toLowerCase()) {
				      case "chrome":
				        ChromeOptions chromeOpts = new ChromeOptions();
				        chromeOpts.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
				        chromeOpts.setPlatformName(os.toUpperCase());
				        rwd = new RemoteWebDriver(hubUrl, chromeOpts);
				        break;

				      case "edge":
				        EdgeOptions edgeOpts = new EdgeOptions();
				        edgeOpts.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--remote-allow-origins=*");
				        edgeOpts.setPlatformName(os.toUpperCase());
				        rwd = new RemoteWebDriver(hubUrl, edgeOpts);
				        break;

				      case "firefox":
				        FirefoxOptions ffOpts = new FirefoxOptions();
				        ffOpts.addArguments("--no-sandbox", "--disable-dev-shm-usage");
				        ffOpts.setPlatformName(os.toUpperCase());
				        rwd = new RemoteWebDriver(hubUrl, ffOpts);
				        break;

				      default:
				        throw new IllegalArgumentException("Unsupported browser: " + br);
				    }

				    driver = rwd;
				}
		
		
		
			
		
		//If Execution environment is local
		
		if(p.getProperty("execution_env").equals("local"))
		{
		
		switch(br)
		{
		
		case "Chrome": driver= new ChromeDriver(); break;
		case "Edge": driver= new EdgeDriver(); break;
		case "Firefox": driver= new FirefoxDriver(); break;
		default: System.out.println("Invalid browser name");return;
		}
		}
		
		
		logger=LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		
		
		
		
		
			
		driver.get(p.getProperty("appurl")); //Reading url from properties file
		driver.manage().window().maximize();
		
		
	}	
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown() 
	{
		driver.close();
	}
	
	

    /** 1. Alphabetic String (A–Z or a–z) */
    public static String randomAlpha() {
        // Uses letters only
        return randomAlphabetic(5);
    }

    /** 2. Numeric String (0–9) */
    public static String randomNum() {
        return randomNumeric(5);
    }

    /** 3. Alphanumeric String (letters + digits) */
    public static String randomAlnum() {
        return randomAlphanumeric(8);
    }
    
    
    //Capture screen method
    
public String captureScreen(String tname) throws IOException {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
		}

}
