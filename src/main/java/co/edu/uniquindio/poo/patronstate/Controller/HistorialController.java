package co.edu.uniquindio.poo.patronstate.Controller;

import co.edu.uniquindio.poo.patronstate.Model.ExportarArchivo;
import co.edu.uniquindio.poo.patronstate.Model.HistorialPedido;
import co.edu.uniquindio.poo.patronstate.Model.Pedido;

import java.io.IOException;
import java.util.List;

public class HistorialController {
    private HistorialPedido historial;

    public HistorialController() {
        historial = HistorialPedido.getInstance();
    }

    public List<Pedido> obtenerPedidos() {
        return historial.obtenerPedidos();
    }

    public void registrarPedido(Pedido pedido) {
        historial.registrarPedido(pedido);
    }

    public void exportarPedido(Pedido pedido, String rutaArchivoTxt) throws IOException {
        ExportarArchivo.exportarPedido(pedido, rutaArchivoTxt);
    }
}
