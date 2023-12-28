package CDP_Practise;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class GeoLocation {

	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeDriver driver=new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map coOrdinates=new HashMap();
		coOrdinates.put("latitude", 35);
		coOrdinates.put("longitude", 139);
		coOrdinates.put("accuracy", 1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coOrdinates);
		
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("youtube", Keys.ENTER);
		
	}

}
