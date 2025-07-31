import { HttpClient } from '@angular/common/http';
import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { environment } from './environment/environment';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.scss'

})
export class App {
  protected readonly title = signal('portal-cliente');
  protected readonly BASE_URL = `${environment.uri}`;
  constructor(private http: HttpClient) {
    
  }

  chamadaFuncao() {
    // this.http.get('http://localhost:8080/v1/auth/check').subscribe({
    //   next: (response) => {
    //     console.log('Resposta do servidor:', response);
    //   },
    //   error: (error) => {
    //     console.error('Erro ao chamar o servidor:', error);
    //   }
    // });
    this.http.post('http://localhost:8080/v1/auth/login',{email:'joao.silva@gmail.com', senha: 'admin123'}).subscribe({
      next: (response) => {
        console.log('Resposta do servidor:', response);
      },
      error: (error) => {
        console.error('Erro ao chamar o servidor:', error);
      }
    });
  }
}
