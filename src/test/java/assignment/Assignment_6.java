package assignment;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_6 {
	@Test
	public static void test() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("checkBoxOption1")).click();
		String checkBoxText = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/..")).getText();

		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(checkBoxText);

		driver.findElement(By.id("name")).sendKeys(checkBoxText);

		driver.findElement(By.id("alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains(checkBoxText))
			System.out.println("CheckBox text is present");

		driver.quit();
	}

}
