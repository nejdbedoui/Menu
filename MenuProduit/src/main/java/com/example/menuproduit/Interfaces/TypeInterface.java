package com.example.menuproduit.Interfaces;

import com.example.menuproduit.Models.Type;

import java.util.List;

public interface TypeInterface {
    public Type CreateProduit(Type t);
    public Type UpdateProduit(Type t);
    public void DeleteProduit(Long id);
    public List<Type> getAllProduit();
    public Type getProduit(Long id);
}
