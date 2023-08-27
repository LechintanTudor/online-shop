import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserRegistration } from '../../data/user-registration';

@Component({
  selector: 'register-form',
  templateUrl: './register-form.component.html',
})
export class RegisterFormComponent {
  @Output()
  onSubmit = new EventEmitter<UserRegistration>();

  registerForm = this.fb.nonNullable.group({
    firstName: ['', Validators.required],
    lastName: ['', Validators.required],
    username: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', Validators.required],
  });

  constructor(private fb: FormBuilder) {}

  isReadyToSubmit(): boolean {
    return this.registerForm.valid;
  }

  emitOnSubmit(): void {
    if (this.isReadyToSubmit()) {
      const formValue = this.registerForm.value;

      this.onSubmit.emit({
        firstName: formValue.firstName!,
        lastName: formValue.lastName!,
        username: formValue.username!,
        email: formValue.email!,
        password: formValue.password!,
      });
    }
  }
}
