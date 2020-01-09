import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ModuleWithProviders } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Template1Component } from 'projects/email/src/app/views/template1/template1.component';
import { CustomMaterialModule } from 'projects/email/src/app/custom-material/custom-material.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule } from '@angular/common/http';
import { EditorModule } from 'src/app/editor/editor.module';
import { PreviewTemplateComponent } from 'projects/email/src/app/views/preview-template/preview-template.component';


@NgModule({
  declarations: [
    AppComponent,
    Template1Component,
    PreviewTemplateComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    CustomMaterialModule,
    FlexLayoutModule,
    HttpClientModule,
    EditorModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [ AppComponent ]
})
export class AppModule { }

@NgModule({})
export class EmailSharedModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: AppModule,
      providers: []
    }
  }
}
