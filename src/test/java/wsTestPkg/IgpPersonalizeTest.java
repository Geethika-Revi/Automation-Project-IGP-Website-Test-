package wsTestPkg;

import org.testng.annotations.Test;

import wsBasePkg.IgpBaseClass;
import wsPagePkg.IgpPersonalizePg;

public class IgpPersonalizeTest extends IgpBaseClass{
	@Test
	public void igpPersonalizePgTst() throws Exception {
		IgpPersonalizePg obj3 = new IgpPersonalizePg(driver);
				
		obj3.perslzd();
	}
}
