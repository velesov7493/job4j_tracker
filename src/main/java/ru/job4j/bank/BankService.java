package ru.job4j.bank;

import java.util.*;

/**
 * Банковский сервис
 * Выполняет операции с клиентами и счетами банка
 */
public class BankService {

    /**
     * Все клиенты и их счета хранятся в карте.
     * Причем ключем выступает клиент, а значение - это
     * список его счетов
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавить клиента в сервис
     * @param user клиент, добавляемый в сервис
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавить личный счет клиенту
     * @param passport серия и номер паспорта клиента, которому добавляется счет
     * @param account Новый счет
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Найти клиента по его паспортным данным
     * @param passport серия и номер паспорта
     * @return объект клиента
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
            if (passport.equals(key.getPassport())) {
                result = key;
                break;
            }
        }
        return result;
    }

    /**
     * Найти счет по его реквизитам
     * @param passport серия и номер паспорта держателя счета
     * @param requisite номер счета
     * @return объект счета
     */
    public Account findByRequisite(String passport, String requisite) {
        Account result = null;
        User user = findByPassport(passport);
        if (user == null) {
            return result;
        }
        List<Account> accounts = users.get(user);
        for (Account entry : accounts) {
            if (requisite.equals(entry.getRequisite())) {
                result = entry;
                break;
            }
        }
        return result;
    }

    /**
     * Выполнить перевод средств
     * @param srcPassport серия/номер паспорта плательщика
     * @param srcRequisite номер счета плательщика
     * @param destPassport серия/номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount сумма перевода
     * @return {@code} true в случае успеха
     */
    public boolean transferMoney(
            String srcPassport, String srcRequisite,
            String destPassport, String destRequisite, double amount
    ) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc == null || destAcc == null || srcAcc.getBalance() < amount) {
            return false;
        }
        srcAcc.setBalance(srcAcc.getBalance() - amount);
        destAcc.setBalance(destAcc.getBalance() + amount);
        return true;
    }
}
