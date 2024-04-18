package org.example.restcrud.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.restcrud.model.Emplyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class EmpoyeeDAOimp implements EmplyeeDAO {
    // define entity manager
    private EntityManager entityManager ;



    //set up constructor injection
   @Autowired
    public EmpoyeeDAOimp (EntityManager theEntityManager){
        entityManager= theEntityManager;
    }
    @Override
    public List<Emplyee> findAll(){

       // create query ;
        TypedQuery<Emplyee> theQuery = entityManager.createQuery("from Emplyee",Emplyee.class);

        // exectude query
        List<Emplyee> emplyees =  theQuery.getResultList();

        // get result



        return emplyees ;
    }

    @Override
    public Emplyee findById(int theId) {

       Emplyee theEmplyee = entityManager.find(Emplyee.class,theId) ;
       return theEmplyee;

    }

    @Override
    public Emplyee sava(Emplyee theEmplyee) {
       Emplyee dbEmplyee= entityManager.merge(theEmplyee) ;

        return dbEmplyee ;
    }

    @Override
    public void deleteById(int thaId) {
       // find employee by id ;
        Emplyee theEmplyee = entityManager.find(Emplyee.class, thaId) ;
        entityManager.remove(theEmplyee);
    }


}
