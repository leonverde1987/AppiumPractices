package examples_test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;


public class sessions_appium {

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
        optI = new XCUITestOptions()
                //.setUdid("2FF90CEF-D92E-4465-882A-FF096081FC64")
                //2A42762F-5D81-4B40-A78E-4AFF2FDA262F
                //2FF90CEF-D92E-4465-882A-FF096081FC64
                .setDeviceName("iPhone 16 Pro")
                .setSafariInitialUrl("https://appiumpro.com")
                .setPlatformVersion("18.3");
                //.setApp("/home/myapp.ipa");
    }

    @Test
    public void sessionAndroid() throws MalformedURLException, URISyntaxException {
        driverAnd = new AndroidDriver(new URI(APPIUM).toURL(), optA);
        driverAnd.findElement(AppiumBy.accessibilityId("Login Screen"));
    }

    @Test
    public void sessionIOS() throws MalformedURLException, URISyntaxException {
        driverIOS = new IOSDriver(new URI(APPIUM).toURL(), optI);
        // if you get error "xcrun: error: SDK "iphonesimulator" cannot be located" you should execute the command sudo xcode-select --switch /Applications/Xcode.app/Contents/Developer
    }

    @AfterClass
    public void closeDrivers(){
        //driverAnd.quit();
        //driverIOS.quit();
    }
}
