package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TC02_recherche_produit {
	
	public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.alinea.fr");
	
	WebElement Element_move_to_three = driver.findElement(By.linkText( "Canapés, Fauteuils"));
	Actions action = new Actions(driver);
	action.moveToElement(Element_move_to_three).build().perform();
	
	
	
	driver.findElement(By.cssSelector("a > p")).click();
	}
}
