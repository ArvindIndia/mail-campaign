import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { ContactsRoutingModule } from './contacts-routing.module';
import { ContactsHomeComponent } from './contacts-home/contacts-home.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { CustomMaterialModule } from 'projects/email/src/app/custom-material/custom-material.module';
import { AddContactsComponent } from './add-contacts/add-contacts.component';
import { ImportContactsComponent } from './import-contacts/import-contacts.component';
import { SelectContactsComponent } from './select-contacts/select-contacts.component';


@NgModule({
  declarations: [
    ContactsHomeComponent,
    AddContactsComponent,
    ImportContactsComponent,
    SelectContactsComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    CustomMaterialModule,
    ContactsRoutingModule
  ],
  entryComponents: [
    AddContactsComponent,
    ImportContactsComponent
  ]
})
export class ContactsModule { }
