// import { Component, Inject } from "@angular/core";
// import { MAT_DIALOG_DATA, MatDialogModule } from "@angular/material/dialog";
// import {MatButtonModule} from '@angular/material/button';
// import { MatIcon } from "@angular/material/icon";

// @Component({
//     selector: 'error-handler-dialog',
//     templateUrl: './global.error.handler.html',
//     styleUrl: './global.error.handler.sass',
//     imports:[ MatIcon, MatDialogModule ],
//     standalone:true
// })
// export class ErrorHandlerDialogComponent {
// public title = 'Network Error';
// constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}   
// }

import {ChangeDetectionStrategy, Component, Inject, inject} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import { MatIcon } from "@angular/material/icon";
import {
  MatDialog,
  MatDialogActions,
  MatDialogClose,
  MatDialogContent,
  MatDialogTitle,
  MAT_DIALOG_DATA
} from '@angular/material/dialog';

/**
 * @title Dialog elements
 */
@Component({
  selector: 'error-handler-dialog',
  templateUrl: './global.error.handler.html',
  styleUrl: './global.error.handler.sass',
  imports: [MatButtonModule, MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatIcon],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
// export class DialogElementsExample {
//   readonly dialog = inject(MatDialog);

//   openDialog() {
//     this.dialog.open(ErrorHandlerDialogComponent);
//   }
// }

// @Component({
//   selector: 'dialog-elements-example-dialog',
//   templateUrl: 'dialog-elements-example-dialog.html',
//   imports: [MatDialogTitle, MatDialogContent, MatDialogActions, MatDialogClose, MatButtonModule],
//   changeDetection: ChangeDetectionStrategy.OnPush,
// })
export class ErrorHandlerDialogComponent {
    public title = 'Network Error';
    constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}   
}