import { Address } from 'cluster';

export class User {
  id: number;
  firstName: string;
  lastName: string;
  email: string;
  password: string;
  enabled: boolean;
  role: string;
  phone: string;
  address: string;
  constructor(
    id?: number,
    firstName?: string,
    lastName?: string,
    email?: string,
    password?: string,
    enabled: boolean = true,
    role: string = 'patient',
    phone?: string,
    address?: string
  ) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.phone = phone;
    this.address = address;



  }







}
