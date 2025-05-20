package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataReader {
    private static final String DATA_PATH = "src/test/resources/testdata/searchData.json";
    private static JsonNode data;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readTree(new File(DATA_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getSearchTerm() {
        return data.get("searchTerm").asText();
    }
}