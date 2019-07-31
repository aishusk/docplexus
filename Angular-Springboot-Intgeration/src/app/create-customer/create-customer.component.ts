import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customer : Customer = new Customer; 
  constructor(private customerService : CustomerService) { }

  ngOnInit() {
  }

  onSubmit(){
    this.customerService.createCustomer(this.customer)
        .subscribe(data => console.log(data), error => console.log(error));
  }
}
