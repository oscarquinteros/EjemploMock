package ejemplomock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscarquinteros
 */
public class ServicioCarritoCompra {
    public ServicioEnvioComunicacion servicioEnvio;
    public ServicioStock servicioStock;
    
    public void confirmarPedido(Pedido pedido){
        servicioEnvio.enviarPedido(pedido);
    }
    public void agregarProductoAPedido(Producto producto,Pedido pedido){
        if (servicioStock.existeProducto(producto)){
            pedido.addProducto(producto);
        }
    }    
}
