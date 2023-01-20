package TestSteps;

import java.awt.AWTException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import FunctionalLibraries.BaseClass;
import objectRepository.AdminPageObjects;
import objectRepository.LoginPageObjects;

public class AssesMent extends BaseClass {

	@Parameters({"URl"})
	@BeforeClass
	private void toLaunchBrowser(String url) {
		WebDriver driver = launchBrowser("CHROME");
		launchUrl(url);
	}

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println("Start Time : " + d);
	}

	@Test(priority = 1)
	private void navigatingToSignIn() throws IOException {
		LoginPageObjects loginPageObjects = new LoginPageObjects();
		loginPageObjects.getSignin().click();
		screenshot("SignPage");
	}

	@Parameters({"IncorrectUserName","IncorrectPassword"})
	@Test(priority = 2)
	private void signInWithAnIncorretUsers(String user, String pass) throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		WebElement username = adminPageObjects.getUsername();
		username.sendKeys(user);
		WebElement passward = adminPageObjects.getPassward();
		passward.sendKeys(pass);
		screenshot("InCorrectUserDetaiils");
		adminPageObjects.getLogin().click();
		screenshot("InCorrectUserErrorPage");
		Assert.assertEquals(adminPageObjects.getFailedUserLoginText().getText(),
				"Login Failed: We're sorry, but this username or password was not found in our system. Please try again.",
				"Login failed due to incorrect username/password");
	}

	@Parameters({"UserName", "Password"})
	@Test(priority = 3)
	private void signInWithAnCorretUsers(String user, String pass) throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getUsername().sendKeys(user);
		adminPageObjects.getPassward().sendKeys(pass);
		screenshot("CorrectUserDetails");
		adminPageObjects.getLogin().click();
		screenshot("SuccessfullyLoggedIn");
	}

	@Test(priority = 4)
	private void viewSummaryDetails() throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getSummary().click();
		screenshot("AccountSummaryDetailPage");
	}

	@Parameters({"AccDDValue"})
	@Test(priority = 5)
	private void accountVerification(String ddValue) throws AWTException, InterruptedException, IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		ddSelectByValue(adminPageObjects.getListAcc(),ddValue);
		Thread.sleep(2000);
		screenshot("Selected"+ ddValue +"OnAccList");
		adminPageObjects.getGo().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("bank/showAccount?listAccounts=800001"));
		screenshot("AccountDetailsPage");
		String availableTextOf800001Acc = driver.findElement(By.xpath(
				"//th[contains(text(), 'Balance Detail')]//parent::tr//following-sibling::tr/td[contains(text(), 'Available balance')]//following-sibling::td"))
				.getText();
		System.out.println("Available Balence: " + availableTextOf800001Acc);
		Assert.assertTrue(availableTextOf800001Acc.length()>0);
	}

	@Test(priority = 6)
	private void transferLink() throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getTransferFundHyperLink().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("bank/transfer.jsp"));
		screenshot("AmountTransferPage");
	}

	@Parameters({"AccDDValue", "TransferAmount"})
	@Test(priority = 7)
	private void transferAndValidate(String ddValue, String amount) throws AWTException, IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		ddSelectByValue(adminPageObjects.getToAcc(), ddValue);
		click(adminPageObjects.getTransfer());
		sendKey(adminPageObjects.getTransfer(), amount);
		adminPageObjects.getTbtn().click();
		Assert.assertTrue(adminPageObjects.getTransferSuccessfullMessage().getText().contains("9876.0 was successfully transferred from Account 800000 into Account 800001"));
		screenshot("AmountTransferedMessage");
	}

	@Test(priority = 8)
	private void viewRecentTransctions() throws InterruptedException, IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getRecentTransaction().click();
		screenshot("RecentTransactionPage");
		Thread.sleep(3000);
	}

	@Test(priority = 9)
	public void viewFirstTwoTransction() throws IOException {
		List<WebElement> transactionRowElements = driver.findElements(By
				.xpath("//h1[text() = 'Recent Transactions']/parent::div//table[contains(@id,'MyTransactions')]//tr"));
		List<String> expStringList = Arrays.asList("Transaction ID", "Transaction Time", "Account ID", "Action",
				"Amount", "800001", "Deposit", "$9876.00",
				"800000", "Withdrawal", "-$9876.00");
		List<WebElement> tableTd = driver.findElements(By.xpath("//table[contains(@id,'MyTransactions')]//tr//td"));
		int size = transactionRowElements.size()-3; 
		boolean flag = false;
		int count = 0;
		for(int i =0; i<(transactionRowElements.size()-size); i++) {
			for(int j = 0; j<tableTd.size();j++) {
				String actText = tableTd.get(j).getText();
				for (String expString : expStringList) {
					if (actText.equals(expString)) {
						Assert.assertTrue(actText.contains(expString));
						count++;
						if(count == expStringList.size()) {flag = true;}
					}
				}
			}
		}
		Assert.assertTrue(flag);
		screenshot("TransactioonDetailsPage");
	}

	@Test(priority = 10)
	private void contactUs() {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getContactus().click();
		adminPageObjects.getEmail().click();
	}

	@Parameters({"Name","EmailId","Subject","Comment"})
	@Test(priority = 11)
	private void fillEmailForm(String name, String email, String sub, String Comment) throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getName().sendKeys(name);
		adminPageObjects.getEmailadd().sendKeys(email);
		adminPageObjects.getSubject().sendKeys(sub);
		adminPageObjects.getComments().sendKeys(Comment);
		screenshot("OnlineFormDetails");
		adminPageObjects.getSubmit().click();
		Assert.assertEquals(adminPageObjects.getThanksAfterFeedBack().getText(), "Thank You");
		screenshot("ThankYouMsg");
	}

	@Test(priority = 12)
	private void signOut() throws IOException {
		AdminPageObjects adminPageObjects = new AdminPageObjects();
		adminPageObjects.getSignOut().click();
		LoginPageObjects login = new LoginPageObjects();
		WebDriverWait wait = new WebDriverWait(driver, 500);
		wait.until(ExpectedConditions.visibilityOfAllElements(login.getSignin()));
		Assert.assertTrue(login.getSignin().getText().equals("Sign In"));
		Assert.assertTrue(driver.getCurrentUrl().contains("http://testfire.net/index.jsp"));
		screenshot("SignedOutHomePage");
	}
	
	@AfterMethod
	private void AftreMethod() {
		System.out.println("Method Execution completed");
		Date d = new Date();
		System.out.println("Start Time : " + d);
	}
	
	@AfterClass
	private void CloseBrowser() {
		quitBrowser();
	}
}
