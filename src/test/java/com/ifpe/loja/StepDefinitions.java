package com.ifpe.loja;

import static org.junit.jupiter.api.Assertions.*;

import io.cucumber.java.en.*;
import io.cucumber.java.Before;

public class CalculaFreteTest {

    private boolean isCidadeSede;
    private boolean isMesmoEstadoSede;
    private double valorDaCompra;
    private boolean resultado;
    private Exception exception;

    @Before
    public void setUp() {
        this.exception = null;
    }

    @Given("a cidade sede")
    public void aCidadeSede() {
        this.isCidadeSede = true;
    }

    @Given("a não cidade sede")
    public void aNaoCidadeSede() {
        this.isCidadeSede = false;
    }

    @Given("a mesma estado sede")
    public void aMesmoEstadoSede() {
        this.isMesmoEstadoSede = true;
    }

    @Given("a diferente estado sede")
    public void aDiferenteEstadoSede() {
        this.isMesmoEstadoSede = false;
    }

    @Given("o valor da compra é {double}")
    public void oValorDaCompraEDouble(double valor) {
        this.valorDaCompra = valor;
    }

    @When("calcular frete")
    public void calcularFrete() {
        try {
            this.resultado = CalculaFrete.devePagarFrete(this.isCidadeSede, this.isMesmoEstadoSede, this.valorDaCompra);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Then("o resultado deve ser {boolean}")
    public void oResultadoDeveSer(boolean expectedResult) {
        assertEquals(expectedResult, this.resultado);
    }

    @Then("uma exceção deve ser lançada com a mensagem {string}")
    public void umaExcecaoDeveSerLancadaComAMensagem(String mensagem) {
        assertNotNull(this.exception);
        assertEquals(mensagem, this.exception.getMessage());
    }
}
