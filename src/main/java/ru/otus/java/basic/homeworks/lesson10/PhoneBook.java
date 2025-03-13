package ru.otus.java.basic.homeworks.lesson10;

import java.util.*;

public class PhoneBook {
    private Set<String> phones;
    private Map<String, Set<String>> storage;

    public PhoneBook() {
        phones = new HashSet<>();
        storage = new HashMap<>();
    }

    private void addToStorage(String key, String phone) {
        var phoneSet = storage.get(key);
        if (phoneSet == null) {
            phoneSet = new HashSet<>();
            storage.put(key, phoneSet);
        }
        phoneSet.add(phone);
    }

    private String lfpKey(String lastName, String firstName, String patronymic) {
        return String.format("l:%s f:%s p:%s ", lastName, firstName, patronymic);
    }

    private String lfKey(String lastName, String firstName) {
        return String.format("l:%s f:%s ", lastName, firstName);
    }

    private String lpKey(String lastName, String patronymic) {
        return String.format("l:%s p:%s ", lastName, patronymic);
    }

    private String fpKey(String firstName, String patronymic) {
        return String.format("f:%s p:%s ", firstName, patronymic);
    }

    private String lKey(String lastName) {
        return String.format("l:%s ", lastName);
    }

    private String pKey(String patronymic) {
        return String.format("p:%s ", patronymic);
    }

    private String fKey(String firstName) {
        return String.format("f:%s ", firstName);
    }


    public void add(String lastName, String firstName, String patronymic, String phone) {
        Objects.requireNonNull(lastName, "last name is null");
        Objects.requireNonNull(firstName, "first name is null");
        Objects.requireNonNull(patronymic, "patronymic is null");
        Objects.requireNonNull(phone, "phone is null");
        phones.add(phone);
        addToStorage(lfpKey(lastName, firstName, patronymic), phone);
        addToStorage(lfKey(lastName, firstName), phone);
        addToStorage(lpKey(lastName, patronymic), phone);
        addToStorage(fpKey(firstName, patronymic), phone);
        addToStorage(lKey(lastName), phone);
        addToStorage(fKey(firstName), phone);
        addToStorage(pKey(patronymic), phone);
    }

    public List<String> find(String lastName, String firstName, String patronymic) {
        final var searchKey = new StringBuilder();
        if (lastName != null) {
            searchKey.append(lKey(lastName));
        }
        if (firstName != null) {
            searchKey.append(fKey(firstName));
        }
        if (patronymic != null) {
            searchKey.append(pKey(patronymic));
        }
        final var phones = storage.get(searchKey.toString());
        if (phones != null) {
            return new ArrayList<>(phones);
        }
        return new ArrayList<>();
    }

    public boolean containsPhoneNumber(String phone) {
        return phones.contains(phone);
    }
}
