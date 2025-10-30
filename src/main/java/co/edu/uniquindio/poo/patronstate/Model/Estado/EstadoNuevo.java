package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoNuevo implements EstadoPedido {

    protected Pedido pedido;

    public EstadoNuevo(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pagar() {
        System.out.println("✅ Pedido pagado correctamente.");
        pedido.cambiarEstado(new EstadoPagado(pedido));
    }

    @Override
    public void enviar() {
        throw new IllegalStateException("❌ No se puede enviar un pedido que aún no ha sido pagado.");
    }

    @Override
    public void entregar() {
        throw new IllegalStateException("❌ No se puede entregar un pedido que aún no ha sido pagado.");
    }

    @Override
    public void cancelar() {
        System.out.println("🛑 Pedido cancelado correctamente.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }

    @Override
    public void nuevo() {
        System.out.println("📌 Pedido ya está en estado NUEVO.");
    }

    @Override
    public String toString() {
        return "NUEVO";
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
