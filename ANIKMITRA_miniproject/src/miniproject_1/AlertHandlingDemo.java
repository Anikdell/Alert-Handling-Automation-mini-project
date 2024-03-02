package miniproject_1;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertHandlingDemo {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\QEAINT23SD007_Selenium\\Driver\\chromedriver.exe");

        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Navigate to the URL
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebElement switchToMenu = driver.findElement(By.partialLinkText("SwitchTo"));
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(switchToMenu).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Alerts")).click();
        
        
        // Click on "Alert with OK"
        WebElement AB = driver.findElement(By.id("OKTab"));
		AB.click();
        Thread.sleep(3000);

        // Check if alert pop-up appears and accept the alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();
        Thread.sleep(3000);

        // Click on "Alert with OK & Cancel"
        WebElement AwC = driver.findElement(By.partialLinkText("Alert with OK & Cancel"));
		AwC.click();
        Thread.sleep(3000);
        
        WebElement AwCT = driver.findElement(By.id("CancelTab"));
		AwCT.click();
        Thread.sleep(3000);
        
        // Check if confirm box pop-up appears and dismiss the alert (clicking Cancel)
        Alert confirmBox = driver.switchTo().alert();
        System.out.println("Confirm Box Text: " + confirmBox.getText());
        confirmBox.dismiss();
        Thread.sleep(3000);

        // Click on "Alert with Textbox"
        WebElement AwT = driver.findElement(By.partialLinkText("Alert with Textbox"));
		AwT.click();
        Thread.sleep(3000);
        
        WebElement AwPB = driver.findElement(By.id("Textbox"));
		AwPB.click();
        Thread.sleep(3000);
        // Check if prompt box pop-up appears, enter name, and accept the alert
        Alert promptBox = driver.switchTo().alert();
        System.out.println("Prompt Box Text: " + promptBox.getText());
        promptBox.sendKeys("Anik mitra");
        promptBox.accept();
        Thread.sleep(3000);

        // Check if the message "Hello <your name>, How are you today" is displayed
        String message = driver.findElement(By.id("demo1")).getText();
        System.out.println("Message displayed: " + message);

        // Close the browser
        driver.quit();
    }
}

