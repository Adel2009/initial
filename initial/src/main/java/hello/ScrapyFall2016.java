package hello;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;







public class ScrapyFall2016 {

    public static void scrapyfall2016() throws InterruptedException {



        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://my.sc.edu/");
        WebElement link =  driver.findElement(By.partialLinkText("Sign in to"));
        link.click();

        WebElement element1 = driver.findElement(By.name("username"));
        element1.sendKeys("00306517");

        WebElement element2 = driver.findElement(By.id("vipid-password"));
        element2.sendKeys("ALjabri2009@");

        WebElement submit= driver.findElement(By.name("submit"));
        submit.click();


        WebElement student = driver.findElement(By.id("bmenu--P_StuMainMnu___UID1"));
        student.click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement registration = driver.findElement(By.id("bmenu--P_RegMnu___UID1"));
        registration.click();

        WebElement lookupclass = driver.findElement(By.id("contentItem12"));
        lookupclass.click();

        WebElement selectterm = driver.findElement(By.id("term_input_id"));
        Select term= new Select(selectterm);
        term.selectByVisibleText("Spring 2017");

        WebElement submit1 = driver.findElement(By.id("id____UID7"));
        submit1.click();

        WebElement advancedsearch = driver.findElement(By.id("id____UID6"));
        advancedsearch.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        WebElement campusoption = driver.findElement(By.id("camp_id"));
        Select campus= new Select(campusoption);
        campus.selectByVisibleText("USC Columbia");

        WebElement subject = driver.findElement(By.id("subj_id"));
        Select subjectt= new Select(subject);
        subjectt.selectByVisibleText("CSCE - Comp Sci & Comp Engr");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement sectionsearch = driver.findElement(By.id("id____UID5"));
        sectionsearch.click();

        WebElement content= driver.findElement(By.className("dddefault"));


        File scheudulerDir = new File(System.getProperty("user.dir")+"/schedule2017");

        if(!scheudulerDir.exists()) {
            try {
                scheudulerDir.mkdir();
            } catch(SecurityException sec) {
                sec.printStackTrace();
            }
        }

        String filename = scheudulerDir + "/spring2017.csv";

        File file = new File(filename);
        FileWriter fileWriter = null;

        try {

            if(file.exists()) {
                fileWriter = new FileWriter(filename);
            } else {

                file.createNewFile();
                fileWriter = new FileWriter(filename);
            }

            String[] rowTxt;
            String locator = "//form/table/tbody";
            String source = "<table>" + driver.findElement(By.xpath(locator)).getAttribute("innerHTML") + "<table>";
            org.jsoup.nodes.Document doc = Jsoup.parse(source, "UTF-8");
            for (org.jsoup.nodes.Element rowElmt : doc.getElementsByTag("tr")) {
                Elements cols = rowElmt.getElementsByTag("th");
                if (cols.size() == 0)
                    cols = rowElmt.getElementsByTag("td");
                rowTxt = new String[cols.size()];
                for (int i = 0; i < rowTxt.length; i++) {
                    fileWriter.append(cols.get(i).text());
                    fileWriter.append(',');
                }
                fileWriter.append('\n');
            }


        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {
            try {

                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {

                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }



    }

}