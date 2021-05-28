package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPage {

	WebDriver driver;

	//initialization of Web elements
	By buttonSignIn = By.xpath("//a[contains(text(),'Sign in')]");
	By emailFieldLogin = By.xpath("//input[@id='email']");
	By loginPass = By.name("passwd");
	By signInButton = By.name("SubmitLogin");
	By WomenButton = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
	By firstDress = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
	By plusQuantity = By.xpath("//p[@id='quantity_wanted_p']/a[2]/span/i");
	By proceedPopUp = By.cssSelector(".button-medium > span");
	By cartProceedButton = By.cssSelector(".standard-checkout > span");
	By addressesProceedButton = By.cssSelector(".button:nth-child(4) > span");
	By checkBox = By.cssSelector("label");
	By shippingProceedButton = By.cssSelector(".standard-checkout > span");
	By payByBankButton = By.cssSelector(".bankwire > span");
	By IConfirmMyOrderButton = By.cssSelector("#cart_navigation span");
	By dropdownSize = By.id("group_1");
	By optionM = By.xpath("//option[. = 'M']");
	By addToCartBTN = By.cssSelector(".exclusive > span");


	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//click on SingIn on the right side of header
	public void clickSignIn() {
		driver.findElement(buttonSignIn).click();
	}

	//enter email in email address field
	public void enterEmailAddress(String emailUser) {
		driver.findElement(emailFieldLogin).sendKeys(emailUser);
	}

	//enter password in password field
	public void enterLoginPassword(String passUser) {
		driver.findElement(loginPass).sendKeys(passUser);
	}

	//click SignIn button on authentication page
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}

	//validation that user is on 
	public void validateIsOnAccountPage() {
		boolean isOnPage=driver.getPageSource().contains("Welcome to your account.");
		if (isOnPage == true)
		{
			System.out.println("User is on account page");
		}
		else {
			System.out.println("No he is not on account page!");
		}

	}

	//clicking WOMEN category
	public void clickWomenCategory() {
		driver.findElement(WomenButton).click();
	}

	//Clicking dress
	public void clickFirstDress() {
		driver.findElement(firstDress).click();
	}

	//increasing quantity by 1
	public void clickPlusQuantity() {
		driver.findElement(plusQuantity).click();
	}

	//selecting size M of the dress
	public void selectSize() {
		driver.findElement(dropdownSize).click();
		{
			WebElement dropdown = driver.findElement(dropdownSize);
			dropdown.findElement(optionM).click();
		}
		driver.findElement(dropdownSize).click();
	}

	//click ADD TO CART
	public void clickAddToCart()
	{
		driver.findElement(addToCartBTN).click();
	}

	//verify that product is successfully added
	public void verifyProductAdded() {
		boolean isAdded=driver.getPageSource().contains("Product successfully added to your shopping cart");
		if (isAdded == true)
		{
			System.out.println("Product successfully added to your shopping cart");
		}
		else {
			System.out.println("Product is not added!!");
		}
	}

	//clicking Proceed when PopUp is displayed
	public void clickProceedPopUp() {
		driver.findElement(proceedPopUp).click();
	}

	//clicking proceed when user is in Cart
	public void clickProceedToCheckoutInCart() {
		driver.findElement(cartProceedButton).click();
	}

	//clicking proceed when user is on Addresses Page
	public void clickProceedToCheckoutInAddresses() {
		driver.findElement(addressesProceedButton).click();
	}

	//clicking the CHECK BOX
	public void clickCheckBox() {
		driver.findElement(checkBox).click();
	}

	//clicking proceed when user is on ShippingPage
	public void clickProceedToCheckoutInShipping() {
		driver.findElement(shippingProceedButton).click();
	}

	//choosing to Pay By Bank
	public void clickPayByBank() {
		driver.findElement(payByBankButton).click();
	}

	//click I CONFIRM
	public void clickIConfirm() {
		driver.findElement(IConfirmMyOrderButton).click();
	}

	// assertions that the order is completed	
	public void assertions() {
		String getActualTitle = driver.getTitle();
		System.out.println(getActualTitle);


		String ExpectedTitle = "Order confirmation - My Store";
		Assert.assertEquals(getActualTitle, ExpectedTitle);
		System.out.println("Assert passed");

		boolean goIma = driver.getPageSource().contains("Your order on My Store is complete.");
		System.out.println(goIma);
	}


}
