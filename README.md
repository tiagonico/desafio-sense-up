<img src="https://senseup.me/site/wp-content/uploads/2021/03/LOGO-SENSEUP-transparente.png" width=20%/>

# Desafio MiniSense

Teste aos candidatos a vaga de estágio para desenvolvimento Backend da SenseUp.

# 📜 Descrição

<b>Cenário do MiniSense:</b>

Um produto na área de Internet das Coisas (IoT) e Sensoreamento Remoto está sendo desenvolvido. Trata-se de um serviço para gerenciar o estado de dispositivos IoT instalados pelos clientes e alertar, através de um aplicativo, sobre situações ou emergências condicionadas aos objetos, mercadorias, ou locais monitorados por esses sensores.

Por exemplo, um cliente pode ser alertado através de seu smartphone sobre o superaquecimento de um equipamento ou produto sensível que estava sendo monitorado através de um sensor previamente instalado e conectado ao serviço. Ao adquirir um sensor compatível com o serviço e instalá-lo, é possível associá-lo à conta de usuário do dono, assim, ele estará disponível no dashboard do app para acompanhamento, sendo informado de quais tipos de dados estão sendo monitorados e seus valores medidos mais recentes. Em outra área do app (fora do escopo deste cenário) seria possível configurar alertas combinando condições sobre os valores medidos, ex: alertar usuário quando a temperatura do sensor 985bf2cde9b54a54b8fcd3423d89ad89 (rotulado como Freezer do depósito) ultrapassar -4 ºC.

O domínio estabelece que cada usuário (User) possui um conjunto de gateways sensores (representações de um dispositivo físico de coleta de dados) e tais sensores (SensorDevice) podem apresentar diferentes streams de dados coletados (DataStream) como temperatura, umidade, pressão atmosférica, luminosidade, etc (label), cada um com sua unidade pré-estabelecida (MeasurementUnit: ºC, hPa, %, lux, etc). Espera-se que para uma stream ativa (enabled), novos dados de leitura (SensorData), realizadas num determinado instante de tempo, sejam publicadas ao longo da atividade do gateway sensor, de modo que, novos objetos SensorData cheguem à stream na ordem de segundos ou minutos. Cada SensorData também apresenta a unidade de medida referente a sua Stream no momento de seu recebimento. 

<b>Regras e Modelagens do Domínio:</b>

O domínio estabelece que cada usuário (User) possui um conjunto de gateways sensores (representações de um dispositivo físico de coleta de dados) e tais sensores (SensorDevice) podem apresentar diferentes streams de dados coletados (DataStream) como temperatura, umidade, pressão atmosférica, luminosidade, etc (label), cada um com sua unidade pré-estabelecida (MeasurementUnit: ºC, hPa, %, lux, etc). Espera-se que para uma stream ativa (enabled), novos dados de leitura (SensorData), realizadas num determinado instante de tempo, sejam publicadas ao longo da atividade do gateway sensor, de modo que, novos objetos SensorData cheguem à stream na ordem de segundos ou minutos. Cada SensorData também apresenta a unidade de medida referente a sua Stream no momento de seu recebimento. 

<b>RESTful API:</b> Os desenvolvedores de front-end da plataforma IoT MiniSense (Web, iOS e Android) precisam acessar uma RESTful API que suporte as operações que o usuário é capaz de desempenhar nos aplicativos.

É esperado que através dos apps o cliente possa visualizar dispositivos e streams ativos, registrar novos dispositivos e vincular/registrar novas streams aos mesmos. Para as streams, é possível consultar o fluxo de dados que vai sendo publicado pelos sensores reais ao longo do tempo. É esperado que a RESTful API permita interagir com duas entidades principais SensorDevice e DataStream através de mensagens em JSON.
Foi definido um conjunto de requisitos mínimos que a API deve atender bem como determinados os formatos das mensagens de cada requisição, como listadas no fim do documento.

<b>Objetivo:</b>

Implementar um serviço de backend (com um modelo e persistência de dados) que provê uma RESTFul API para os desenvolvedores de front-end atendendo as definições em Definição da API.

<b>Implementação:</b>

Para a implementação do serviço o candidato pode optar por utilizar Java ou Kotlin com Spring Boot, Vert.X, Spark, ou Ktor, ou utilizar TypeScript com Express, AdonisJS ou NestJS.

# 🛠️ Instalação

1️⃣ Primeiramente faça o download do projeto, seja baixando o arquivo .zip pelo navegador ou através do comando <i>git clone</i>.

2️⃣ Instale em seu sistema o <a href="https://www.java.com/pt-BR/">Java</a> e <a href="https://maven.apache.org/">Maven</a>, caso não tenha instalado.

3️⃣ Na pasta raiz do projeto digite o comando no terminal para rodar a aplicação:
 
 ```
 mvn spring-boot:run
 ```
 
Esse projeto utiliza o banco de dados H2, para acessar seu painel de controle basta 
inserir o endereço abaixo no seu navegador e clicar em "Connect".

```
localhost:8080/h2-console
```

Para testar os endpoints sugeridos no desafio pode ser utilizado o <a href="https://www.postman.com/">Postman</a>, ou o próprio 
Swagger, acessado pelo endereço abaixo.

```
localhost:8080/swagger-ui/index.html#/
```
 
# 🧿 Endpoints

Segue abaixo o funcionamento dos endpoints sugeridos no desafio:

* [GET] localhost:8080/measurement-units

Essa requisição GETALL retorna todas as unidades de medida no banco de dados.

* [GET] localhost:8080/sensor-devices/user/{id}

Essa requisição GET retorna todos os dispositivos de usuário passando seu ID.

* [GET] localhost:8080/sensor-devices?key={key}

Essa requisição GET retorna o dispositivo que corresponda à chave passada por parâmetro,
caso não seja passado nada como parâmetro a requisição retorna todos os dispositivos no banco de dados.

* [GET] localhost:8080/data-streams?key={key}

Essa requisição GET retorna o fluxo de dados que corresponda à chave passada por parâmetro,
caso não seja passado nada como parâmetro a requisição retorna todos os fluxos no banco de dados.

* [POST] localhost:8080/sensor-devices

{
  "label": "string",
  "description": "string"
}

Essa requisição POST registra um dispositivo, retornando os campos "label" e "description" passados no corpo da requisição
e o "id" e "key" gerado. 

* [POST] localhost:8080/data-streams?key={key}

{
  "label": "string",
  "unitId": 1
}

Essa requisição POST registra um fluxo de dados para um dispositivo cuja chave é passada por parâmetro.
A requisição precisa dos campos "label" e "unitId" em seu corpo. A resposta é os campos passados no corpo, 
o "id" e "key" gerados, o "deviceId" (ID do dispositivo passado por parâmetro) e "measurementCount" (contador de medições).

* [POST] localhost:8080/sensor-data?key={key}

{
  "timestamp": 1506521102,
  "value": 28.5
}

Essa requisição POST registra um dados para um fluxo de dados cuja chave é passada por parâmetro.
A requisição precisa dos campos "timestamp" e "value" em seu corpo. A resposta é os campos passados no corpo, 
o "id" gerado e o "unitId" (ID da unidade de medida do seu fluxo de dados).







