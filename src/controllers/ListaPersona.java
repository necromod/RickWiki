package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import modelos.Personagem;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ListaPersona {
    public List<Personagem> listarPersonagens() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/character"))
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
            List<Personagem> personagens = new ArrayList<>();

            for (JsonElement element : results) {
                Personagem personagem = gson.fromJson(element, Personagem.class);
                personagens.add(personagem);
            }

            // Agora 'personagens' contém a lista de personagens
            return personagens;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Personagem> filtrarPersonagensPorNome(String nome) {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://rickandmortyapi.com/api/character/?name=" + nome;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            // Realize a solicitação e receba a resposta em JSON
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // Use GSON para desserializar o JSON em uma lista de objetos Personagem
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
            JsonArray results = jsonObject.getAsJsonArray("results");

            List<Personagem> personagens = new ArrayList<>();
            for (JsonElement element : results) {
                Personagem personagem = gson.fromJson(element, Personagem.class);
                personagens.add(personagem);
            }

            return personagens;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
