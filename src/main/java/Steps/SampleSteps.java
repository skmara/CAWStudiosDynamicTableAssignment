package Steps;

import Pages.SamplePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SampleSteps {

    SamplePage page=new SamplePage();
    @Given("I Launch Google")
    public void launchGoogle(){
page.launchUrl("https://www.google.co.in/");
    }

    @Given("I Launch flipcart")
    public void iLaunchFlipcart() {
        page.launchUrl("https://www.flipkart.com");
    }
//    @When("I Enter value in search box")
//    public void enterValue(){
//
//    }

}
