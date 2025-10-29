package co.edu.uniquindio.poo.patronstate.Controller;
import co.edu.uniquindio.poo.patronstate.Model.HistorialPedido;
import co.edu.uniquindio.poo.patronstate.Model.Pedido;

import java.io.IOException;
import java.util.List;

public class GestorEstadosController {
    private Pedido pedido; // Pedido actualmente seleccionado

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Pedido> obtenerPedidos() {
        return HistorialPedido.getInstance().obtenerPedidos();
    }

    public void cambiarEstado(String accion) throws IOException {
        if (pedido != null) {
            pedido.procesar(accion);
        } else {
            System.out.println("⚠️ No hay un pedido seleccionado.");
        }
    }
}







