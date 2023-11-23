package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.StudantRepo;
import com.example.demo.entities.Studant;

@Component
public class Servisec {
    @Autowired
    private StudantRepo studantRepo;
    // private static List<Studant> list = new ArrayList();
    // static {
    //     list.add(new Studant(1, "bhautik", "surat", 20));
    //     list.add(new Studant(2, "vivek", "vdodra", 21));
    //     list.add(new Studant(3, "bhavin", "ahemdabad", 22));
    //     list.add(new Studant(4, "mihir", "palsana", 23));
    //     list.add(new Studant(5, "uday", "palitana", 24));

    // }

    public List<Studant> getStud() {
        List<Studant> stud = (List<Studant>)this.studantRepo.findAll();
        return stud;
    }

    public Studant getSingleStudent(int id) {
        Studant stud = null;
        try {
            //  stud =  list.stream().filter(e -> e.getId() == id).findFirst().get();
            stud = this.studantRepo.findById(id);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stud;

    }

    public Studant add(Studant studant) {
        // list.add(studant);
        Studant stud = this.studantRepo.save(studant);
        return stud;
    }

    public void delete(int id) {

        studantRepo.deleteById(id);

        return;

    }

    public void Update(Studant stud , int id){
        // Studant s = list.stream().filter(e->e.getId() == id).findFirst().get();
        // s.setAge(stud.getAge());
        // s.setCity(stud.getCity());
        // s.setName(stud.getName());
        // return s;
        stud.setId(id);
        studantRepo.save(stud);
    }
}

