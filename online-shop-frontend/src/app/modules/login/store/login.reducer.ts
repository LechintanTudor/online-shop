import { LoadingStatus } from 'src/app/data/loading-status';
import { createReducer, on } from '@ngrx/store';
import {
  loginAction,
  loginErrorAction,
  loginSuccessAction,
} from './login.actions';
import { initialLoginState } from './login.state';

export const loginReducer = createReducer(
  initialLoginState,
  on(loginAction, (state) => ({
    ...state,
    status: LoadingStatus.Loading,
  })),
  on(loginErrorAction, (state) => ({
    ...state,
    status: LoadingStatus.Error,
    error: 'Failed to log in',
  })),
  on(loginSuccessAction, (state) => ({
    ...state,
    status: LoadingStatus.Success,
  })),
);
