package com.example.demo.DAO;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOimp implements StudentDAO {
    //define field
    private EntityManager entityManager ;
    // inject entity manager using constructor injection
    @Autowired
    public StudentDAOimp (EntityManager entityManager) {
        this.entityManager = entityManager ;
    }
    @Override
    @Transactional
    public void  save  (Student theStudent)  {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create the query
        TypedQuery<Student> theQery = entityManager.createQuery("FROM Student ",Student.class);
         // return query result
        return theQery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theDate",Student.class);

        //set query parameters
        theQuery.setParameter("theDate",theLastName);


        //return query results

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent) ;
    }

    @Override
    @Transactional
    public void delete(int id ) {
        Student theStudent = entityManager.find(Student.class,id) ;
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleyeAll() {
        int count = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return count;
    }


}
