import { User } from './user';
import { Appointment } from './appointment';

export class Pet {
  id: number;
  name: string;
  health: string;
  custody: string;
  user: User;
  species: string;
  breed: string;
  fixed: boolean;
  gender: string;
  appt: Appointment[];

  constructor(
    id?: number,
    name?: string,
    health?: string,
    custody?: string,
    user?: User,
    species?: string,
    breed?: string,
    fixed?: boolean,
    gender?: string,
    appt?: Appointment[]

  ) {
    this.id = id;
    this.name = name;
    this.health = health;
    this.custody = custody;
    this.user = user;
    this.species = species;
    this.breed = breed;
    this.fixed = fixed;
    this.gender = gender;
    this.appt = appt;




  }
}
