# Exercice 3 : Intégration d'API avec Mocking

## Description
Cet exercice teste `ProductService` qui récupère des données via une API simulée par `ProductApiClient`.

## Explications

### Scénarios testés
- **Succès** : Le mock retourne un produit valide.
- **Échec API** : Le mock lève une `ApiException` pour simuler une indisponibilité.
- **Format invalide** : Le mock lève une `ApiException` pour simuler un problème de format.

### Vérifications
`verify()` s’assure que `getProduct` est appelé avec le bon `productId`. Les assertions vérifient les résultats ou les exceptions attendues.