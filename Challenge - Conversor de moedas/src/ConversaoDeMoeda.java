import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversaoDeMoeda {

    public void converter (String moedaOrigem, String moedaDestino, float valorDigitadoPeloUsuario) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String endereco = "https://v6.exchangerate-api.com/v6/88d846ddcc24725a78882a4c/latest/" + moedaOrigem;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        TipoDeMoeda tipoDeMoeda = gson.fromJson(json, TipoDeMoeda.class);

        Double taxaDeConversao = tipoDeMoeda.conversion_rates().get(moedaDestino);

        System.out.println("\nA moeda " + moedaOrigem + " em " + moedaDestino + " esta valendo: " + tipoDeMoeda.conversion_rates().get(moedaDestino));

        System.out.printf("O valor final é: %.4f", taxaDeConversao * valorDigitadoPeloUsuario);
    }
}
