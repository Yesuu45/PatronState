package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoEntregado extends EstadoPedido{
    public EstadoEntregado( Pedido pedido){
        super(pedido);
    }

    @Override
    public void pagar() {
        System.out.println("❌ El pedido ya fue entregado y pagado.");
    }

    @Override
    public void enviar() {
        System.out.println("❌ Ya fue entregado.");
    }

    @Override
    public void entregar() {
        System.out.println("El pedido fue entregado correctamente a su destino.");
        pedido.cambiarEstado(new EstadoEntregado(pedido));
    }

    @Override
    public void cancelar() {
        System.out.println("❌ No se puede cancelar un pedido ya entregado.");
    }

    @Override
    public String toString() {
        return "ENTREGADO";
    }

}
