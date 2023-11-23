package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Studant;

public interface StudantRepo extends CrudRepository<Studant,Integer>{
    public Studant findById(int id);
}
