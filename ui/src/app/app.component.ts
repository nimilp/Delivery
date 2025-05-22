import { Component, CUSTOM_ELEMENTS_SCHEMA, inject, NO_ERRORS_SCHEMA } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule} from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListItem, MatListModule } from '@angular/material/list';
import { ItemService } from './services/item-service';
import { Item } from './models/item';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, MatToolbarModule, MatButtonModule, MatSidenavModule, MatIconModule, MatListModule, MatListItem, ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass',
  schemas: [CUSTOM_ELEMENTS_SCHEMA, NO_ERRORS_SCHEMA]
})
export class AppComponent {

  public items: Observable<Item[]>;
  constructor(private itemService: ItemService){
    
    this.items = itemService.getItems();
  //   itemService.getItems().subscribe((res: Item[])=>{
  //     console.log(res)
  //     this.items = res;
  //   })
  }
  appName = 'Demo Demo Demo';
  year = new Date().getFullYear();
}
