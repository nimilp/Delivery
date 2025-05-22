import { ChangeDetectionStrategy, Component, inject, } from '@angular/core';
// import { RouterOutlet } from '@angular/router';
import { FormGroup, FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { AuthService } from '../services/auth.service';
import { ItemService } from '../services/item-service';
import { Item } from '../models/item';


@Component({
    selector: 'login-page',
    imports: [ ReactiveFormsModule, MatCardModule, MatButtonModule, MatInputModule],
    templateUrl: 'login.component.html',
    styleUrl: 'login.component.sass',
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class LoginComponent {
    
    authService = inject(AuthService);
    
    loginForm: FormGroup = new FormGroup({
        username:  new FormControl(''),
        password: new FormControl('')
    })
    
    getUsername(){
        return this.loginForm.get('username')
    }
    getPassword() {
        return this.loginForm.get('password')
    }

    signIn(){
        this.authService.authenticate(this.getUsername()?.value, this.getPassword()?.value)
    }
}