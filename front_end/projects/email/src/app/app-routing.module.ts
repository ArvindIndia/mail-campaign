import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Template1Component } from 'projects/email/src/app/views/template1/template1.component';
import { PreviewTemplateComponent } from 'projects/email/src/app/views/preview-template/preview-template.component';


const routes: Routes = [
  { path: 'email/template1/:id', component: Template1Component },
  { path: 'email/preview/:id', component: PreviewTemplateComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
