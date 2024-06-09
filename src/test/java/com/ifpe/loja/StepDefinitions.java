package com.ifpe.loja;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    private boolean isCidadeSede;
    private boolean isMesmoEstadoSede;
    private double valorDaCompra;
    private boolean resultado;
    private Exception exception;

    @Before
    public void setUp() {
        this.isCidadeSede = false;
        this.isMesmoEstadoSede = false;
        this    .valorDaCompra = 0;
        this.resultado = false;
        this.exception = null;
    }

    @Dado("a cidade sede da loja")
    public void aCidadeSedeDaLoja() {
        this.isCidadeSede = true;
    }

    @Dado("uma cidade que não seja a sede da loja")
    public void umaCidadeQueNaoSejaASedeDaLoja() {
        this.isCidadeSede = false;
    }

    @Dado("o mesmo estado da sede")
    public void oMesmoEstadoDaSede() {
        this.isMesmoEstadoSede = true;
    }

    @Dado("um estado diferente da sede")
    public void umEstadoDiferenteDaSede() {
        this.isMesmoEstadoSede = false;
    }

    @Dado("o valor da compra for {double}")
    public void oValorDaCompraFor(double valor) {
        this.valorDaCompra = valor;
    }

    @Quando("for calculado o frete")
    public void forCalculadoOFrete() {
        try {
            this.resultado = CalculaFrete.devePagarFrete(this.isCidadeSede, this.isMesmoEstadoSede, this.valorDaCompra);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Entao("não deve pagar frete")
    public void naoDevePagarFrete() {
        assertFalse(this.resultado);
    }

    @Entao("deve pagar frete")
    public void devePagarFrete() {
        assertTrue(this.resultado);
    }

    @Entao("uma exceção deve ser lançada com a mensagem {string}")
    public void umaExcecaoDeveSerLancadaComAMensagem(String mensagem) {
        assertNotNull(this.exception);
        assertEquals(mensagem, this.exception.getMessage());
    }
}
