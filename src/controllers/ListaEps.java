package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import modelos.Episodio;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ListaEps{
    public List<Episodio> listarEpisodios() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/episode"))
                .GET()
                .build();

        try {
            //Solicitação json
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // GSON converte o JSON em lista de objetos Episodio
            Gson gson = new Gson();

            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonArray results = jsonObject.getAsJsonArray("results");

            // Crie uma lista para armazenar os episódios
            List<Episodio> episodios = new ArrayList<>();

            for (JsonElement element : results) {
                Episodio episodio = gson.fromJson(element, Episodio.class);
                episodios.add(episodio);
            }

            // Agora 'episodios' contém a lista de episódios
            return episodios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<Episodio> filtrarEpisodiosPorNome(String nome) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://rickandmortyapi.com/api/episode/?name=" + nome;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Refazer a solicitação pra trabalhar com o mesmo em JSON
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // GSON converte o JSON em lista de objetos Episodio
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonArray results = jsonObject.getAsJsonArray("results");

            List<Episodio> episodios = new ArrayList<>();
            for (JsonElement element : results) {
                Episodio episodio = gson.fromJson(element, Episodio.class);
                episodios.add(episodio);
            }

            return episodios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
