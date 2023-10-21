package principal;

import java.util.List;
import java.util.Scanner;
import controllers.ListaEps;
import controllers.ListaPersona;
import modelos.Episodio;
import modelos.Personagem;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu();

        int opcao = scanner.nextInt();

        ListaEps listaEps = new ListaEps();
        ListaPersona listaPersona = new ListaPersona();
        switch (opcao) {
            case 1:
                List<Episodio> episodios = listaEps.listarEpisodios();
                if (episodios != null) {
                    for (Episodio episodio : episodios) {
                        System.out.println("ID: " + episodio.getId());
                        System.out.println("Nome: " + episodio.getName());
                        System.out.println("Data: " + episodio.getAirDate());
                        System.out.println("Número do episódio: " + episodio.getEpisode());
                        System.out.println("Personagens: " + episodio.getCharacters());
                        System.out.println("Link: " + episodio.getUrl());
                        System.out.println("Criado: " + episodio.getCreated());
                    }
                } else {
                    System.out.println("Não foi possível obter a lista de episódios.");
                }
                break;
            case 2:
                List<Personagem> personagens = listaPersona.listarPersonagens();
                if (personagens != null) {
                    for (Personagem personagem : personagens) {
                        System.out.println("ID: " + personagem.getId());
                        System.out.println("Nome: " + personagem.getName());
                        System.out.println("Status: " + personagem.getStatus());
                        System.out.println("Espécie: " + personagem.getSpecies());
                        System.out.println("Tipo: " + personagem.getType());
                        System.out.println("Gênero: " + personagem.getGender());
                        System.out.println("Origem: " + personagem.getOrigin());
                        System.out.println("Localização: " + personagem.getLocation());
                        System.out.println("URL: " + personagem.getUrl());
                        System.out.println("Criado: " + personagem.getCreated());
                        System.out.println();
                    }
                } else {
                    System.out.println("Não foi possível obter a lista de personagens.");
                }
                break;
            case 3:
                System.out.print("Digite o nome para filtrar episódios: ");
                String nomeEpisodio = scanner.next();

                List<Episodio> episodiosFiltrados = listaEps.filtrarEpisodiosPorNome(nomeEpisodio);

                if (episodiosFiltrados != null) {
                    if (episodiosFiltrados.isEmpty()) {
                        System.out.println("Nenhum episódio encontrado com o nome: " + nomeEpisodio);
                    } else {
                        for (Episodio episodio : episodiosFiltrados) {
                            System.out.println("ID: " + episodio.getId());
                            System.out.println("Nome: " + episodio.getName());
                            System.out.println("Data: " + episodio.getAirDate());
                            System.out.println("Número do episódio: " + episodio.getEpisode());
                            System.out.println("Personagens: " + episodio.getCharacters());
                            System.out.println("Link: " + episodio.getUrl());
                            System.out.println("Criado: " + episodio.getCreated());
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("Não foi possível obter a lista de episódios.=");
                }
                break;
            case 4:
                System.out.print("Digite o nome para filtrar personagens: ");
                String nomePersonagem = scanner.next();
                List<Personagem> personagensFiltrados = listaPersona.filtrarPersonagensPorNome(nomePersonagem);

                if (personagensFiltrados != null) {
                    if (personagensFiltrados.isEmpty()) {
                        System.out.println("Nenhum personagem encontrado com o nome: " + nomePersonagem);
                    } else {
                        for (Personagem personagem : personagensFiltrados) {
                            System.out.println("ID: " + personagem.getId());
                            System.out.println("Nome: " + personagem.getName());
                            System.out.println("Status: " + personagem.getStatus());
                            System.out.println("Espécie: " + personagem.getSpecies());
                            System.out.println("Tipo: " + personagem.getType());
                            System.out.println("Gênero: " + personagem.getGender());
                            System.out.println("Origem: " + personagem.getOrigin());
                            System.out.println("Localização: " + personagem.getLocation());
                            System.out.println("URL: " + personagem.getUrl());
                            System.out.println("Criado em: " + personagem.getCreated());
                            System.out.println();
                        }
                    }
                } else {
                    System.out.println("Não foi possível obter a lista de personagens.");
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
    private static void Menu() {
        // Menu de opções:
        System.out.println("\nBem-vindo ao Wiki de Rick and Morty!");
        System.out.println("Aqui você pode fazer uma pesquisa completa sobre o universo do desenho, seja de seus personagens ou episódios.\n");

        System.out.println("\nEscolha uma opção:");
        System.out.println("1. Listar TODOS os episódios");
        System.out.println("2. Listar TODOS os personagens");
        System.out.println("3. Filtrar episódios por nome");
        System.out.println("4. Filtrar personagens por nome");
    }
}
