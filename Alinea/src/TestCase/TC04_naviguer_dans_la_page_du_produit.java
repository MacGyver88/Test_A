package TestCase;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC04_naviguer_dans_la_page_du_produit {

	
	WebDriver driver;	
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Test
	public void TC04() throws Exception {
	
		System.out.println("LogStatus.INFO - Navigating to alinea.fr");
		driver.navigate().to("http://www.alinea.fr/par-type-de-produit/les-canapes-et-fauteuils/canapes-et-banquettes.html");
		
		
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//div[15]/div/div/img"));
		
		Point hoverItem =webElement.getLocation();
		((JavascriptExecutor)driver).executeScript("return window.title;");    
		Thread.sleep(4000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+(hoverItem.getY())+");");
		
		
		
		String ImageAvant = webElement.getAttribute("src"); 
	
		Actions action = new Actions(driver);
		action.moveToElement(webElement).build().perform();
		Thread.sleep(2000);
		String ImageApres = webElement.getAttribute("src"); 
        
        //comparaison entre image avant et apr�s
		try{
        Assert.assertFalse(ImageApres.equals(ImageAvant));
		System.out.println("LogStatus.PASS - Visuel du produit correspand � la miniature");
		
		} catch (Error e) {
	        verificationErrors.append(e.toString());
	        System.out.println("LogStatus.FAIL - Visuel du produit correspand � la miniature" + "<pre>" + e.toString() + "</pre>");
	      }
       



		
	}
	
	@Before
	public void setUp() throws Exception {
		
		System.out.println("Test Alinea - Naviguer dans la page du produit");
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
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
}
