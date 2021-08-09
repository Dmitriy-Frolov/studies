import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        try(Session session = getSessionFactory().openSession();
        Session currentSession = getSessionFactory().getCurrentSession())
        {
            String hqlCreate = "Create table LinkedPurchaseList(student_id int, course_id int)";
            String hqlPurchaseList = "From " + PurchaseList.class.getSimpleName();
            String hqlStudent = "From " + Student.class.getSimpleName() + " where name = :name";
            String hqlCourse = "From " + Course.class.getSimpleName() + " where name = :name";
            String hqlSelect = "Select students.id student_id, courses.id course_id " +
                    "from purchaseList " +
                    "left join courses " +
                    "on course_name = courses.name " +
                    "left join students " +
                    "on student_name = students.name";

            //session.createQuery(hqlCreate);


//            Query query = session.createSQLQuery(hqlSelect).addEntity(LinkedPurchaseList.class);
//            List<LinkedPurchaseList> linkedPurchaseLists = query.getResultList();
//            currentSession.beginTransaction();
//            linkedPurchaseLists.forEach(linkedPurchaseList -> currentSession.saveOrUpdate(linkedPurchaseList));
//            currentSession.getTransaction().commit();

            List<PurchaseList> purchaseLists = session.createQuery(hqlPurchaseList).getResultList();
            for (PurchaseList purchaselist : purchaseLists){
                Query<Student> studentQuery =
                        session.createQuery(hqlStudent).setParameter("name", purchaselist.getStudentName());
                Student student = studentQuery.uniqueResult();

                Query<Course> courseQuery =
                        session.createQuery(hqlCourse).setParameter("name", purchaselist.getCourseName());
                Course course = courseQuery.uniqueResult();

                LinkedPurchaseList item = new LinkedPurchaseList();
                item.setCourseId(course.getId());
                item.setStudentId(student.getId());

                session.beginTransaction();
                session.saveOrUpdate(item);
                session.getTransaction().commit();
            }
        }
    }

    public static SessionFactory getSessionFactory()
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();

    }
}




