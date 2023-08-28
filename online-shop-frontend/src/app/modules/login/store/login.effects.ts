import { catchError, exhaustMap, map, of, tap } from 'rxjs';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import {
  loginAction,
  loginErrorAction,
  loginSuccessAction,
  registerAction,
  registerErrorAction,
  registerSuccessAction,
} from './login.actions';

@Injectable()
export class LoginEffects {
  constructor(
    private actions$: Actions,
    private router: Router,
    private authenticationService: AuthenticationService,
    private userService: UserService,
  ) {}

  login$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loginAction),
      exhaustMap(({ credentials }) =>
        this.authenticationService.login(credentials).pipe(
          map((response) => loginSuccessAction({ response })),
          catchError(() => of(loginErrorAction())),
        ),
      ),
    ),
  );

  register$ = createEffect(() =>
    this.actions$.pipe(
      ofType(registerAction),
      exhaustMap(({ registration }) =>
        this.userService.register(registration).pipe(
          map((user) =>
            registerSuccessAction({
              credentials: {
                username: registration.username,
                password: registration.password,
              },
              user,
            }),
          ),
          catchError(() => of(registerErrorAction())),
        ),
      ),
    ),
  );

  registerSuccess$ = createEffect(
    () =>
      this.actions$.pipe(
        ofType(registerSuccessAction),
        tap(() => this.router.navigateByUrl('/user/login')),
      ),
    { dispatch: false },
  );
}
