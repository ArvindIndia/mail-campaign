import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactsHomeComponent } from './contacts-home/contacts-home.component';
import { SelectContactsComponent } from './select-contacts/select-contacts.component';


const routes: Routes = [
  {
    path: '',
    component: ContactsHomeComponent
  },
  {
    path: 'select',
    component: SelectContactsComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ContactsRoutingModule { }
