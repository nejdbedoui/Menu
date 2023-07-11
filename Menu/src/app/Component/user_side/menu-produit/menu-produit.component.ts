import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProduitDto } from 'src/app/Models/ProduitDto';
import { Produit } from 'src/app/Models/Produits';
import { ProduitsService } from 'src/app/Services/produits.service';

@Component({
  selector: 'app-menu-produit',
  templateUrl: './menu-produit.component.html',
  styleUrls: ['../../../app.component.css']
})
export class MenuProduitComponent implements OnInit{
produit:ProduitDto[] | undefined

  constructor(private produitservice:ProduitsService,private router: Router) {

  }
    ngOnInit(): void {
      this.produitservice.getAll().subscribe((result)=>{
        if(result){
          this.produit=result
          
        }
      })
    }
} 
