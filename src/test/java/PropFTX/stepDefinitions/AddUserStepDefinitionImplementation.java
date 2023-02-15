package PropFTX.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import PropFTX.PageObject.AddUser;
import PropFTX.PageObject.LandingPage;
import PropFTX.TestComponent.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUserStepDefinitionImplementation extends BaseTest {

	public LandingPage lp;

	@Given("I landed on Add user page")
	public void I_landed_on_Add_user_page() throws IOException {
		lp = launchWebsite();
		lp.enterEmailPassword("jyotsana.pandey@mail.vinove.com", "Admin@123");
		lp.clickOnSubmit();
		adduser = new AddUser(driver);
		adduser.clickOnUserManagement();
		adduser.clickOnAddOption();

	}

	AddUser adduser = new AddUser(driver);

	@Given("^Enter name (.+), address (.+), phone no. (.+), Select country, state, city and Enter email (.+)$")
	public void enter_name_address_phone_no_select_country_state_city_and_enter_email(String name, String address,
			String phoneno, String email) throws Throwable {
		adduser.enterNameAddressPhoneNumber(name, address, phoneno);
		adduser.selectCountry();
		adduser.selectState();
		adduser.selectCity();
		adduser.enterEmail(email);
	}

	@When("^Click on Submit button$")
	public void click_on_submit_button() throws InterruptedException {
		adduser.clickOnSubmitButton();
	}

	@Then("^User added successfully$")
	public void user_added_successfully() {
		Assert.assertEquals(lp.getPopup(), "User Created Successfully");
	}

}
