# RickWiki
Acelera devs - Desafio de projeto da Alura trilha 1 java 

Projeto para consumo de API e fazer uma pesquisa sobre a série animada Rick And Morty.
Endpoints:

Lista de Episódios
Lista de Personagems
Filtro de Episódios
Filtro de Personagens

Projeto trabalho com REST API do site "https://rickandmortyapi.com",criada por Axel Fuhrmann.

O funcionamento do projeto se inicia no arquivo main, localizado no \RickWiki\src\principal\Main.java. A partir dele haverá uma interface para o usuário escolher dentre 4 opções, na mesma ordem dos Endpoints listados acima.
A partir da seleção por um Switch, o caso escolhido puxa uma função dos controlles que fazem uma query a API RickAndMorty e retorna um arquivo JSON.
Esse arquivo é transformado pelo gson em um objeto que por sua vez é incorporado pela classe Episodio ou Personagem, de acordo com a pesquisa feita.
Essa classa então é utilizada dentro do switch par aexibir os atributos do objeto que contém cada personagem ou episódio da série.

Para visualização do funcionamento do projeto, favor abrir arquivo VEJAME.MP4