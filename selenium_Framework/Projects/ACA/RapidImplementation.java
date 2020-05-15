package ACA;

import static ioTasksAndOperations.ReadObjectRepository.findTestObject;
import static ioTasksAndOperations.createGlobalVariable.updateGlobalVariables;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ioTasksAndOperations.GlobalVariable;
import ioTasksAndOperations.WebUI;

public class RapidImplementation {
	@BeforeTest
	public void setup() {
		//Run only this part of code once before running/creating actual script
		//This updates the actual GlobalVariables class
	updateGlobalVariables("LowCostOption"); 
	}
	
	@Test
  public void TC1() {
	

//		WebDriver driver = DriverFactory.getWebDriver()
		
		WebUI.navigateToUrl(GlobalVariable.url);

		//WebUI.navigateToUrl("https://cbagold.hewitt.com/safe")
		WebUI.setText(findTestObject("Login/EnterUsername"), GlobalVariable.username);

		//WebUI.sendKeys(findTestObject("Login/EnterPassword"), GlobalVariable.password)
		WebUI.setText(findTestObject("Login/EnterPassword"), GlobalVariable.password);

		WebUI.click(findTestObject("Login/ClickLogOn"));

		WebUI.selectOptionByLabel(findTestObject("Login/SelectModule"), "Rapid Implementation", false);

		WebUI.click(findTestObject("Login/ClickGo"));

		WebUI.maximizeWindow();

		WebUI.click(findTestObject("RICompanionPlan/EmployerSelection"));

		WebUI.click(findTestObject("RIACA/Click6055_6056Link"));

		WebUI.click(findTestObject("RIACA/EIN"));

		WebUI.click(findTestObject("RIACA/EIN_SaveButton"));

		String AllErrorMessage = WebUI.getText(findTestObject("RIACA/EIN_ErrorMessage"));

		boolean allEINError = false;

  }
}
