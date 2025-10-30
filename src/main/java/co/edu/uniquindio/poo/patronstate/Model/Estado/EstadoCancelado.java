package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoCancelado implements EstadoPedido {

    protected Pedido pedido;

    public EstadoCancelado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pagar() {
        throw new IllegalStateException("❌ El pedido está cancelado. No se puede pagar.");
    }

    @Override
    public void enviar() {
        throw new IllegalStateException("❌ El pedido está cancelado. No se puede enviar.");
    }

    @Override
    public void entregar() {
        throw new IllegalStateException("❌ El pedido está cancelado. No se puede entregar.");
    }

    @Override
    public void cancelar() {
        throw new IllegalStateException("❌ El pedido ya está cancelado.");
    }

    @Override
    public void nuevo() {
        System.out.println("📌 El pedido está cancelado, no puede volver a NUEVO.");
    }

    @Override
    public String toString() {
        return "CANCELADO";
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
