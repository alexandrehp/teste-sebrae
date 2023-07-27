ENUNCIADO BACK-SÊNIOR

## 0. Versione o projeto no github.com e crie uma estrutura de branchs baseadas no GitFlow.

## 1. Crie uma chamada para o serviço http://viacep.com.br/ws/01001000/json/ utilizando Spring Cloud OpenFeign e disponibilize um endpoint para expor o resultado da chamada.

// https://viacep.com.br/ws/35500021/json/

{
"cep": "35500-021",
"logradouro": "Avenida Divino Espírito Santo",
"complemento": "até 1299/1300",
"bairro": "Centro",
"localidade": "Divinópolis",
"uf": "MG",
"ibge": "3122306",
"gia": "",
"ddd": "37",
"siafi": "4445"
}


## 2. Desenvolva um CRUD RESTful para a entidade “Conta”.  A entidade precisa ter apenas os atributos "nome" e "descricao". Para manter as informações da entidade utilize um banco de dados em memória como o H2 ou similar.

## 3. Implemente um teste conforme a metodologia BDD para a funcionalidade de cadastro de conta.

## 4. Crie um dockerfile da aplicação e execute localmente.

## 5. Justifique cada camada/pacote definido no projeto. 