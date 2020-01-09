import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
    providedIn: 'root'
})
export class LookupService {

    private baseUrl = "http://localhost:8200/";

    constructor(private http: HttpClient) {

    }

    getTemplate(request) {
        const url = this.getUri('emails/getTemplate/');

        return this.http
            .get(url + request, this.getOptions())
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
        return this.baseUrl +  endpoint;
    }

}
