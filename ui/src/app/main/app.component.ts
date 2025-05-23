import { AfterViewInit, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListItem, MatListModule } from '@angular/material/list';
import { ItemService } from '../services/item-service';
import { Item } from '../models/item';
import { Observable } from 'rxjs';
import { MatDialogModule } from '@angular/material/dialog';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatListItem ,MatDialogModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass',
})
export class AppComponent{

  appName = 'Demo Demo Demo';
  year = new Date().getFullYear();
  items!: Observable<Item[]>;//= new Observable<Item[]>();
  constructor(private itemService: ItemService) {

    this.items = itemService.getCategories();
    // cdr.detectChanges();
  }

  // ngOnInit(): void {

  //   this.items = this.itemService.getCategories();
  //   this.cdr.detectChanges();
  //   console.debug('Page Loaded')
  //   // throw new Error('Method not implemented.');
  // }
  
}
