package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Correios {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// INPUTS

		String cep_num = "50610310 ";
		String rua_esperado = "Rua Doutor João Coimbra ";
		String rua = "Dados não encontrados";
		boolean error=false; 
		int delay=2000;
		
		
		//conexão chrome
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
		WebDriver Chrome = new ChromeDriver(capabilities);

		
		
		// Abrir correios
		Chrome.get("http://www.detran.pe.gov.br/index.php?option=com_search_placa&placa=pfr6572");

		// Esperar x segundos
		//Thread.sleep(delay);

		// Maximizar Browser
		Chrome.manage().window().maximize();

		// Buscar Elemento
		
		//#lblMarcaModelo
		
		
		WebElement elemento = Chrome.findElement(By.xpath("/html/body/span[2]"));
		System.out.println(elemento.getText());
			// Fechar no final
			Chrome.close();
		}
	}


