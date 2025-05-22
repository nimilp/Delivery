import { HttpErrorResponse } from "@angular/common/http";
import { ErrorHandler, inject, Injectable, Injector } from "@angular/core";
import { NotificationService } from "../services/notification.service";

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {

    constructor(private injector: Injector) {}

  handleError(error: Error | HttpErrorResponse) {
    // const notifier = inject(NotificationService);
    const notifier = this.injector.get(NotificationService);
    let message: string;
    if (error instanceof HttpErrorResponse) {
      // Serve error
      notifier.openServerErrorDialog(error.message);
    } else {
      // client error
      message = error.message ? error.message : error.toString();
      notifier.showClientErrorMessage(message);
    }
    // log every error to the console
    console.error(error.message);
  }
}