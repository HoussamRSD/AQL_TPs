# Exercice 1 : Interaction Simple entre Modules

## Description
Cet exercice teste l'interaction entre `UserService` et `UserRepository` pour récupérer un utilisateur par son ID.

## Explications

### Mocking
`UserRepository` est mocké avec `Mockito.mock()`. On simule son comportement avec `when(...).thenReturn(...)`.

### Vérification
`verify()` s’assure que `findUserById` est appelé avec le bon `userId`.

### Assertions
On vérifie que l’utilisateur retourné par `getUserById` correspond à celui configuré dans le mock.