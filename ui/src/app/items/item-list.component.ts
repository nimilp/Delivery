import { Component, inject, OnInit, ViewChild } from '@angular/core';
import {MatPaginator, MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../services/item-service';
import { Item } from '../models/item';

export interface ItemData {
  id: string;
  name: string;
  otherName: string;
  description: string;
}
@Component({
  selector: 'app-item-list',
  imports: [MatFormFieldModule, MatInputModule, MatTableModule, MatSortModule, MatPaginatorModule],
  templateUrl: './item-list.component.html',
  styleUrl: './item-list.component.sass'
})
export class ItemListComponent implements OnInit {

  itemService = inject(ItemService);
  items: ItemData[] = [];
  parent!: ItemData;
  displayedColumns: string[] = ['id', 'name','otherName','description'];
  categoryId :string|null= '';
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;
  constructor(private activeRout: ActivatedRoute) {

  }
  itemsData = new MatTableDataSource<ItemData>();
  ngOnInit(): void {
    this.categoryId = this.activeRout.snapshot.paramMap.get('id');
    // data = this.itemService.getItems();
    this.activeRout.paramMap.subscribe(params => {
      this.categoryId = params.get('id');
    })

    this.itemService.getItems(this.categoryId ||'').subscribe((res: Item[])=> {
      console.log(res)
      this.items = res;
      this.itemsData.data = res;
      this.itemsData.paginator = this.paginator;
      this.itemsData.sort = this.sort;
      
    })

    this.itemService.getParent(this.categoryId ||'').subscribe((res: Item)=> {
      this.parent = res;
    })
  }

  
  applyFilter(event: Event) {
    const searchText = (event.currentTarget as HTMLInputElement).value;
    this.itemsData.filter = searchText.trim().toLocaleLowerCase();
  }
}
