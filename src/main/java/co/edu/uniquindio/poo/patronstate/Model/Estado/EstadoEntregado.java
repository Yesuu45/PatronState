package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoEntregado implements EstadoPedido {

    protected Pedido pedido;

    public EstadoEntregado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pagar() {
        throw new IllegalStateException("❌ El pedido ya fue entregado y pagado.");
    }

    @Override
    public void enviar() {
        throw new IllegalStateException("❌ El pedido ya fue entregado.");
    }

    @Override
    public void entregar() {
        throw new IllegalStateException("❌ El pedido ya fue entregado anteriormente.");
    }

    @Override
    public void cancelar() {
        throw new IllegalStateException("❌ No se puede cancelar un pedido ya entregado.");
    }

    @Override
    public void nuevo() {
        System.out.println("📌 El pedido ya fue entregado, no puede volver a NUEVO.");
    }

    @Override
    public String toString() {
        return "ENTREGADO";
    }

    @Override
    public void ejecutarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "pagar" -> pagar();
            case "enviar" -> enviar();
            case "entregar" -> entregar();
            case "cancelar" -> cancelar();
            case "nuevo" -> nuevo();
            default -> throw new IllegalArgumentException("⚠️ Acción no válida: " + accion);
        }
    }
}
