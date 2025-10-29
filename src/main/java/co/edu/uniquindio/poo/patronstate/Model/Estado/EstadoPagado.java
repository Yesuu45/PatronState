package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoPagado extends EstadoPedido {
    public EstadoPagado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void pagar() {
        System.out.println("❌ El pedido ya está pagado.");
    }

    @Override
    public void enviar() {
        System.out.println("📦 El pedido fue pagado correctamente en empaquetado.");
        pedido.cambiarEstado(new EstadoEnviado(pedido));

    }

    @Override
    public void entregar() {
        System.out.println("❌ No se puede entregar sin enviar antes.");


    }

    @Override
    public void cancelar() {
        System.out.println("🛑 Pedido cancelado con reembolso.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));

    }

    @Override
    public String toString() {
        return "PAGADO";
    }

}
