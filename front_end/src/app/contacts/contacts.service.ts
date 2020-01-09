import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ContactsService {

  userLists = [];

  constructor() { }

  getContactListNames() {
    const list = [];
    this.userLists.forEach(userList => {
      list.push(userList.name);
    });
    return list;
  }

  getContacts(listName) {
    const list = this.userLists.find(l => l.name === listName);
    return list.users;
  }

  addContact(listName, contact) {
    const lists = this.getContactListNames();
    const listIndex = lists.indexOf(listName)
    if (listIndex > -1) {
      this.userLists[listIndex].users.push(contact);
    } else {
      const newList = {
        name: listName,
        users: [contact]
      }
      this.userLists.push(newList);
    }
  }
}
