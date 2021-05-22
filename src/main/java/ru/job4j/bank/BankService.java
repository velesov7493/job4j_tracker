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
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return;
        }
        List<Account> accounts = users.get(user.get());
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Найти клиента по его паспортным данным
     * @param passport серия и номер паспорта
     * @return объект клиента
     */
    public Optional<User> findByPassport(String passport) {
        return
                users.keySet().stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Найти счет по его реквизитам
     * @param passport серия и номер паспорта держателя счета
     * @param requisite номер счета
     * @return объект счета
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<Account> result = Optional.empty();
        Optional<User> user = findByPassport(passport);
        return
                user.isEmpty()
                ? result
                : users.get(user.get()).stream()
                    .filter(a -> requisite.equals(a.getRequisite()))
                    .findFirst();
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
        boolean result = false;
        Optional<Account> srcAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account>  destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc.isPresent() && destAcc.isPresent() && srcAcc.get().getBalance() >= amount) {
            srcAcc.get().setBalance(srcAcc.get().getBalance() - amount);
            destAcc.get().setBalance(destAcc.get().getBalance() + amount);
            result = true;
        }
        return result;
    }
}
