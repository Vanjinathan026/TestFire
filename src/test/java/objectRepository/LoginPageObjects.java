package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FunctionalLibraries.BaseClass;

public class LoginPageObjects extends BaseClass {
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//font")
	private WebElement Signin;

	public WebElement getSignin() {
		return Signin;
	}


	
	
	
	
	
}
