package co.edu.uniquindio.poo.patronstate.Model;

import co.edu.uniquindio.poo.patronstate.Model.Estado.EstadoNuevo;
import co.edu.uniquindio.poo.patronstate.Model.Estado.EstadoPedido;

public class Pedido {
    private String id;
    private CarritoDeCompras carrito;
    private EstadoPedido estado;

    public Pedido(String id, CarritoDeCompras carrito) {
        this.id = id;
        this.carrito = carrito;
        this.estado = new EstadoNuevo(this);
    }

    public String getId() {
        return id;
    }
    public CarritoDeCompras getCarrito() {
        return carrito;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public double calcularTotal() {
        return carrito.calcularTotal();
    }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public boolean procesar(String accion) {
        try {
            estado.ejecutarAccion(accion);
            return true; // ✅ Si la acción se ejecutó sin errores
        } catch (IllegalStateException e) {
            System.out.println("🚫 No se puede realizar la acción: " + e.getMessage());
            return false; // ❌ Acción inválida para el estado actual
        }
    }








}
