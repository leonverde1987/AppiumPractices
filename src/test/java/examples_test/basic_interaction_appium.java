package examples_test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class basic_interaction_appium {

    private static final String APK = "/Users/leonverde/Downloads/TheApp.apk";
    private static final String IOS = "";
    private static final String APPIUM = "http://127.0.0.1:4723";

    private XCUITestOptions optI;
    private AndroidDriver driverAnd;
    private IOSDriver driverIOS;
    private UiAutomator2Options optA;



    @BeforeClass
    public void setUp(){
        optA = new UiAutomator2Options()
                //.setUdid("emulator-5554")//Emulator device
                .setUdid("320124841951")//Real device to see devices available go to SDK path PlatformTools and use de command ./adb devices
                .setApp(APK);
    }

    @Test
    public void interactionAndroid() throws MalformedURLException, URISyntaxException {
        driverAnd = new AndroidDriver(new URI(APPIUM).toURL(), optA);
        Wait<WebDriver> wait = new WebDriverWait(driverAnd, Duration.ofSeconds(2));
        driverAnd.findElement(AppiumBy.accessibilityId("Login Screen")).click();
        driverAnd.findElement(AppiumBy.accessibilityId("username")).sendKeys("alice");
        driverAnd.findElement(AppiumBy.accessibilityId("password")).sendKeys("mypassword");
        driverAnd.findElement(AppiumBy.accessibilityId("loginBtn")).click();
        WebElement loginText = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'You are logged in')]")));

        Assert.assertTrue(loginText.getText().contains("alice"));
    }
}
