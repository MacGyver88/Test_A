package TestCase;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acceder_Site {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.alinea.fr");
		Assert.assertTrue(driver.getPageSource().contains("Alin�a : Mobilier et D�coration."));
		
		
		Thread.sleep(5);
		driver.close();

	}

}