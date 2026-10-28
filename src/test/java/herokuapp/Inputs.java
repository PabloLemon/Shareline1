package herokuapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Inputs {

    @Test
    public void testInputs() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.tagName("input"));

        inputField.sendKeys("5");

        inputField.sendKeys(Keys.ARROW_UP);

        Assert.assertEquals("Значение должно увеличиться","6",inputField.getAttribute("value"));

        inputField.sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals("Значение должно уменьшиться","5",inputField.getAttribute("value"));

        inputField.clear();

        inputField.sendKeys("abc");

        Assert.assertEquals("Поле не должно принимать буквы", "", inputField.getAttribute("value"));

        driver.quit();
    }
}