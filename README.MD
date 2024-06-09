# Teste Calcula Frete Cucumber

Este projeto é uma aplicação Java que utiliza Cucumber e JUnit para realizar testes automatizados. O objetivo é testar o cálculo de frete baseado em diferentes condições.

* Se a compra for na mesma cidade da sede da loja, o frete é gratis, independente do valor da compra;
* Se a compra for feita em outra cidade, mas que esteja no mesmo estado da sede da loja, o frete será gratis para compras a partir de R$ 200,00;
* Se a compra for feita em outro estado, o frete será cobrado independente do valor;
* Se for informado que a compra foi feita na cidade sede, mas o estado não for da cidade sede, deverá ocorrer um erro de validação, assim como para valores de compras negativo;

## Pré-requisitos

- Java 11
- Maven
- IntelliJ IDEA (opcional)
- Eclipse (opcional)

## Configuração do Projeto

### Maven

O arquivo `pom.xml` está configurado para incluir todas as dependências necessárias para o Cucumber e JUnit.

## Executando os Testes

### No Terminal

Para executar os testes no terminal, use os seguintes comandos:

```sh
./mvnw clean install
./mvnw clean test
```

### No IntelliJ IDEA

1. Abra o projeto no IntelliJ IDEA.
2. Certifique-se de que o SDK está configurado corretamente (`File > Project Structure > Project Settings > Project`).
3. Clique em `maven` do lado esquerdo e em `Reload All Maven Projects` para download das dependências
4. Configure a execução do Cucumber:
   - Clique na raiz do projeto com o botão direito e vá até `Run 'All Features in: test-calcula-frete-cucumber'`

### No Eclipse

1. Abra o projeto no Eclipse.
2. Certifique-se de que o JDK está configurado corretamente (`Window > Preferences > Java > Installed JREs`).
3. Configure a execução do Maven:
   - Clique com o botão direito no projeto e selecione `Run As > Maven build`.
   - No campo `Goals`, insira `clean test`.
   - Clique em `Run`.
4. Configure a execução do Cucumber:
   - Clique com o botão direito no projeto e selecione `Run As > Run Configurations`.
   - Clique em `+` e selecione `JUnit`.
   - Preencha os seguintes campos:
      - **Name**: `Cucumber Test`
      - **Project**: Selecione o seu projeto.
      - **Test Runner**: Selecione `JUnit 5`.
      - **Test class**: `com.ifpe.loja.RunCucumberTest`
   - Clique em `Apply` e depois em `Run`.

## Estrutura dos Testes

### Arquivo `.feature`

Os arquivos `.feature` estão localizados em `src/test/resources/com/ifpe/loja` e definem os cenários de teste.

### Step Definitions

Os arquivos de step definitions estão localizados em `src/test/java/com/ifpe/loja` e implementam os passos dos cenários de teste.

### Classe de Teste

A classe `RunCucumberTest` está localizada em `src/test/java/com/ifpe/loja` e configura a execução dos testes com Cucumber.
