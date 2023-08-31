import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { UserRegistration } from '../../data/user-registration';
import { registerAction } from '../../store/login.actions';

@Component({
  selector: 'register-page',
  templateUrl: './register-page.component.html',
})
export class RegisterPageComponent {
  constructor(private store: Store) {}

  onRegisterFormSubmit(registration: UserRegistration): void {
    this.store.dispatch(registerAction({ registration }));
  }
}
