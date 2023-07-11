package com.example.menuproduit.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    private Long id;
    private  byte[] image;
    private String nom;
    private float prix;
}
