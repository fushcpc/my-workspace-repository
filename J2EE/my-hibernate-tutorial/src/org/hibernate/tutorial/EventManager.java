package org.hibernate.tutorial;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.tutorial.domain.Event;
import org.hibernate.tutorial.domain.Person;
import org.hibernate.tutorial.util.HibernateUtil;

public class EventManager {
    public static void main(String[] args) {
        if ("store".equals(args[0])) {
            createAndStoreEvent("My new event!", new Date());
        } else if ("list".equals(args[0])) {
            listOutEvents();
        } else if ("createAndStorePerson".equals(args[0])) {
            createAndStorePerson(22, "David", "Chen");
        } else if ("addPerson2Event".equals(args[0])) {
            addPerson2Event(41, 23);
        }
    }

    private static void listOutEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Event> events = session.createQuery("from Event").list();
        for (Event e : events) {
            System.out.println(e);
        }

        session.getTransaction().commit();
    }

    private static void createAndStoreEvent(String title, Date date) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event event = new Event();
        event.setTitle(title);
        event.setDate(date);
        session.save(event);

        session.getTransaction().commit();
    }

    private static void createAndStorePerson(int age, String firstname,
            String lastname) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person person = new Person();
        person.setAge(age);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        session.save(person);

        session.getTransaction().commit();
    }

    private static void addPerson2Event(int personId, int eventId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Person p = (Person) session.load(Person.class, personId);
        Event e = (Event) session.load(Event.class, eventId);
        p.getEvents().add(e);

        session.getTransaction().commit();
    }

}
