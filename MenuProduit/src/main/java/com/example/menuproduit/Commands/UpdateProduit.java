package com.example.menuproduit.Commands;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProduit {
    private Long id;
    private MultipartFile image;
    private String nom;
    private float prix;
}
