export interface iLogin {
  email:string
  password:string
}

export interface iUser {
  id:number,
  name:string,
  email:string
  password?:string
}

export interface iAccess {
  accessToken:string,
  user:iUser
}
