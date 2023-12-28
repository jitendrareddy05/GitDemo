package CDP_Practise;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.network.Network;
import org.openqa.selenium.devtools.v118.network.model.Request;
import org.openqa.selenium.devtools.v118.network.model.Response;

public class NetworkLogs {

	public static void main(String[] args) {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();

		devTools.send(Network.enable(Optional.<Integer>empty(), Optional.<Integer>empty(), Optional.<Integer>empty()));

		devTools.addListener(Network.requestWillBeSent(), request -> {
			Request req = request.getRequest();
//			System.out.println(req.getUrl());
		});

		devTools.addListener(Network.responseReceived(), response -> {
			Response res = response.getResponse();

			if (res.getStatus().toString().startsWith("4")) {
				System.out.println(res.getUrl() + " is failing with response code: " + res.getStatus());
			}
		});

		driver.get("https://httpbin.org/status/400");

		driver.quit();
	}

}
