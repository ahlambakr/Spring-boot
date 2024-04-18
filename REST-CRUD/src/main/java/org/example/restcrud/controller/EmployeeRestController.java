package org.example.restcrud.controller;


import org.example.restcrud.DAO.EmplyeeDAO;
import org.example.restcrud.Service.EmplyeeService;
import org.example.restcrud.model.Emplyee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api")
public class EmployeeRestController  {
   private EmplyeeService emplyeeService ;
    // constructor injection , inject emplyeeDAO

    public EmployeeRestController(EmplyeeService theEmplyeeService)  {
         emplyeeService = theEmplyeeService; ;

    }
    @GetMapping("/employees")
    public List<Emplyee> findall (){
        return emplyeeService.findAll();
    }

     @GetMapping ("/employees/{emplyeeId}")
    public Emplyee getEmplyee (@PathVariable int emplyeeId) {
       Emplyee theEmplyee = emplyeeService.findById(emplyeeId) ;
        if (theEmplyee == null ){
            throw new RuntimeException("Employee id not found "+emplyeeId);
        }
        return theEmplyee;
     }


     @PostMapping("/employees")
    public Emplyee addEmplyee (@RequestBody Emplyee theEmplyee ){
       theEmplyee.setId(6);
        Emplyee dbEmplyee  = emplyeeService.sava(theEmplyee) ;
        return dbEmplyee ;
     }
     @PutMapping("/employees")
    public Emplyee updateEmployee (@RequestBody Emplyee theEmployee ){
        Emplyee dbEmlpyee  = emplyeeService.sava(theEmployee) ;
        return dbEmlpyee  ;
     }
     @DeleteMapping("/employees/{employeeId}")
    public String deletEmployee (@PathVariable int employeeId) {
        Emplyee theEmployee  = emplyeeService.findById(employeeId) ;
        if(theEmployee== null ){
            throw new RuntimeException("Employee id not found" + employeeId) ;

        }
        emplyeeService.deleteById(employeeId);
        return "Delete the Employee id " + employeeId;
     }

}
