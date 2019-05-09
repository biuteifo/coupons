import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EnsureHostInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // clone request and replace 'http://' with 'https://' at the same time
    const host = (req.url.indexOf('http') > -1 || req.url.indexOf('https') > -1) ? req.url : environment.apiUrl + req.url;
    const secureReq = req.clone({url: host});
    // send the cloned, "secure" request to the next handler.
    return next.handle(secureReq);
  }
}
