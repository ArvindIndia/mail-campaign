import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class TemplateService {

  private baseUrl = "http://localhost:8200/";

  constructor(private http: HttpClient) {

  }

  saveTemplate(request) {
    const url = this.getUri('emails/addTemplate');

    return this.http
      .post(url, request, this.getOptions())
      .toPromise();
  }

  getTemplate(request) {
    const url = this.getUri('emails/getTemplate/');

    this.http
      .get(url + request, this.getOptions())
      .toPromise().then(response => {
        console.log('json output ', response)
      })
  }

  generateTemplate() {
    const url = "http://localhost:3000/email";
    return this.http
      .get(url)
      .toPromise();
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
    return this.baseUrl + endpoint;
  }

}
