package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AIHelper {
    private static final String API_KEY = "YOUR_API_KEY"; // apna key daal
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";

    // Cache: ek hi description ke liye repeat call avoid karega
    private static final Map<String, String> cache = new HashMap<>();

    public static WebElement findElementSmart(WebDriver driver, String description) {
        try {
            // Agar cache me hai to direct wahi use karo
            if (cache.containsKey(description)) {
                String cachedXPath = cache.get(description);
                return driver.findElement(By.xpath(cachedXPath));
            }

            String xpath = callOpenAI(description);

            // Cache me save kar do
            cache.put(description, xpath);

            return driver.findElement(By.xpath(xpath));
        } catch (Exception e) {
            throw new RuntimeException("AIHelper error: " + e.getMessage(), e);
        }
    }

    private static String callOpenAI(String prompt) throws Exception {
        int[] retryDelays = {5000, 15000, 30000}; // retry delays: 5s, 15s, 30s
        for (int attempt = 1; attempt <= retryDelays.length; attempt++) {
            try {
                // Request body
                String jsonInputString = "{"
                        + "\"model\": \"gpt-4o-mini\","
                        + "\"messages\": [{\"role\": \"user\", \"content\": \"Give only XPath for: " + prompt + "\"}]"
                        + "}";

                // HTTP connection
                URL url = new URL(API_URL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("POST");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("Authorization", "Bearer " + API_KEY);
                con.setDoOutput(true);

                try (OutputStream os = con.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int code = con.getResponseCode();
                if (code == 429) {
                    // Rate limit
                    System.out.println("⚠️ Rate limit hit. Retrying attempt " + attempt + " of " + retryDelays.length);
                    Thread.sleep(retryDelays[attempt - 1]);
                    continue; // retry
                }

                if (code != 200) {
                    throw new IOException("Server returned HTTP response code: " + code);
                }

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }

                // Response se XPath extract karna (simple assumption)
                String responseStr = response.toString();
                String xpath = extractXPath(responseStr);

                return xpath;
            } catch (IOException e) {
                if (e.getMessage().contains("429")) {
                    System.out.println("⚠️ Rate limit hit. Retrying attempt " + attempt + " of " + retryDelays.length);
                    Thread.sleep(retryDelays[attempt - 1]);
                } else {
                    throw e;
                }
            }
        }
        throw new RuntimeException("Failed after multiple retries due to rate limiting.");
    }

    // Simple function to extract XPath from response
    private static String extractXPath(String response) {
        // ⚠️ Yeh placeholder hai (response parsing customize karna padega)
        int start = response.indexOf("\"content\":\"") + 11;
        int end = response.indexOf("\"", start);
        return response.substring(start, end).replace("\\/", "/");
    }
}