# TP1 – Exercice 5 : RomanNumeral

## 🐞 Bug détecté :
Dans la boucle :
```java
for (int i = 0; i <= symbols.length; i++)
```


## ✅ Correction apportée :
```java
for (int i = 0; i < symbols.length; i++) {
        while (n >= values[i]) {
        sb.append(symbols[i]);
n -= values[i];
        }
        }

```

## 📌 Remarque :
Des tests spécifiques ont été écrits pour chaque critère de couverture :

Pour les lignes : vérification des conversions simples, valeurs limites.

Pour les branches : vérification des différents chemins (if, while), répétition de symboles.

Pour les conditions : chaque condition booléenne (n < 1 || n > 3999) est évaluée à vrai et à faux.

👉 Tous les tests atteignent 100% de couverture dans leurs catégories respectives.