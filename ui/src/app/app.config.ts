import { ApplicationConfig, Provider, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch } from '@angular/common/http';
import { ItemService } from './services/item-service';
import { ResponseInterceptor } from './interceptors/response-interceptor';

export const HttpInterceptorProvider: Provider =
  { provide: HTTP_INTERCEPTORS, useClass: ResponseInterceptor, multi: true };
  
export const appConfig: ApplicationConfig = {
  providers: [HttpInterceptorProvider, provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes), provideHttpClient(
    // withFetch(),
  ), ItemService ]
};
