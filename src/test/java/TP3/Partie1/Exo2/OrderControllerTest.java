package TP3.Partie1.Exo2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class OrderControllerTest {

    @Test
    void testCreateOrder() {
        // Créer les mocks
        OrderService orderServiceMock = Mockito.mock(OrderService.class);
        OrderDao orderDaoMock = Mockito.mock(OrderDao.class);
        OrderController orderController = new OrderController(orderServiceMock);

        // Créer une commande
        Order order = new Order("123", 99.99);

        // Appeler la méthode à tester
        orderController.createOrder(order);

        // Vérifications
        verify(orderServiceMock).createOrder(order); // Vérifie que createOrder est appelé avec la bonne commande
    }

    @Test
    void testOrderServiceAndDaoInteraction() {
        // Créer les mocks
        OrderDao orderDaoMock = Mockito.mock(OrderDao.class);
        OrderService orderService = new OrderService(orderDaoMock);

        // Créer une commande
        Order order = new Order("123", 99.99);

        // Appeler la méthode à tester
        orderService.createOrder(order);

        // Vérifications
        verify(orderDaoMock).saveOrder(order); // Vérifie que saveOrder est appelé avec la bonne commande
    }
}
