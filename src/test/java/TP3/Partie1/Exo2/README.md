# Exercice 2 : Interaction avec une Base de Données avec des Mocks

## Description
Cet exercice teste la création d'une commande à travers l'interaction entre `OrderController`, `OrderService` et `OrderDao`.

## Explications

### Mocks en cascade
Dans le premier test, on mocke `OrderService` pour tester `OrderController`. Dans le second, on utilise un `OrderService` réel avec un `OrderDao` mocké pour tester l’interaction entre `OrderService` et `OrderDao`.

### Vérifications
On utilise `verify()` pour s’assurer que les méthodes sont appelées avec les bons arguments.