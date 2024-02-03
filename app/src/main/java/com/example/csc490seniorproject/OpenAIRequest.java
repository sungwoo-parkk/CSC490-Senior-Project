package com.example.csc490seniorproject;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// This class makes the requests to the OpenAI's API
public class OpenAIRequest {

    // URL for OpenAI's API for completions
    private static final String OPENAI_URL = "https://api.openai.com/v1/completions";
    // OpenAI key
    private static final String API_KEY = "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"; 

    /**
     * This method sends a POST request to the API with a certain prompt
     * that the dating app user will ask for
     * @param prompt
     */
    public static void postRequest(String prompt) {
        try {
            // Creating a new instance for the 'client' to send HTTP requests
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{"
                    + "\"model\": \"text-davinci-003\","
                    + "\"prompt\": \"" + prompt + "\","
                    + "\"temperature\": 0.7,"
                    + "\"max_tokens\": 150"
                    + "}");

            Request request = new Request.Builder()
                    .url(OPENAI_URL)
                    .post(body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + API_KEY)
                    .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error has occured");
        }
    }
}
