import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class Main {

    public static void main(String[] args) throws InterruptedException {
       LoginTest loginTest = new LoginTest();

       loginTest.loginWithValidData();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
