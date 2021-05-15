package ru.job4j.bank;

import java.util.*;

public class BankService {

    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = users.get(user);
        accounts.add(account);
    }

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

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
        int i = accounts.indexOf(new Account(requisite, 0));
        return i < 0 ? null : accounts.get(i);
    }

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
