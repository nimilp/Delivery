import { inject, Injectable } from "@angular/core";
import { Item } from "../models/item";
import { Observable } from "rxjs";
import { HttpClient } from "@angular/common/http";

@Injectable()
export class ItemService {

    private readonly http: HttpClient = inject(HttpClient);
    private getItemUrl = '/api/items'
    public getCategories(): Observable<Item[]> {
        console.log("in Get Categories")
        return this.http.get<Item[]>(this.getItemUrl);
    }

    public getItems(id: string): Observable<Item[]> {
        console.log("in Get Items")
        return this.http.get<Item[]>(this.getItemUrl+"/"+id);
    }
    
    public getParent(id: string): Observable<Item> {
        console.log("in Get Category")
        return this.http.get<Item>(this.getItemUrl+"/parent/"+id);
    }
}