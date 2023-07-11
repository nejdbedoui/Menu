import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Produit } from '../Models/Produits';
import { ProduitDto } from '../Models/ProduitDto';

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  apiUrl= "http://localhost:8080/produit";
  constructor(private http: HttpClient) {
  }


  createProduit(nom:string,prix:number,image:File){
    const formdata: FormData = new FormData();
    formdata.append('image', image);
    formdata.append('nom', nom);
    formdata.append('prix', prix.toString());
    return this.http.post(`${this.apiUrl}/createp`,formdata)
  }

  updateProduit(id:number,nom:string,prix:number,image:File){
    const formdata: FormData = new FormData();
    formdata.append('id', id.toString());
    formdata.append('image', image);
    formdata.append('nom', nom);
    formdata.append('prix', prix.toString());
    return this.http.put(`${this.apiUrl}/updatep`,formdata)
  }

  deleteProduit(id:number){
    return this.http.delete(`${this.apiUrl}/delete/${id}`)
  }

  getAll(){
    return this.http.get<ProduitDto[]>(`${this.apiUrl}/all`)
  }

  getProduit(id:number){
    return this.http.get<ProduitDto>(`${this.apiUrl}/get/${id}`)
  }


}
