package objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import FunctionalLibraries.BaseClass;

public class AdminPageObjects extends BaseClass {
	public AdminPageObjects() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "uid")
	private WebElement Username;

	@FindBy(name = "passw")
	private WebElement Passward;

	@FindBy(name = "btnSubmit")
	private WebElement Login;

	@FindBy(xpath = "//span[contains(text(),'Login Failed:')]")
	private WebElement failedUserLoginText;

	@FindBy(id = "MenuHyperLink1")
	private WebElement Summary;

	@FindBy(name = "listAccounts")
	private WebElement ListAcc;

	@FindBy(id = "btnGetAccount")
	private WebElement Go;

	@FindBy(id = "MenuHyperLink3")
	private WebElement TransferFundHyperLink;

	@FindBy(id = "toAccount")
	private WebElement ToAcc;

	@FindBy(id = "transferAmount")
	private WebElement Transfer;

	@FindBy(id = "transfer")
	private WebElement Tbtn;

	@FindBy(id = "MenuHyperLink2")
	private WebElement RecentTransaction;

	@FindBy(id = "HyperLink3")
	private WebElement Contactus;

	@FindBy(xpath = "//a[text()='online form']")
	private WebElement Email;

	@FindBy(name = "name")
	private WebElement Name;

	@FindBy(name = "email_addr")
	private WebElement Emailadd;

	@FindBy(name = "subject")
	private WebElement Subject;

	@FindBy(name = "comments")
	private WebElement Comments;

	@FindBy(name = "submit")
	private WebElement Submit;

	@FindBy(id = "LoginLink")
	private WebElement SignOut;

	@FindBy(xpath = "//span[contains(text(),'9876.0 was successfully')]")
	private WebElement TransferSuccessfullMessage;
	
	@FindBy(xpath = "//h1[text() = 'Thank You']")
	private WebElement ThanksAfterFeedBack;

	public WebElement getThanksAfterFeedBack() {
		return ThanksAfterFeedBack;
	}

	public WebElement getTransferSuccessfullMessage() {
		return TransferSuccessfullMessage;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassward() {
		return Passward;
	}

	public WebElement getFailedUserLoginText() {
		return failedUserLoginText;
	}

	public WebElement getSummary() {
		return Summary;
	}

	public WebElement getListAcc() {
		return ListAcc;
	}

	public WebElement getGo() {
		return Go;
	}

	public WebElement getTransferFundHyperLink() {
		return TransferFundHyperLink;
	}

	public WebElement getToAcc() {
		return ToAcc;
	}

	public WebElement getTransfer() {
		return Transfer;
	}

	public WebElement getTbtn() {
		return Tbtn;
	}

	public WebElement getRecentTransaction() {
		return RecentTransaction;
	}

	public WebElement getContactus() {
		return Contactus;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getName() {
		return Name;
	}

	public WebElement getEmailadd() {
		return Emailadd;
	}

	public WebElement getSubject() {
		return Subject;
	}

	public WebElement getComments() {
		return Comments;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getSignOut() {
		return SignOut;
	}

}
