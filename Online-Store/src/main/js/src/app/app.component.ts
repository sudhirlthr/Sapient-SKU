import { Component } from '@angular/core';
import { EcommerceServiceService } from './ecommerce/services/ecommerce-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers:[EcommerceServiceService]
})
export class AppComponent {
  title = 'js';
}
