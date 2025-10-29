package co.edu.uniquindio.poo.patronstate.Model;

public class Pasarela implements Pago {
    private PasarelaAPI api;
    private String nombreServicio;

    public Pasarela(String nombreServicio) {
        this.api = new PasarelaAPI();
        this.nombreServicio = nombreServicio;
    }

    @Override
    public String procesarPago(double monto) {
        return api.realizarTransaccion(nombreServicio, monto);
    }

}
