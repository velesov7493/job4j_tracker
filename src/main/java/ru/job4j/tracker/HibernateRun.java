package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {

    private static Item create(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    private static void update(Item item, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    private static void delete(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    private static List<Item> findAll(SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from ru.job4j.tracker.Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    private static Item findById(Integer id, SessionFactory sf) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item result = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return result;
    }

    public static void main(String[] args) {
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Item item = new Item("Изучение Hibernate 5");
            item.setDescription("Hibernate - 21 задача");
            create(item, sf);
            System.out.println(item);
            item = new Item("Изучение Spring");
            item.setDescription("Spring - 42 задачи");
            create(item, sf);
            System.out.println(item);
            item = new Item("Изучение Микросервисов");
            item.setDescription("Микросервисы - 22 задачи");
            create(item, sf);
            System.out.println(item);
            List<Item> list = findAll(sf);
            for (Item it : list) {
                System.out.println(it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}