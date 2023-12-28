package CrossBrowser_Testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class BrowserStack {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap=new DesiredCapabilities();
		
		WebDriver driver=new RemoteWebDriver(new URL("https://hub.browserstack.com/wb/hub"), cap);
		
		driver.get("https://www.bstackdemo.com");
		Assert.assertTrue(driver.getTitle().matches("StackDemo"));
		// Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();

        // See if the cart is opened or not
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Assert.assertEquals(productOnScreenText, productOnCartText);
		
	}

}
