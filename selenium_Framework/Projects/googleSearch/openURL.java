package googleSearch;
import ioTasksAndOperations.WebUI;
import ioTasksAndOperations.GlobalVariable;
import static ioTasksAndOperations.createGlobalVariable.updateGlobalVariables;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static ioTasksAndOperations.ReadObjectRepository.findTestObject;

public class openURL {

	@BeforeTest
	public void setup() {
		//Run only this part of code once before running/creating actual script
		//This updates the actual GlobalVariables class
	updateGlobalVariables("globalvarTest"); }
	
	@Test
  public void openWebSiteandSearch() {
	
	  WebUI.navigateToUrl(GlobalVariable.url);
	  WebUI.setText(findTestObject("Object Repository/search_input"), GlobalVariable.search);
	  WebUI.click(findTestObject("Object Repository/search_button"));
//	  WebUI.takeScreenshot();

  }
}
