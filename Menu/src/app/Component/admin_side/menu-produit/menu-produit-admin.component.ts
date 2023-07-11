import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { ProduitDto } from 'src/app/Models/ProduitDto';
import { ProduitsService } from 'src/app/Services/produits.service';

@Component({
  selector: 'app-menu-produit',
  templateUrl: './menu-produit-admin.component.html',
  styleUrls: ['../../../app.component.css']
})
export class MenuProduitComponentAdmin  implements OnInit{
  produit:ProduitDto[] | undefined
  createModalOpen:boolean=false
  showModal:boolean=false
  idproduit:number=-1 
  
    constructor(private produitservice:ProduitsService,private router: Router) {
  
    }

  
      ngOnInit(): void {
        this.getall()
        
      }   

      create(){
        this.router.navigate(['/create']);
      }

      update(id:number){
        this.router.navigate(['/update/'+id]);
      }

    

      delete(){
          this.produitservice.deleteProduit(this.idproduit).subscribe((result)=>{
            if(this.produit!=undefined){
              const index = this.produit.findIndex(product => product.id === this.idproduit);
              if (index !== -1) {
                this.produit.splice(index, 1);
                this.closeModal();
              }
            }
          })
      }

getall(){
  this.produitservice.getAll().subscribe((result)=>{
    if(result){
      this.produit=result
    }
  })
}






 openModal(id:number) {
  this.idproduit=id
  const modal = document.getElementById('myModal');
  modal!.style.display = 'block';
}

 closeModal() {
  const modal = document.getElementById('myModal');
  modal!.style.display = 'none';
}


 cancelAction() {
  this.closeModal();
}


  }


