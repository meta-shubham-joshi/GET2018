import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Observable } from 'rxjs';
import { Users } from '../Users';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  users: Users;
  userFilter: any = {name:''};

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.getItem();
  }

  getItem(): any {
    return this.dataService.getUsers().subscribe(
      (promiseData: Users) => this.users = promiseData
    )
  }

}
