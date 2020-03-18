export class Items {
    id: number;
    name: string;
    // tslint:disable-next-line: variable-name
    model_no: string;
    mrp: number;
    discount: number;
    // tslint:disable-next-line: variable-name
    sale_price: number;
    available:boolean;
    pictureUrl: string;



    constructor(id: number, name: string, model_no: string, mrp: number,discount: number,sale_price: number,available:boolean, pictureUrl: string) {
        this.id = id;
        this.name = name;
        this.model_no = model_no;
        this.mrp = mrp;
        this.discount = discount;
        this.sale_price = sale_price;
        this.available = available;
        this.pictureUrl = pictureUrl;
    }
}
