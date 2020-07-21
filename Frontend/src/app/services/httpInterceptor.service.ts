import { HttpHeaders, HttpClient, HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';



@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>,
              next: HttpHandler): Observable<HttpEvent<any>> {


                console.log("USAAAOOO JE NEMANJA");

        const jwt = localStorage.getItem("jwt");

        const xsrfToken=localStorage.getItem("xsrfToken");

        console.log("Tokencic je ovaj=="+jwt);



      

        if (jwt) {
            const cloned = req.clone({
                headers: req.headers.set("Authorization",
                      jwt)
                      .set('X-XSRF-TOKEN', xsrfToken)
            });
            console.log("Pogodi prvi if!")

            return next.handle(cloned);
        }
        else if(xsrfToken){
            const cloned = req.clone({
                headers: req.headers
                      .set('X-XSRF-TOKEN', xsrfToken)
            });
            console.log("Pogodi DRUGI IF");
            return next.handle(cloned);
        }
        else {
            return next.handle(req);
        }
        
/*
        if(xsrfToken && idToken){
            const headers = new HttpHeaders({
                'Authorization': idToken,
                'X-XSRF-TOKEN':  xsrfToken
              });
          const cloneReq = req.clone({headers});
          
              return next.handle(cloneReq);
        }
        else if(xsrfToken){
            const headers = new HttpHeaders({
                'X-XSRF-TOKEN':  xsrfToken
              });
          const cloneReq = req.clone({headers});
          
              return next.handle(cloneReq);

        }
        else {
            return next.handle(req);
        }

        */
    }
}
      