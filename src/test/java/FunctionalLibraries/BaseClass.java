package FunctionalLibraries;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	protected static Select sc;
	
	protected static WebDriver launchBrowser(String browserName) {
		if (browserName.toUpperCase().equals("CHROME")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} 
		else if (browserName.toUpperCase().equals("EDGE")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	protected static void screenshot(String imgName) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("\\Project\\Assesment\\target\\Result" + imgName + ".jpg");
		FileUtils.copyFile(src, des);
	}
	
	public static WebDriverWait explicitWait() {
		WebDriverWait wait = new WebDriverWait(driver, 500);
		return wait;
	}
	protected static void ddselectbyindex(WebElement element, int index) {
		sc = new Select(element);
		sc.selectByIndex(index);
	}

	protected static void ddSelectByValue(WebElement element, String value) {
		sc = new Select(element);
		sc.selectByValue(value);
	}

	protected static void ddSelectByVisibleText(WebElement element, String text) {
		sc = new Select(element);
		sc.selectByValue(text);
	}

	protected static void ddDeselectbyindex(WebElement element, int index) {
		sc = new Select(element);
		sc.deselectByIndex(index);
	}

	protected static void ddDeSelectByValue(WebElement element,String value) {
		sc = new Select(element);
		sc.deselectByValue(value);
	}

	protected static void ddDeSelectByVisibleText(WebElement element, String text) {
		sc = new Select(element);
		sc.deselectByValue(text);
	}

	public static void ddDeSelectAll(WebElement element) {
		sc = new Select(element);
		sc.deselectAll();
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	 public static void getTitle() {
		 String title = driver.getTitle();
		 System.out.println(title);
	}
	 public static void closeTab() {
		 driver.close();
	}
	 
	 public static void quitBrowser() {
		 driver.quit();
	}
	
	
	 public static void getUrl() {
		 driver.getCurrentUrl();
		 
	}
	 public static void windowId() {
		 String windowHandle = driver.getWindowHandle();
		 System.out.println(windowHandle);
	}
	
	public static void allWindowId() {
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
	}
	
	
	
	 public static void getText(WebElement element) {
		 String text = element.getText();
		 System.out.println(text);
	}
	 
	 
	 public static void getAttributeValue(WebElement ref,String value) {
		 String t = ref.getAttribute(value);
		 System.out.println(t);
		
	}
	public static void tagName(WebElement ref,String Name) {
		String b = ref.getTagName();
		System.out.println(b);
		
	}
	public static void sendKey(WebElement ref,String value) {
		ref.sendKeys(value);
	}
	
	 public static void click(WebElement ref) {
		 ref.click();
	}
	 
	 static Actions a;
	 public static void mouseHover(WebElement ref) {
		 a = new Actions(driver);
		 a.moveToElement(ref).perform();
	}
	 
	 public static void dragAndDown(WebElement src,WebElement dest) {
		 a=new Actions(driver);
		 a.dragAndDrop(src, dest).perform();
	}
	 
	 public static void doubleClick(WebElement ref) {
		 a=new Actions(driver);
		 a.doubleClick(ref);
	}
	 	 
	 public static void rightClick(WebElement ref) {
		 a=new Actions(driver);
		 a.contextClick(ref).perform();
	}
	 
	 public static void Down() {
		 a=new Actions(driver);
		 a.keyDown(Keys.SHIFT);
		 a.keyUp(Keys.SHIFT);
	 }
	 
	 
	 public static void Shift() {
		 a=new Actions(driver);
		 a.keyDown(Keys.ARROW_DOWN);
		 a.keyUp(Keys.ARROW_DOWN);
		 
	} 
	 public static void enter() {
		 a=new Actions(driver);
		 a.keyDown(Keys.ENTER);
		 a.keyUp(Keys.ENTER);
		 
	} 
	 public static void delete() {
		 a=new Actions(driver);
		 a.keyDown(Keys.DELETE);
		 a.keyUp(Keys.DELETE);
		 
	} 
	 public static void backSpace() {
		 a=new Actions(driver);
		 a.keyDown(Keys.BACK_SPACE);
		 a.keyUp(Keys.BACK_SPACE);
		 
	} 
	 public static void control() {
		 a=new Actions(driver);
		 a.keyDown(Keys.CONTROL);
		 a.keyUp(Keys.CONTROL);
		 
	} 
	 public static void alt() {
		 a=new Actions(driver);
		 a.keyDown(Keys.ALT);
		 a.keyUp(Keys.ALT);
		 
	} 
	 
	  
	 
	 public static void escape() {
		 a=new Actions(driver);
		 a.keyDown(Keys.ESCAPE);
		 a.keyUp(Keys.ESCAPE);
		 
	} 
	 
	 
	 public static void tab() {
		 a=new Actions(driver);
		 a.keyDown(Keys.TAB);
		 a.keyUp(Keys.TAB);
		 
	} 
	 
	 public static void num() {
		 a=new Actions(driver);
		 a.keyDown(Keys.HOME);
		 a.keyUp(Keys.HOME);
		 
	}
	 static Robot r;
	 public static void copy() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_C);
		 r.keyRelease(KeyEvent.VK_C);
	}
	 
	 public static void psate() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_V);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_V);
	}
	 public static void cut() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_X);
		 r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_X);
	}
	 public static void Enter() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
	}
	 public static void capsLock() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_CAPS_LOCK);
		 r.keyRelease(KeyEvent.VK_CAPS_LOCK);
		 
	}
	 public static void up() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_UP);
		 r.keyRelease(KeyEvent.VK_UP);
	}
	 public static void down() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_DOWN);
		 r.keyRelease(KeyEvent.VK_DOWN);
		 
	}
	 
	 public static void window() throws AWTException {
		 r= new Robot();
		 r.keyPress(KeyEvent.VK_WINDOWS);
		 r.keyRelease(KeyEvent.VK_WINDOWS);
	}
	 
	 public static void screenShot(String filename) throws IOException {
		 TakesScreenshot ts =(TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File dest =new File("D:\\Maven\\screenshot\\"+filename+".png");
		 FileUtils.copyFile(src, dest);
	}
	 static  JavascriptExecutor js;
	 public static void jsSendValue(String input,WebElement ref) {
		js=(JavascriptExecutor) driver;
		 js.executeScript("arguments[0].setAttribute('value','"+input+"')", ref);
		
	 }
	 
	 public static void jsClick(WebElement ref) {
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", ref);
	}
	 public static void jsGetAttribute(WebElement ref) {
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].getAttribute('value')", ref);
	}
	 public static void scrollUp(WebElement ref) {
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrolInToView(false)", ref);
	}
	 public static void scrollDown(WebElement ref) {
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrolInToView(true)", ref);
	}
	 
	 public static void highLight(String input,WebElement ref) {
		 js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].setAttribute('style','"+input+"')", ref);
	}
	 static  Alert al;
	 public static void alertAccept() {
		 al = driver.switchTo().alert();
		 al.accept();
	}
	 public static void alertCancel() {
		 al = driver.switchTo().alert();
		 al.dismiss();
	}
	 public static void alertValue(String value) {
		 al = driver.switchTo().alert();
		 al.sendKeys(value);
	}
	 public static void alertText() {
		 al = driver.switchTo().alert();
		 String text = al.getText();
		 System.out.println(text);
	}
	 
///Data Driven
	 
	 //Excel Read
	 
	 public static  String excelRead(String fileloc,String sheetName,int irow,int icell) throws IOException {
			//mention excel file location
				File f=new File(fileloc);
				
			//to read file
				FileInputStream fi=new FileInputStream(f);
			//to read xlxs sheet
				Workbook w=new XSSFWorkbook(fi);
			//get sheet from Wrokbook
				Sheet a = w.getSheet(sheetName);
			//get row from Sheet
				Row row = a.getRow(irow);
			//get ceel from row
				Cell cell = row.getCell(icell);
				int cellType = cell.getCellType();
				String value;
				if (cellType==1) {
					 value = cell.getStringCellValue();
					
				}
				else if (DateUtil.isCellDateFormatted(cell)) {
					Date dd = cell.getDateCellValue();
					SimpleDateFormat d=new SimpleDateFormat("dd-MM-yy");
					value=d.format(dd);
				}
				else {
					double d=cell.getNumericCellValue();
					long l=(long) d;
					 value = String.valueOf(l);
				}
				return value;
				}
	 
	 
 //read  NO Row and No Cell by index
	 
	 public static void readCell(String fileloc,String sheetName,int irow,int icell) throws IOException {
		//mention excel file location
			File f=new File(fileloc);
			
		//to read file
			FileInputStream fi=new FileInputStream(f);
		//to read xlxs sheet
			Workbook w=new XSSFWorkbook(fi);
		//get sheet from Wrokbook
			Sheet a = w.getSheet(sheetName);
		//get row from Sheet
			Row row = a.getRow(irow);
		//get ceel from row
			Cell cell = row.getCell(icell);
			
			System.out.println(cell);
			
		//no of row
			int rows = a.getPhysicalNumberOfRows();
			
			System.out.println("No of Rows :"+rows);
			
		//no of cell
			int cells = row.getPhysicalNumberOfCells();
			System.out.println("No of Cells :"+cells);

	}
	 
 //Read all row and cell
	 
	 public static void readAll(String fileloc,String sheetName) throws IOException {
		 File f=new File(fileloc);
			FileInputStream fi = new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fi);
			Sheet a = w.getSheet(sheetName);
			int b = a.getPhysicalNumberOfRows();
			System.out.println("No of Rows :"+b);
			for (int i = 0; i <a.getPhysicalNumberOfRows() ; i++) {
				Row row = a.getRow(i);
				
				
				for (int j = 0; j <row.getPhysicalNumberOfCells(); j++) {
					
					Cell cell = row.getCell(j);
					System.out.println(cell);
					
					
				}
				
							
			}
			
			

	}
	 
	 
 //correct format
	 
	public static void correctValue(String fileLoc,String sheetName )throws IOException {
		File f =new File(fileLoc);
		FileInputStream fi=new FileInputStream(f);
		Workbook w=new XSSFWorkbook(fi);
		Sheet sheet = w.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println("No of Rows :"+rows);
		for (int i = 0; i <sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j <row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int k = cell.getCellType();
				
				if (k==1) {
					String value = cell.getStringCellValue();
					System.out.println(value);			
				}
				else if (DateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat d=new SimpleDateFormat("dd-MM-yy");
					String format = d.format(date);
					System.out.println(format);		
				}
				else {
					double dd = cell.getNumericCellValue();
					
					long l=(long)dd;
					String vv = String.valueOf(l);
					System.out.println(vv);
				}
			}
		}
	}
	
//create excel sheet
	
	public static void createExcel(String fileLoc, String SheetName, int row, int cell, String data) throws IOException {
		File f = new File(fileLoc);
		FileOutputStream fos = new FileOutputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet s = w.createSheet();
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		w.write(fos);
		System.out.println("Execute Successfully");
	}
	
//create cell
	
	public static void createCell(String fileLoc, String SheetName, int row, int cell, String data) throws IOException {
		File f = new File(fileLoc);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(SheetName);
		Row r = s.getRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("Execute Successfully");

	}
	
	
//create row
	
	public static void createRow(String fileLoc, String SheetName, int row, int cell, String data) throws IOException {
		File f = new File(fileLoc);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(SheetName);
		Row r = s.createRow(row);
		Cell c = r.createCell(cell);
		c.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("Execute Successfully");

	}
	
	
//update cell
	public static void updateCell(String fileLoc, String SheetName, int row, int cell, String olddata,String newdata) throws IOException {
		File f = new File(fileLoc);
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet(SheetName);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		String dd=c.getStringCellValue();
		if (dd.equals(olddata)) {
			c.setCellValue(newdata);
		}
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
		System.out.println("Execute Successfully");

	}




































}

				
			
			
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

