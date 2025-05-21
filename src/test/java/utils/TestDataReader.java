package utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for reading test data from a JSON file.
 * Provides methods to retrieve specific test data values.
 */
public class TestDataReader {
    // Path to the JSON file containing test data
    private static final String DATA_PATH = "src/test/resources/testdata/searchData.json";
    // JsonNode object to hold the parsed JSON data
    private static JsonNode data;

    // Static block to initialize the JSON data when the class is loaded
    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readTree(new File(DATA_PATH));
        } catch (IOException e) {
            e.printStackTrace(); // Print stack trace if an error occurs while reading the file
        }
    }

    /**
     * Retrieves the search term from the JSON test data.
     *
     * @return The search term as a String.
     */
    public static String getSearchTerm() {
        return data.get("searchTerm").asText();
    }
}
