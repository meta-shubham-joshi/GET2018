import { Component, OnInit, Input } from '@angular/core';
import { DataService } from '../data.service';
import { Users } from '../Users';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user = new Users();
  userId: number;

  constructor(private dataService: DataService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.userId = this.route.snapshot.params.id;
    if (this.userId != 0 || this.userId != undefined){
      this.dataService.getUserById(this.userId).subscribe(response => this.user = response);
    }
  }

  decideChoice(userForm: NgForm): void {
    this.userId = this.route.snapshot.params.id;
    if (this.userId == 0 || this.userId == undefined) {
      this.addUser(userForm);
    }else{
      this.editUser(this.user, this.userId);
    }
  }

  addUser(userForm: NgForm): void {
    this.user.name = userForm.value.username;
    this.user.phone = userForm.value.userphone;
    this.user.city = userForm.value.usercity;
    this.dataService.addUser(this.user).subscribe();
    this.router.navigate(['']);
  }

  editUser(user: Users, userId: number){
    this.dataService.editUser(user, userId).subscribe();
    this.router.navigate(['']);
  }

}
