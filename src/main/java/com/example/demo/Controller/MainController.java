package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.Servisec;
import com.example.demo.entities.Studant;





@RestController
public class MainController {

    @Autowired
   private Servisec service;
   
   @GetMapping("/students")
   public List<Studant> getBooks() {
       return this.service.getStud();
   }
   @GetMapping("/student/{id}")
   public Studant getOne(@PathVariable("id") int id){
        return this.service.getSingleStudent(id);
   }
   @PostMapping("/student")
   public void add(@RequestBody Studant studant){
        this.service.add(studant);
        return;
   }
   @DeleteMapping("student/{id}")
   public String delete(@PathVariable("id") int id){
    
    return this.service.delete(id);
   }
   @PutMapping("student/{id}")
   public Studant Update(@RequestBody Studant stud , @PathVariable("id") int id){
     return this.service.Update(stud,id);
   }
}
