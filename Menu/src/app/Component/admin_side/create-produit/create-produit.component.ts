import { Component, EventEmitter, HostListener, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { ProduitsService } from 'src/app/Services/produits.service';

@Component({
  selector: 'app-create-produit',
  templateUrl: './create-produit.component.html',
  styleUrls: ['../../../app.component.css']
})


export class CreateProduitComponent implements OnInit {

  loading:boolean=false;
  nom: string=""
  prix!: number
  file!: File
  file_name:string=""
  submitted:boolean=false


  constructor(private produitservice:ProduitsService,private router: Router) {
}
  ngOnInit(): void {
  }



@HostListener('document:keydown', ['$event']) onKeydownHandler(event: KeyboardEvent) {
  if (event.key === "Escape") {
    //this.closeModal()
  }
}


chooseFile(event: any | null) {
  if (event.target.files[0]) {
    this.file=event.target.files[0]
    this.file_name=this.file.name
  }
}

submit(){
  this.submitted=true
  if(this.nom!="" && this.prix && this.file!=null){
    this.produitservice.createProduit(this.nom,this.prix,this.file).subscribe((result)=>{
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
