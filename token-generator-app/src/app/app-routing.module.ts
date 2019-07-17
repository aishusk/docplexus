import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CollectTokenComponentComponent } from './collect-token-component/collect-token-component.component';
import { CustomerComponent } from './customer/customer.component';

const routes: Routes = [
  { path: 'collectTokens', component: CollectTokenComponentComponent },
  {
    path: 'createCustomer',
    component: CustomerComponent,
         },
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
