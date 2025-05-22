import { Component, Inject } from "@angular/core";
import { MAT_DIALOG_DATA, MatDialogModule } from "@angular/material/dialog";
import { MatIcon } from "@angular/material/icon";

@Component({
    selector: 'error-handler-dialog',
    templateUrl: './global.error.handler.html',
    styleUrl: './global.error.handler.sass',
    imports:[ MatIcon, MatDialogModule ],
    standalone:true
})
export class ErrorHandlerDialogComponent {
public title = 'Network Error';
constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}   
}