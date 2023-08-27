import { createFeatureSelector, createSelector } from '@ngrx/store';
import { LOGIN_FEATURE_NAME, LoginState } from './login.state';

export const selectLoginState =
  createFeatureSelector<LoginState>(LOGIN_FEATURE_NAME);

export const selectToken = createSelector(
  selectLoginState,
  (state) => state.token,
);

export const selectLastRegisteredCredentials = createSelector(
  selectLoginState,
  (state) => state.lastRegisteredCredentials,
);
