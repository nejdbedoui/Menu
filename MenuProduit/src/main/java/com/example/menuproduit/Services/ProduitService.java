package com.example.menuproduit.Services;

import com.example.menuproduit.Commands.CreateProduitCommand;
import com.example.menuproduit.Commands.UpdateProduit;
import com.example.menuproduit.DTO.ProduitDto;
import com.example.menuproduit.Interfaces.ProduitInterface;
import com.example.menuproduit.Models.Produit;
import com.example.menuproduit.Respository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.*;

import org.apache.commons.io.IOUtils;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProduitService implements ProduitInterface {
    @Autowired
    ProduitRepo produitRepo;

    @Override
    public Produit CreateProduit(CreateProduitCommand c) {
        Produit p=new Produit();
        p.setNom(c.getNom());
        p.setPrix(c.getPrix());
        if (!c.getImage().isEmpty()) {
            String originalFileName = c.getImage().getOriginalFilename();
            String fileExtension = StringUtils.getFilenameExtension(originalFileName);
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String newFileName = StringUtils.cleanPath(timeStamp + "_" + originalFileName+"."+fileExtension);
        try {
             Path path = Paths.get("Images/" + newFileName);
             Files.copy(c.getImage().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            p.setImage_url(path.toString());
        } catch (IOException e) {

        }
        }
        return produitRepo.save(p);
    }

    @Override
    public Produit UpdateProduit(UpdateProduit p) {
        Produit produit=produitRepo.findById(p.getId()).orElse(null);
        produit.setNom((p.getNom().isEmpty() || p.getNom()==null) ? produit.getNom() : p.getNom());
        produit.setPrix(p.getPrix() == 0 ? produit.getPrix() : p.getPrix());
        if (p.getImage()!=null) {
            String originalFileName = p.getImage().getOriginalFilename();
            String fileExtension = StringUtils.getFilenameExtension(originalFileName);
            String timeStamp = String.valueOf(System.currentTimeMillis());
            String newFileName = StringUtils.cleanPath(timeStamp + "_" + originalFileName+"."+fileExtension);
            try {
                Path path = Paths.get("Images/" + newFileName);
                Files.copy(p.getImage().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                if(produit.getImage_url()!=null){
                    File file = new File(produit.getImage_url());
                    file.delete();
                }
                produit.setImage_url(path.toString());
            } catch (IOException e) {

            }
        }
        return produitRepo.save(produit);
    }

    @Override
    public void DeleteProduit(Long id) {
        Produit produit=produitRepo.findById(id).orElse(null);
        if(produit!=null){
            if(produit.getImage_url()!=null){
                File file = new File(produit.getImage_url());
                file.delete();
            }
            produitRepo.deleteById(id);
        }


    }

    @Override
    public List<ProduitDto> getAllProduit() throws Exception {
        List<ProduitDto> l = new ArrayList<ProduitDto>();
        for (Produit p:produitRepo.findAll(Sort.by(Sort.Direction.DESC, "id"))) {
            ProduitDto p1 = new ProduitDto();
            p1.setPrix(p.getPrix());
            p1.setNom(p.getNom());
            p1.setId(p.getId());
            if(p.getImage_url()!=null){
                    InputStream in = new FileInputStream(p.getImage_url());
                if(in!=null){
                    System.out.println("yes");
                    p1.setImage(IOUtils.toByteArray(in));
                }
            }
            l.add(p1);
        }
        return l;
    }

    @Override
    public ProduitDto getProduit(Long id) throws IOException {
        Produit p=produitRepo.findById(id).orElse(null);
        ProduitDto p1 = new ProduitDto();
        p1.setPrix(p.getPrix());
        p1.setNom(p.getNom());
        p1.setId(p.getId());
        if(p.getImage_url()!=null){
            InputStream in = new FileInputStream(p.getImage_url());
            if(in!=null){
                System.out.println("yes");
                p1.setImage(IOUtils.toByteArray(in));
            }
        }
        return p1;
    }
}
