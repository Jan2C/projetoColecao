Esse é um pequeno projeto em desenvolvimento Web que eu fiz para aplicar o meu gerenciamento de livros, são dois C.R.U.D que atuam para organizar as minhas listas, futuramente podem surgir algumas coisas novas.

Essa é a minha primeira tentativa de importar um projeto para o GitHub.

A pasta Target atua dentro da pasta projetoColecao, de modo que ela ficaria logo abaixo da pasta src dentro de projeto colecao.
Foi feito dessa forma pois não consegui encontrar outro modo para enviar todos os arquivos.

Ficaria então desse jeito com a pasta projetoColecao aberta:

.idea
.mvn
src
target
.gitignore
HELP
mvnw
pom.xml

Ressalvas: Não esqueça dos servidores, na minha máquina utiliza-se o XAMPP.

Necessário dar build logo após um breve tempo de abrir a pasta projetoColecao, já com a pasta target dentro, em sua IDE.

Digitar localhost:8080/home na barra de pesquisa depois de inicar a aplicação.

Dentro do banco de dados é necessário tar uma base de dados chamada de colecao (você trocar o nome dessa base dentro de application
properties, caminho --> projetoColecao/src/main/resources/application.properties).
           
Não esqueça de baixar a pasta target e colocar dentro de projetoColecao, logo abaixo da pasta src, é de vital importância para o funcionamento da pequena aplicação web.
