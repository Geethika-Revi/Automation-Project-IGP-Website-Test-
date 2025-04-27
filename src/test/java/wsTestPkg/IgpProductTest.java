package wsTestPkg;

import org.testng.annotations.Test;

import wsBasePkg.IgpBaseClass;
import wsPagePkg.IgpProductPg;


public class IgpProductTest extends IgpBaseClass{
	@Test
	public void igpProdctPgTst() throws Exception {
		IgpProductPg obj2 = new IgpProductPg(driver);
				
		obj2.dateTxtBox("May 2025", "26");
	}
		

	
}
