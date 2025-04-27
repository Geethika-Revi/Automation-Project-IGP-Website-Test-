package wsTestPkg;

import org.testng.annotations.Test;

import wsBasePkg.IgpBaseClass;
import wsPagePkg.IgpCartPg;


public class IgpCartTest extends IgpBaseClass {
	@Test
	public void igpCartPgTst() throws Exception {
		IgpCartPg obj4 = new IgpCartPg(driver);
		obj4.cart();
		obj4.loginDisplay();
		obj4.logOut();
	}
}
