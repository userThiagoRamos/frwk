# frwk

A api foi desenhada com a intenção de distribuir os serviços em projetos distintos.

1 - post - CRUD para os posts do blog
2 - post-comment - CRUD para os comentários do post
3 - post-links - CRUD para os links do post

Decidi abordar desta maneira para garantir maior isolamento e possibilitar a utilização de padrões de projeto na nuvem.

As requisições devem ser enviadas para o projeto blog-gateway (zuul) que autentica o usuário e distribui a requisição para o projeto encarregado.
Além disso criei um projeto de descoberta de serviços que também trata a tolerância a falha e balanceamento de carga.
Um projeto de servidor de configuração também está presente , porém apenas a título ilustrativo no momento.

O objeto é utilizar as apis de cada item em um componente dedicado e isolado no angular.

Estava sem trabalhar com java por algum tempo, 
então a cada projeto que desenvolvi fui lembrando as melhores práticas e preferi manter cada um em seu estado para demonstrar
a evolução até chegar no que acho mais adequado, que é o projeto post-links.

Para inicializar os projetos recomendo a utilização do comando mvn spring-boot:run
na pasta raiz de cada projeto ou através do runAs => Spring Boot App da IDE de preferência.
Criei issue contendo os arquivos de schema do banco e testes e ambiente do Postman.
No postman deve se realizado o registro do usuário, Coleção “blog” => pasta => “Usuario” => requisição de nome "Signup"
Após o registro de usuário executar a requisição de nome "Autenticar" informando o usuário e senha.. 
Esta requisição executa um script de teste responsável por alimentar as variáveis de valor para o Header de "Authorization"
e X-username utilizadas em outras requisições da api. Para isso é necessário também importar o arquivo "frame.postman_environment.json".

