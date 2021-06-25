package sberApi.parsers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserr {
    public static String parser(String s){
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(s);
            return (String) jsonObject.get("access_token");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
