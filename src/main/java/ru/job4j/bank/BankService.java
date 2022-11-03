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
        users.put((User) user.getPassport(), user);
    }

    }

    public boolean deleteUser(String passport) {
        boolean rsl = false;
        if (findByPassport(passport) == null) {
            users.remove(passport);
            rsl = true;
            }
            return rsl;
    }

    public void addAccount(String passport, Account account) {
        User rsl = findByPassport(passport);
        if (rsl != null) {
            rsl.add(account);
        }
    }

    public User findByPassport(String passport) {
        Map<User, List<Account>> user = new HashMap<>();
        for (User key : users.keySet()) {
            if (users.containsKey(key)) {
                user = (Map<User, List<Account>>) users.remove(passport);

            }
        }
        return (User) user;
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