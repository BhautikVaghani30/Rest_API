package com.example.demo.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entities.Studant;

@Component
public class Servisec {
    private static List<Studant> list = new ArrayList();
    static {
        list.add(new Studant(1, "bhautik", "surat", 20));
        list.add(new Studant(2, "vivek", "vdodra", 21));
        list.add(new Studant(3, "bhavin", "ahemdabad", 22));
        list.add(new Studant(4, "mihir", "palsana", 23));
        list.add(new Studant(5, "uday", "palitana", 24));

    }

    public List<Studant> getStud() {
        return list;
    }

    public Studant getSingleStudent(int id) {
        Studant stud = null;
        try {
             stud =  list.stream().filter(e -> e.getId() == id).findFirst().get();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stud;

    }

    public Studant add(Studant studant) {
        list.add(studant);
        return studant;
    }

    public String delete(int id) {
       
        Studant stud = list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
         String name = stud.getName();
        if (stud != null) {
            list.remove(stud);
        }

        return "Student "+name+" Deleted Successfully";

    }

    public Studant Update(Studant stud , int id){
        Studant s = list.stream().filter(e->e.getId() == id).findFirst().get();
        s.setAge(stud.getAge());
        s.setCity(stud.getCity());
        s.setName(stud.getName());
        return s;
    }
}

