package miniproject_1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertHandlingAutomation {

    public static void main(String[] args) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\QEAINT23SD007_Selenium\\Driver\\chromedriver.exe");

        // Launch Chrome browser and navigate to the URL
        WebDriver chromeDriver = new ChromeDriver();
        WebDriver edgeDriver = new EdgeDriver();
        chromeDriver.manage().window().maximize();
        edgeDriver.manage().window().maximize();
        try {
            // Perform actions on Chrome browser
            chromeDriver.get("http://demo.automationtesting.in/Alerts.html");
            handleAlerts(chromeDriver);

            // Switch to edge browser
            chromeDriver.quit();
            edgeDriver.get("http://demo.automationtesting.in/Alerts.html");
            handleAlerts(edgeDriver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close both browsers
            chromeDriver.quit();
            edgeDriver.quit();
        }
    }

    public static void handleAlerts(WebDriver driver) {
        try {
            // Hover over "SwitchTo" menu and click on "Alerts"
            WebElement switchToMenu = driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
            Actions actions = new Actions(driver);
            Thread.sleep(3000);
            actions.moveToElement(switchToMenu).build().perform();
            Thread.sleep(3000);
            driver.findElement(By.linkText("Alerts")).click();

            // Handle Alert with OK
            driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
            Thread.sleep(3000);
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            System.out.println("Alert Text: " + alertText);
            alert.accept();
            Thread.sleep(3000);
            
            // Handle Alert with OK & Cancel
            driver.findElement(By.linkText("Alert with OK & Cancel")).click();
            driver.findElement(By.xpath("//button[contains(text(),'click the button to display a confirm box')]")).click();
            Thread.sleep(3000);
            Alert confirmBox = driver.switchTo().alert();
            String confirmText = confirmBox.getText();
            System.out.println("Confirm Box Text: " + confirmText);
            confirmBox.dismiss();
            Thread.sleep(3000);
            
            // Handle Alert with Textbox
            driver.findElement(By.linkText("Alert with Textbox")).click();
            driver.findElement(By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]")).click();
            Thread.sleep(3000);
            Alert promptBox = driver.switchTo().alert();
            promptBox.sendKeys("Anik mitra");
            promptBox.accept();
            Thread.sleep(3000);
            
            // Check the displayed message
            WebElement resultMessage = driver.findElement(By.id("demo1"));
            String message = resultMessage.getText();
            System.out.println("Result Message: " + message);
            Thread.sleep(3000);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

