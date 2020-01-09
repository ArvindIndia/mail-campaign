import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';

import { ContactsService } from '../contacts.service';
import { AddContactsComponent } from '../add-contacts/add-contacts.component';
import { ImportContactsComponent } from '../import-contacts/import-contacts.component';

@Component({
  selector: 'app-contacts-home',
  templateUrl: './contacts-home.component.html',
  styleUrls: ['./contacts-home.component.scss']
})
export class ContactsHomeComponent implements OnInit {

  contactLists = [];
  public contacts = [];
  displayedColumns: string[] = ['firstName', 'lastName', 'email'];
  selectedList = '';

  constructor(
    private contactsService: ContactsService,
    public dialog: MatDialog
    ) { }

  ngOnInit() {
    this.contactLists = this.contactsService.getContactListNames();
    this.contacts = this.contactsService.userLists[0] ? this.contactsService.userLists[0].users : [];
    this.selectedList = this.contactsService.userLists[0] ? this.contactsService.userLists[0].name : '';
  }

  onAddContacts() {
    const dialogRef = this.dialog.open(AddContactsComponent, {
      width: '600px'
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  onImportContacts() {
    const dialogRef = this.dialog.open(ImportContactsComponent, {
      width: '600px'
    });

    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });
  }

  updateUserList(){
    this.contacts = this.contactsService.getContacts(this.selectedList);
  }

}
