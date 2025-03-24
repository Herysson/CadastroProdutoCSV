
# Cadastro de Produto com Interface Gráfica (Java + CSV)

Este projeto é um exemplo didático utilizado na disciplina de **Projeto de Software**, com o objetivo de demonstrar a interação entre o **Diagrama de Classes** e o **Diagrama de Sequência**.

A funcionalidade implementada é o **Cadastro de Produtos**, onde os dados são inseridos por meio de uma **interface gráfica (Swing)** e armazenados em um arquivo **CSV**.

---

## ✨ Funcionalidade Principal

- Cadastro de produto com os campos:
  - Nome
  - Preço
  - Quantidade
- Armazenamento dos dados em arquivo CSV
- Interface simples com Java Swing

---

## 🧱 Estrutura do Projeto

- `Produto`: classe modelo que representa o produto
- `ProdutoRepository`: responsável por salvar e carregar os dados do arquivo CSV
- `ProdutoForm`: interface gráfica para entrada dos dados

> 💡 Opcionalmente, pode-se adicionar uma camada de serviço (`ProdutoService`) para centralizar regras de negócio.

---

## 📘 Diagrama de Classes

<!-- Substitua o link abaixo com a imagem do seu diagrama de classes -->
### Astah

![C - Cadastro de Produto](https://github.com/user-attachments/assets/77ddad27-aee2-4f98-b3a3-3528bd820579)

---

### PlantUML

![image](https://github.com/user-attachments/assets/e2b13764-f51f-48b6-8bcb-5e8176e3a898)

---

#### PlantUML – code

```plantuml
@startuml
title Diagrama de Classes - Cadastro de Produto

class Produto {
    - nome: String
    - preco: double
    - quantidade: int
    --
    + Produto(nome: String, preco: double, quantidade: int)
    + getNome(): String
    + setNome(nome: String): void
    + getPreco(): double
    + setPreco(preco: double): void
    + getQuantidade(): int
    + setQuantidade(qtd: int): void
}

class ProdutoRepository {
    - FILE_NAME: String = "produtos.csv"
    --
    + salvar(produto: Produto): void
    + carregarTodos(): List<Produto>
}

class ProdutoForm {
    - nomeField: JTextField
    - precoField: JTextField
    - quantidadeField: JTextField
    - cadastrarButton: JButton
    - repository: ProdutoRepository
    --
    + ProdutoForm()
    - limparCampos(): void
}

ProdutoForm --> ProdutoRepository : usa
ProdutoRepository --> Produto : manipula
@enduml
```

---

## 🔄 Diagrama de Sequência

<!-- Substitua o link abaixo com a imagem do seu diagrama de sequência -->
### Astah

![DS - Cadastro de Produto](https://github.com/user-attachments/assets/4cd7a905-574e-483d-85d8-ca076026c51f)

---

### PlantUML

![image](https://github.com/user-attachments/assets/687dad68-2687-40fd-a1ac-9112088cc1a1)

---

#### PlantUML – code

```plantuml
@startuml
title Diagrama de Sequência - Cadastro de Produto

actor Usuario

boundary ProdutoForm
control ProdutoRepository
entity Produto

== Início do Cadastro ==

Usuario -> ProdutoForm : preencherCampos()
Usuario -> ProdutoForm : clicarEmCadastrar()

ProdutoForm -> Produto : new Produto(nome, preco, quantidade)

ProdutoForm -> ProdutoRepository : salvar(produto)

ProdutoRepository -> "Arquivo CSV" : escreverLinha(produto)

ProdutoRepository --> ProdutoForm : retorno (void)

ProdutoForm -> Usuario : mostrarMensagem("Produto cadastrado com sucesso!")

@enduml
```

---

## ▶️ Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/cadastro-produto-java.git
   ```
2. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```
3. Execute a interface gráfica:
   ```bash
   java ProdutoForm
   ```

---

## 🧠 Objetivos Didáticos

- Compreender o uso prático de diagramas UML (classes e sequência)
- Aplicar a arquitetura orientada a objetos
- Trabalhar com persistência de dados simples (CSV)
- Desenvolver interfaces gráficas com Swing

---

## 📂 Organização dos Arquivos

```
├── Produto.java
├── ProdutoRepository.java
├── ProdutoForm.java
├── produtos.csv
└── docs
    ├── diagrama-classes.png
    └── diagrama-sequencia.png
```

---

## 📄 Licença

Este projeto está licenciado sob os termos da licença MIT.  
Consulte o arquivo [LICENSE](LICENSE) para mais informações.

---

## 📸 Créditos

Professor Herysson – Projeto de Software  
Universidade Franciscana – Curso de Ciência da Computação

