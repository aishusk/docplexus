import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';

@Component({
  selector: 'app-search-customer',
  templateUrl: './search-customer.component.html',
  styleUrls: ['./search-customer.component.css']
})
export class SearchCustomerComponent implements OnInit {
  name: string;
  customers : Customer = null;
  constructor(private CustomerService : CustomerService) { }

  ngOnInit() {
  }

  onSubmit(){
      this.CustomerService.getCustomerByName(this.name)
        .subscribe(
          (customer : Customer) => {
            this.customers = customer;
            console.log(customer);
          },
        
        error => console.log(error))
  }

}
