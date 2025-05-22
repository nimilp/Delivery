import { Injectable, NgZone } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { MatSnackBar } from "@angular/material/snack-bar";
import { ErrorHandlerDialogComponent } from "../dialogs/error/error.component";

@Injectable({
    providedIn: 'root'
})
export class NotificationService {

    constructor(
        private snackBar: MatSnackBar,
        private dialog: MatDialog,
        private zone: NgZone
    ) { }

    showClientErrorMessage(message: string): void {
        this.zone.run(() => {
            this.snackBar.open('Error: ' + { message }, 'Okay', {
                panelClass: ['error-snack']
            });
        });
    }

    openServerErrorDialog(message: string) {
        this.zone.run(() => {
            this.dialog.open(ErrorHandlerDialogComponent, {
                data: { message },
            });
        });
    }

    showNonErrorSnackBar(message: string, duration = 6000) {
        this.snackBar.open(message, 'Okay', {
            panelClass: ['non-error-snack'],
            duration,
        });
    }
}