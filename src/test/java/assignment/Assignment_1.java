package assignment;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Assignment_1 {
	@Test
	public static void test() {

		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// 1
		WebElement FirstCheckBox = driver.findElement(By.id("checkBoxOption1"));
		FirstCheckBox.click();
		AssertJUnit.assertTrue(FirstCheckBox.isSelected());
		FirstCheckBox.click();
		AssertJUnit.assertFalse(FirstCheckBox.isSelected());

		// 2
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		driver.quit();
	}

}
