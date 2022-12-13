package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывыет работу банковской системы, позволяющий добавлять пользователей,
 * а также присваивать пользователям банковский счёт и взаимодействовать с ним.
 * @author ALEXANDR ZYRYANOV
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение пользователей осуществляется в колекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает один паравметр: пользователя (Объект класса User).
     * К этому пользователю привязывается пустой список, в котором будут храниться банковские счета.
      * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод принимает на вход паспорт и удаляет по нему пользователя из системы.
     * @param passport этот параметр позволяет уникально идентифиицировать рользователя
     * и удалить его из системы.
     * @return возвращает true в случае, когда пользователь нашёлся, и удаление произведено успешно.
     * в противном случае - метод возвращает false.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, null)) != null;
    }

    /**
     * Метод добавляет пользователю банковский счёт по двум входным параметрам.
     * @param passport ищет пользователя по паспорту, используя метод findByPassport.
     * @param account проверив, что такого счёта у пользователя нет, добавляет новый счёт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта, который сравнивается с номером пасорта каждого пльзователя,
     * путём их перебора
     * @return возвращает найденного пользователя, если ничего не найдено - метод возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет искать счёт пользователя по реквизитам.
     * @param passport по номеру паспорта ищет пользователя с помощью метода findByPassport.
     * @param requisite если пользователь нащёлся, открывает у него все счета и сравневает реквизиты
     * каждого счета с входным путём их перебора.
     * @return возвращает найденный счёт, если ничего не найдено - метод возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport номер паспорта для поиска счёта, с которого будет осуществляться перевод.
     * @param srcRequisite реквизиты счёта для поиска счёта, с которого будет осуществляться перевод.
     * @param destPassport номер паспорта для поиска счёта, на который будет осуществляться перевод.
     * @param destRequisite реквизиты счёта для поиска счёта, на который будет осуществляться перевод.
     * @param amount значение суммы, которую необходимо перевисти с одного счёта на другой
     * Для поиска счёта используется метод findByRequisite.
     * @return Если счёт не найден или баланс на счёте, с которого осуществляется перевод меньше суммы,
     * заданной в параметрах - метод возвращает false. Если всё успешно - true.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account scrAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (scrAccount != null && destAccount != null && scrAccount.getBalance() >= amount) {
            scrAccount.setBalance(scrAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}

