package TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC01_Acceder_Site {

	WebDriver driver ;
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Test
	public void TC01() throws Exception {

		System.out.println("LogStatus.INFO - Navigating to alinea.fr");
		driver.get("http://www.alinea.fr");
		
		try {
		Assert.assertTrue(driver.getPageSource().contains("Alin�a : Mobilier et D�coration."));
		System.out.println("LogStatus.PASS - Page affich�e ");
		
		} catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("LogStatus.FAIL - Page affich�e " + "<pre>" + e.toString() + "</pre>");
	      }
		
		try {
		assertEquals("Par produits",driver.findElement(By.cssSelector("li.first-level-item.active")).getText());
		System.out.println("LogStatus.PASS - Onglet <<Par Produit>> affich� par d�faut");
		
		} catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("LogStatus.FAIL - Onglet <<Par Produit>> affich� par d�faut" + "<pre>" + e.toString() + "</pre>");
	      }
		Thread.sleep(5);
		driver.close();

	}

	@Before
	public void setUp() throws Exception {
		
		System.out.println("Test Alinea - Acc�der au site");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		System.out.println("LogStatus.INFO - Launching browser");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}