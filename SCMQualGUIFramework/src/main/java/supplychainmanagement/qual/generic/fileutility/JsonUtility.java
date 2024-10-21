package supplychainmanagement.qual.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
public String getDataFromJsonFile(String key) throws Throwable
{
	FileReader fileR=new FileReader("./configAppData/CommonData.json");
	JSONParser parse=new JSONParser();
	Object obj = parse.parse(fileR);
	JSONObject map=(JSONObject)obj;
	String data=(String) map.get(key);
	
	return data;
}
}
