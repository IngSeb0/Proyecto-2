package modelo.ventas;

public class MetodoPago {
    // Enumeración para los diferentes tipos de método de pago
    public enum Tipo {
        TARJETA_CREDITO,
        EFECTIVO,
        TRANSFERENCIA_BANCARIA
    }

    private Tipo tipo;

    // Constructor que recibe el tipo de método de pago
    public MetodoPago(Tipo tipo) {
        this.tipo = tipo;
    }

    // Método para obtener el tipo de método de pago
    public Tipo getTipo() {
        return tipo;
    }

    // Método para establecer el tipo de método de pago
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    // Método para procesar el pago (simulación)
    public void procesarPago(double monto) {
        switch (tipo) {
            case TARJETA_CREDITO:
                System.out.println("Procesando pago con tarjeta de crédito por $" + monto);
                // Lógica para procesar el pago con tarjeta de crédito
                break;
            case EFECTIVO:
        }
    }
}
