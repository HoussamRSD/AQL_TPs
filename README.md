# TP1 – Exercice 1 : Palindrome



## 📌 Remarque :
Les trois critères de couverture (**lignes**, **branches**, **conditions**) ont chacun nécessité des **tests spécifiques**.  
Même si la couverture atteinte est de 100% pour les trois critères, les tests ne sont **pas exactement les mêmes**.

Chaque fichier `Exo1Test.java` dans :
- `LineCoverageTest/`
- `BranchCoverageTest/`
- `ConditionCoverageTest/`

...contient des cas de test **adaptés à son critère de couverture**.

## 🐞 Bug détecté :
La boucle utilisait `j++` et `i--` au lieu de `i++` et `j--`. Résultat : la condition de palindrome n'était jamais correctement testée, même si la chaîne était valide.

## ✅ Correction apportée :
```java
while (i < j) {
    if (s.charAt(i) != s.charAt(j)) return false;
    i++;
    j--;
}

