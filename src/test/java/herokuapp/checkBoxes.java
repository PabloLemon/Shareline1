package herokuapp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class checkBoxes {

    @Test
    public void checkBox() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));

        boolean isFirstUnchecked = checkboxes.get(0).isSelected();
        Assert.assertEquals("Первый чекбокс должен быть пустым", false, isFirstUnchecked);

        checkboxes.get(0).click();

        boolean isFirstChecked = checkboxes.get(0).isSelected();
        Assert.assertEquals("Первый чекбокс должен быть отмечен", true, isFirstChecked);

        boolean isSecondChecked = checkboxes.get(1).isSelected();
        Assert.assertEquals("Второй чекбокс должен быть отмечен", true, isSecondChecked);

        checkboxes.get(1).click();

        boolean isSecondUnchecked = checkboxes.get(1).isSelected();
        Assert.assertEquals("Второй чекбокс должен быть пустым", false, isSecondUnchecked);

        driver.quit();
    }
}