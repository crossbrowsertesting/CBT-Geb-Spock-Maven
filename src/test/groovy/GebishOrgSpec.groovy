import geb.spock.GebSpec
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities

class GebishOrgSpec extends GebSpec {


    //Will execute before the step definition
    public setup() {
        def caps
       caps = new DesiredCapabilities([
                "name"            : "Basic Test Example Geb",
                "build"           : "1.0",
                "browserName"     : "Chrome",
                "version"         : "78x64",
                "platform"        : "Windows 10",
                "screenResolution": "1366x768"])



        //Create remote web driver here. If this is created in the Config file you won't be able to pass it to the Page.

         driver =
            new RemoteWebDriver(new URL("http://username:authkey@hub.crossbrowsertesting.com:80/wd/hub"), caps)


    }


    def "Go to CBT Selenium example page"() {

            when:


            to CBTSeleniumPage

            //Set this here because fails cause Geb to end with no error handling so set the fail off top and
            //change it to pass if it passes subsequent tests
            setScore(driver, "fail")



            //Check to see if the title is the expected value
            then:
            title == "Selenium Test Example Page"


            //If you make it to this step then the title is correct and you can set the score
            when:
            setScore(driver, "pass")
            quit()

            //Have to provide a then for every when statement, this makes sure that the previous when executes
            then:
            1 ==1


    }
}