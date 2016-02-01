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
		driver.get("http://www.alinea.fr");
	
	driver.findElement(By.xpath("//aside[@id='quicknav']/a[4]/strong")).click();
	driver.findElement(By.id("email_compte")).clear();
	driver.findElement(By.id("email_compte")).sendKeys(email);
	driver.findElement(By.id("pass_compte")).clear();
	driver.findElement(By.id("pass_compte")).sendKeys(password);
	
	//résultat attendi step 1
    try {
        assertEquals(email, driver.findElement(By.id("email_compte")).getAttribute("value"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      try {
        assertEquals(password, driver.findElement(By.id("pass_compte")).getAttribute("value"));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      
	
	driver.findElement(By.cssSelector("#login-form > input[type=\"submit\"]")).click();
	assertEquals("Mon compte", driver.getTitle());
	
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
