/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplomock;

import java.util.ArrayList;

/**
 *
 * @author oscarquinteros
 */
class Pedido {
    private ArrayList productos = new ArrayList();
    void addProducto(Producto producto) {
        productos.add(producto);
    }
    public int cantidadProductos(){
        return productos.size();
    }
    
}
