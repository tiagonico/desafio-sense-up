Desafio Minisense

Para executar a aplicação é necessário ter instalado em seu sistema o Java e Maven.

Caso não tenha instalado, segue baixo os links para os sites oficiais:
https://www.java.com/pt-BR/
https://maven.apache.org/

Para rodar a aplicação abra o terminal nesse diretório e execute o comando:

- mvn spring-boot:run

Esse projeto utiliza o banco de dados H2, para acessar seu painel de controle basta 
inserir o endereço abaixo no seu navegador e clicar em "Connect".

- localhost:8080/h2-console

Para testar os endpoints sugeridos no desafio pode ser utilizado o Postman, ou o próprio 
Swagger, acessado pelo endereço abaixo.

- localhost:8080/swagger-ui/index.html#/

A modelagem do domínio foi baseado no diagrama de classes disponibilizado no desafio.

O usuário (User) possui dispositivos (SensorDevice).
Já os dispositivos possuem fluxos de dados (DataStream).
E os fluxos de dados coletam dados (SensorData).
Tanto o fluxo de dados quanto os dados tem uma unidade de medida (MeasurementUnit).


Segue abaixo o funcionamento dos endpoints sugeridos no desafio.

- [GET] localhost:8080/measurement-units

Essa requisição GETALL retorna todas as unidades de medida no banco de dados.

- [GET] localhost:8080/sensor-devices/user/{id}

Essa requisição GET retorna todos os dispositivos de usuário passando seu ID.

- [GET] localhost:8080/sensor-devices?key={key}

Essa requisição GET retorna o dispositivo que corresponda à chave passada por parâmetro,
caso não seja passado nada como parâmetro a requisição retorna todos os dispositivos no banco de dados.

- [GET] localhost:8080/data-streams?key={key}

Essa requisição GET retorna o fluxo de dados que corresponda à chave passada por parâmetro,
caso não seja passado nada como parâmetro a requisição retorna todos os fluxos no banco de dados.

- [POST] localhost:8080/sensor-devices

{
  "label": "string",
  "description": "string"
}

Essa requisição POST registra um dispositivo, retornando os campos "label" e "description" passados no corpo da requisição
e o "id" e "key" gerado. 

- [POST] localhost:8080/data-streams?key={key}

{
  "label": "string",
  "unitId": 1
}

Essa requisição POST registra um fluxo de dados para um dispositivo cuja chave é passada por parâmetro.
A requisição precisa dos campos "label" e "unitId" em seu corpo. A resposta é os campos passados no corpo, 
o "id" e "key" gerados, o "deviceId" (ID do dispositivo passado por parâmetro) e "measurementCount" (contador de medições).

- [POST] localhost:8080/sensor-data?key={key}

{
  "timestamp": 1506521102,
  "value": 28.5
}

Essa requisição POST registra um dados para um fluxo de dados cuja chave é passada por parâmetro.
A requisição precisa dos campos "timestamp" e "value" em seu corpo. A resposta é os campos passados no corpo, 
o "id" gerado e o "unitId" (ID da unidade de medida do seu fluxo de dados).







