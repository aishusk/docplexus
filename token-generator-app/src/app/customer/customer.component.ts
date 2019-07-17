import { Component, OnInit, Input } from '@angular/core';
import { Customer } from '../customer';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  @Input() customer = { name:'', age: 0, yearsOfBond: 0 ,token:null};
  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
  }

  addCustomer()
  {
    this.rest.addCustomer(this.customer).subscribe((result)=>{
      console.log(this.customer);
    },
    (err)=>{
      console.log(err);
    })
  }



  

}
