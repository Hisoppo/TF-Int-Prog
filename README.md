# TF-Int-Prog
Trabalho final da disciplina de Int. a Programação na PUCRS 2024/2

<h1>Sistema de Gerenciamento de Passeios</h1>

<p>Este projeto consiste na implementação de um Sistema de Gerenciamento de Passeios de Barco. Ele abrange desde o gerenciamento dos barcos disponíveis, até a organização de passeios e a administração de passageiros. As funcionalidades incluem o cadastro e manipulação de barcos, a criação de passeios, e o gerenciamento de passageiros e arrecadação. O sistema é projetado para ser utilizado por uma empresa especializada em passeios de barco.</p>

<h2>Funcionalidades Implementadas</h2>
<ol>
    <li>Cadastro de barcos: Adição, remoção, listagem e busca de barcos pelo nome.</li>
    <li>Gerenciamento de passeios:
        Criação de passeios vinculados a um barco existente.
        Inserção e remoção de passageiros do passeio.
        Cálculo de arrecadação total com base nos bilhetes vendidos.
        Consulta da quantidade de passageiros com uma profissão específica.</li>
    <li>Interface com o usuário: Menu interativo com opções para cada funcionalidade.</li>
</ol>


<h2>Estrutura do Código</h2>

    <h3>O sistema foi implementado em Java com as seguintes classes principais:</h2>

<ol>
    <li>Passageiro: Representa os dados de um passageiro (nome, idade e profissão).</li>
    <li>Barco: Representa as informações de um barco (código, nome e lotação).</li>
    <li>CadastroBarcos: Gerencia o cadastro de barcos (inclui, remove e busca barcos).</li>
    <li>Passeio: Administra os passeios (vinculação de barco, gestão de passageiros e cálculo de valores).</li>
    <li>Application: Contém o main e implementa a interface de interação com o usuário.</li>
</ol>



<h2>Lições Aprendidas</h2>
<ul>
    <li>Modelagem de Classes: Aprendemos a importância de planejar bem as classes, seus atributos e métodos para que se comuniquem de forma eficiente.</li>
    <li>Encapsulamento: A prática de proteger os atributos das classes com métodos de acesso (getters e setters) foi fundamental para manter a integridade dos  dados</li>.
    <li>Manipulação de Vetores: O uso de vetores para gerenciar dados (barcos e passageiros) foi essencial para o funcionamento do sistema.</li>
    <li>Controle de Fluxo: A implementação de menus interativos ajudou a consolidar o conhecimento sobre controle de fluxo e validação de entrada.</li>
</ul>   
<h2>Dificuldades Encontradas e Soluções</h2>
    
<h3>Validação de Dados</h3>
<ul>
    <li>Desafio: Garantir que barcos e passageiros sejam adicionados apenas com informações válidas.</li>
    <li>Solução: Implementação de verificações detalhadas antes de permitir operações.</li>
</ul>

<h3>Gerenciamento de Objetos</h3>
<ul>
    <li>Desafio: Controlar o vínculo entre passeios e barcos de maneira eficaz.</li>
    <li>Solução: Utilização de referências de objetos para estabelecer relações diretas.</li>
</ul>
<h3>Manipulação de arraylist<h3>
<ul>
    <li>Desafio: Se localizou especificamente no metodo criarPasseio</li>
    <li>Solução: Reorganizar a lógica de forma manual(papel e caneta), com o objetivo de compreender como são utilizadas as classes que se ligam a ele. </li>

</ul>



<h3>Fontes de Consulta/Ajuda</h3>

    Documentação Oficial do Java: Para métodos e estruturas básicas da linguagem.
    https://docs.oracle.com/javase/
    W3Schools Java: Para exemplos e referência rápida de sintaxe.
    https://www.w3schools.com/java/
    Stack Overflow: Soluções para dúvidas específicas durante a implementação.
    https://stackoverflow.com/
    Materiais didáticos da disciplina: Exemplos e exercícios fornecidos pela Profª Eduarda Monteiro.

<h2>Autores</h2>

Nome: André Luiz Goi Quatrin 

Número de Matrícula: 24201023-9

Nome: Gabriel Maxwell

Número de Matrícula: 24108579-4

Nome: Henrique Isoppo

Número de Matrícula: 22111228-7
