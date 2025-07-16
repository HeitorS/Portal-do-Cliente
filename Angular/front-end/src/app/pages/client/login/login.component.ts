// Importando o AuthService para manipulação de autenticação
import { AuthService } from '@services/auth.service';

// Importando módulos e serviços necessários
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
})
export class LoginComponent {
  login = '';
  senha = '';

  constructor(
    private http: HttpClient,
    private authService: AuthService,
    private router: Router
  ) {}

  logar(): void {
    console.log({
        login: this.login,
        senha: this.senha,
      })
    this.http
      .post<any>('localhost:3000/auth/login', {
        login: this.login,
        senha: this.senha,
      })
      .subscribe({
        next: (response) => {
          this.authService.salvarToken(response.token);
          this.router.navigate(['/admin/dashboard']);
        },
        error: (err) => alert('Login inválido'),
      });
  }
}
