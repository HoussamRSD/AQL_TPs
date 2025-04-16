# TP2 – Exercice 4 : Jeu de dés (Jeu du 7)

## 🎯 Objectif :
Tester de manière unitaire la méthode `jouer(Joueur joueur, De de1, De de2)` de la classe `Jeu`, en simulant tous les cas de figure via des mocks.

---

## ✅ 1. Objets à mocker :
- **`Joueur`**, **`Banque`** et **`De`** doivent être mockés.
- Cela permet d’isoler la logique de la méthode `jouer` sans dépendre des implémentations concrètes.

---

## ✅ 2. Scénarios à tester (classes d’équivalence) :

| Scénario                                 | Résultat attendu                                           | Type de test         |
|------------------------------------------|-------------------------------------------------------------|-----------------------|
| Jeu fermé                                | Exception `JeuFermeException` levée                         | Test d’état           |
| Joueur insolvable                        | Aucun lancer de dé, aucune interaction avec la banque       | Test d’interaction    |
| Le joueur perd (somme ≠ 7)               | La banque garde la mise                                     | Test d’interaction    |
| Le joueur gagne (somme = 7)              | Le joueur reçoit 2× mise, la banque débite                 | Test d’interaction + état |
| La banque devient insolvable après gain  | Le jeu se ferme                                             | Test d’état           |
| Test semi-intégré avec vraie banque      | Comportement réel sans mocks                                | Test d’intégration léger |

---
## ✅ 3. Écrire le code Java pour Jeu:

```java
package TP2.Exo4;

import TP2.Exo4.Interfaces.Banque;
import TP2.Exo4.Interfaces.De;
import TP2.Exo4.Interfaces.Exceptions.DebitImpossibleException;
import TP2.Exo4.Interfaces.Exceptions.JeuFermeException;
import TP2.Exo4.Interfaces.Joueur;

public class Jeu {
  private boolean ouvert = true;
  private final Banque banque;

  public Jeu(Banque banque) {
    this.banque = banque;
  }

  public void fermer() {
    ouvert = false;
  }

  public boolean estOuvert() {
    return ouvert;
  }

  public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException {
    if (!ouvert) throw new JeuFermeException("Le jeu est fermé");

    int mise = joueur.mise();
    try {
      joueur.debiter(mise);
    } catch (DebitImpossibleException e) {
      return; // joueur insolvable : on ne continue pas
    }

    banque.crediter(mise);

    int somme = de1.lancer() + de2.lancer();
    if (somme == 7) {
      int gain = 2 * mise;
      joueur.crediter(gain);
      banque.debiter(gain);
      if (!banque.est_solvable()) fermer();
    }
  }
}

```

## ✅ 4. Cas du jeu fermé :
- ✅ Une exception `JeuFermeException` est levée.
- ✅ C’est un **test d’état** : on teste que l’état du jeu empêche l’appel.

---

## ✅ 5. Joueur insolvable :
- ✅ On simule une exception `DebitImpossibleException`.
- ✅ On vérifie que les dés **ne sont jamais lancés** avec :
```java
verify(de1, never()).lancer();
verify(de2, never()).lancer();
```
- ✅ C’est un **test d’interaction**, car on vérifie que certaines interactions n’ont pas eu lieu.

---

## ✅ 5. Autres scénarios (continuation) :
- Somme ≠ 7 → perte
- Somme = 7 → gain
- Gain + banque insolvable → le jeu se ferme
- Implémentation réelle de la banque pour tester un comportement plus intégré

---

## ✅ 6. Implémentation concrète de la banque :

```java
package TP2.Exo4;

import TP2.Exo4.Interfaces.Banque;

public class BanqueReelle implements Banque {
    private int fond;
    private final int fondMinimum;

    public BanqueReelle(int fondInitial, int fondMinimum) {
        this.fond = fondInitial;
        this.fondMinimum = fondMinimum;
    }

    @Override
    public void crediter(int somme) {
        fond += somme;
    }

    @Override
    public void debiter(int somme) {
        fond -= somme;
    }

    @Override
    public boolean est_solvable() {
        return fond > fondMinimum;
    }

}

```

---

## ✅ 7. Test réécrit avec implémentation réelle de la banque

### 🎯 Titre : *“Le joueur gagne et rend la banque insolvable (test semi-intégré)”*

```java
@Test
void testGagneEtBanqueInsolvableAvecImplementationReelle() throws Exception {
    BanqueReelle banqueReelle = new BanqueReelle(30, 20); // fond initial 30, min 20
    Jeu jeuReel = new Jeu(banqueReelle);

    Joueur joueurFake = mock(Joueur.class);
    De deFake1 = mock(De.class);
    De deFake2 = mock(De.class);

    when(joueurFake.mise()).thenReturn(10);
    when(deFake1.lancer()).thenReturn(3);
    when(deFake2.lancer()).thenReturn(4); // somme = 7

    jeuReel.jouer(joueurFake, deFake1, deFake2);

    // gain = 20, la banque passe de 30 - 20 = 10 < 20 → plus solvable
    assertFalse(jeuReel.estOuvert());
}
```

### 🧠 Différence entre ce test et celui avec mocks :
- Avec **mocks** : on simule le retour de `banque.est_solvable()` → **test d’interaction unitaire**.
- Avec **implémentation réelle** : on teste **l’enchaînement logique réel** (le fond de la banque baisse), donc c’est un **test semi-intégré**.

---

## 📁 Fichiers associés :
- `Jeu.java` : classe testée
- `BanqueConcrète.java` : version réelle de la banque
- `JeuTest.java` : classe de test complète avec Mockito
- `Joueur.java`, `Banque.java`, `De.java` : interfaces
- `JeuFermeException.java`, `DebitImpossibleException.java` : exceptions personnalisées

