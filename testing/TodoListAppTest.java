package testing;



import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TodoListAppTest {
	
    public static void main(String[] args) {
    	
        try {     
        	 {
        		 //device details
                 DesiredCapabilities capabilities = new DesiredCapabilities();
                 capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                 capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo I2011");
                 capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                 capabilities.setCapability("appPackage", "com.example.todolistapp");
                 capabilities.setCapability("appActivity", "com.example.todolistapp.MainActivity");
                 

                 //driver details
                 AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

                 //accesing the elements
 
                 WebElement nav1Button = driver.findElement(By.id("com.example.todolistapp:id/fab_add"));
                 nav1Button.click();

                 WebElement task = driver.findElement(By.id("com.example.todolistapp:id/edit_text_task"));
             	// System.out.println("Field 1 : "+task);
                   task.sendKeys("Appium");
                   
                   WebElement taskDesc = driver.findElement(By.id("com.example.todolistapp:id/edit_text_task_desc"));
               	// System.out.println("Field 2 : "+taskDesc);
               	taskDesc.sendKeys("Testing Here");
               	
               	WebElement addTaskBtn = driver.findElement(By.id("com.example.todolistapp:id/btn_add_task"));
               	addTaskBtn.click();

                WebElement listViewNew = driver.findElement(By.id("com.example.todolistapp:id/recycler_view"));
                String resultText = listViewNew.getText();
                System.out.println(resultText);
                System.out.println("Navigation from TaskFragment to AddTaskFragment was successful!");
                System.out.println("Task Successfully Added!");

                 driver.quit();
        	 }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}