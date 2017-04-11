package selenium;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestEncapsulamento {
	
	
	
	
	public static void encapsula(WebDriver chrome){
		
		chrome.get("http://sampleapp.tricentis.com/");

		//// *[@id="Map"]/area[1]
		chrome.manage().window().maximize();

		// Buscar Elemento
		WebElement moto = chrome.findElement(By.id("nav_motorcycle"));
		moto.click();

		WebElement make = chrome.findElement(By.id("make"));
		make.sendKeys("Audi");

		WebElement model = chrome.findElement(By.id("model"));
		model.sendKeys("Scooter");

		WebElement cylindercapacity = chrome.findElement(By.id("cylindercapacity"));
		cylindercapacity.sendKeys("200");

		WebElement engineperformance = chrome.findElement(By.id("engineperformance"));
		engineperformance.sendKeys("200");

		WebElement dateofmanufacture = chrome.findElement(By.id("dateofmanufacture"));
		dateofmanufacture.sendKeys("03/14/2017");

		WebElement numberofseatsmotorcycle = chrome.findElement(By.id("numberofseatsmotorcycle"));
		numberofseatsmotorcycle.sendKeys("1");

		WebElement listprice = chrome.findElement(By.id("listprice"));
		listprice.sendKeys("10000");

		WebElement annualmileage = chrome.findElement(By.id("annualmileage"));
		annualmileage.sendKeys("10000");

		WebElement nextenterinsurantdata = chrome.findElement(By.id("nextenterinsurantdata"));
		nextenterinsurantdata.click();

		WebElement enterInsurance = chrome.findElement(By.id("enterinsurantdata"));
		enterInsurance.click();

		WebElement firstname = chrome.findElement(By.id("firstname"));
		firstname.sendKeys("Fernando");

		WebElement lastname = chrome.findElement(By.id("lastname"));
		lastname.sendKeys("Andrade");

		WebElement birthdate = chrome.findElement(By.id("birthdate"));
		birthdate.sendKeys("03/24/1990");

		WebElement sexo = chrome
				.findElement(By.xpath(".//*[@id='insurance-form']/div/section[2]/div[4]/p/label[1]/span"));
		sexo.click();

		WebElement streetaddress = chrome.findElement(By.id("streetaddress"));
		streetaddress.sendKeys("Rua Doutor João Coimbra");

		WebElement country = chrome.findElement(By.id("country"));
		country.sendKeys("Brazil");

		WebElement zipcode = chrome.findElement(By.id("zipcode"));
		zipcode.sendKeys("55010590");

		WebElement city = chrome.findElement(By.id("city"));
		city.sendKeys("Recife");

		WebElement occupation = chrome.findElement(By.id("occupation"));
		occupation.sendKeys("Employee");

		WebElement hobbies = chrome
				.findElement(By.xpath(".//*[@id='insurance-form']/div/section[2]/div[10]/p/label[1]/span"));
		hobbies.click();

		WebElement website = chrome.findElement(By.id("website"));
		website.sendKeys("fernandofagunde.google.sites.com");

		WebElement open = chrome.findElement(By.id("nextenterproductdata"));
		open.click();

		//////////
		WebElement startdate = chrome.findElement(By.id("startdate"));
		startdate.sendKeys("05/23/2017");

		WebElement insurancesum = chrome.findElement(By.id("insurancesum"));
		insurancesum.sendKeys("3.000.000,00");

		// WebElement meritrating = Chrome.findElement(By.id("meritrating"));
		// meritrating.sendKeys("Bonus 1");

		WebElement damageinsurance = chrome.findElement(By.id("damageinsurance"));
		damageinsurance.sendKeys("NO Coverage");

		WebElement optional = chrome
				.findElement(By.xpath(".//*[@id='insurance-form']/div/section[3]/div[4]/p/label[1]/span"));
		optional.click(); 

		

		WebElement nextselectpriceoption = chrome.findElement(By.id("nextselectpriceoption"));
		nextselectpriceoption.click();

		WebElement silver = chrome.findElement(By.xpath(".//*[@id='priceTable']/tfoot/tr/th[2]/label[1]/span"));
		silver.click(); 

		WebElement nextsendquote = chrome.findElement(By.id("nextsendquote"));
		nextsendquote.click();

		//////
		WebElement email = chrome.findElement(By.id("email"));
		email.sendKeys("fernandofagunde@gmail.com");

		WebElement phone = chrome.findElement(By.id("phone"));
		phone.sendKeys("81973012529");

		WebElement username = chrome.findElement(By.id("username"));
		username.sendKeys("fernandofagunde");

		WebElement password = chrome.findElement(By.id("password"));
		password.sendKeys("Teste01");

		WebElement confirmpassword = chrome.findElement(By.id("confirmpassword"));
		confirmpassword.sendKeys("Teste01");

		WebElement sendemail = chrome.findElement(By.id("sendemail"));
		sendemail.click();

		
		//chrome.findElement(By.cssSelector(selector))
		WebDriverWait wait = new WebDriverWait(chrome,20);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("./html/body/div[4]/h2")));
		
		
		

		WebElement verify = chrome.findElement(By.xpath("./html/body/div[4]/h2"));

		assertEquals(verify.getText(), "Sending e-mail success!");

		//
		 chrome.close();


		
		
		
		
	}

}
