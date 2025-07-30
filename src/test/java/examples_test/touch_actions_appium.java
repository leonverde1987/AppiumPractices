package examples_test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Interaction;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
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
import java.util.Arrays;
import java.util.List;

public class touch_actions_appium {

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
                .setUdid("emulator-5554")
                .setApp(APK);
        

    }

    @Test
    public void touchActions() throws MalformedURLException, URISyntaxException {
        driverAnd = new AndroidDriver(new URI(APPIUM).toURL(), optA);
        Wait<WebDriver> wait = new WebDriverWait(driverAnd, Duration.ofSeconds(2));
        driverAnd.findElement(AppiumBy.accessibilityId("List Demo")).click();
        //driverAnd.findElement(AppiumBy.accessibilityId("Altostratus")).click();
        //driverAnd.findElement(AppiumBy.accessibilityId("Ok")).click();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Interaction MoveToStart = finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 520, 1530);
        Interaction pressDown = finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg());
        Interaction moveToEnd = finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 520, 490);
        Interaction pressUp = finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg());

        Sequence swipe = new Sequence(finger, 0);
        swipe.addAction(MoveToStart);
        swipe.addAction(pressDown);
        swipe.addAction(moveToEnd);
        swipe.addAction(pressUp);

        driverAnd.perform(List.of(swipe));

        driverAnd.findElement(AppiumBy.accessibilityId("PhoenixNAP"));

    }
}
