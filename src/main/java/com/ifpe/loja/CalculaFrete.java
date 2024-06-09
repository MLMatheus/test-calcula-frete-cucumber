public class CalculaFrete {

    public static boolean devePagarFrete(boolean isCidadeSede, boolean isMesmoEstadoSede, double valorDaCompra) throws Exception {
        if (isCidadeSede && !isMesmoEstadoSede) {
            throw new Exception("Cidade sede tem que está no estado sede");
        } else if (valorDaCompra < 0) {
            throw new Exception("Valor da compra não pode ser negativo");
        }
        if (isCidadeSede) {
            return false;
        } else if (isMesmoEstadoSede && valorDaCompra >= 200) {
            return false;
        }

        return true;
    }
}
