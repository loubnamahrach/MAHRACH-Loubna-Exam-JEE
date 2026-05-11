import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { map, tap, catchError } from 'rxjs/operators';
import { LoginRequest, LoginResponse, User, AuthState } from '../models/auth.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/api/auth';
  private authStateSubject = new BehaviorSubject<AuthState>(this.getInitialState());
  public authState$ = this.authStateSubject.asObservable();

  constructor(private http: HttpClient) {
    this.loadAuthState();
  }

  private getInitialState(): AuthState {
    return {
      token: null,
      user: null,
      isAuthenticated: false,
      role: null
    };
  }

  private loadAuthState(): void {
    const token = localStorage.getItem('auth_token');
    const user = localStorage.getItem('auth_user');
    
    if (token && user) {
      const parsedUser = JSON.parse(user);
      this.authStateSubject.next({
        token,
        user: parsedUser,
        isAuthenticated: true,
        role: parsedUser.role
      });
    }
  }

  login(credentials: LoginRequest): Observable<LoginResponse> {
    return this.http.post<LoginResponse>(`${this.apiUrl}/login`, credentials)
      .pipe(
        tap(response => {
          localStorage.setItem('auth_token', response.token);
          const user: User = {
            username: response.username,
            role: response.role
          };
          localStorage.setItem('auth_user', JSON.stringify(user));
          
          this.authStateSubject.next({
            token: response.token,
            user,
            isAuthenticated: true,
            role: response.role
          });
        }),
        catchError(error => {
          console.error('Login failed:', error);
          throw error;
        })
      );
  }

  register(credentials: LoginRequest): Observable<User> {
    return this.http.post<User>(`${this.apiUrl}/register`, credentials);
  }

  logout(): void {
    localStorage.removeItem('auth_token');
    localStorage.removeItem('auth_user');
    this.authStateSubject.next(this.getInitialState());
  }

  getToken(): string | null {
    return localStorage.getItem('auth_token');
  }

  getCurrentUser(): User | null {
    const user = localStorage.getItem('auth_user');
    return user ? JSON.parse(user) : null;
  }

  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  hasRole(role: string): boolean {
    const currentUser = this.getCurrentUser();
    return currentUser ? currentUser.role === role : false;
  }

  hasAnyRole(roles: string[]): boolean {
    const currentUser = this.getCurrentUser();
    return currentUser ? roles.includes(currentUser.role) : false;
  }

  getRoles(): string[] {
    return ['ROLE_CLIENT', 'ROLE_EMPLOYE', 'ROLE_ADMIN'];
  }
}
