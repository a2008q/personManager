package cn.a2008q.service;

import cn.a2008q.pojo.Person;

public interface PersonManagerIF {
    void addPerson(Person person);
    void updatePerson(Person person);
    void queryAllPerson();
    void queryOne(int id);
    void deleteOne(int id);
}
