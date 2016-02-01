package TestCase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CT14_Connexion {

	
	String email = "Test11@test.fr";
	String password = "testtest";
	
    WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Test
	public void TC014() throws Exception {
		
		 

		System.out.println("LogStatus.INFO - Navigating to alinea.fr");
		driver.get("http://www.alinea.fr");
	
	driver.findElement(By.xpath("//aside[@id='quicknav']/a[4]/strong")).click();
	driver.findElement(By.id("email_compte")).clear();
	driver.findElement(By.id("email_compte")).sendKeys(email);
	driver.findElement(By.id("pass_compte")).clear();
	driver.findElement(By.id("pass_compte")).sendKeys(password);
	
	//résultat attendu step 1
    try {
        assertEquals(email, driver.findElement(By.id("email_compte")).getAttribute("value"));
        System.out.println("LogStatus.PASS - Mail affiché dans le champ ");
    } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("LogStatus.FAIL - Mail affiché dans le champ " + "<pre>" + e.toString() + "</pre>");
      }
      try {
        assertEquals(password, driver.findElement(By.id("pass_compte")).getAttribute("value"));
        System.out.println("LogStatus.PASS - Mot de passe  affiché dans le champ ");
      } catch (Error e) {
        verificationErrors.append(e.toString());
        System.out.println("LogStatus.FAIL - Mot de passe  affiché dans les champ " + "<pre>" + e.toString() + "</pre>");
      }
      
	
	driver.findElement(By.cssSelector("#login-form > input[type=\"submit\"]")).click();
	try {
	assertEquals("Mon compte", driver.getTitle());
	System.out.println("LogStatus.PASS - Page Mon compte affichée");
	} catch (Error e) {
	      verificationErrors.append(e.toString());
	      System.out.println("LogStatus.FAIL -  Page Mon compte affichée " + e.toString());
	    }
	
	}
@Before
public void setUp() throws Exception {
	System.out.println("Test Alinea - Connexion");
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
