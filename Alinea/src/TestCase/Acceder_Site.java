package TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acceder_Site {

	public static void main(String[] args) throws InterruptedException {

		
        WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.alinea.fr");
		Assert.assertTrue(driver.getPageSource().contains("Alin�a : Mobilier et D�coration."));
		
		assertEquals("Par produits", driver.findElement(By.cssSelector("li.first-level-item.active")).getText());
		Thread.sleep(5);
		driver.close();

	}

}