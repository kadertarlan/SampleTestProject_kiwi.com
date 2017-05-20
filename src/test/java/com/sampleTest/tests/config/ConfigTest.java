package com.sampleTest.tests.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.saucelabs.common.SauceOnDemandAuthentication;
import org.junit.*;
import org.junit.runner.RunWith;
import com.saucelabs.junit.ConcurrentParameterized;
import java.util.LinkedList;

import com.saucelabs.common.SauceOnDemandSessionIdProvider;


@Ignore
@RunWith(ConcurrentParameterized.class)
public class ConfigTest implements SauceOnDemandSessionIdProvider  {
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	protected WebDriver driver; 
	public static String baseUrl = "https://www.kiwi.com/tr/";

	//for remote
	public static final String USERNAME = "kadertrl";
    public static final String ACCESS_KEY = "ef011196-07af-41a6-9e3d-5ee73b743644";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static String seleniumURI;
    public static String buildTag;
    protected String browser;
    protected String os;
    protected String version;
    protected String deviceName;
    protected String deviceOrientation;
    protected String sessionId;
    public ConfigTest(String os, String version, String browser, String deviceName, String deviceOrientation) {
        super();
        this.os = os;
        this.version = version;
        this.browser = browser;
        this.deviceName = deviceName;
        this.deviceOrientation = deviceOrientation;
    }

    @ConcurrentParameterized.Parameters
    public static LinkedList browsersStrings() {
        LinkedList browsers = new LinkedList();
        browsers.add(new String[]{"OS X 10.10", "54.0", "chrome", null, null});
//      browsers.add(new String[]{"Windows 10", "49.0", "firefox", null, null});
//      browsers.add(new String[]{"Windows 7", "11.0", "internet explorer", null, null});
//      browsers.add(new String[]{"OS X 10.11", "10.0", "safari", null, null});
//      browsers.add(new String[]{"Windows 10", "14.14393", "MicrosoftEdge", null, null});
        return browsers;
    }
    
    public boolean local = true;
	@Before
	public void setUp() throws MalformedURLException {
		if(local){
		    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		    capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
		    capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		    capabilities.setCapability("nativeEvents", false);
		    capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		    capabilities.setCapability("ignoreProtectedModeSettings", true);
		    capabilities.setCapability("disable-popup-blocking", true);
		    capabilities.setCapability("enablePersistentHover", true);
		    System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver");
			driver = new ChromeDriver();
		}else{
	        //for remote 
		     DesiredCapabilities caps = new DesiredCapabilities();
		     caps.setCapability(CapabilityType.BROWSER_NAME, browser);
		     caps.setCapability(CapabilityType.VERSION, version);
		     caps.setCapability("deviceName", deviceName);
		     caps.setCapability("device-orientation", deviceOrientation);
		     caps.setCapability(CapabilityType.PLATFORM, os);
			 this.driver = new RemoteWebDriver(new URL(URL), caps);	
	         this.sessionId = (((RemoteWebDriver) driver).getSessionId()).toString();

 		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseUrl);
	}

	@After
	public void tearDown() {
		driver.quit();
	}
    public String getSessionId() {
        return sessionId;
    }

}
