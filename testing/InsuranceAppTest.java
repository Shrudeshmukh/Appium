package testing;



import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InsuranceAppTest {
	
    public static void main(String[] args) {
    	
        try {     
        	 {
        		 //device details
                 DesiredCapabilities capabilities = new DesiredCapabilities();
                 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM-E225F");
                 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                 capabilities.setCapability("appPackage", "com.example.insuranceapp");
                 capabilities.setCapability("appActivity", "com.example.insuranceapp.MainActivity");
                 

                 //driver details
                 AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

                 //accesing the elements

                   WebElement useremail = driver.findElement(By.id("com.example.insuranceapp:id/emailaddress"));
                   useremail.sendKeys("admin@gmail.com");
                   
                   WebElement userpass = driver.findElement(By.id("com.example.insuranceapp:id/password"));
               	   userpass.sendKeys("admin");
               	
               	   WebElement LoginUserBtn = driver.findElement(By.id("com.example.insuranceapp:id/loginButton"));
                   LoginUserBtn .click();
                   
                   WebElement resultView = driver.findElement(By.id("com.example.insuranceapp:id/dashtext"));
                   String resultText = resultView.getText();
                  // System.out.println(" resultText :: "+resultText);
                   System.out.println("Navigation from LoginFragment to Dashboard!");
                   System.out.println("Login Successfully !");

                 driver.quit();
        	 }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}