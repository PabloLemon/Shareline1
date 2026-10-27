package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class addRemoveElements {

    @Test
    public void addTwoElements() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement addRemoveElements = driver.findElement(By.xpath("//a[text()='Add/Remove Elements']"));
        addRemoveElements.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement addElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button" +
                "[text()='Add Element']")));

        addElement.click();
        addElement.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(deleteButtons.size(),2,"Количество кнопок не равно 2");

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement deleteElement = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button" +
                "[text()='Delete']")));

        deleteElement.click();

        List<WebElement> deleteButtonsAfterDelete = driver.findElements
                (By.xpath("//button[text()='Delete']"));
        Assert.assertEquals
                (deleteButtonsAfterDelete.size(),1, "Количество кнопок после удаления не равно 1");

        driver.quit();
    }
}