import geb.Page
import org.openqa.selenium.remote.RemoteWebDriver
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.JsonNode
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.http.exceptions.UnirestException

class CBTSeleniumPage extends Page {


    //a variable of a Page object that defines the location of the page
    static url = "http://crossbrowsertesting.github.io/selenium_example_page.html"

    //at checkers verify that the page is correct. feature of page object model of geb
    static at = { title.contentEquals("Selenium Test Example Page") }




    def testScore="fail";


    void setScore(RemoteWebDriver driver, String score){


        //Be sure to use the %40 instead of the @ symbol
        def  response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/" +  driver.getSessionId().toString())
                .basicAuth("username", "authkey")

                .field("action","set_score")
                .field("score", score)
                .asJson();


        testScore = score;
    }

    void quit()
    {
        driver.quit()
    }
}