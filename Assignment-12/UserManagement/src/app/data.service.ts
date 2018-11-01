import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import { Users } from './Users';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DataService {

  _url='http://localhost:3000/users';
  
  constructor(private http: HttpClient) { }

  getUsers():Observable<Users>{
    return this.http.get<Users>(this._url);
  }

  getUserById(userId):Observable<Users>{
    return this.http.get<Users>(this._url+'/'+userId);
  }

  addUser(user: Users): Observable<Users>{
    return this.http.post<Users>(this._url, user, httpOptions);
  }

  editUser(user: Users, userId): Observable<Users>{
    return this.http.put<Users>(this._url+'/'+userId, user, httpOptions)
  }

  // updateUser(user: Users): Observable<Users>{
  //   return this.http.put<Users>(this._url, user, httpOptions);
  // }

}
