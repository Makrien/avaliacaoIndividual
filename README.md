# Avaliação Individual de API Restful

## Descrição

A aplicação é utilizada para cadastro e consulta de pedidos com os seguintes parâmetros e seus tipos no java/postgres:

* cliente: String/varchar
* prato: String/varchar
* preco: Double/float

O método GET funciona com as URNs:
* "/pedidos" - Lista todos os pedidos cadastrados;
* "/pedidos/*id*" - Retorna o pedido com o id especificado; 
* "/pedidos/cliente" - Lista todos os pedidos cujos segmentos de string passados no body equiparam-se ao cliente;
* "/pedidos/prato" - Lista todos os pedidos cujos segmentos de string passados no body equiparam-se ao prato;
* "/pedidos/preco-min" - Lista todos os pedidos com preco maior que o especificado;
* "/pedidos/preco-intervalo" - Lista os pedidos cujo preco está entre um valor mínimo e um máximo (deve ser passado como JSON no body com as chaves "min" e "max".

Pedidos podem ser cadastrados com POST, através de JSON com as chaves "cliente", "prato" e "preco".

Pedidos podem ser modificados com PUT, passando o *id* na URI (e.g. .../pedidos/4).

Pedidos podem ser excluídos com DELETE, bastando passar seu *id* na URI como acima.

## Intruções para execução da aplicação

1. Certifique-se de configurar as variáveis de ambiente **DB_HOST**, **DB_USER** e **DB_PASSWORD** para conexão com o banco de dados;
2. Crie um database chamado "serratec".
3. Importe a pasta principal no Eclipse como projeto Maven.
4. Inicie o arquivo "AvaliacaoIndividualApplication.java" como Java Application.
