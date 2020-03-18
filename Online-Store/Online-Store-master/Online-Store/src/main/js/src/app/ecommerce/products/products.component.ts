import { Component, OnInit } from '@angular/core';
import { ItemsOrder } from '../models/items-order.model';
import { Items } from '../models/items.model';
import { ItemsOrders } from '../models/items-orders.model';
import { EcommerceServiceService } from '../services/ecommerce-service.service';
import {Subscription} from "rxjs/internal/Subscription";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productOrders: ItemsOrder[] = [];
    products: Items[] = [];
    selectedProductOrder: ItemsOrder;
    private shoppingCartOrders: ItemsOrders;
    sub: Subscription;
    productSelected: boolean = false;

    constructor(private ecommerceService: EcommerceServiceService) {
    }

    ngOnInit() {
        this.productOrders = [];
        this.loadProducts();
        this.loadOrders();
    }

    addToCart(order: ItemsOrder) {
        this.ecommerceService.SelectedProductOrder = order;
        this.selectedProductOrder = this.ecommerceService.SelectedProductOrder;
        this.productSelected = true;
    }

    removeFromCart(productOrder: ItemsOrder) {
        let index = this.getProductIndex(productOrder.items);
        if (index > -1) {
            this.shoppingCartOrders.itemsOrder.splice(
                this.getProductIndex(productOrder.items), 1);
        }
        this.ecommerceService.ProductOrders = this.shoppingCartOrders;
        this.shoppingCartOrders = this.ecommerceService.ProductOrders;
        this.productSelected = false;
    }

    getProductIndex(product: Items): number {
        return this.ecommerceService.ProductOrders.itemsOrder.findIndex(
            value => value.items === product);
    }

    isProductSelected(product: Items): boolean {
        return this.getProductIndex(product) > -1;
    }

    loadProducts() {
        this.ecommerceService.getAllProducts()
            .subscribe(
                (products: any[]) => {
                    this.products = products;
                    this.products.forEach(product => {
                        this.productOrders.push(new ItemsOrder(product, 0));
                        console.log(this.products.length);
                    })
                },
                (error) => console.log(error)
            );
    }

    loadOrders() {
        this.sub = this.ecommerceService.OrdersChanged.subscribe(() => {
            this.shoppingCartOrders = this.ecommerceService.ProductOrders;
        });
    }

    reset() {
        this.productOrders = [];
        this.loadProducts();
        this.ecommerceService.ProductOrders.itemsOrder = [];
        this.loadOrders();
        this.productSelected = false;
    }

}
