import { Component, OnInit, HostListener } from '@angular/core';
import { SectionProps } from 'src/app/editor/models/section-props';
import { TemplateService } from 'src/app/editor/services/template.service';
import { TemplatePlaceholdersService } from 'src/app/editor/services/template-placeholders.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-template1',
  templateUrl: './template1.component.html',
  styleUrls: [ './template1.component.scss' ]
})
export class Template1Component implements OnInit {

  public sections: SectionProps[];
  public index: number;

  constructor(private templatePlaceholdersService: TemplatePlaceholdersService, 
    private templateService: TemplateService, private route: ActivatedRoute) {
            
    //const sections = [{"type":"image","url":"assets/img/makeathon-logo.PNG","style":{"fontSize":"","fontColor":"","backgroundColor":"#bfbfbf","fontWeight":""}},{"type":"text","text":"Welcome to STG Makeathon !!!","style":{"fontSize":"25px","fontColor":"#191750","backgroundColor":"","fontWeight":"600"}},{"type":"text","text":"Hello @@firstName@@ @@lastName@@","style":{"fontSize":"12px","fontColor":"","backgroundColor":"","fontWeight":"600"}},{"type":"text","text":"Gear up with your programming skills.","style":{"fontSize":"11px","fontColor":"","backgroundColor":"","fontWeight":"600"}},{"type":"text","text":"Be ready with your ideas !!","style":{"fontSize":"11px","fontColor":"","backgroundColor":"","fontWeight":"600"}},{"type":"button","text":"Subscribe","style":{"fontSize":"","fontColor":"","backgroundColor":"","fontWeight":""},"link":"http://localhost:4200/emails/subscribe/@@messageId@@/Y"},{"type":"button","text":"Unsubscribe","style":{"fontSize":"","fontColor":"","backgroundColor":"","fontWeight":""},"link":"http://localhost:4200/emails/subscribe/@@messageId@@/N"}]
    /*this.templatePlaceholdersService.getSections().subscribe(response => {
      this.sections = response;
    });*/
    //this.index = 0;
    //this.templatePlaceholdersService.index.next(this.index);
  }

  ngOnInit() {
        this.route.params.subscribe(response => {
          this.templateService.getTemplate(22).then(response => {
            this.sections = JSON.parse(response['sections']);
            console.log(this.sections);
          }).catch(() => { 
          this.sections = [
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
      })  });
      this.templatePlaceholdersService.sections.next(this.sections);
   }

  @HostListener('click', [ '$event' ])
  onClick(event): void {
    if (event.target.classList.contains('section')) {
      const idSplit = event.target.id.split('-');
      this.index = Number(idSplit[ 1 ]);
      this.templatePlaceholdersService.index.next(this.index);
    }
  }
}
