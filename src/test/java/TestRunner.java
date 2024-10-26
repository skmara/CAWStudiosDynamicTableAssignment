import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        tags = "@Mahesh",
        glue = {"Steps","Pages"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
