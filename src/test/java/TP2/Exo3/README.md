# TP2 – Exercice 3 : Mocker un service externe avec différents scénarios

## 🎯 Objectif :
Tester des cas réalistes d’interaction avec un service externe (`UtilisateurApi`) via la classe `UserService`, en simulant différents comportements de l'API avec **Mockito** :
- Exceptions
- Appels non effectués
- Captures d’arguments
- Vérification de l’état

---

## 🧪 Scénarios testés :

### ✅ 1. Exception lors de la création de l’utilisateur
- Simule une erreur côté API.
- Utilise `doThrow(new ServiceException(...)).when(...)`
- Vérifie que l’exception est bien levée par `userService`.

### ✅ 2. Erreur de validation côté client
- Le test vérifie que **l’API n’est pas appelée du tout**.
- Utilise `verify(..., never()).creerUtilisateur(...)`
- C’est un **test d’interaction négative**.

### ✅ 3. Retour d’un ID utilisateur depuis l’API
- Simule le comportement où `UtilisateurApi` retourne un ID.
- L’objet `Utilisateur` est mis à jour avec un identifiant.
- Test d’**état** : `assertEquals(123, utilisateur.getId())`

### ✅ 4. Capture d’arguments transmis à l’API
- Utilise `ArgumentCaptor<Utilisateur>` pour vérifier que les bonnes données ont été envoyées.
- Permet de tester les **valeurs précises** passées à la méthode `creerUtilisateur(...)`.

---

## 🧠 Résumé des types de tests utilisés :

| Scénario                             | Type de test      | Technique utilisée                        |
|-------------------------------------|-------------------|-------------------------------------------|
| Exception API                       | Test d’état       | `assertThrows(...)`                       |
| Erreur de validation                | Test d’interaction| `verify(..., never())`                    |
| ID utilisateur retourné             | Test d’état       | `assertEquals(..., utilisateur.getId())`  |
| Vérification des valeurs transmises | Test d’interaction| `ArgumentCaptor`, `getValue()`, `getters` |

---

## ⚠️ Remarques :
- Pour le scénario 3, la classe `Utilisateur` doit avoir une méthode `setId(int)` et `getId()`.
- La méthode `creerUtilisateur()` dans `UtilisateurApi` devra être adaptée pour retourner un `int` dans ce scénario.

---

## 📁 Fichiers associés :
- `UserService.java` : classe testée
- `UtilisateurApi.java` : interface mockée
- `Utilisateur.java` : classe métier (avec champ `id`)
- `UserServiceTest.java` : tests complets pour les 4 scénarios
