package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.List;

public class HbmTracker implements Store {

    private final StandardServiceRegistry registry;
    private final SessionFactory sf;

    public HbmTracker() {
        registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        sf =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        item.setId(id);
        Session session = sf.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        boolean result = session.getTransaction().getStatus().equals(TransactionStatus.COMMITTED);
        session.close();
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Item item = new Item(null);
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        boolean result = session.getTransaction().getStatus().equals(TransactionStatus.COMMITTED);
        session.close();
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM tz_items";
        Query q = session.createSQLQuery(sql).addEntity(Item.class);
        tx.commit();
        List<Item> result = q.getResultList();
        session.close();
        return result;
    }

    @Override
    public void findAllReact(Observe<Item> observe) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM tz_items";
        Query q = session.createSQLQuery(sql).addEntity(Item.class);
        tx.commit();
        List<Item> result = q.getResultList();
        session.close();
        result.forEach(observe::receive);
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM tz_items WHERE name='" + key + "'";
        Query q = session.createSQLQuery(sql).addEntity(Item.class);
        tx.commit();
        List<Item> result = q.getResultList();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        String sql = "SELECT * FROM tz_items WHERE id=" + id;
        Query q = session.createSQLQuery(sql).addEntity(Item.class);
        tx.commit();
        List<Item> records = q.getResultList();
        if (!records.isEmpty()) {
            result = records.get(0);
        }
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        sf.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }
}