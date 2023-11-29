# Controlador de cadastro de entregadores
Essa é uma API para criar um banco de dados para entregadores. Nela é possível que você crie cadastros, veja a lista completa de todos entregadores cadastrados, procure por um entregador especifico, altere um entregador já cadastrados e exclua um entregador.
Vídeo demonstrando utilização: 

## Requisitos
1. Java 17
2. Maven
3. IDE intellij ou Eclipse
4. PostgreSQL
5. Postman, ou outro gerenciador de arquivos.

## Configurar banco de dados:
Essa API foi construída usando o banco de dados PostgreSQL
		Database: postgres
		Username: postgres
		Password: s3nh4

## Iniciar a aplicação
1. Copie esse projeto para pasta da sua IDE
2. Importa o projeto para sua IDE
3. Atualize as bibliotecas com o maven
4. Inicialize
5. Abra o gerenciador de API
6. Verifque quais os comandos que podem ser utilizados

## Utilização
Ver a lista já cadastrada
        - URI: http://localhost:8080/lista
	
        - Metodo: GET

Cadastrar entregador
        - URI: http://localhost:8080/criar
	
        - Metodo: POST
	
        - Formulário json
	
        {
        “nome”: “...”,
        “cpf”: “...”,
        “capacidade”: “...”
        }

Pesquisar um entregador
        - URI: http://localhost:8080/pesquisar/{id}
	
        - Metodo: GET

Alterar um cadastro
        - URI: http://localhost:8080/alterar/{id}
	
        - Metodo: POST
	
        - Formulário json
	
        {
        “nome”: “...”,
        “cpf”: “...”,
        “capacidade” : “...”
        }

Excluir um entregador
        - URI: http://localhost:8080/apagar/{id}
	
        - Metodo: DELETE



