import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.remote.DesiredCapabilities





caps = new DesiredCapabilities([
        "name"            : "Basic Test Example Geb",
        "build"           : "1.0",
        "browserName"     : "Chrome",
        "version"         : "78x64",
        "platform"        : "Windows 10",
        "screenResolution": "1366x768"])



//Create remote web driver here. If this is created in the Config file you won't be able to pass it to the Page.
//Use %40 instead of @ symbol in your email address (username)
driver = {
        new RemoteWebDriver(new URL("http://username:authkey@hub.crossbrowsertesting.com:80/wd/hub"), caps)}