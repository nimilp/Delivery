import { inject, Injectable } from "@angular/core";
import { Item } from "../models/item";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ItemService {

    private readonly http: HttpClient = inject(HttpClient);
    private getItemUrl = '/api/items'
    public getItems(): Observable<Item[]> {
        console.log("in Get Items")
        return this.http.get<Item[]>(this.getItemUrl);
    }
    // httpClient = inject(HttpClient);

    // private items = Observable<Item[]>;
    // getItem = '/api/items'

    // public getItems(): Item[] {

    //     return this.httpClient.get(this.getItem);

    // }
}