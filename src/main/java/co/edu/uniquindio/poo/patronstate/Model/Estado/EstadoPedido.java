package co.edu.uniquindio.poo.patronstate.Model.Estado;

public interface EstadoPedido {
    void pagar();
    void enviar();
    void entregar();
    void cancelar();
    void nuevo();
    void ejecutarAccion(String accion);
}
