package wsTestPkg;

import org.testng.annotations.Test;

import wsBasePkg.IgpBaseClass;
import wsPagePkg.IgpHomePg;


public class IgpHomeTest extends IgpBaseClass{
	@Test
	public void igphomePgTst() throws Exception {
		IgpHomePg obj1 = new IgpHomePg(driver);
		
		obj1.persnlItem();
		Thread.sleep(1000);
		obj1.optnSel();
		Thread.sleep(1000);
		obj1.locatnButn("683101");
		obj1.sbmtButn();
        Thread.sleep(1000);
		obj1.prodctButn();
		
	}

}
