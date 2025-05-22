import { Component, inject, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule, MatTableDataSource } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { ActivatedRoute } from '@angular/router';
import { ItemService } from '../services/item-service';


@Component({
  selector: 'app-item-list',
  imports: [MatFormFieldModule, MatInputModule, MatTableModule],
  templateUrl: './item-list.component.html',
  styleUrl: './item-list.component.sass'
})
export class ItemListComponent implements OnInit {

  itemService = inject(ItemService);
  displayedColumns: string[] = ['position', 'name', 'Description', 'symbol'];
  data =new MatTableDataSource([
    {id:1,name:"hi"},
    {id:2,name:"hiT"},
    {id:3,name:"hiV"},
    {id:4,name:"hiS"},
  ]);
  categoryId: string | null = '';
  constructor(private activeRout: ActivatedRoute) {

  }
  ngOnInit(): void {
    this.categoryId = this.activeRout.snapshot.paramMap.get('id');
    // data = this.itemService.getItems();
    this.activeRout.paramMap.subscribe(params => {
      this.categoryId = params.get('id');
    })
  }

  
  applyFilter(event: Event) {

  }
}
