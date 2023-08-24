import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { Credentials } from '../../data/credentials';
import { loginAction } from '../../store/login.actions';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
})
export class LoginPageComponent {
  constructor(private store: Store) {}

  onSubmit(credentials: Credentials): void {
    this.store.dispatch(loginAction({ credentials }));
  }
}
