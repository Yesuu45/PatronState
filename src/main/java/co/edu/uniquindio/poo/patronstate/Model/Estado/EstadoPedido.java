package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public abstract class EstadoPedido {
    public Pedido pedido;

    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void pagar( );
    public abstract void enviar( );
    public abstract void entregar( );
    public abstract void cancelar( );

    public void ejecutarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "pagar" -> pagar();
            case "enviar" -> enviar();
            case "entregar" -> entregar();
            case "cancelar" -> cancelar();
            default -> System.out.println("⚠️ Acción no válida: " + accion);
        }
    }
}
