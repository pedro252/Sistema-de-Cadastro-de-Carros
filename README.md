# Sistema de Cadastro de Carros com CRUD e Rota de Venda

Este projeto é um sistema simples para cadastro de carros, implementando as operações CRUD (Create, Read, Update, Delete) e uma rota específica para a venda de carros. Além disso, um mock de serviço de estoque é utilizado para simular a verificação de disponibilidade dos carros.

## Funcionalidades

### CRUD de Carros

O sistema permite realizar as seguintes operações:

- **Criar** um novo carro
- **Listar** todos os carros
- **Obter detalhes** de um carro específico
- **Atualizar** informações de um carro existente
- **Excluir** um carro

### Rota de Venda de Carros

A rota de venda verifica se o carro está disponível em estoque antes de realizar a venda. Se o carro não estiver disponível, a rota retorna o motivo pelo qual a venda não foi realizada.

### Mock de Serviço de Estoque

Um mock de serviço é utilizado para simular a verificação de disponibilidade dos carros no estoque. O mock pode retornar diferentes cenários (disponível/não disponível) com mensagens de erro apropriadas.

## Endpoints

### Operações CRUD

- `POST /carros`
  - Cria um novo carro.
  - Exemplo de requisição:
    ```json
    {
      "marca": "Toyota",
      "nome": "Corolla",
      "preco": 75000
    }
    ```

- `GET /carros`
  - Lista todos os carros cadastrados.

- `GET /carros/{id}`
  - Obtém os detalhes de um carro específico pelo seu ID.

- `PUT /carros/{id}`
  - Atualiza as informações de um carro existente.
  - Exemplo de requisição:
    ```json
    {
      "marca": "Honda",
      "nome": "Civic",
      "preco": 80000
    }
    ```

- `DELETE /carros/{id}`
  - Exclui um carro pelo seu ID.

### Rota de Venda de Carros

- `POST /carros/{id}/vender`
  - Realiza a venda de um carro. Antes de concluir a venda, verifica se o carro está disponível em estoque através do serviço mock.
  - Se o carro não estiver disponível, retorna o motivo da indisponibilidade.

## Testes Unitários

Os testes unitários foram implementados para garantir a funcionalidade correta do sistema. Os testes cobrem:

- Todas as operações CRUD.
- Lógica da rota de venda, incluindo verificação de disponibilidade pelo mock do serviço de estoque.
- Validação das mensagens de erro quando o carro não está disponível.
