package TP3.Partie1.Exo3;

public class ProductService {
    private final ProductApiClient apiClient;

    public ProductService(ProductApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Product getProduct(String productId) throws ApiException {
        return apiClient.getProduct(productId);
    }
}
