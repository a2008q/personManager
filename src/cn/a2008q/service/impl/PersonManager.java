package cn.a2008q.service.impl;

import cn.a2008q.pojo.Person;
import cn.a2008q.service.PersonManagerIF;

import java.util.ArrayList;
import java.util.List;

public class PersonManager implements PersonManagerIF {
    private List<Person> personList = new ArrayList<>();

    @Override
    public void updatePerson(Person person) {
        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            if (person.getId() == p.getId()) {
                personList.set(i, person);
            }
        }
    }

    @Override
    public void deleteOne(int id) {
        for (Person person : personList) {
            if (id == person.getId()) {
                personList.remove(person);
            }
        }
    }

    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }

    @Override
    public void queryOne(int id) {
        for (Person person : personList) {
            if (id == person.getId()) {
                System.out.println(person.toString());
            }
        }
    }

    @Override
    public void queryAllPerson() {
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
