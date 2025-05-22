import { Component, inject, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../services/item-service';
import { Item } from '../models/item';


@Component({
  selector: 'app-item-list',
  imports: [MatFormFieldModule, MatInputModule, MatTableModule],
  templateUrl: './item-list.component.html',
  styleUrl: './item-list.component.sass'
})
export class ItemListComponent implements OnInit {

  itemService = inject(ItemService);
  items: Item[] = [];
  parent: Item = {
    _id: '',
    id: '',
    name: '',
    otherName: '',
    description: '',
    parentId: ''
  };
  displayedColumns: string[] = ['id', 'name','Other Name', 'Description'];
  categoryId :string|null= '';
  constructor(private activeRout: ActivatedRoute) {

  }
  ngOnInit(): void {
    this.categoryId = this.activeRout.snapshot.paramMap.get('id');
    // data = this.itemService.getItems();
    this.activeRout.paramMap.subscribe(params => {
      this.categoryId = params.get('id');
    })

    this.itemService.getItems(this.categoryId ||'').subscribe((res: Item[])=> {
      console.log(res)
      this.items = res;
    })

    this.itemService.getParent(this.categoryId ||'').subscribe((res: Item)=> {
      console.log(res)
      this.parent = res;
    })
  }

  
  applyFilter(event: Event) {

  }
}
