<h1>Inicialização</h1>
Acessar o <a href="https://start.spring.io">Spring Initalizr</a> e extrair o arquivo para pasta do projeto, ou se for conveniente trabalhar direto na pasta e mudar o
"implementation" para org.springframework.boot:spring-boot-starter-<b>web</b> no arquivo build.gradle

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
"http://localhost:8080/transacao" -H "Content-Type: application/json" -d "{\"valor\": 123.45,\"dataHora\": \"2020-08-07T12:34:56.789-00:00\"}"