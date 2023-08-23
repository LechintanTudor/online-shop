import { LoadingStatus } from 'src/app/data/loading-status';

export const LOGIN_FEATURE_NAME = 'login';

export interface LoginState {
  status: LoadingStatus;
  lastError: string;
  token: string | null;
}

export const initialLoginState: LoginState = {
  status: LoadingStatus.Initial,
  lastError: '',
  token: null,
};
