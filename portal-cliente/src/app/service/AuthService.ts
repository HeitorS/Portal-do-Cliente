import { HttpClient } from "@angular/common/http";
import { environment } from "../environment/environment";
import { AuthRequest } from "../model/request/AuthRequest";
import { AuthResponse } from "../model/response/AuthResponse";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({ providedIn: 'root' })
export class AuthService {
  protected readonly BASE_URL = `${environment.uri}`;

  constructor(private http: HttpClient) {}

  login(auth: AuthRequest): Observable<AuthResponse> {
    return this.http.post<AuthResponse>(`${this.BASE_URL}v1/auth/login`, auth);
  }

  checkToken(): Observable<any> {
    return this.http.get(`${this.BASE_URL}v1/auth/check`);
  }

}