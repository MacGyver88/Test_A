package TestCase;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC02_recherche_produit {
	
	WebDriver driver;
	
	private StringBuffer verificationErrors = new StringBuffer();
	
	
	@Test
	public void TC02() throws Exception {

	
		driver.get("http://www.alinea.fr");

		WebElement Element_move_to_three = driver.findElement(By
				.linkText("Canapés, Fauteuils"));
		Actions action = new Actions(driver);
		action.moveToElement(Element_move_to_three).build().perform();

		driver.findElement(By.cssSelector("a > p")).click();
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
