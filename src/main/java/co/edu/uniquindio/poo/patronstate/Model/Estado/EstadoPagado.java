package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoPagado implements EstadoPedido {

    protected Pedido pedido;

    public EstadoPagado(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public void pagar() {
        throw new IllegalStateException("❌ El pedido ya está pagado.");
    }

    @Override
    public void enviar() {
        System.out.println("📦 Pedido enviado correctamente.");
        pedido.cambiarEstado(new EstadoEnviado(pedido));
    }

    @Override
    public void entregar() {
        throw new IllegalStateException("❌ No se puede entregar sin haber sido enviado.");
    }

    @Override
    public void cancelar() {
        System.out.println("🛑 Pedido cancelado con reembolso.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }

    @Override
    public void nuevo() {
        System.out.println("📌 El pedido ya fue pagado, no puede volver a NUEVO.");
    }

    @Override
    public String toString() {
        return "PAGADO";
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
