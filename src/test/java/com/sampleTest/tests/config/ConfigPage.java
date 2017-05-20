package com.sampleTest.tests.config;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ConfigPage {
	protected WebDriver driver;
	public static final int element_wait = 6;
	public static final int page_wait = 13;
	
	public ConfigPage(WebDriver driver) {
		this.driver = driver;
	}
		
	public static WebElement waitForElementClickable(WebDriver driver, final By by, int seconds) {
		WebElement element;
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, seconds, 2000);
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.manage().timeouts().implicitlyWait(page_wait, TimeUnit.SECONDS); 
			return element; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement submitObjectBy(By by) {
		waitForElementClickable(driver, by, 5);
		WebElement element = driver.findElement(by);
		element.submit();
		return element;
	}

	public WebElement getElementBy(By by) {
		return driver.findElement(by);
	}
	
	public WebElement setObjectBy(By by, String value) {
		WebElement element = getElementBy(by);
		element.clear();
		element.sendKeys(value);
		sleep(3000);
		return element;
	}

	public WebElement selectValueObjectBy(By by, String value) {
		WebElement element = driver.findElement(by);
		new Select(element).selectByVisibleText(value);
		return element;
	}

	public WebElement selectIndexObjectById(String name, int index) {
		WebElement element = driver.findElement(By.id(name));
		new Select(element).selectByIndex(index);
		return element;
	}

	public WebElement clickObjectByLinkText(String linkText) {
		return clickObjectBy(By.linkText(linkText));
	}


	public WebElement clickObjectBy(By by) {
		waitForElementClickable(driver, by, 10);
		WebElement element = driver.findElement(by);
		element.click();
		sleep(3000);
		return element;
	}

	public boolean isDisplayBy(By by) {
		sleep(2000);
		return driver.findElement(by).isDisplayed();
	}


	public String getCurrentUrl() {
		return driver.getCurrentUrl().trim().toString();
	}

	public void goBack() {
		driver.navigate().back();
	}

	public void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
		}
	}
	
	public void waitForElement(WebDriver driver, int seconds, By elementBy) {
		WebDriverWait wait = new WebDriverWait(driver, seconds, 5000);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
	}
	
	public boolean isExist(int seconds,By by){
		try {
			waitForElement(driver, seconds, by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void scrollDownPageUntilView(By by){
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);			
		sleep(1000);
	}
	
	public void scrollDownPage(){
		JavascriptExecutor js = (JavascriptExecutor)driver;
     	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	public boolean isTextPresent(By by, String text) {
		try {
			return driver.findElement(by).getText().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean isTextPresent(String text) {
		try {
			return driver.getPageSource().contains(text);
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public boolean isElementPresentAndDisplay(By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isClickable(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void moveToElement(WebElement element) {
		if (!(driver instanceof ChromeDriver)) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
			} else {
			String strJavaScript = "var element = arguments[0];"
					+ "var mouseEventObj = document.createEvent('MouseEvents');"
					+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";
			executeJavascript(strJavaScript, element);
		}
	}
	public void executeJavascript(String script, Object... obj) {
		((JavascriptExecutor) driver).executeScript(script, obj);
	}

	public void waitElementDisappear(By by, int second) {
		int counter = 0;
		while (isElementPresent(by) && counter < (second)) {
			sleep(2000);
			counter += 2;
		}
	}
	
	public static boolean isValidDate(String inDate) {
		String date="";
		if(inDate.length()==10)
			date="dd.MM.yyyy";
		else date="dd.MM.yyyy - mm:ss";
		SimpleDateFormat dateFormat = new SimpleDateFormat(date);
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(inDate.trim());
		} catch (Exception pe) {
			return false;
		}
		return true;
	}
	
	public static boolean isValidHour(String inDate) {
		String hour="";
		if(inDate.length()==5)
			hour="mm:ss";
		else hour="hh:mm:ss";
		SimpleDateFormat hourFormat = new SimpleDateFormat(hour);
		hourFormat.setLenient(false);
		try {
			hourFormat.parse(inDate.trim());
		} catch (Exception pe) {
			return false;
		}
		return true;
	}
	
	public static Calendar getYear() {
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		//int year = c.get(Calendar.YEAR);
		return c;
	}
	
	public static String generateRandomString(int length){
		String alphabet = 
		        new String("0123456789ABCDEFGHIJKLMNOPRSTUVYZabcdefghijklmnoprstuvyz"); //9
		int n = alphabet.length(); //10

		String result = new String(); 
		Random r = new Random(); //11

		for (int i=0; i<length; i++) //12
		    result = result + alphabet.charAt(r.nextInt(n)); //13
		return result;
	}
}
