package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;

    public static ConfigReader configReader = new ConfigReader();

    public static WebDriver initDriver(){
        String browser = configReader.getProperty("browser").toLowerCase().trim();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        boolean headless = Boolean.parseBoolean(configReader.getProperty("headless"));

        if(headless){
            chromeOptions.addArguments("--headless=new");
            firefoxOptions.addArguments("--headless");
        }

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Unsupported browser: " + browser + ". Defaulting to Chrome.");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
        }



        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CustomWebDriverListener customWebDriverListener = new CustomWebDriverListener();
        driver = new EventFiringDecorator<>(customWebDriverListener).decorate(driver);
        driver.manage().window().maximize();
        return driver;
    }

    public static void quitDriver(){
        if (driver != null) driver.quit();
    }
}