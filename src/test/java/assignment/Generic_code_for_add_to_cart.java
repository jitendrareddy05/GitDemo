package assignment;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Generic_code_for_add_to_cart {

	public static void addItems(String[] itemsToBeAddedToCart, WebDriver driver) {
		List<String> listOfitemsToBeAddedToCart = Arrays.asList(itemsToBeAddedToCart);
		int count = 0;

		List<WebElement> listOfProducts = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < listOfProducts.size(); i++) {
			String[] productText = listOfProducts.get(i).getText().split("-");
			String formattedProductText = productText[0].trim();

			if (listOfitemsToBeAddedToCart.contains(formattedProductText)) {
				count++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (count == listOfitemsToBeAddedToCart.size())
					break;
			}
		}
	}

	@Test
	public static void test() {

		String[] itemsToBeAddedToCart = { "Cauliflower", "Beans", "Mushroom", "Beetroot", "Walnuts", "Cashews" };

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(itemsToBeAddedToCart, driver);
		driver.quit();
	}

}
