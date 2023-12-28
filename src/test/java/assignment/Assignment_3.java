package assignment;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment_3 {

	public static void login(WebDriver driver, WebDriverWait wait) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		driver.findElement(
				By.xpath("//div[@class='form-check-inline']/label/following-sibling::label/span[@class='checkmark']"))
				.click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("okayBtn"))));
		driver.findElement(By.id("okayBtn")).click();

		Select s = new Select(driver.findElement(By.tagName("Select")));
		s.selectByValue("consult");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
	}

	public static void addProductsToCart(WebDriver driver) {
		List<WebElement> listOfProducts = driver.findElements(By.className("card-title"));

		for (int i = 0; i < listOfProducts.size(); i++) {
			driver.findElements(By.className("btn-info")).get(i).click();
		}

		driver.findElement(By.cssSelector(".btn-primary")).click();
	}

	@Test
	public static void test() throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		login(driver, wait);
		addProductsToCart(driver);

		driver.quit();
	}

}
