package Steps;

import Pages.SamplePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;


public class SampleSteps {

    SamplePage page = new SamplePage();

    @Given("User navigate to the html table page")
    public void navigateToHtmlTablePage() {
        page.launchUrl("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
    }

    @When("User click on the Table Data button")
    public void clickTableDataButton()  {
        page.clickTableDataButton();
    }

    @When("User insert the data into the input box")
    public void insertDataIntoInputBox() throws IOException {
        page.getJsonAsString();
        page.enterJsonValue();
    }

    @And("User click on the Refresh Table button")
    public void iClickOnTheRefreshTableButton() {
        page.clickRefreshTable();
    }

    @Then("User Verify the table should display the inserted data")
    public void verifyTableData() {
        for (int i = 0; i < page.data.size(); i++) {
            Assert.assertEquals(page.data.get(i).get("name"), page.getValue("name", i));
            Assert.assertEquals(page.data.get(i).get("age").toString(), page.getValue("age", i));
            Assert.assertEquals(page.data.get(i).get("gender"), page.getValue("gender", i));
        }
    }
}

