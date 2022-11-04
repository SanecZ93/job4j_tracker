package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
    List<Account> list = new ArrayList<>();
    user.addAll(list);
    if (!users.containsKey(user.getPassport())) {
        users.putIfAbsent(user, list);
    }

    }

    public boolean deleteUser(String passport) {

    }

    public void addAccount(String passport, Account account) {

    }

    public User findByPassport(String passport) {

    }

    public Account findByRequisite(String passport, String requisite) {
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}