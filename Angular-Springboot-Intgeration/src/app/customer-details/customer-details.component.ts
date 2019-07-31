import { Component, OnInit, Input } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { CustomerListComponent } from '../customer-list/customer-list.component';
import { Router, ActivatedRoute } from '../../../node_modules/@angular/router';

@Component({
  selector: 'customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

 
  @Input() customer: Customer;

  constructor(private customerService : CustomerService, private listComponent: CustomerListComponent,
              private router : Router, private route : ActivatedRoute
  ) { }

  ngOnInit() {
  
  }

  updateActive(isActive:boolean){
      this.customerService.updateCustomer(this.customer.id, {name : this.customer.name, age : this.customer.age, active : isActive})
        .subscribe(
          data => {
            console.log(data);
            this.customer = data as Customer;
          },
          error => console.log(error)
        );
  }
  
  deleteCustomer(){
    this.customerService.deleteCustomer(this.customer.id)
      .subscribe(
        data => {
          console.log(data);
          this.listComponent.reloadData();
        },
        error => console.log('Error : ' + error)
      )
  }

  getProduct(){
    this.router.navigate(['products',this.customer.id],{relativeTo : this.route});
  }

  addProduct(){
    this.router.navigate(['addProduct',this.customer.id],{relativeTo :this.route});
  }
 
}
