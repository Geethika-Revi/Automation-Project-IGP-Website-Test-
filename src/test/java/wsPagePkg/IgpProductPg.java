package wsPagePkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Product Page
public class IgpProductPg {
	WebDriver driver;
	
	@FindBy(id = "std-datepicker")            //Locate calendar text box
	WebElement datepickr;
	
	@FindBy(xpath = "//*[@id='ui-datepicker-div']/div/div")    //Locate current month
	WebElement curntCalndrMnth;
	
	@FindBy(xpath = "/html/body/div[5]/div[1]/a[2]/span")          //Locate next icon
	WebElement calndrNxtIcon;
	
		
	//Constructor
	public IgpProductPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);   //Initialize web elements
	}
	
	
	//Handling calendar
	public void dateTxtBox(String month, String date) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;    //Scroll Down
		js.executeScript("window.scrollBy(0,340)");
		datepickr.click();
		
		//Thread.sleep(1000);
		//dateSel("May 2025", "26");
		dateSel(month,date);
	}
	
	
	public void dateSel(String expmonth, String expdate) throws Exception {
		while(true)
		{
			String month = curntCalndrMnth.getText(); //Click on calendar title to find xpath//At present what is the month in the date picker calendar
			System.out.println("month = " + month);
			
			if (month.equals(expmonth))   //Check whether the current date in the date picker is equal to our required month (eg. here Aug 2025)
			{
				break;
			}
			else
			{
				calndrNxtIcon.click(); //click on the next icon in calendar window
				
			}
		}
		
		//Select data
		//List <WebElement> date = CalndrDate; //Store all 31 elements in the calendar and store in List
		List <WebElement> date = driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"));
		for(WebElement d : date) 																					//For xpath: Click on a random date, remove numerals in brackets of tr, tr..to take general xpath of all 31 numbers in a month
		{
			String datetext = d.getText();
			if(datetext.equals(expdate)) 
			{
				d.click();
				System.out.println("Date Selected successfully on calendar");
				break;				
			}
		}
	}	
}

