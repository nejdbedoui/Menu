package com.example.menuproduit.Apis;

import com.example.menuproduit.Models.Produit;
import com.example.menuproduit.Models.Type;
import com.example.menuproduit.Services.ProduitService;
import com.example.menuproduit.Services.TypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/type")
public class TypeApi {

    @Autowired
    TypeService typeService;

    @PostMapping("/createt")
    public Type CreateProduit(@Valid @RequestBody Type p){
        return typeService.CreateProduit(p);
    }

    @PutMapping("/updatet")
    public Type UpdateProduit(@Valid @RequestBody Type p){
        return typeService.UpdateProduit(p);
    }
    @DeleteMapping("/delete/{id}")
    public void UpdateProduit(@PathVariable("id") Long id){
        typeService.DeleteProduit(id);
    }

    @GetMapping("/all")
    public List<Type> GetAll(){
        return typeService.getAllProduit();
    }

    @GetMapping("/get/{id}")
    public Type GetAll(@PathVariable("id") Long id){
        return typeService.getProduit(id);
    }
}
