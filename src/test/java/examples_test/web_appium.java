package examples_test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class web_appium {

    private static final String APK = "/Users/leonverde/Downloads/TheApp.apk";
    private static final String IOS = "";
    private static final String APPIUM = "http://127.0.0.1:4723";

    private XCUITestOptions optI;
    private AndroidDriver driverAnd;
    private IOSDriver driverIOS;
    private UiAutomator2Options optA;
    private RemoteWebDriver driverRm;
    private DesiredCapabilities caps;

    @BeforeClass
    public void setUp(){
        optI = new XCUITestOptions()
                .setDeviceName("iPhone 16 Pro")
                .setSafariInitialUrl("https://appiumpro.com")
                .setPlatformVersion("18.3");

    }

    @Test
    public void webAppium() throws MalformedURLException, URISyntaxException {

        driverIOS = new IOSDriver(new URI(APPIUM).toURL(), optI);
        WebDriverWait wait = new WebDriverWait(driverIOS, Duration.ofSeconds(10));
        driverIOS.get("https://appiumpro.com");
        driverIOS.findElement(By.xpath("//a[contains(@id,'Menu')]")).click();
        driverIOS.findElement(By.linkText("All Editions")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.cssSelector(".editionList")));

    }


    @AfterClass
    public void closeDrivers(){
        //driverAnd.quit();
    }
}
