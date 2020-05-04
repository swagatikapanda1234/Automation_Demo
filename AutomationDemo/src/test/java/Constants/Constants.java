package Constants;

public class Constants {
	public static String RESOURCES_PATH = System.getProperty("user.dir") + "/src/test/resources/";
	public static String APP_CONFIG_SHEET_NAME = "Application_Config";
	public static String TEST_DATA_FILE_PATH = RESOURCES_PATH + "/TestData/TestData.xlsx";
	public static String PROPERTIES_FILE_PATH = RESOURCES_PATH + "applicationSpecificTextContent.properties";

	// Driver
	public static String FF_DRIVER_PATH = Constants.RESOURCES_PATH + "Drivers/geckodriver.exe";
	public static String IE_DRIVER_PATH = Constants.RESOURCES_PATH + "Drivers/IEDriverServer.exe";
	public static String CC_DRIVER_PATH = Constants.RESOURCES_PATH + "Drivers/chromedriver.exe";
}
