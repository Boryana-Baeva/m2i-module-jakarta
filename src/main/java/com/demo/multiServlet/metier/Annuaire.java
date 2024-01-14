package com.demo.multiServlet.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Annuaire {
    private ArrayList<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public ArrayList<Person> getAllPersons() {
        return persons;
    }

    public ArrayList<Person> getVIPs() {
        ArrayList<Person> vip = new ArrayList<>();
        for(Person p : persons) {
            if(p.isVIP()) {
                vip.add(p);
            }
        }
        return vip;
    }

    public ArrayList<Person> getNonVIPs() {
        ArrayList<Person> nonVip = new ArrayList<>();
        for(Person p : persons) {
            if(!p.isVIP()) {
                nonVip.add(p);
            }
        }
        return nonVip;
    }

    /*public ArrayList<Person> getNonVIP() {
        return persons.stream()
                        .filter(p -> !p.isVIP())
                        .collect(Collectors.toCollection(ArrayList::new));
    }*/
}
