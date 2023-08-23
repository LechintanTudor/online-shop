import { catchError, exhaustMap, map, of } from 'rxjs';
import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { AuthenticationService } from '../services/authentication.service';
import {
  loginAction,
  loginErrorAction,
  loginSuccessAction,
} from './login.actions';

@Injectable()
export class LoginEffects {
  constructor(
    private actions$: Actions,
    private authenticationService: AuthenticationService,
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
}
