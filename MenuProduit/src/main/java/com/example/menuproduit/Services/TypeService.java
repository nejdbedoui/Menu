package com.example.menuproduit.Services;

import com.example.menuproduit.Interfaces.TypeInterface;
import com.example.menuproduit.Models.Type;
import com.example.menuproduit.Respository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements TypeInterface {
    @Autowired
    TypeRepo typeRepo;
    @Override
    public Type CreateProduit(Type t) {
        return typeRepo.save(t);
    }

    @Override
    public Type UpdateProduit(Type t) {
        Type type=typeRepo.findById(t.getId()).orElse(null);
        type.setNom(t.getNom());
        return typeRepo.save(type);
    }

    @Override
    public void DeleteProduit(Long id) {
        typeRepo.deleteById(id);
    }

    @Override
    public List<Type> getAllProduit() {
        return typeRepo.findAll();
    }

    @Override
    public Type getProduit(Long id) {
        return typeRepo.findById(id).orElse(null);
    }
}
