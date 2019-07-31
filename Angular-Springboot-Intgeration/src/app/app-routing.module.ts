import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { SearchCustomerComponent } from './search-customer/search-customer.component';
import { SearchProductComponent } from './search-product/search-product.component';
import { AddProductComponent } from './add-product/add-product.component';

const routes: Routes = [
  {path:'' , component: CustomerListComponent},
  {path:'customers', component : CustomerListComponent},
  {path:'customers/create', component : CreateCustomerComponent},
  {path:'customers/search', component : SearchCustomerComponent},
  {path:'customers/products/:id', component : SearchProductComponent},
  {path:'customers/addProduct/:id',component : AddProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
