import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { AuthenticationService } from './services/authentication.service';
import { LoginEffects } from './store/login.effects';
import { loginReducer } from './store/login.reducer';
import { LOGIN_FEATURE_NAME } from './store/login.state';

@NgModule({
  declarations: [],
  providers: [AuthenticationService],
  imports: [
    // Angular
    CommonModule,

    // NgRx
    StoreModule.forFeature(LOGIN_FEATURE_NAME, loginReducer),
    EffectsModule.forFeature([LoginEffects]),
  ],
})
export class LoginModule {}
