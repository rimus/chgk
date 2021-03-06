package by.rimus.dev.utils;

import by.rimus.dev.logger.Log;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class RatingApiUtils {

    private static final String BRACES_REG_EXP = "[\\[\\]]";
    private static final String EMPTY = "";

    public static Response getResponse(String url) {
        Log.debug("Getting response from " + url);
        Response response = RestAssured.given().when().get(url);
        Log.debug("Response with Content-Type \"" + response.getHeaders().getValue("Content-Type") + "\" received");
        Log.debug("Status " + response.getStatusLine());
        return response;
    }

    public static String getValueByJsonPath(Response response, String jsonPath) {
        Log.debug("Getting value from received JSON by path \"" + jsonPath + "\"");
        String value = JsonPath.from(response.asString()).getString(jsonPath).replaceAll(BRACES_REG_EXP, EMPTY);
        Log.debug("Value \"" + value + "\" received");
        return value;
    }

    public static List<String> getStringListByJsonPath(Response response, String jsonPath) {
        Log.debug("Getting list of values from received JSON by path \"" + jsonPath + "\"");
        List<String> list = JsonPath.from(response.asString()).getList(jsonPath);
        Log.debug("List " + list + " received");
        return list;
    }
}
