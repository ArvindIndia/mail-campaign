import { Component, OnInit } from '@angular/core';
import { TemplatePlaceholdersService } from 'src/app/editor/services/template-placeholders.service';
import { SectionProps } from 'src/app/editor/models/section-props';
import { TemplateService } from '../services/template.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: [ './editor.component.scss' ]
})
export class EditorComponent implements OnInit {

  public i: number;
  public sections: SectionProps[];
  public fontSize: string[];
  public textAlign: string[];
  public fontWeight: string[];
  public fileData: File = null;
  public uploadedFilePath: string = null;
  private previewUrl: string;
  public campaignName: string;
  public mailSubject: string;
  public listArray;
  public listName: string;

  constructor(private templatePlaceholdersService: TemplatePlaceholdersService, private templateService: TemplateService,
    private router: Router) {
    this.i = 0;
      this.templateService.getTemplate(22).then(response => {
        this.sections = JSON.parse(response['sections']);
    });
    //this.templatePlaceholdersService.getIndex().subscribe(response => {
     // this.i = response;
    //});
    this.fontSize = [ '10px', '11px', '12px', '25px', '40px' ];
    this.textAlign = [ 'left', 'right', 'center' ];
    this.fontWeight = [ '400', '500', '600', '800' ];
    this.templateService.getList().then(response => {
      console.log(response);
      this.listArray = response;
    });
  }

  ngOnInit() {
    const designView = this.router.url.split('/').indexOf('design') !== -1;
    this.previewUrl = designView ? "/editor/preview/" : "/preview/email/template1/";
  }

  submit() {
    const request = {
      templateName: 'base',
      sections: JSON.stringify(this.sections),
      userName: 'saran'
    }
    this.templateService.saveTemplate(request).then(response => {
      this.router.navigate([ this.previewUrl + response[ 'templateId' ] ]);
    }).catch(() => {
      localStorage.setItem('request', JSON.stringify(request));
      this.router.navigate([ this.previewUrl + '0' ]);
    });
  }

  sendmail() {
    const request = {
      campaignName: this.campaignName,
      mailSubject: this.mailSubject,
      listName: this.listName,
      createdBy: 'arvind'
    }
    this.templateService.sendMail(request).then(response => {
      this.router.navigate([ this.previewUrl + response[ 'templateId' ] ]);
    }).catch(() => {
      localStorage.setItem('request', JSON.stringify(request));
      this.router.navigate([ this.previewUrl + '0' ]);
    });
  }

  preview() {
    const request = {
      templateName: 'base',
      sections: JSON.stringify(this.sections),
      userName: 'saran'
    }
    this.templateService.saveTemplate(request).then(response => {
      this.router.navigate([ this.previewUrl + response[ 'templateId' ] ]);
    }).catch(() => {
      localStorage.setItem('request', JSON.stringify(request));
      this.router.navigate([ this.previewUrl + '0' ]);
    });
  }

  fileProgress(fileInput: any) {
    this.fileData = <File> fileInput.target.files[ 0 ];
    this.previewFile();
  }

  previewFile() {
    // Show preview 
    var mimeType = this.fileData.type;
    if (mimeType.match(/image\/*/) == null) {
      return;
    }

    var reader = new FileReader();
    reader.readAsDataURL(this.fileData);
    reader.onload = (_event) => {
      this.sections[ this.i ].url = reader.result;
    }
  }
}
