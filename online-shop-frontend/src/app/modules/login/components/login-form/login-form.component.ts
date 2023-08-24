import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Credentials } from '../../data/credentials';

@Component({
  selector: 'login-form',
  templateUrl: './login-form.component.html',
})
export class LoginFormComponent {
  @Output()
  onSubmit = new EventEmitter<Credentials>();

  loginForm = this.fb.nonNullable.group({
    username: ['', Validators.required],
    password: ['', Validators.required],
  });

  constructor(private fb: FormBuilder) {}

  emitOnSubmit(): void {
    if (this.loginForm.valid) {
      this.onSubmit.emit({
        username: this.loginForm.value.username!,
        password: this.loginForm.value.password!,
      });
    }
  }
}
