import { Pet } from './pet';
export class Appointment {
  id: number;
  timeOfAppoitment: Date;
  type: string;
  urgency: string;
  status: string;
  pet: Pet;
  constructor(
    id?: number,
    timeOfAppoitment?: Date,
    type?: string,
    urgency?: string,
    status?: string,
    pet?: Pet
  ) {
    this.id = id;
    this.timeOfAppoitment = timeOfAppoitment;
    this.type = type;
    this.urgency = urgency;
    this.status = status;
    this.pet = pet;



  }
}
