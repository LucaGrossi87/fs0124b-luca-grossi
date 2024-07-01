import { User } from './i-users';
export interface LoginResponse {
  jwt: string;
  admin: User;
}
