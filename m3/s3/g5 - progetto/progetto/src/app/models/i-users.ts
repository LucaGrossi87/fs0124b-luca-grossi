import { iFavs } from './i-favs';
import { iMovies } from './i-movies';
export interface iUsers {
  id: number,
  firstName: string,
  lastName: string,
  email: string,
  password: string,
  favMov:iFavs[]
}
