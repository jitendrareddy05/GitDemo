package assignment;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class Assignment_8 {
	@Test
	public static void test() throws IOException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("ind");

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File("C:\\Users\\user1\\Downloads\\screenshot.png"));

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[.='India']"))).click().build().perform();

		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		driver.quit();
	}

}
