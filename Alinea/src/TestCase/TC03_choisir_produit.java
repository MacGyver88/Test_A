package TestCase;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC03_choisir_produit {
	
	
    WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Test
	public void TC03() throws Exception {

		driver.get("http://www.alinea.fr");
		
		//affichage des liste des produit
		driver.findElement(By.xpath("//a[contains(text(),'Canapés, Fauteuils')]")).click();
		
		WebElement Element_move_to_produit = driver.findElement(By.xpath("//div[@id='content']/div[2]/div[8]/div/div/img"));
		String ImageAvant = Element_move_to_produit.getAttribute("src");
		
		//placer le curseur sur un produit
		Actions action1 = new Actions(driver);
		action1.moveToElement(Element_move_to_produit).build().perform();
		
		String ImageApres = Element_move_to_produit.getAttribute("src"); 
		
		//comparaison entre image avant et après
		Assert.assertFalse(ImageApres.equals(ImageAvant));
		String titre1 = driver.getTitle();
		//click sur le produit
		driver.findElement(By.xpath("//div[@id='content']/div[2]/div[8]/div/div/img")).click();
		
		String titre2 = driver.getTitle();
		//verifier que l apage est changer 
		Assert.assertFalse(titre1.equals(titre2));
		
		driver.navigate().back();
		// verifier le retour au page précédente
		Assert.assertTrue(titre1.equals(driver.getTitle()));
		
		//click sur le liens
		driver.findElement(By.xpath("//div[@id='content']/div[2]/div[8]/div[2]/h3/a/span")).click();
		
		//String Prix = driver.findElement(By.cssSelector("#product-price-103597 > span.price")).getText();
		//Assert.assertFalse(Prix.isEmpty());
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
