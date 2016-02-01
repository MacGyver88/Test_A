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
		Assert.assertTrue(driver.getPageSource().contains("Alinéa : Mobilier et Décoration."));
		System.out.println("LogStatus.PASS - Page affichée ");
		
		} catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("LogStatus.FAIL - Page affichée " + "<pre>" + e.toString() + "</pre>");
	      }
		
		try {
		assertEquals("Par produits",driver.findElement(By.cssSelector("li.first-level-item.active")).getText());
		System.out.println("LogStatus.PASS - Onglet <<Par Produit>> affiché par défaut");
		
		} catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("LogStatus.FAIL - Onglet <<Par Produit>> affiché par défaut" + "<pre>" + e.toString() + "</pre>");
	      }
		Thread.sleep(5);
		driver.close();

	}

	@Before
	public void setUp() throws Exception {
		
		System.out.println("Test Alinea - Accéder au site");
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