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

	WebDriver driver = new FirefoxDriver();
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Test
	public void TC01() throws Exception {

		driver.get("http://www.alinea.fr");
		Assert.assertTrue(driver.getPageSource().contains(
				"Alinéa : Mobilier et Décoration."));

		assertEquals(
				"Par produits",
				driver.findElement(By.cssSelector("li.first-level-item.active"))
						.getText());
		Thread.sleep(5);
		driver.close();

	}

	@Before
	public void setUp() throws Exception {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
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