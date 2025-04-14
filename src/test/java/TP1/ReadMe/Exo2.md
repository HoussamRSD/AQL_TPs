# TP1 – Exercice 2 : Anagram

## 🐞 Bug détecté :
Dans la boucle de comparaison des caractères :
```
for (int i = 0; i <= s1.length(); i++) {
```

## ✅ Correction apportée :
```
for (int i = 0; i < s1.length(); i++) {
    count[s1.charAt(i) - 'a']++;
    count[s2.charAt(i) - 'a']--;
}
```

## 📌 Remarque :
Les tests pour les critères de couverture (lignes, branches, conditions) ne sont pas identiques, car chaque critère nécessite des cas spécifiques :

Nullité des chaînes (s1 == null, s2 == null)

Longueurs différentes (s1.length() != s2.length())

Comptes de caractères déséquilibrés (c != 0)

Égalité parfaite des lettres (cas positif)

👉 Les trois jeux de tests permettent chacun d’atteindre 100% de couverture pour leur critère respectif.



