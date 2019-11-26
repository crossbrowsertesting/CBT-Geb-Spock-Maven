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







    void setScore(RemoteWebDriver driver, String score){



        def  response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/" +  driver.getSessionId().toString())
                .basicAuth(username, password)

                .field("action","set_score")
                .field("score", score)
                .asJson();



    }

    void quit()
    {
        driver.quit()
    }
}