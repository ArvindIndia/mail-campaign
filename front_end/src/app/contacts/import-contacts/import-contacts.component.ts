import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

import * as XLSX from 'xlsx';
import { ContactsService } from '../contacts.service';

@Component({
  selector: 'app-import-contacts',
  templateUrl: './import-contacts.component.html',
  styleUrls: ['./import-contacts.component.scss']
})
export class ImportContactsComponent implements OnInit {

  public listName: string;
  public showMessage: boolean;
  public userData: FormGroup;

  constructor(
    private contactsService: ContactsService,
    public dialogRef: MatDialogRef<ImportContactsComponent>
    ) { }

  ngOnInit() {
  }

  onFileChange(ev) {
    let workBook = null;
    let users = null;
    const reader = new FileReader();
    const file = ev.target.files[0];
    reader.onload = (event) => {
      const data = reader.result;
      workBook = XLSX.read(data, { type: 'binary' });
      users = workBook.SheetNames.reduce((initial, name) => {
        const sheet = workBook.Sheets[name];
        initial[name] = XLSX.utils.sheet_to_json(sheet);
        return initial;
      }, {});
      users = users.Sheet1;
      const newList = {
        name: this.listName,
        users: users
      };
      this.contactsService.userLists.push(newList);
      this.showMessage = true;
      setTimeout(() => {
        this.showMessage = false;
        this.listName = '';
        this.dialogRef.close();
      }, 2000);
    }
    reader.readAsBinaryString(file);
  }

}
