import { LoadingStatus } from 'src/app/data/loading-status';
import { createReducer, on } from '@ngrx/store';
import {
  loginAction,
  loginErrorAction,
  loginSuccessAction,
  registerAction,
  registerErrorAction,
  registerSuccessAction,
} from './login.actions';
import { initialLoginState } from './login.state';

export const LOGIN_FEATURE_NAME = 'login';

export const loginReducer = createReducer(
  initialLoginState,

  // Login
  on(loginAction, (state) => ({
    ...state,
    status: LoadingStatus.Loading,
  })),
  on(loginSuccessAction, (state) => ({
    ...state,
    status: LoadingStatus.Success,
  })),
  on(loginErrorAction, (state) => ({
    ...state,
    status: LoadingStatus.Error,
    error: 'Failed to log in',
  })),

  // Register
  on(registerAction, (state) => ({
    ...state,
    status: LoadingStatus.Loading,
  })),
  on(registerSuccessAction, (state, { credentials }) => ({
    ...state,
    status: LoadingStatus.Success,
    lastRegisteredCredentials: credentials,
  })),
  on(registerErrorAction, (state) => ({
    ...state,
    status: LoadingStatus.Error,
    error: 'Failed to register',
  })),
);
