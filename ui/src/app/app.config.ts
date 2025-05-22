import { ApplicationConfig, ErrorHandler, Provider, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';
import { routes } from './app.routes';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch } from '@angular/common/http';
import { ItemService } from './services/item-service';
import { ResponseInterceptor } from './interceptors/response-interceptor';
import { GlobalErrorHandler } from './handlers/global.error.handler';
import { ServerErrorInterceptor } from './interceptors/server-error.interceptor';

export const HttpInterceptorProviders = [
  { provide: ErrorHandler, useClass: GlobalErrorHandler },
  { provide: HTTP_INTERCEPTORS, useClass: ServerErrorInterceptor, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: ResponseInterceptor, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: ServerErrorInterceptor, multi: true },
]

export const appConfig: ApplicationConfig = {
  providers: [HttpInterceptorProviders, provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideHttpClient(
    withFetch(),
  ), ItemService]
};
