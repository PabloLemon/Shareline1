package herokuapp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.List;

public class dropD {

    @Test
    public void Drop() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement drop = driver.findElement(By.id("dropdown"));
        drop.click();

        Select select = new Select(drop);

        List<WebElement> allOptions = select.getOptions();

        Assert.assertEquals("Количество элементов в дропдауне не совпадают", 3, allOptions.size());
        Assert.assertEquals("Текст первого элемента неверный", "Please select an option",
                allOptions.get(0).getText());

        Assert.assertEquals("Текст второго элемента неверный", "Option 1", allOptions.get(1).getText());
        Assert.assertEquals("Текст третьего элемента неверный", "Option 2", allOptions.get(2).getText());

        select.selectByIndex(1);

        String firstSelectedText = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Первый элемент не выбран", "Option 1", firstSelectedText);

        select.selectByIndex(2);

        String secondSelectedText = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Второй элемент не выбран", "Option 2", secondSelectedText);

        driver.quit();
    }
    }


