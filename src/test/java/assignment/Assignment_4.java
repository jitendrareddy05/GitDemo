package assignment;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_4 {
	@Test
	public static void test() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://the-internet.herokuapp.com/windows");
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> totalWindows = driver.getWindowHandles();
		Iterator<String> window = totalWindows.iterator();
		String parentWindow = window.next();
		String childWindow = window.next();

		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.tagName("h3")).getText());

		driver.quit();

	}

}
