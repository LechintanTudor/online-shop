import { Subscription } from 'rxjs';
import { AfterViewInit, Component, OnDestroy, ViewChild } from '@angular/core';
import { Store } from '@ngrx/store';
import { LoginFormComponent } from '../../components/login-form/login-form.component';
import { UserCredentials } from '../../data/user-credentials';
import { loginAction } from '../../store/login.actions';
import { selectLastRegisteredCredentials } from '../../store/login.selectors';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
})
export class LoginPageComponent implements AfterViewInit, OnDestroy {
  @ViewChild('loginForm')
  loginForm!: LoginFormComponent;

  private credentialsSubscription = new Subscription();

  constructor(private store: Store) {}

  ngAfterViewInit(): void {
    this.credentialsSubscription = this.store
      .select(selectLastRegisteredCredentials)
      .subscribe((credentials) =>
        // I hate Angular change detection >:(
        setTimeout(() => this.loginForm.setCredentials(credentials), 0),
      );
  }

  ngOnDestroy(): void {
    this.credentialsSubscription.unsubscribe();
  }

  onRegisterFormSubmit(credentials: UserCredentials): void {
    this.store.dispatch(loginAction({ credentials }));
  }
}
