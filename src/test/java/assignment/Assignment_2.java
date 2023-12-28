package assignment;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_2 {
	@Test

	public static void test() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.name("name")).sendKeys("Jitendra");
		driver.findElement(By.name("email")).sendKeys("jitendra@abc.com");
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("Password@123");
		driver.findElement(By.id("exampleCheck1")).click();

		Select genderDropDown = new Select(driver.findElement(By.id("exampleFormControlSelect1")));
		genderDropDown.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("27011998");
		driver.findElement(By.className("btn-success")).click();

		System.out.println(driver.findElement(By.className("alert-success")).getText());

		driver.quit();
	}

}
