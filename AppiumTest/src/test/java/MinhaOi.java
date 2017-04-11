import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class MinhaOi {
	static WebDriver driverChrome;
	static WebDriver driverIE;
	static WebDriver driverFireFox;
	static DesiredCapabilities capacidade;
	static AndroidDriver driverAndroid;
	
	
	public static void setUpAndroid() throws MalformedURLException{
		
		File dirAplicativo = new File("c:\\TrianguloApp");
		File arqAplicativo = new File(dirAplicativo, "MinhaOi.apk");
		capacidade = new DesiredCapabilities();
		//definindo a plataforma que será testada.
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//definindo o dispositivo que será testado.
		//capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "0018903858");
		capacidade.setCapability("udid", "3300f86e4b43822b");
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME,"samsung");
		//capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Simulator");
		//definindo o aplicativo a ser testado.
		capacidade.setCapability(MobileCapabilityType.APP, arqAplicativo.getAbsolutePath());
		driverAndroid = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
	}

	public static void setUpChrome() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		driverChrome = new ChromeDriver(capabilities);
		driverChrome.get("https://login.oi.com.br/nidp/idff/sso?id=sso&sid=3&option=credential&sid=3");
		driverChrome.manage().window().maximize();

	}

	public void setUpFireFox() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver.exe");

		driverFireFox = new FirefoxDriver(capabilities);
		driverFireFox.get("https://login.oi.com.br/nidp/idff/sso?id=sso&sid=3&option=credential&sid=3");
		// driverFireFox.manage().window().maximize();

	}

	public static void setUpIE() throws InterruptedException {
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", "C:/Selenium/IEDriverServer64.exe");
		capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,
				"https://login.oi.com.br/nidp/idff/sso?id=sso&sid=3&option=credential&sid=3");
		capabilities.setCapability("requireWindowFocus", true);
		driverIE = new InternetExplorerDriver(capabilities);
		driverIE.manage().window().maximize();
		Thread.sleep(5000);

	}

	public static void login(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("usernameinput")).sendKeys("fernandofagunde@gmail.com");
		WebElement senha = driver.findElement(By.xpath("//*[@id='passwordinput']"));
		senha.sendKeys("Accenture0");
		WebElement entrar = driver.findElement(By.xpath("//*[@id='login']/div[1]/div[2]/form/button"));
		entrar.click();
		Thread.sleep(5000);
		//driver.quit();

	}
	public static void loginAndroid() throws InterruptedException{
		Thread.sleep(5000);
		//driverAndroid.findElement(By.id("br.com.mobicare.minhaoi:id/button_positive")).click();
		driverAndroid.findElement(By.id("br.com.mobicare.minhaoi:id/screenLogin_editTextUser")).sendKeys("fernandofagunde@gmail.com");
		driverAndroid.findElement(By.id("br.com.mobicare.minhaoi:id/screenLogin_editTextPass")).sendKeys("Accenture0");
		driverAndroid.findElement(By.id("br.com.mobicare.minhaoi:id/screenLogin_btnSignIn")).click();
		
		
		Thread.sleep(7000);
		driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='CONTAS']")).click();
		driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='RECARGA']")).click();
		driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='PACOTES']")).click();
		driverAndroid.findElement(By.xpath("//android.widget.TextView[@text='RECARGA']")).click();
		driverAndroid.findElement(By.xpath("//android.widget.Button[@text='R$ 20']")).click();
		
		//driverAndroid.findElement(By.xpath("//android.widget.ImageButton")).click();
	//	((AndroidDriver) driverAndroid).pressKeyCode(4);
		
//		driverAndroid.navigate().back();
	}
	
	public static void comprarPacotes(WebDriver driver) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='box-movel']/div/div/div[1]/div[2]/a")));
		
		driver.findElement(By.xpath("//*[@id='box-movel']/div/div/div[1]/div[2]/a")).click();
		//jse.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//*[@id='box-movel']/div/div/div[2]/div/section/ul/li[1]/a")).click();
		
		driver.get("https://minha.oi.com.br/portal/site/MinhaOi/menuitem.12c704971435fd109db49db4246d02a0/?vgnextoid=de00fe43b0c0e210VgnVCM1000009ad0200aRCRD&vgnextfmt=default");
		
		driver.findElement(By.xpath("//*[@id='formprinc']/section/table/tbody/tr[3]/td[2]/label/span[3]")).click();
		//jse.executeScript("window.scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//*[@id='formprinc']/section/table/tbody/tr[15]/td[2]/label/span[3]")).click();
		
		driver.findElement(By.xpath("//*[@id='submitBotao']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		
		
	}

	@Test
	public void fluxoChrome() throws Exception {

		setUpChrome();
		login(driverChrome);
		comprarPacotesChrome();
		driverChrome.quit();
	}

	@Test
	public  void fluxoIE() throws Exception {

		setUpIE();
		login(driverIE);
		//Thread.sleep(20000);
		comprarPacotesIE();
		driverIE.quit();

	}

	public void testLoginFireFox() throws InterruptedException {

		setUpFireFox();
		login(driverFireFox);

	}
	
	public void fluxoAndroid() throws MalformedURLException, InterruptedException{
		
		setUpAndroid();
		loginAndroid();
		driverAndroid.quit();

		
	}
	
	public static void comprarPacotesChrome() throws Exception{
		//setUpChrome();
		comprarPacotes(driverChrome);
		
		
		
	}
	
	public static void comprarPacotesIE() throws Exception{
		//setUpIE();
		comprarPacotes(driverIE);
		
		
		
	}


	public static void main(String[] args) throws Exception {
		//testLoginChrome();
		//testLoginIE();
		//Thread.sleep(120000);
		//comprarPacotesIE();
	
		

	}

}
