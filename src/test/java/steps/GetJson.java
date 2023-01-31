package data;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class GetJson {


    public static JSONObject readAsJASONObject(String fileName) throws IOException, ParseException {

        String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName;
        File srcFile = new File(filePath);
        JSONParser jsonParser = new JSONParser();
        JSONObject jarray = (JSONObject) jsonParser.parse(new FileReader(srcFile));
        return jarray;

    }
}

