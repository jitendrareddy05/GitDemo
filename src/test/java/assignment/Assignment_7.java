package assignment;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_7 {
	@Test
	public static void test() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,650)");

		System.out.println("No. of rows: " + driver.findElements(By.cssSelector(".table-display tr")).size());
		System.out.println(
				"No. of columns: " + driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th")).size());

		List<WebElement> secondRow = driver.findElements(By.cssSelector(".table-display tr:nth-child(3)"));
		for (WebElement secondRowContent : secondRow) {
			System.out.println(secondRowContent.getText());
		}
		driver.quit();
	}

}
