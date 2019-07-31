import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';  
import { Customer } from './customer';
import { THROW_IF_NOT_FOUND } from '../../node_modules/@angular/core/src/di/injector';
import { Product } from './product';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private baseUrl = 'http://localhost:5555/customers';
  constructor(private http : HttpClient) { }

  getCustomer(id : number) : Observable<Object>{
    return this.http.get(this.baseUrl+'/'+id);
  }

  getCustomerList() : Observable<any>{
    return this.http.get(this.baseUrl);
  }

  createCustomer(customer : Object) : Observable<Object>{
    return this.http.post(this.baseUrl + '/create',customer);
  }
  
  deleteCustomer(id:number):Observable<any>{
    return this.http.delete(this.baseUrl + '/' + id, {responseType : 'text'});
  }

  updateCustomer(id : number, customer : any) : Observable<Object>{
    return this.http.put(this.baseUrl + '/' + id, customer);
  }

  getCustomerByName(name : string) : Observable<Object>{
    return this.http.get(this.baseUrl + '/name/' + name);
  }

  getProductByCutomerId(id : number) : Observable<Object>{
    return this.http.get(this.baseUrl + '/' + id + '/product');
  }

  addProductByCustomerId(id : number, product : Product) : Observable<Object>{
    return this.http.post(this.baseUrl + '/' + id + '/product',product);
  } 
}
