import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { RouterModule } from '@angular/router';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { RegisterFormComponent } from './components/register-form/register-form.component';
import { LoginRoutingModule } from './login-routing.module';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { RegisterPageComponent } from './pages/register-page/register-page.component';
import { AuthenticationService } from './services/authentication.service';
import { UserService } from './services/user.service';
import { LoginEffects } from './store/login.effects';
import { loginReducer } from './store/login.reducer';
import { LOGIN_FEATURE_NAME } from './store/login.state';

@NgModule({
  declarations: [
    LoginFormComponent,
    LoginPageComponent,
    RegisterFormComponent,
    RegisterPageComponent,
  ],
  providers: [AuthenticationService, UserService],
  imports: [
    // Angular
    CommonModule,
    ReactiveFormsModule,
    RouterModule,

    // Routing
    LoginRoutingModule,

    // Material
    MatButtonModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,

    // NgRx
    StoreModule.forFeature(LOGIN_FEATURE_NAME, loginReducer),
    EffectsModule.forFeature([LoginEffects]),
  ],
})
export class LoginModule {}
