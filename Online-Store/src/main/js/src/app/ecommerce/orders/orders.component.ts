import { Component, OnInit } from '@angular/core';
import { ItemsOrders } from '../models/items-orders.model';
import {Subscription} from "rxjs/internal/Subscription";
import { EcommerceServiceService } from '../services/ecommerce-service.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: ItemsOrders;
    total: number;
    paid: boolean;
    sub: Subscription;

    constructor(private ecommerceService: EcommerceServiceService) {
        this.orders = this.ecommerceService.ProductOrders;
    }

    ngOnInit() {
        this.paid = false;
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.orders = this.ecommerceService.ProductOrders;
        });
        this.loadTotal();
    }

    pay() {
        this.paid = true;
        console.log("ordes : "+this.orders);
        this.ecommerceService.saveOrder(this.orders).subscribe();
    }

    loadTotal() {
        this.sub = this.ecommerceService.TotalChanged.subscribe(() => {
            this.total = this.ecommerceService.Total;
        });
    }

}
