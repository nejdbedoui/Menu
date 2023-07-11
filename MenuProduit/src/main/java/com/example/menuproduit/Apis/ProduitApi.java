package com.example.menuproduit.Apis;

import com.example.menuproduit.Commands.CreateProduitCommand;
import com.example.menuproduit.Commands.UpdateProduit;
import com.example.menuproduit.DTO.ProduitDto;
import com.example.menuproduit.Models.Produit;
import com.example.menuproduit.Services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produit")
@RequiredArgsConstructor
public class ProduitApi {
    @Autowired
    ProduitService produitService;


    @PostMapping("/createp")
    public Produit CreateProduit(@RequestParam("nom") String nom,
                                 @RequestParam("prix") float prix,
                                 @RequestParam("image") MultipartFile image){
        CreateProduitCommand c=new CreateProduitCommand();
        c.setPrix(prix);
        c.setNom(nom);
        c.setImage(image);
        return produitService.CreateProduit(c);
    }

    @PutMapping("/updatep")
    public Produit UpdateProduit(@RequestParam("id") Long id,
                                 @RequestParam("nom") String nom,
                                 @RequestParam("prix") float prix,
                                 @RequestParam(value = "image", required = false)  MultipartFile image
                                 ){
        UpdateProduit u =new UpdateProduit();
        u.setPrix(prix);
        u.setNom(nom);
        u.setId(id);
        if(image!=null){
            u.setImage(image);
        }
        return produitService.UpdateProduit(u);
    }
    @DeleteMapping("/delete/{id}")
    public void UpdateProduit(@PathVariable("id") Long id){
         produitService.DeleteProduit(id);
    }

    @GetMapping("/all")
    public List<ProduitDto> GetAll() throws Exception {
        return produitService.getAllProduit();
    }

    @GetMapping("/get/{id}")
    public ProduitDto GetAll(@PathVariable("id") Long id) throws IOException {
        return produitService.getProduit(id);
    }

}
