import { Component, OnInit, HostListener } from '@angular/core';
import { LookupService } from 'projects/email/src/app/services/lookup.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-template1',
  templateUrl: './template1.component.html',
  styleUrls: [ './template1.component.scss' ]
})
export class Template1Component implements OnInit {

  public sections: any[];
  public index: number;

  constructor(private lookupService: LookupService, private route: ActivatedRoute) {
    this.route.params.subscribe(response => {
      this.lookupService.getTemplate(response.id).then(response => {
        this.sections = JSON.parse(response[ 'sections' ]);
      }).catch(() => {
        try {
          const request = JSON.parse(localStorage.getItem('request'));
          this.sections = JSON.parse(request.sections)
        } catch (e) {
          /*STUB DATA IF NO API*/
          const sections = [
            {
              url: 'assets/img/ecart-logo.PNG',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'The Sale is LIVE !!!!!',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'Hi User',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'The sale starts on 24th December 8am.',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'Be ready with your wishlist!!',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'Subscribe',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            },
            {
              text: 'Unsubscribe',
              style: {
                fontSize: '',
                fontColor: '',
                backgroundColor: '',
                fontWeight: ''
              }
            }
          ];
          this.sections = sections;
        }
      })
    })
  }

  ngOnInit() {
  }

  @HostListener('click', [ '$event' ])
  onClick(event): void {
    if (event.target.classList.contains('section')) {
      const idSplit = event.target.id.split('-');
      this.index = Number(idSplit[ 1 ]);
    }
  }
}
