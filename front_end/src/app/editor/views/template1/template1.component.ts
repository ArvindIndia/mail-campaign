import { Component, OnInit, HostListener } from '@angular/core';
import { SectionProps } from 'src/app/editor/models/section-props';
import { TemplatePlaceholdersService } from 'src/app/editor/services/template-placeholders.service';

@Component({
  selector: 'app-template1',
  templateUrl: './template1.component.html',
  styleUrls: [ './template1.component.scss' ]
})
export class Template1Component implements OnInit {

  public sections: SectionProps[];
  public index: number;

  constructor(private templatePlaceholdersService: TemplatePlaceholdersService) {
    const sections = [
      {
        type: 'image',
        url: 'assets/img/ecart-logo.PNG',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'text',
        text: 'Lorem Ipsum is simply dummy text of the !!!!!',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'text',
        text: 'Small Text',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'text',
        text: 'Lorem Ipsum is simply a Date',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'text',
        text: 'Be ready with your wishlist!!',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'button',
        text: 'submit',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      },
      {
        type: 'button',
        text: 'submit',
        style: {
          fontSize: '',
          fontColor: '',
          backgroundColor: '',
          fontWeight: ''
        }
      }
    ]
    this.templatePlaceholdersService.getSections().subscribe(response => {
      this.sections = response;
    });
    this.templatePlaceholdersService.sections.next(sections);
    this.index = 0;
    this.templatePlaceholdersService.index.next(this.index);
  }

  ngOnInit() { }

  @HostListener('click', [ '$event' ])
  onClick(event): void {
    if (event.target.classList.contains('section')) {
      const idSplit = event.target.id.split('-');
      this.index = Number(idSplit[ 1 ]);
      this.templatePlaceholdersService.index.next(this.index);
    }
  }
}
