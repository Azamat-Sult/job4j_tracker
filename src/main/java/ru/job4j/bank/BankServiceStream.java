package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает модель работы банка: добавление в систему нового клиента,
 * открытие клиенту банковского счёта, перевод денег со счёта на счёт.
 * @author AZAMAT SULTANGAREEV
 * @version 1.0
 */
public class BankServiceStream {
    /**
     * Хранение данных всех клиентов осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход данные нового клиента и добавляет в систему
     * @param user данные нового клиента
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает паспортные данные клиента и данные банковского счета
     * далее идет поиск клиента в системе по паспортным данным
     * если клиент найден и у него нет банковского счета с такими вводными данными
     * то этому клиенту открывается такой счет
     * @param passport паспортные данные для поиска клиента
     * @param account данные банковского счета для открытия
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод принимает паспортные данные для поиска клиента
     * @param passport паспортные данные для поиска клиента
     * @return возвращает данные клиента или null если клиента с таким паспортом нет
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает паспортные данные клиента и реквизиты счета
     * для поиска банковского счета
     * @param passport паспортные данные клиента
     * @param requisite реквизиты счета
     * @return возвращает данные банковского счета клиента или null если нет такого клиента
     * или нет такого открытого счета у клиента
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst();

        }
        return Optional.empty();
    }

    /**
     * Метод принимает паспортные данные и реквизиты счета клиента переводящего деньги,
     * паспортные данные и реквизиты счета клиента принимающего деньги и сумму перевода
     * @param srcPassport паспортные данные клиента переводящего деньги
     * @param srcRequisite реквизиты счета клиента переводящего деньги
     * @param destPassport паспортные данные клиента принимающего деньги
     * @param destRequisite реквизиты счета клиента принимающего деньги
     * @param amount сумма перевода
     * @return возвращает true если перевод выполнен или false если перевод не выполнен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent() && srcAccount.get().getBalance() >= amount && destAccount.isPresent()) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
