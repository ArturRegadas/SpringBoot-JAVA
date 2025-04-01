<h1>Inicialização</h1>
Acessar o <a href="https://start.spring.io">Spring Initalizr</a> e extrair o arquivo para pasta do projeto, ou se for conveniente trabalhar direto na pasta e mudar o
"implementation" para org.springframework.boot:spring-boot-starter-<b>web</b> no arquivo build.gradle

<h1>Dependencies</h1>
- spring web<br>
- jpa(ajudar na manipulação do db)<br>
- devTools<br>
- postgreSQL<br>

<h1>Controller</h1>
dentro de 
    
    /src/main/java/Itau/demo/Controller 

<ul>
    <li>@RestController -> Indica que a classe é um controlador REST</li>
    <li>@RestMapping -> Mapear requisições</li>
    <li>@GetMapping -> Requisicao do Tipo GET</li>
    <li>@PostMapping -> Requisicao do Tipo POST</li>
    <li>@RequestBody -> Recebe um arquivo JSON </li>

</ul>
reuqisição via curl

    curl "http://localhost:8080/transacao" -H "Content-Type: application/json" -d "{\"valor\": 123.45,\"dataHora\": \"2020-08-07T12:34:56.789-00:00\"}"

configurar db em application.properties e dependências em pom.xml

<h1>MVC (model view controller)</h1>
<ul>
    <li><h2>Controller</h2>Recebe requisições HTTP e chama os services</li>
    <li><h2>Model</h2>Representa os dados da aplicação (entidades do banco, DTOs, etc.)</li>
    <li><h2>Repository</h2>Gerencia o acesso ao banco de dados (CRUD, queries, etc.)</li>
    <li><h2>Service</h2>Contém a lógica de negócio e chama os repositórios</li>
</ul>