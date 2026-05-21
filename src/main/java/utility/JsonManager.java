package utility;

import com.jayway.jsonpath.JsonPath;

import java.io.File;
import java.io.IOException;

public class JsonManager {
    String filePath ;

    public JsonManager (String filePath )
    {
       this.filePath= filePath;
    }

    public String readTestData(String jsonPath){

        File file = new File(filePath);

        String value = null;
        try {
            value = JsonPath.parse(file).read(jsonPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return value;

    }
}
