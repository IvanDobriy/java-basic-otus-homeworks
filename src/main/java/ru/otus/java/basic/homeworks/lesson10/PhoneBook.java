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

    public void add(String lastName, String firstName, String patronymic, String phone) {
        Objects.requireNonNull(lastName, "last name is null");
        Objects.requireNonNull(firstName, "first name is null");
        Objects.requireNonNull(patronymic, "patronymic is null");
        Objects.requireNonNull(phone, "phone is null");
        phones.add(phone);
        addToStorage(String.format("l:%s f:%s p:%s ", lastName, firstName, patronymic), phone);
        addToStorage(String.format("l:%s f:%s ", lastName, firstName), phone);
        addToStorage(String.format("l:%s p:%s ", lastName, patronymic), phone);
        addToStorage(String.format("f:%s p:%s ", firstName, patronymic), phone);
        addToStorage(String.format("l:%s ", lastName), phone);
        addToStorage(String.format("f:%s ", firstName), phone);
        addToStorage(String.format("p:%s ", patronymic), phone);
    }

    public List<String> find(String lastName, String firstName, String patronymic) {
        final var searchKey = new StringBuilder();
        if (lastName != null) {
            searchKey.append(String.format("l:%s ", lastName));
        }
        if (firstName != null) {
            searchKey.append(String.format("f:%s ", firstName));
        }
        if (patronymic != null) {
            searchKey.append(String.format("p:%s ", patronymic));
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
