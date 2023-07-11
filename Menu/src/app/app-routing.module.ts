import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { MenuProduitComponentAdmin } from './Component/admin_side/menu-produit/menu-produit-admin.component';
import { MenuProduitComponent } from './Component/user_side/menu-produit/menu-produit.component';
import { UpdateProduitComponent } from './Component/admin_side/update-produit/update-produit.component';
import { CreateProduitComponent } from './Component/admin_side/create-produit/create-produit.component';

const routes: Routes = [
  { path: '',component: MenuProduitComponent},
  { path: 'admin', component: MenuProduitComponentAdmin },
  { path: 'user', component: MenuProduitComponent },
  { path: 'create', component: CreateProduitComponent },
  { path: 'update/:id', component: UpdateProduitComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
