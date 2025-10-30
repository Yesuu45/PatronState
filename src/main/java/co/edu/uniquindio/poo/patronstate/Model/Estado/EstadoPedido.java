package co.edu.uniquindio.poo.patronstate.Model.Estado;

public interface EstadoPedido {
    void pagar();
    void VerificacionPago();
    void Empaquetado();
    void Enviado();
    void Entregado();
    void ejecutarAccion(String accion);
}
