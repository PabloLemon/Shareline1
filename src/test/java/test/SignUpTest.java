package test;

import com.sun.source.tree.AssertTree;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SignUpTest{

    @Test
    public void checkZipCodeInputWithValidData() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("11111");
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();


        WebElement signUpform = driver.findElement(By.className("yellow_bg"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("first_name")));

        WebElement firsttName = driver.findElement(By.name("first_name"));
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password1"));
        WebElement passwordTwo = driver.findElement(By.name("password2"));
        firstName.sendKeys("Pablo");
        email.sendKeys("pablo@gmail.com");
        password.sendKeys("12345");
        passwordTwo.sendKeys("12345");

        WebElement registerButton = driver.findElement(By.xpath("//input[@value='Register']"));
        registerButton.click();

        driver.quit();








    }









    }

