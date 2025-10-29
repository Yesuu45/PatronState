package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoCancelado extends EstadoPedido {

    public EstadoCancelado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void pagar() {
        System.out.println("❌ El pedido está cancelado. No se puede pagar.");
    }

    @Override
    public void enviar() {
        System.out.println("❌ El pedido está cancelado. No se puede enviar.");
    }

    @Override
    public void entregar() {
        System.out.println("❌ El pedido está cancelado. No se puede entregar.");
    }

    @Override
    public void cancelar() {
        System.out.println("🛑 El pedido ya está cancelado.");
    }

    @Override
    public String toString() {
        return "CANCELADO";
    }
}
