import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginTest {

    public void loginWithValidData(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Actions actions;
        driver.manage().window().maximize();
        driver.get("http://dedeman.ro/ro");
        actions = new Actions(driver);// trebuie sa definesc elementele
        actions.moveToElement(driver.findElement(By.cssSelector(".header-actions-list li:nth-child(2)>span"))).perform();
        actions.moveToElement(driver.findElement(By.cssSelector(".dropdown-buttons .blue-gradient"))).perform();
        driver.findElement(By.cssSelector(".dropdown-buttons .blue-gradient")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[1]/div/input")).click();
        wait(1);
        driver.findElement(By.cssSelector("#app > div > div.wrapper-header.position-relative > div.wrapper-modal.select-locality-modal > div > div > div:nth-child(2) > div > div > ul > li:nth-child(24)")).click();
        wait(1);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[2]/div/input")).click();
        wait(1);
        driver.findElement(By.cssSelector("#app > div > div.wrapper-header.position-relative > div.wrapper-modal.select-locality-modal > div > div > div:nth-child(3) > div > div > ul > li:nth-child(64)")).click();
        wait(1);
        driver.findElement(By.cssSelector("[type=\"email\"]")).sendKeys("ing_vasile_cristian@yahoo.co.uk");
        driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("Parola_dedeman2021");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/button")).click();
        wait(3);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[1]/a")).click();

//        WebElement welcomeTextElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > div.welcome-msg > p.hello > strong"));
//
//        String expectedText = "Hello, Cosmin Fast!";
//        String actualText = welcomeTextElement.getText();
//
//        if (actualText.equals(expectedText)){
//            System.out.println("S-a logat cu success!");
//        }else
//            System.err.println("Nu s-a logat. ");

//        driver.close();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
