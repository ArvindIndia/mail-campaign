import { Injectable } from '@angular/core';
import { SectionProps } from 'src/app/editor/models/section-props';
import { Subject } from 'rxjs/internal/Subject';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class TemplatePlaceholdersService {

  public sections: Subject<SectionProps[]> = new Subject<SectionProps[]>();
  public index: Subject<any> = new Subject<any>();

  constructor() { }

  getSections(): Observable<SectionProps[]> {
    return this.sections.asObservable();
  }

  getIndex(): Observable<any> {
    return this.index.asObservable();
  }
}
