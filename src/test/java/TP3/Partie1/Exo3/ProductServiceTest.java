package TP3.Partie1.Exo3;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    @Test
    void testGetProductSuccess() throws ApiException {
        // Créer un mock
        ProductApiClient apiClientMock = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Définir le comportement du mock
        String productId = "P123";
        Product expectedProduct = new Product(productId, "Laptop");
        when(apiClientMock.getProduct(productId)).thenReturn(expectedProduct);

        // Appeler la méthode à tester
        Product actualProduct = productService.getProduct(productId);

        // Vérifications
        assertEquals(expectedProduct, actualProduct, "Le produit retourné doit correspondre à celui attendu");
        verify(apiClientMock).getProduct(productId); // Vérifie que getProduct est appelé avec le bon argument
    }

    @Test
    void testGetProductApiFailure() throws ApiException {
        // Créer un mock
        ProductApiClient apiClientMock = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Définir le comportement du mock pour un échec
        String productId = "P123";
        when(apiClientMock.getProduct(productId)).thenThrow(new ApiException("API indisponible"));

        // Vérifier l'échec
        ApiException exception = assertThrows(ApiException.class, () -> productService.getProduct(productId));
        assertEquals("API indisponible", exception.getMessage());
        verify(apiClientMock).getProduct(productId);
    }

    @Test
    void testGetProductInvalidDataFormat() throws ApiException {
        // Créer un mock
        ProductApiClient apiClientMock = Mockito.mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClientMock);

        // Définir le comportement du mock pour un format invalide
        String productId = "P123";
        when(apiClientMock.getProduct(productId)).thenThrow(new ApiException("Format de données incompatible"));

        // Vérifier l'échec
        ApiException exception = assertThrows(ApiException.class, () -> productService.getProduct(productId));
        assertEquals("Format de données incompatible", exception.getMessage());
        verify(apiClientMock).getProduct(productId);
    }
}
