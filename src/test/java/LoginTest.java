import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoginTest {
    List<WebElement> listOfProductNames = new ArrayList<WebElement>();
    List<WebElement> listOfProductPrices = new ArrayList<WebElement>();
    public void loginWithValidData(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://dedeman.ro/ro");
        logBtn(driver);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[1]/div/input")).click();
        wait(1);
        driver.findElement(By.cssSelector("#app > div > div.wrapper-header.position-relative > div.wrapper-modal.select-locality-modal > div > div > div:nth-child(2) > div > div > ul > li:nth-child(24)")).click();
        wait(1);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div/div[2]/div/input")).click();
        wait(1);
        driver.findElement(By.cssSelector("#app > div > div.wrapper-header.position-relative > div.wrapper-modal.select-locality-modal > div > div > div:nth-child(3) > div > div > ul > li:nth-child(64)")).click();
        wait(2);
        // credentials
        driver.findElement(By.cssSelector("[type=\"email\"]")).sendKeys("ing_vasile_cristian@yahoo.co.uk");
        driver.findElement(By.cssSelector("[type=\"password\"]")).sendKeys("Parola_dedeman2021");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div/div[1]/form/button")).click();
        wait(3);
        //favourites btn
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/ul/li[1]/a")).click();
        wait(7);// sa fac o metoda care sa astepte fix pana cand se afiseaza pagina de favorite, ma fol de page title
        listOfProductNames = driver.findElements(By.cssSelector(".product-name"));
        listOfProductPrices = driver.findElements(By.cssSelector(".product-price .bold"));
//        scrie();
        wait(1);
        compara();
        wait(3);
        driver.close();
    }
    public static void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void logBtn(WebDriver driver){
        Actions actions;
        actions = new Actions(driver);// trebuie sa definesc elementele
        actions.moveToElement(driver.findElement(By.cssSelector(".header-actions-list li:nth-child(2)>span"))).perform();
        actions.moveToElement(driver.findElement(By.cssSelector(".dropdown-buttons .blue-gradient"))).perform();
        driver.findElement(By.cssSelector(".dropdown-buttons .blue-gradient")).click();
    }
    public void scriu(String data){
        try{
            FileWriter file = new FileWriter("bd.txt",true);
            file.write(data+ "\n");
            file.close();
        } catch (IOException e){e.printStackTrace();}// oare se poate scrie cu Files?
    }
    public List<String> citescSiAtat(){
        List<String> allLines = new ArrayList<String>();
        try {
            allLines = Files.readAllLines(Paths.get("bd.txt"));
//            for(String s:allLines){
//                System.out.println(s);
//            String[] sSplit =s.split("-",-2);
//                System.out.println(sSplit[0]);
//                System.out.println(sSplit[1]);}
        } catch (IOException e){e.printStackTrace();}
        return allLines;}
    public List<String> formatAndExtractName(){
        List<String> productName = new ArrayList<String>();
        for(String element:citescSiAtat()){
            productName.add(element.split("-",2)[0]);
//            System.out.println(productName);
        }return productName;
    }
    public List<String> formatAndExtractPrice(){
        List<String> productPrice = new ArrayList<String>();
        for(String element:citescSiAtat()){
            productPrice.add(element.split("-",-2)[1]);
//            System.out.println(productPrice);
        }return productPrice;
    }
    public String getProductX(int index){
        return listOfProductNames.get(index).getText();}
    public String getPriceOfProductX(int index){
        return listOfProductPrices.get(index).getText();}
    public void scrie() {
        String deScris="";
        for(int i=0;i<listOfProductNames.size();i++){
            deScris = getProductX(i) + " - " + getPriceOfProductX(i);
            scriu(deScris);}
    }
    public void compara(){
        boolean schimbare = false;
        for(int i=0;i<formatAndExtractName().size();i++) {
//            System.out.println(Float.parseFloat(homePage.formatAndExtractPrice().get(i)));
//            System.out.println(Float.parseFloat(homePage.getPriceOfProductX(i)));
            if (Float.parseFloat(formatAndExtractPrice().get(i)) != Float.parseFloat(getPriceOfProductX(i))) {
                System.out.println("s-a modificat pretul produsului " + formatAndExtractName().get(i) + " ,noul pret este :" +
                        getPriceOfProductX(i));
                schimbare = true;
            }
        }
        if(!schimbare) System.out.println("nici o modificare");
    }
}
