package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoEnviado implements EstadoPedido {

    protected Pedido pedido;

    public EstadoEnviado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pagar() {
        throw new IllegalStateException("❌ El pedido ya fue pagado.");
    }

    @Override
    public void enviar() {
        throw new IllegalStateException("❌ El pedido ya fue enviado.");
    }

    @Override
    public void entregar() {
        System.out.println("📬 Pedido entregado al cliente.");
        pedido.cambiarEstado(new EstadoEntregado(pedido));
    }

    @Override
    public void cancelar() {
        throw new IllegalStateException("❌ No se puede cancelar, ya está en camino.");
    }

    @Override
    public void nuevo() {
        System.out.println("📌 El pedido ya fue enviado, no puede volver a NUEVO.");
    }

    @Override
    public String toString() {
        return "ENVIADO";
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
