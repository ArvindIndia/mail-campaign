import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public username;
  private baseUrl = "http://localhost:4200/";

  constructor(private http: HttpClient) { }

  userLogin(request) {
    const url = this.getUri('user/');
    return this.http.get(url + request, this.getOptions()).toPromise();
  }

  private getHeaders(obj?: any): HttpHeaders {
      const headers = new HttpHeaders();
      headers.append('Content-Type', 'application/json');

      for (const h in obj || {}) {
          if (obj.hasOwnProperty(h)) {
              headers.append(h, obj[ h ]);
          }
      }
      return headers;
  }

  private getOptions() {
      const options = { headers: this.getHeaders(), withCredentials: true };
      return options;
  }

  private getUri(endpoint?: string): string {
      return this.baseUrl +  endpoint;
  }
}
