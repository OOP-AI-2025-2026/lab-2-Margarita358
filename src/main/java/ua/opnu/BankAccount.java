package ua.opnu;

public class BankAccount {
    public String name;
    public double balance;
    public double transactionFee;

    // Метод для внесення грошей на рахунок
    public void deposit(double amount) {
        if (amount <= 0) return; // ігноруємо негативні та нульові суми
        balance += amount;
    }

    // Метод для отримання поточного балансу
    public double getBalance() {
        return balance;
    }

    // Метод для зняття грошей з рахунку
    public boolean withdraw(double amount) {
        if (amount <= 0) return false; // нічого не робимо для негативних або нульових сум
        if (amount + transactionFee <= balance) {
            balance -= (amount + transactionFee); // знімаємо суму з комісією
            return true; // зняття успішне
        }
        return false; // недостатньо коштів
    }

    // Метод для переказу грошей на інший рахунок
    public boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0) return false; // не дозволяємо переказ нульових або негативних сум
        if (withdraw(amount)) { // пробуємо зняти гроші зі свого рахунку
            receiver.deposit(amount); // додаємо суму на рахунок отримувача
            return true; // переказ успішний
        }
        return false; // не вистачає коштів
    }
}