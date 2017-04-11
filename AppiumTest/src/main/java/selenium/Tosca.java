package selenium;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tosca {
	WebDriver Chrome;

	@Before
	public void setUp() throws Exception {
		// conexão chrome
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		Chrome = new ChromeDriver(capabilities);

	}

	@Test
	public void test() throws InterruptedException {
		
		TestEncapsulamento.encapsula(Chrome);
		
		
		}
	
	

}
