package org.example.restcrud.Service;

import org.example.restcrud.DAO.EmplyeeDAO;
import org.example.restcrud.model.Emplyee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmplyeeServiceimp implements EmplyeeService {
 private EmplyeeDAO emplyeeDAO;

    @Autowired
    public EmplyeeServiceimp(EmplyeeDAO theEmplyeeDAO) {
        emplyeeDAO = theEmplyeeDAO;
    }



    @Override
    public List<Emplyee> findAll() {
        return emplyeeDAO.findAll();
    }

    @Override
    public Emplyee findById(int theId) {
        return emplyeeDAO.findById(theId) ;
    }

    @Transactional
    @Override
    public Emplyee sava(Emplyee theEmplyee) {
        return emplyeeDAO.sava(theEmplyee) ;
    }
@Transactional
    @Override
    public void deleteById(int theId) {
      emplyeeDAO.deleteById(theId);
    }
}
