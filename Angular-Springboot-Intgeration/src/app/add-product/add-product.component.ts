import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '../../../node_modules/@angular/router';
import { CustomerService } from '../customer.service';
import { Product } from '../product';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  customerId : number;
  product : Product = new Product;
  constructor(private route : ActivatedRoute, private customerService : CustomerService) { }

  ngOnInit() {
    this.customerId = this.route.snapshot.params['id'];
  }

  onSubmit(){
    this.addProduct()
  }

  addProduct(){
    this.customerService.addProductByCustomerId(this.customerId,this.product)
      .subscribe(data => console.log(data), error => console.log(error));
  }
}
