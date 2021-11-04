//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)

package Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
    public HerokuAppTest() {
    }

    @Test
    public void HerokuAppTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys(new CharSequence[]{"1111"});
        String textFromField = inputField.getAttribute("value");
        Assert.assertEquals(textFromField, "1111");
        driver.quit();
    }

    @Test
    public void HerokuAppAddRemoveElementsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        Actions act = new Actions(driver);
        WebElement inputField = driver.findElement(By.tagName("button"));
        act.moveToElement(inputField).doubleClick().perform();
        WebElement el = driver.findElement(By.xpath("//button[text()='Delete']"));
        el.click();
    }

    @Test
    public void HerokuAppCheckboxesTest() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        checkbox1.click();
        WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        checkbox2.click();
    }

    @Test
    public void HerokuAppAddDropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 2");
        String selectedOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 2");
        driver.quit();
    }

    @Test
    public void HerokuAppAddTyposTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        chromeOptions.addArguments(new String[]{"--incognito"});
        chromeOptions.addArguments(new String[]{"--disable-popup-blocking"});
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement element = driver.findElement(By.tagName("This example demonstrates a typo being introduced. It does it randomly on each page load."));
        if (element.getText().equals("This example demonstrates a typo being introduced. It does it randomly on each page load.")) {
            System.out.println("Match found");
        } else {
            System.out.println("Match Not found");
        }

        Assert.assertEquals(element.getText(), "This example demonstrates a typo being introduced. It does it randomly on each page load.");
    }
}

