import { createAction, props } from '@ngrx/store';
import { LoginResponse } from '../data/login-response';
import { User } from '../data/user';
import { UserCredentials } from '../data/user-credentials';
import { UserRegistration } from '../data/user-registration';

export const loginAction = createAction(
  '[Login] Log In',
  props<{ credentials: UserCredentials }>(),
);

export const loginSuccessAction = createAction(
  '[Login] Log In Success',
  props<{ response: LoginResponse }>(),
);

export const loginErrorAction = createAction('[Login] Log In Error');

export const registerAction = createAction(
  '[Register] Register',
  props<{ registration: UserRegistration }>(),
);

export const registerSuccessAction = createAction(
  '[Register] Register Success',
  props<{ credentials: UserCredentials; user: User }>(),
);

export const registerErrorAction = createAction('[Register] Register Error');
