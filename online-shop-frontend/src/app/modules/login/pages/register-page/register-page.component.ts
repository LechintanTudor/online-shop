import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Actions } from '@ngrx/effects';
import { Store } from '@ngrx/store';
import { UserRegistration } from '../../data/user-registration';
import { registerAction } from '../../store/login.actions';

@Component({
  selector: 'register-page',
  templateUrl: './register-page.component.html',
})
export class RegisterPageComponent {
  constructor(
    private router: Router,
    private store: Store,
    private actions$: Actions,
  ) {}

  onRegisterFormSubmit(registration: UserRegistration): void {
    this.store.dispatch(registerAction({ registration }));
  }
}
