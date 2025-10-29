package co.edu.uniquindio.poo.patronstate.Model.Estado;

import co.edu.uniquindio.poo.patronstate.Model.Pedido;

public class EstadoNuevo  extends EstadoPedido{

    public EstadoNuevo(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void pagar() {
        System.out.println("✅ Pedido pagado.");
        pedido.cambiarEstado(new EstadoPagado(pedido));
    }

    @Override
    public void enviar() {
        System.out.println("❌ No se puede enviar, aún no está pagado.");
    }

    @Override
    public void entregar() {
        System.out.println("❌ No se puede entregar, aún no está pagado.");
    }

    @Override
    public void cancelar() {
        System.out.println("🛑 Pedido cancelado.");
        pedido.cambiarEstado(new EstadoCancelado(pedido));
    }

    @Override
    public void ejecutarAccion(String accion) {
        switch (accion.toLowerCase()) {
            case "pagar":
                pagar();
                break;
            case "enviar":
                enviar();
                break;
            case "entregar":
                entregar();
                break;
            case "cancelar":
                cancelar();
                break;
            default:
                System.out.println("⚠️ Acción no válida: " + accion);
        }
    }

}
