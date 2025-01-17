public class Cambio {
    public static double cambioMoneda(Moneda moneda, double valor) {
        return moneda.conversion_rate() * valor;
    }
}
