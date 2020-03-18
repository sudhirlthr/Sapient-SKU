import { Injectable } from '@angular/core';
import { ItemsOrder } from '../models/items-order.model';
import { ItemsOrders } from '../models/items-orders.model';
import {Subject} from "rxjs/internal/Subject";
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EcommerceServiceService {

  private productsUrl = "/api/items";
    private ordersUrl = "/api/orders";

    private productOrder: ItemsOrder;
    private orders: ItemsOrders = new ItemsOrders();

    private productOrderSubject = new Subject();
    private ordersSubject = new Subject();
    private totalSubject = new Subject();

    private total: number;

    ProductOrderChanged = this.productOrderSubject.asObservable();
    OrdersChanged = this.ordersSubject.asObservable();
    TotalChanged = this.totalSubject.asObservable();

    constructor(private http: HttpClient) {
    }

    getAllProducts() {
        return this.http.get(this.productsUrl);
    }

    saveOrder(order: ItemsOrders) {
        return this.http.post(this.ordersUrl, order);
    }

    set SelectedProductOrder(value: ItemsOrder) {
        this.productOrder = value;
        this.productOrderSubject.next();
    }

    get SelectedProductOrder() {
        return this.productOrder;
    }

    set ProductOrders(value: ItemsOrders) {
        this.orders = value;
        this.ordersSubject.next();
    }

    get ProductOrders() {
        return this.orders;
    }

    get Total() {
        return this.total;
    }

    set Total(value: number) {
        this.total = value;
        this.totalSubject.next();
    }
}
