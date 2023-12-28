package AutoIt;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fileUpload {

	public static void main(String[] args) throws IOException, InterruptedException {
		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\user1\\OneDrive\\Documents\\autoITFileUpload.exe");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		driver.findElement(By.id("processTask")).click();
//		driver.findElement(By.cssSelector(".btn--secondary")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(10000);
		File file=new File(downloadPath+"/Assessment.docx");
		System.out.println(file.exists());
		file.delete();
		
		driver.quit();
	}

}
