package com.example.menuproduit.Interfaces;

import com.example.menuproduit.Commands.CreateProduitCommand;
import com.example.menuproduit.Commands.UpdateProduit;
import com.example.menuproduit.DTO.ProduitDto;
import com.example.menuproduit.Models.Produit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ProduitInterface {
    public Produit CreateProduit(CreateProduitCommand p);
    public Produit UpdateProduit(UpdateProduit p);
    public void DeleteProduit(Long id);
    public List<ProduitDto> getAllProduit() throws Exception;
    public ProduitDto getProduit(Long id) throws IOException;
}
