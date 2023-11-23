package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
   public ResponseEntity<List<Studant>> getBooks() {
          List<Studant> list = this.service.getStud();
          if (list.size() <= 0) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }
       return ResponseEntity.status(HttpStatus.CREATED).body(list);
   }



   @GetMapping("/student/{id}")
   public ResponseEntity<Studant> getOne(@PathVariable("id") int id){
          Studant s = this.service.getSingleStudent(id);
          if (s==null) {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
          }
        return ResponseEntity.of(Optional.of(s));
   }




   @PostMapping("/student")
   public ResponseEntity<Studant> add(@RequestBody Studant studant){
     Studant s = null;
     try {
        s = this.service.add(studant);  
        return ResponseEntity.of(Optional.of(s));

     } catch (Exception e) {
          e.printStackTrace();
     }
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   }





   @DeleteMapping("student/{id}")
   public ResponseEntity<Void> delete(@PathVariable("id") int id){
    try {
     this.service.delete(id);
     return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
   }
   @PutMapping("student/{id}")
   public ResponseEntity<Void> Update(@RequestBody Studant stud , @PathVariable("id") int id){
     Studant s = null;
     try {
          this.service.Update(stud,id);
        return ResponseEntity.ok().build();

          
     } catch (Exception e) {
         e.printStackTrace();
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }
   }
}
