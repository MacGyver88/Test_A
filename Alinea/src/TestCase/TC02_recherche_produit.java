package TestCase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

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
		
		//résultat attendu step1
		assertTrue(isElementPresent(By.cssSelector("li.second-level-item.hover")));


		driver.findElement(By.cssSelector("a > p")).click();
		
		//résultat attendu step2
		assertEquals("Canapés, Banquettes", driver.findElement(By.cssSelector("h1")).getText());
		
		
		//Step3 scroll
		
		//scroll direct auto vers la fin du page

		//scroll vers le bas en plusieus step
		
	
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		for (int second = 0;; second++) {

			    jse.executeScript("window.scrollBy(0,800)", ""); //y value '800' can be altered
			    Thread.sleep(1000);

		    if(second >=10){
		        break;
		    }
		}
		
/*		WebElement element = driver.findElement(By.cssSelector("section.cgv"));
		Coordinates coordinate = ((Locatable)element).getCoordinates(); 
		coordinate.onPage(); 
		coordinate.inViewPort();
		Thread.sleep(5000);*/
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	
		
		
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
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

}
