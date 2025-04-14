# TP1 – Exercice 3 : BinarySearch


## 🐞 Bug détecté :
La condition de la boucle était incorrecte :
```java
while (low < high)
```


## ✅ Correction apportée :
```java
while (low <= high)
```


## 📌 Remarque :
Les jeux de tests sont différents pour chaque type de couverture, car :

La couverture des branches nécessite de forcer l’évaluation de chaque cas (==, <, >)

La couverture des conditions implique d’évaluer séparément chaque condition logique (nullité, comparaisons)

La couverture des lignes s’obtient avec des cas simples (élément trouvé, non trouvé, tableau nul)

👉 Grâce à des jeux de tests ciblés, chaque critère atteint 100% de couverture.