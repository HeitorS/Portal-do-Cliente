import { AuthService } from '../../../service/AuthService';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthRequest } from '../../../model/request/AuthRequest';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.scss',
})
export class Login {
  auth: AuthRequest = new AuthRequest();
  erro = false;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  logar(): void {
    this.erro = false;

    this.authService.checkToken().subscribe({
        next: (response) => {
          console.log('Login bem-sucedido:', response);
        },
        error: () => {
          this.erro = true;
        },
      });
  }
}
