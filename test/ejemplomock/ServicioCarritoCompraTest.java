package ejemplomock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author oscarquinteros
 */
public class ServicioCarritoCompraTest {

    public ServicioCarritoCompraTest() {
    }

    @Test
    public void confirmarEnvioPedidoTest() {
        // Escenario de prueba
        ServicioCarritoCompra carrito = new ServicioCarritoCompra();
        ServicioEnvioComunicacion servicioEnvioMock = mock(ServicioEnvioComunicacion.class);
        Pedido pedido = new Pedido();

        //declaracion de dependencia entre el SUT y su colaborador
        carrito.servicioEnvio = servicioEnvioMock;

        // invocacion del metodo a testear del SUT
        carrito.confirmarPedido(pedido);

        // comprobacion de resultados y/o comportamientos
        verify(servicioEnvioMock).enviarPedido(pedido);

    }

    @Test
    public void agregarProductoAPedidoTest() {

        // Escenario de prueba
        ServicioCarritoCompra carrito = new ServicioCarritoCompra();
        ServicioStock servicioStockMock = mock(ServicioStock.class);
        Pedido pedido = new Pedido();
        Producto producto = new Producto();

        //declaracion de dependencia entre el SUT y su colaborador
        carrito.servicioStock = servicioStockMock;

        // comportamiento esperado en invocacion
        when(servicioStockMock.existeProducto(producto)).thenReturn(new Boolean(true));

        // invocacion del metodo a testear del SUT
        carrito.agregarProductoAPedido(producto, pedido);

        // comprobacion de resultados y/o comportamientos
        verify(servicioStockMock).existeProducto(producto);
        assertEquals(pedido.cantidadProductos(), 1);

    }
}
