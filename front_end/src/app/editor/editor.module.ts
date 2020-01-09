import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EditorComponent } from './editor/editor.component';
import { EditorRoutingModule } from 'src/app/editor/editor-routing.module';
import { FormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { Template1Component } from './views/template1/template1.component';
import { CustomMaterialModule } from '../custom-material/custom-material.module';
import { ColorPickerModule } from 'ngx-color-picker';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { DesignComponent } from './design/design.component';
import { ImageComponent } from './design/components/image/image.component';
import { TextComponent } from './design/components/text/text.component';
import { ButtonComponent } from './design/components/button/button.component';
import { DynamicElementDirective } from './design/components/dynamic-element/dynamic-element.directive';
import { PreviewComponent } from './preview/preview.component';
import { FilterRowPipe } from './pipes/filter-row.pipe';

@NgModule({
  declarations: [
    EditorComponent,
    Template1Component,
    DesignComponent,
    ImageComponent,
    TextComponent,
    ButtonComponent,
    DynamicElementDirective,
    PreviewComponent,
    FilterRowPipe
  ],
  imports: [
    CommonModule,
    FormsModule,
    FlexLayoutModule,
    CustomMaterialModule,
    ColorPickerModule,
    AngularFontAwesomeModule,
    EditorRoutingModule
  ],
  entryComponents: [
    ImageComponent,
    TextComponent,
    ButtonComponent
  ],
  exports: [
    PreviewComponent
  ]
})
export class EditorModule { }
