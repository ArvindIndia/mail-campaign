import { Component, OnInit } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';

import { ContactsService } from '../contacts.service';

@Component({
  selector: 'app-add-contacts',
  templateUrl: './add-contacts.component.html',
  styleUrls: ['./add-contacts.component.scss']
})
export class AddContactsComponent implements OnInit {

  public firstName: string;
  public lastName: string;
  public email: string;
  public listName: string;
  public newListName: string;
  public contactLists;

  constructor(
    public dialogRef: MatDialogRef<AddContactsComponent>,
    private contactsService: ContactsService
  ) { }

  ngOnInit() {
    this.contactLists = this.contactsService.getContactListNames();
  }

  onAddContact() {
    const contact = {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email
    };
    const list = this.newListName ? this.newListName : this.listName;
    this.contactsService.addContact(list, contact);
    this.dialogRef.close();
  }

}
