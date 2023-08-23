import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Credentials } from '../data/credentials';
import { LoginResponse } from '../data/login-response';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  constructor(private http: HttpClient) {}

  login(credentials: Credentials): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(
      `${environment.apiUrl}/login`,
      credentials,
    );
  }
}
