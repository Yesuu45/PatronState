package co.edu.uniquindio.poo.patronstate.ViewController;

import co.edu.uniquindio.poo.patronstate.App;
import co.edu.uniquindio.poo.patronstate.Controller.GestorEstadosController;
import co.edu.uniquindio.poo.patronstate.Model.Pedido;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class EstadoViewController {

    @FXML private Button botonVolver;
    @FXML private Button botonEntregado;
    @FXML private Button botonCancelar;
    @FXML private Button botonEnviado;
    @FXML private Button botonPagar; // 🔹 Nuevo botón

    @FXML private TableView<Pedido> tablaPedidos;
    @FXML private TableColumn<Pedido, String> columnaId;
    @FXML private TableColumn<Pedido, String> columnaEstado;
    @FXML private TableColumn<Pedido, Double> columnaTotal;

    private ObservableList<Pedido> datos;
    private GestorEstadosController gestorEstadosController;

    @FXML
    private void initialize() {
        gestorEstadosController = new GestorEstadosController();

        columnaId.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getId()));
        columnaEstado.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEstado().toString()));
        columnaTotal.setCellValueFactory(param -> new SimpleDoubleProperty(param.getValue().calcularTotal()).asObject());

        datos = FXCollections.observableArrayList(gestorEstadosController.obtenerPedidos());
        tablaPedidos.setItems(datos);
    }

    private Pedido getPedidoSeleccionado() {
        Pedido pedido = tablaPedidos.getSelectionModel().getSelectedItem();
        if (pedido == null) {
            mostrarAlerta("Selecciona un pedido", "Debes elegir un pedido de la tabla.");
        }
        return pedido;
    }

    // 🔹 Nuevo método para procesar el pago
    @FXML
    void estadoPagado() {
        cambiarEstadoPedido("pagar");
    }

    @FXML
    void estadoEnviado() {
        cambiarEstadoPedido("enviar");
    }

    @FXML
    void estadoEntregado() {
        cambiarEstadoPedido("entregar");
    }

    @FXML
    void cancelarPedido() {
        cambiarEstadoPedido("cancelar");
    }

    private void cambiarEstadoPedido(String accion) {
        Pedido pedidoSeleccionado = getPedidoSeleccionado();
        if (pedidoSeleccionado != null) {
            gestorEstadosController.setPedido(pedidoSeleccionado);

            boolean exito = gestorEstadosController.cambiarEstado(accion);

            if (exito) {
                tablaPedidos.refresh();

                String mensaje = switch (accion) {
                    case "pagar" -> "💳 El pedido fue PAGADO correctamente.";
                    case "enviar" -> "📦 El pedido fue marcado como ENVIADO.";
                    case "entregar" -> "🎉 El pedido fue marcado como ENTREGADO.";
                    case "cancelar" -> "❌ El pedido fue CANCELADO.";
                    default -> "✅ Acción realizada correctamente.";
                };

                mostrarInfo("Estado actualizado", mensaje);

            } else {
                mostrarAlerta("Acción inválida",
                        "🚫 No se pudo realizar la acción '" + accion + "' sobre el pedido seleccionado.\n" +
                                "Verifica que el estado actual lo permita.");
            }
        }
    }

    private void mostrarInfo(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    @FXML
    void onVolver() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("mercadolibre.fxml"));
            AnchorPane root = loader.load();
            Stage stage = (Stage) botonVolver.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String msg) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
