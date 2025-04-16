# TP2 – Exercice 2 : Mocker un service externe (API)

## 🎯 Objectif :
Tester l’interaction entre une classe `UserService` et un service externe `UtilisateurApi` en utilisant **Mockito**.

## 🧩 Description :
La classe `UserService` utilise une instance de l’interface `UtilisateurApi` pour créer des utilisateurs via la méthode `creerUtilisateur(Utilisateur utilisateur)`.

Le but du test est de :
- Vérifier que `UserService.creerUtilisateur(...)` appelle bien la méthode correspondante dans l'API.
- Simuler l’API sans dépendre d’un vrai service réseau.

---

## 🧪 Type de test : **Test d’interaction**
Ce test ne vérifie pas un état final ou une valeur de retour, mais uniquement **si une méthode a été appelée correctement** avec les bons arguments.

---

## ✅ Outils utilisés :
- `@Mock` pour simuler `UtilisateurApi`
- `verify(...)` pour s’assurer que `creerUtilisateur(...)` a été appelée

---

## ✅ Résultat attendu :
- L'appel `utilisateurApi.creerUtilisateur(utilisateur)` doit être effectué une seule fois avec les bons arguments.

---

## ⚠️ Remarque importante :
La méthode `creerUtilisateur` de `UtilisateurApi` est `void`.  
→ On n’utilise pas `when(...).thenReturn(...)` mais uniquement `verify(...)`.

---

## 📁 Fichiers associés :
- `UserService.java` : classe à tester
- `UtilisateurApi.java` : interface externe mockée
- `Utilisateur.java` : classe représentant un utilisateur
- `UserServiceTest.java` : test JUnit 5 avec Mockito
