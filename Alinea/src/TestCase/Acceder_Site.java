package TestCase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acceder_Site {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.alinea.fr");
		Assert.assertTrue(driver.getPageSource().contains("Alinéa : Mobilier et Décoration."));
		
		
		Thread.sleep(5);
		driver.close();

	}

}