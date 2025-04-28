package TP3.Partie1.Exo3;

public interface ProductApiClient {
    Product getProduct(String productId) throws ApiException;
}
