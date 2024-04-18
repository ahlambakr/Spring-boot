package org.example.restcrud.Service;

import org.example.restcrud.model.Emplyee;

import java.util.List;

public interface EmplyeeService {
    List<Emplyee> findAll();
    Emplyee findById (int theId);
    Emplyee sava (Emplyee theEmplyee) ;
    void deleteById (int tneId) ;

}
