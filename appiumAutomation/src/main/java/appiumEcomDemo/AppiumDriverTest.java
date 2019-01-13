package appiumEcomDemo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumDriverTest {

   private String accessKey = "eyJ4cC51IjoyOSwieHAucCI6MiwieHAubSI6Ik1UVXhOakE0TXprd05UUXhNQSIsImFsZyI6IkhTMjU2In0.eyJleHAiOjE4NDA3Nzc4NDIsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.AZ_dyzCY3T0gStr29lgGi_YlqDLTk8mizErdHG2BX5c";

   protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

 

    @Before

    public void setUp() throws MalformedURLException {

        dc.setCapability("testName", "Quick Start Android Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='android' and @version='7.0' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "com.buuuk.st/com.sph.straitstin");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.buuuk.st/com.sph.straitstimes.views.activities.SplashActivity");        
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

    }
 

    @Test

    public void quickStartAndroidNativeDemo() {

        driver.rotate(ScreenOrientation.PORTRAIT);
        //Open drawer menu
        driver.findElement(By.xpath("//*[@id='drawermenu']")).click();
        
        // Click on Log In
        driver.findElement(By.xpath("//*[@id='Log In']")).click();
        
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("digitaltest10");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("Sphdigital1");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='Continue']")).click();
        
        //Verify logged in  as
      //Verify user successfully logged in
        try {
        	Thread.sleep(2000);
        	if (driver.findElement(By.name("login-user-name")).isDisplayed()){
                System.out.println("User able to login successfully");
            } else {
                System.out.println("User login authentication failed");
                Assert.assertTrue(false);
            }
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        
        //Go to latest tab
        driver.findElement(By.xpath("//*[@id='Latest']")).click();
        driver.findElement(By.xpath("//*[@id='FirstArticle']")).click();
        

    }

 

    @After

    public void tearDown() {

        driver.quit();

    }

}