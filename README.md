# Exchange de Criptomoedas

Projeto acadêmico em Java Swing, PostgreSQL/JDBC e arquitetura MVC.

## Funcionalidades implementadas

- Login do investidor com CPF de 11 dígitos e senha numérica de 6 dígitos.
- Consulta de saldo em reais, Bitcoin, Ethereum e Ripple, protegida por senha.
- Depósito e saque em reais, com validação para impedir valores inválidos e saldo negativo.
- Compra e venda de Bitcoin, Ethereum e Ripple, com as taxas exigidas no enunciado.
- Extrato persistido de depósitos, saques, compras e vendas.
- Atualização aleatória das cotações, com variação entre -5% e +5% sobre a cotação anterior.
- Persistência das cotações entre execuções do programa.
- Persistência dos saldos e do extrato no PostgreSQL.

## Tecnologias

- Java 21
- Swing (os formulários `Login.form` e `Menu.form` foram preservados para edição no GUI Builder do NetBeans)
- JDBC PostgreSQL
- Maven
- MVC: `model`, `view`, `controller` e `dao`

## Banco de dados

1. Crie um banco PostgreSQL chamado `moeda`.
2. Abra o arquivo `Projeto/sql/banco.sql` no pgAdmin ou no `psql` e execute o script dentro do banco `moeda`.
3. O script cria as tabelas `usuario`, `dados` e `cotacao`. Ele não apaga os registros que já existirem.
4. O script cadastra um investidor de demonstração, apenas se o CPF ainda não estiver cadastrado:

   - CPF: `12345678900`
   - Senha: `123456`

A tabela `usuario` e a tabela `dados` seguem os nomes das colunas do SQL enviado. A tabela `cotacao` é adicional e necessária para salvar os preços entre execuções.

## Configuração da conexão

Por padrão, a aplicação tenta conectar usando:

- URL: `jdbc:postgresql://localhost:5432/moeda`
- Usuário: `postgres`
- Senha: `admin`

A senha `admin` é apenas o valor padrão usado pelo projeto anterior. Altere para a senha configurada no seu PostgreSQL. É possível configurar sem editar o código:

**Variáveis de ambiente**

- `EXCHANGE_DB_URL`
- `EXCHANGE_DB_USER`
- `EXCHANGE_DB_PASSWORD`

Ou propriedades Java:

```text
-Dexchange.db.url=jdbc:postgresql://localhost:5432/moeda
-Dexchange.db.user=postgres
-Dexchange.db.password=sua_senha
```

## Abrir no NetBeans

1. Extraia o ZIP.
2. No NetBeans, selecione **File > Open Project** e abra a pasta `Projeto` (a pasta que contém `pom.xml`).
3. Aguarde o Maven baixar a dependência JDBC do PostgreSQL.
4. Confira a conexão e execute a classe `com.mycompany.projeto.Projeto`.
5. Para editar as telas visualmente, abra `Login.java` ou `Menu.java` e selecione a aba **Design**. Os arquivos `.form` correspondentes estão junto dos arquivos `.java`.

## Compilar e gerar o executável JAR

Com Java 21 e Maven instalados, dentro da pasta `Projeto` execute:

```bash
mvn clean package
```

O JAR com a dependência PostgreSQL incluída será gerado em:

```text
Projeto/target/ExchangeCriptomoedas.jar
```

Para executar:

```bash
java -jar target/ExchangeCriptomoedas.jar
```

## Gerar Javadoc

Dentro da pasta `Projeto`:

```bash
mvn javadoc:javadoc
```

A documentação ficará em `Projeto/target/site/apidocs/`.

## Organização do código

```text
Projeto/
├── pom.xml
├── sql/
│   └── banco.sql
└── src/main/java/
    ├── com/mycompany/projeto/Projeto.java
    ├── controller/
    │   ├── LoginController.java
    │   └── MenuController.java
    ├── dao/
    │   ├── Conexao.java
    │   ├── InvestidorDAO.java
    │   ├── OperacaoDAO.java
    │   └── CotacaoDAO.java
    ├── model/
    │   ├── Pessoa.java
    │   ├── Investidor.java
    │   ├── Carteira.java
    │   ├── Moedas.java
    │   ├── Real.java
    │   ├── Bitcoin.java
    │   ├── Ethereum.java
    │   ├── Ripple.java
    │   ├── Tarifacao.java
    │   └── Operacao.java
    └── view/
        ├── Login.java
        ├── Login.form
        ├── Menu.java
        └── Menu.form
```

## Regras de cálculo

- Compra: o valor digitado representa o total debitado da carteira em reais. A taxa é calculada sobre esse total e o restante é convertido em criptomoeda.
- Venda: a quantidade digitada é convertida pelo preço atual; a taxa de venda é descontada do valor bruto e o valor líquido é creditado em reais.
- Dinheiro é arredondado para duas casas decimais e saldos de criptomoedas para oito casas.

## Observação sobre o escopo

O código recebido contém apenas o fluxo do investidor. Por isso, esta versão implementa o projeto individual do investidor. O módulo administrativo adicional exigido no PDF para projetos em dupla (cadastro/exclusão de investidores e consultas administrativas) não foi incluído, pois não havia telas nem código administrativo no material-fonte enviado.
