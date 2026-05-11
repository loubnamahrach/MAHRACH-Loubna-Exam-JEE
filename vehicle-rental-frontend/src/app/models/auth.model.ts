export interface LoginRequest {
  username: string;
  motdepasse: string;
}

export interface LoginResponse {
  token: string;
  username: string;
  role: string;
}

export interface User {
  id?: number;
  username: string;
  email?: string;
  nom?: string;
  prenom?: string;
  role: string;
  enabled?: boolean;
}

export interface AuthState {
  token: string | null;
  user: User | null;
  isAuthenticated: boolean;
  role: string | null;
}
