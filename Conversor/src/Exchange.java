import com.google.gson.Gson;

import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Exchange {
    public Moneda exchange(String m1, String m2) {
        URI url = URI.create(String.format("https://v6.exchangerate-api.com/v6/ccce75e7ecedf01c61da9f67/pair/%s/%s", m1, m2));

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al tratar de encontrar el tipo de conversion");
        }
    }
}
