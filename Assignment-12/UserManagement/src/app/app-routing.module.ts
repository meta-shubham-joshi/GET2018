import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersListComponent } from './users-list/users-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { CanActivate } from '@angular/router/src/utils/preactivation';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {
    path: '',
    component: UsersListComponent
  },
  {
    path: 'addUser',
    component: AddUserComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'addUser/:id',
    component: AddUserComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'pageNotFound',
    component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
