import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserCredentials } from '../../data/user-credentials';

@Component({
  selector: 'login-form',
  templateUrl: './login-form.component.html',
})
export class LoginFormComponent {
  @Output()
  onSubmit = new EventEmitter<UserCredentials>();

  loginForm = this.fb.nonNullable.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  constructor(private fb: FormBuilder) {}

  setCredentials(credentials: UserCredentials): void {
    this.loginForm.patchValue(credentials);
  }

  isReadyToSubmit(): boolean {
    return this.loginForm.valid;
  }

  emitOnSubmit(): void {
    if (this.isReadyToSubmit()) {
      const formValue = this.loginForm.value;

      this.onSubmit.emit({
        username: formValue.username!,
        password: formValue.password!,
      });
    }
  }
}
