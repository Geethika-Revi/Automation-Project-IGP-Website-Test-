package wsBasePkg;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class IgpBaseClass {

public static WebDriver driver; //static
	
	@BeforeTest
	public void setup() {
		 // ChromeOptions to block notifications
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2); // 1 = Allow, 2 = Block
        options.setExperimentalOption("prefs", prefs);

        // Initialize ChromeDriver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.igp.com");
				
	}
	
		
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
