package wsTestPkg;

import org.testng.annotations.Test;

import wsBasePkg.IgpBaseClass;
import wsPagePkg.IgpCartPg;
import wsPagePkg.IgpHomePg;
import wsPagePkg.IgpLoginPg;
import wsPagePkg.IgpPersonalizePg;
import wsPagePkg.IgpProductPg;
import wsUtilities.WsExcelUtils;

public class IgpLoginTest extends IgpBaseClass{

	@Test
	public void igpdatadriven() throws Exception {
		IgpLoginPg obj = new IgpLoginPg(driver);
				
		//Reading the data from excel file by the specified path
		String xl = "C:\\Users\\geeth\\OneDrive\\Desktop\\Selenium_Works\\IgpWebsiteTestData\\IgpLoginData.xlsx";
		String Sheet = "Sheet1";
		int rowCount = WsExcelUtils.getRowCount(xl, Sheet); //calling WsExcelutils cls, getRowCount method (static method, obj not required)
		
		for(int i = 1;i<= rowCount; i++)
		{
			String UserName = WsExcelUtils.getCellValString(xl,Sheet,i,0);
			System.out.println("email----" + UserName);
			
			
			String Pwd = WsExcelUtils.getCellValString(xl, Sheet, i, 1); // (Excel, sheet, row, column) 1st row lst column.
			System.out.println("password---" + Pwd);
			
			obj.login();
			
						
			// Passing User name and password as parameters 
			obj.setvalues(UserName, Pwd);
			// Submitting the data by clicking on login button 
			obj.submit();
			
			Thread.sleep(3000); //3 sec delay
			
			// Login Validation
			String expectedurl="https://www.igp.com/";
			String actualurl = driver.getCurrentUrl();
			if (actualurl.equals(expectedurl)) 
			{
				System.out.println("Login validation = Pass");
				
				//Object 1 created for Home Page----------------------------------------------------
				
				IgpHomePg obj1 = new IgpHomePg(driver);
				
				obj1.persnlItem();
				Thread.sleep(1000);
				obj1.optnSel();
				Thread.sleep(1000);
				obj1.locatnButn("683101");
				obj1.sbmtButn();
                Thread.sleep(1000);
				obj1.prodctButn();
				
								
				//Object 2 created for Product Page-------------------------------------------------
				IgpProductPg obj2 = new IgpProductPg(driver);
				Thread.sleep(1000);
				obj2.dateTxtBox("May 2025", "26");
				
				
				//Object 3 created for Personalization page-----------------------------------------
				IgpPersonalizePg obj3 = new IgpPersonalizePg(driver);
				obj3.perslzd();
				
				//obj2.dateSel("May 2025", "26");

												
				//Object 4 created for Cart Page-----------------------------------------------------
				IgpCartPg obj4 = new IgpCartPg(driver);
				obj4.cart();
				obj4.loginDisplay();
				obj4.logOut();
				
			}
			else {
				System.out.println("Login validation = Fail");
				driver.get("https://www.igp.com/");
			}
			
		}
		
	}		
		
}
