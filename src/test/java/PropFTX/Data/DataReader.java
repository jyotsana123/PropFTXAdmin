package PropFTX.Data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class DataReader {

	public void getJsonDataToMap() throws IOException
	{
		//read json to string
		String jsonContemt = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\PropFTX\\Data\\Login.json"));
	}
}
