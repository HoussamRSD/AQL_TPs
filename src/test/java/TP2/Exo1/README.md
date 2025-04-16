# TP2 – Exercice 1 : Initiation aux Mocks avec Mockito

## 🎯 Objectif :
Découvrir l'utilisation de **Mockito** pour :
- Simuler le comportement d'une méthode (`additionner`)
- Vérifier les **interactions** avec un objet mocké
- Comprendre la **limite des mocks** concernant le test de l’état interne d’un objet

---

## 🧩 Description :
On souhaite tester la méthode `additionner(int a, int b)` de la classe `Calculatrice`.  
La classe possède également un attribut `result` censé mémoriser le dernier résultat.

Dans ce test, la classe est mockée avec `@Mock` :

```java
@Mock
private Calculatrice calculatrice;
```

---

## 🧪 Type de test : **Test d’interaction**
Le test vérifie que :
- La méthode `additionner(2, 3)` a bien été appelée,
- Elle retourne bien `5` comme valeur (simulée),
- Aucune autre méthode n’a été appelée.

---

## ⚠️ Limite rencontrée : **test d’état impossible**
Le champ `result` de la classe `Calculatrice` n’est **pas mis à jour** lorsque l’objet est mocké.  
Un **mock ne fait pas appel au code réel** de la méthode — il renvoie simplement ce qu'on lui a dit (`thenReturn(...)`).

👉 Cela rend impossible toute vérification de l’état (`result`) via un `getResult()`.

---

## ✅ Solution alternative :
Si on veut tester réellement l'état de l'objet :
- Utiliser une vraie instance de `Calculatrice` :
```java
Calculatrice calculatrice = new Calculatrice();
```
- Ou bien un `@Spy` pour combiner exécution réelle et vérification d’interactions.

---

## 📁 Fichiers associés :
- `Calculatrice.java` : classe métier
- `CalculatriceTest.java` : test Mockito
- Ce `README.md`
