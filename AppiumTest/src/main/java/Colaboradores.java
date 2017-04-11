import static org.junit.Assert.*;

import java.io.File;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Colaboradores {
	DesiredCapabilities capacidade;
	AndroidDriver driver;

	@Before
	public void setUp() throws Exception {
		//definindo caminho para o aplicativo a ser testado.
		File dirAplicativo = new File("c:\\TrianguloApp");
		File arqAplicativo = new File(dirAplicativo, "Colaboradores.apk");
		capacidade = new DesiredCapabilities();
		//definindo a plataforma que será testada.
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Simulator");
		//definindo o aplicativo a ser testado.
		capacidade.setCapability(MobileCapabilityType.APP, arqAplicativo.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
	}

	@Test
	public void test() {
	}





}

		
//abrindo conexão com servidor.

