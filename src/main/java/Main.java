import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import entities.Test_collections;
import org.hibernate.type.LocalDateTimeType;
import types.Obj;

import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args){

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();

        MetadataSources metadataSources = new MetadataSources(registry);
        Metadata metadata = metadataSources.addAnnotatedClass(Test_collections.class).getMetadataBuilder().
                applyBasicType(LocalDateTimeType.INSTANCE).build();
        SessionFactory sessionFactory = metadata.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Test_collections");
        List objs = query.getResultList();

        for (Test_collections o:(List<Test_collections>) objs) {
            System.out.println(String.format("id: %d name: %s sum: %s cur: %s",
                    o.getT_id(),o.getName(),o.getSum(),o.getCur()));
        }
         ////amend
        session.getTransaction().commit();
        session.close();
    }

}
