import { LoadingStatus } from 'src/app/data/loading-status';
import { UserCredentials } from '../data/user-credentials';

export const LOGIN_FEATURE_NAME = 'login';

export interface LoginState {
  status: LoadingStatus;
  lastError: string;
  token: string | null;
  lastRegisteredCredentials: UserCredentials;
}

export const initialLoginState: LoginState = {
  status: LoadingStatus.Initial,
  lastError: '',
  token: null,
  lastRegisteredCredentials: {
    username: '',
    password: '',
  },
};
