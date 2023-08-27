import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../data/user';
import { UserRegistration } from '../data/user-registration';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  register(registration: UserRegistration): Observable<User> {
    return this.http.post<User>(`${environment.apiUrl}/register`, registration);
  }
}
