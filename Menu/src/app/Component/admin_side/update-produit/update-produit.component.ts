import { Component, HostListener, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from 'src/app/Models/Produits';
import { ProduitsService } from 'src/app/Services/produits.service';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styleUrls: ['../../../app.component.css']
})
export class UpdateProduitComponent implements OnInit {

  loading:boolean=false;
  nom: string=""
  prix:number=0
  file!: File;
  id!: number;
  image:any
  submitted:boolean=false



  constructor(private produitservice:ProduitsService,private router: Router,private route: ActivatedRoute) {

}
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id']; 
      this.produitservice.getProduit(this.id).subscribe((result)=>{
       this.nom=result.nom
       this.prix=result.prix
       this.image=result.image
      }) 
    });
    
  }




chooseFile(event: any | null) {
  if (event.target.files[0]) {
    this.file=event.target.files[0]
  }
}

submit(){
  this.submitted=true
  if(this.nom!="" && this.prix ){
    this.produitservice.updateProduit(this.id,this.nom,this.prix,this.file).subscribe((result)=>{
      if(result){
        this.router.navigate(['/admin']);
      }
    }
    )
  }

   
}

return(){
  this.router.navigate(['/admin']);
}
}
