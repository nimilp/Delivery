import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AppComponent } from './main/app.component';
import { HomeComponent } from './home/home.component';
import { ItemListComponent } from './items/item-list.component';

export const routes: Routes = [
    {
        path: "login",
        component: LoginComponent
    },
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path:'category/:id',
        component: ItemListComponent
    }

];

