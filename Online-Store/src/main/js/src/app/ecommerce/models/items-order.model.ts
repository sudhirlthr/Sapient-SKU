import {Items} from "./items.model"

export class ItemsOrder {
    items:Items;
    quantity:number;
    constructor(items:Items,quantity:number ){
        this.items = items;
        this.quantity = quantity;
    }
}
