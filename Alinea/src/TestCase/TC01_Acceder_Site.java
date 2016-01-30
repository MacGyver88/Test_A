package TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC01_Acceder_Site {
	
	
	@Test
	public static void main(String[] args) throws InterruptedException {

		
        WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.alinea.fr");
		Assert.assertTrue(driver.getPageSource().contains("Alinéa : Mobilier et Décoration."));
		
		assertEquals("Par produits", driver.findElement(By.cssSelector("li.first-level-item.active")).getText());
		Thread.sleep(5);
		driver.close();

	}

}