import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { ActivatedRoute } from '../../../node_modules/@angular/router';
import { Product } from '../product';

@Component({
  selector: 'app-search-product',
  templateUrl: './search-product.component.html',
  styleUrls: ['./search-product.component.css']
})
export class SearchProductComponent implements OnInit {

  customerId : number;
  products : Product[];
  constructor(private customerService : CustomerService,
             private route : ActivatedRoute) { }

  ngOnInit() {
    this.customerId = this.route.snapshot.params['id'];
    this.customerService.getProductByCutomerId(this.customerId)
      .subscribe((products : Product[]) => this.products = products)
  }



}
