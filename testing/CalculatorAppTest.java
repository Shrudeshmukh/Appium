package testing;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorAppTest {

    public static void main(String[] args) {
        try {     
        	 {
        		 //device details
                 DesiredCapabilities capabilities = new DesiredCapabilities();
                 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM-E225F");
                 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
               //  capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                 
                 //base package, launcher 
                 capabilities.setCapability("appPackage", "com.example.calculatorapp");
                 capabilities.setCapability("appActivity", ".MainActivity");

                 //driver details
                 AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

                 //accesing the elements
                 WebElement firstNumber = driver.findElement(By.id("com.example.calculatorapp:id/etFirstNumber"));
                 WebElement secondNumber = driver.findElement(By.id("com.example.calculatorapp:id/etSecondNumber"));
                 WebElement addButton = driver.findElement(By.id("com.example.calculatorapp:id/btnAdd"));
                 WebElement resultView = driver.findElement(By.id("com.example.calculatorapp:id/tvResult"));

                 firstNumber.sendKeys("5"); //type text 5
                 secondNumber.sendKeys("7"); // type text 7
                 addButton.click();
                 

                 String resultText = resultView.getText();
                 if (resultText.contains("12")) {
                     System.out.println("Test Passed: Result is correct.");
                 } else {
                     System.out.println("Test Failed: Incorrect result.");
                 }

                 driver.quit();

        	 }
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}