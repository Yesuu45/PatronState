package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoEnviado extends EstadoPedido{
    public EstadoEnviado (Pedido pedido){
        super(pedido);
    }

    @Override
    public void pagar() {
        System.out.println("❌ Ya fue pagado.");


    }

    @Override
    public void enviar() {
        System.out.println("❌ Ya fue enviado.");


    }

    @Override
    public void entregar() {
        System.out.println("📬 pedido enviado al cliente .");
        pedido.cambiarEstado(new EstadoEntregado(pedido));
    }



    @Override
    public void cancelar() {
        System.out.println("❌ No se puede cancelar, ya está en camino.");

    }

    @Override
    public String toString() {
        return "ENVIADO";
    }
}
