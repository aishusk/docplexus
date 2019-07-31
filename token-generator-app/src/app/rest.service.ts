import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpClientJsonpModule } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { Customer } from './customer';
const proxyurl = "https://cors-anywhere.herokuapp.com/";
const customerEndpoint = 'http://localhost:8090/customer';
const tokenEndpoint = "http://localhost:8090/tokens";
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    
  })
};
@Injectable({
  providedIn: 'root'
})


export class RestService {

  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

getToken(id): Observable<any> {
  console.log(id);
  return this.http.post<any>(tokenEndpoint+"/createTokens/"+id,null,httpOptions).pipe(
    tap((t)=>console.log("token is generated for id"+id))
  )
}
addCustomer (customer): Observable<any> {
  console.log(customer);
  return this.http.post<Customer>(customerEndpoint + '/createCustomer', JSON.stringify(customer), httpOptions).pipe(
    tap((customer) => console.log(`added customer w/ id=${customer.custId}`))
    
  );
}

}