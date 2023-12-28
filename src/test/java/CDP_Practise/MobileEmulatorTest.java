package CDP_Practise;


import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.emulation.Emulation;
import org.openqa.selenium.devtools.v118.emulation.model.DisplayFeature;
import org.openqa.selenium.devtools.v118.emulation.model.ScreenOrientation;
import org.openqa.selenium.devtools.v118.page.model.Viewport;

public class MobileEmulatorTest {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools=driver.getDevTools();
		devTools.createSession();
		
		devTools.send(Emulation.setDeviceMetricsOverride(430, 932, 50, true, Optional.<Number>empty(), Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Boolean>empty(), Optional.<ScreenOrientation>empty(), Optional.<Viewport>empty(), Optional.<DisplayFeature>empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Library")).click();
	}
}
