import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-token-screen-component',
  templateUrl: './token-screen-component.component.html',
  styleUrls: ['./token-screen-component.component.css']
})
export class TokenScreenComponentComponent implements OnInit {

  constructor(public rest:RestService, private route: ActivatedRoute, private router: Router) { }
  customerId: any;

  ngOnInit() {
  }

  open()
  {
   
      this.router.navigate(['/createCustomer']);
    
  
  }
  onClickSubmit(customerId:any)
  {
    console.log(customerId);
    this.rest.getToken(customerId).subscribe((result)=>
    console.log(result)
    )
  }

}
