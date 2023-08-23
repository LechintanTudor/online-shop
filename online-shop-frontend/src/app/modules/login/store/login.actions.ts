import { createAction, props } from '@ngrx/store';
import { Credentials } from '../data/credentials';
import { LoginResponse } from '../data/login-response';

export const loginAction = createAction(
  '[Login] Log In',
  props<{ credentials: Credentials }>(),
);

export const loginSuccessAction = createAction(
  '[Login] Log In Success',
  props<{ response: LoginResponse }>(),
);

export const loginErrorAction = createAction('[Login] Log In Error');
