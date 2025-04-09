package TP0;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testInitialBalance() {
        BankAccount account = new BankAccount(1000.0, 0.05);
        assertEquals(1000.0, account.getBalance());
    }

    // ✅ Classe valide : Dépôt positif
    @Test
    void testDepositPositiveAmount() {
        BankAccount account = new BankAccount(500.0, 0.03);
        account.deposit(200.0);
        assertEquals(700.0, account.getBalance());
    }

    // ❌ Classe invalide : Dépôt négatif
    @Test
    void testDepositNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(500.0, 0.03);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
    }

    // ✅ Classe valide : Retrait possible
    @Test
    void testWithdrawValidAmount() {
        BankAccount account = new BankAccount(400.0, 0.02);
        account.withdraw(100.0);
        assertEquals(300.0, account.getBalance());
    }

    // ❌ Classe invalide : Retrait > solde
    @Test
    void testWithdrawMoreThanBalanceThrowsException() {
        BankAccount account = new BankAccount(200.0, 0.02);
        assertThrows(IllegalStateException.class, () -> account.withdraw(300.0));
    }

    // ❌ Classe invalide : Retrait négatif
    @Test
    void testWithdrawNegativeAmountThrowsException() {
        BankAccount account = new BankAccount(200.0, 0.02);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50.0));
    }

    // ✅ Transfert valide
    @Test
    void testTransferValidAmount() {
        BankAccount sender = new BankAccount(500.0, 0.01);
        BankAccount receiver = new BankAccount(100.0, 0.01);
        sender.transfer(200.0, receiver);
        assertEquals(300.0, sender.getBalance());
        assertEquals(300.0, receiver.getBalance());
    }

    // ❌ Transfert vers un compte nul
    @Test
    void testTransferToNullThrowsException() {
        BankAccount sender = new BankAccount(500.0, 0.01);
        assertThrows(NullPointerException.class, () -> sender.transfer(100.0, null));
    }

    // ✅ Ajout d’intérêts
    @Test
    void testAddInterest() {
        BankAccount account = new BankAccount(1000.0, 0.05); // 5%
        account.addInterest(); // 1000 * 1.05 = 1050
        assertEquals(1050.0, account.getBalance(), 0.0001); // tolérance pour le float
    }
}

