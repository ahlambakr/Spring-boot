package org.example.restcrud.DAO;

import org.example.restcrud.model.Emplyee;

import java.util.List;

public interface EmplyeeDAO {

  List<Emplyee> findAll();

  Emplyee findById (int theId);
  Emplyee sava (Emplyee theEmplyee) ;
  void deleteById (int tneId) ;

}
