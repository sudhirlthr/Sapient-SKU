import { Component, OnInit, OnDestroy ,EventEmitter, Output} from '@angular/core';
import { ItemsOrders } from '../models/items-orders.model';
import {Subscription} from "rxjs/internal/Subscription";
import { EcommerceServiceService } from '../services/ecommerce-service.service';
import { ItemsOrder } from '../models/items-order.model';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.css']
})
export class ShoppingCartComponent implements OnInit, OnDestroy {

  orderFinished: boolean;
    orders: ItemsOrders;
    total: number;
    sub: Subscription;

    @Output() onOrderFinished: EventEmitter<boolean>;

    constructor(private ecommerceService: EcommerceServiceService) {
        this.total = 0;
        this.orderFinished = false;
        this.onOrderFinished = new EventEmitter<boolean>();
    }

    ngOnInit() {
        this.orders = new ItemsOrders();
        this.loadCart();
        this.loadTotal();
    }

    private calculateTotal(products: ItemsOrder[]): number {
        let sum = 0;
        products.forEach(value => {
            sum += (value.items.sale_price * value.quantity);
        });
        return sum;
    }

    ngOnDestroy() {
        this.sub.unsubscribe();
    }

    finishOrder() {
        this.orderFinished = true;
        this.ecommerceService.Total = this.total;
        this.onOrderFinished.emit(this.orderFinished);
    }

    loadTotal() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.total = this.calculateTotal(this.orders.itemsOrder);
        });
    }

    loadCart() {
        this.sub = this.ecommerceService.ProductOrderChanged.subscribe(() => {
            let productOrder = this.ecommerceService.SelectedProductOrder;
            if (productOrder) {
                this.orders.itemsOrder.push(new ItemsOrder(
                    productOrder.items, productOrder.quantity));
            }
            this.ecommerceService.ProductOrders = this.orders;
            this.orders = this.ecommerceService.ProductOrders;
            this.total = this.calculateTotal(this.orders.itemsOrder);
        });
    }

    reset() {
        this.orderFinished = false;
        this.orders = new ItemsOrders();
        this.orders.itemsOrder = []
        this.loadTotal();
        this.total = 0;
    }

}
