import geb.spock.GebSpec
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import com.mashape.unirest.http.Unirest

class CBTGebSpec extends GebSpec {




    public cleanup(){


        if(testScore=="fail") {

            //Be sure to use %40 instead of the @ symbol

            def response = Unirest.put("http://crossbrowsertesting.com/api/v3/selenium/" + driver.getSessionId().toString())
                    .basicAuth("username", "authkey")

                    .field("action", "set_score")
                    .field("score", "fail")
                    .asJson();
        }
        driver.quit();

    }

    def "Go to CBT Selenium example page"() {

            when:


            //Check all conditions on the Page.  If the page does not cause Spock to fail the test mark the test as passed
            to CBTSeleniumPage


            //Set the score to pass here which will also set the boolean that keeps the test from being marked as failed
            setScore(driver, "pass")

            //Always execute the tests
            then:
            1==1






    }
}