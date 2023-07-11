import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuProduitComponent } from './Component/user_side/menu-produit/menu-produit.component';
import { UpdateProduitComponent } from './Component/admin_side/update-produit/update-produit.component';
import { HeaderComponent } from './Component/header/header.component';
import { FooterComponent } from './Component/footer/footer.component';
import { FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreateProduitComponent } from './Component/admin_side/create-produit/create-produit.component';
import { HomeComponent } from './home/home.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { MenuProduitComponentAdmin } from './Component/admin_side/menu-produit/menu-produit-admin.component';
import { PopUpComponent } from './pop-up/pop-up.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateProduitComponent,
    UpdateProduitComponent,
    MenuProduitComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    MenuProduitComponentAdmin,
    PopUpComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    CommonModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
