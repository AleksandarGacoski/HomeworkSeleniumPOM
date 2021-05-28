package tests;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.junit.After;
import org.junit.Before;
import pages.LoginPage;


public class LoginOrderVerifyTest {

	public static WebDriver driver;
	LoginPage objLogin;
	
	@Before
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		objLogin = PageFactory.initElements(driver, pages.LoginPage.class);
		driver.navigate().to("http://automationpractice.com/index.php");
	}
	@After
	public void TearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
		
	
	@Test
	public void Tests() throws Exception {
		objLogin.clickSignIn();
		objLogin.enterEmailAddress("fasdfa@gmail.com");
		objLogin.enterLoginPassword("Testing123");
		objLogin.clickSignInButton();
		objLogin.validateIsOnAccountPage();
		objLogin.clickWomenCategory();
		objLogin.clickFirstDress();
		objLogin.clickPlusQuantity();
		objLogin.selectSize();
		Thread.sleep(3000);
		objLogin.clickAddToCart();
		objLogin.verifyProductAdded();
		objLogin.clickProceedPopUp();
		objLogin.clickProceedToCheckoutInCart();
		objLogin.clickProceedToCheckoutInAddresses();
		objLogin.clickCheckBox();
		objLogin.clickProceedToCheckoutInShipping();
		objLogin.clickPayByBank();
		objLogin.clickIConfirm();
		Thread.sleep(3000);
		objLogin.assertions();
	}
	
	
}
