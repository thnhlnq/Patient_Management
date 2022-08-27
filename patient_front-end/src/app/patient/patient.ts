import {Patienter} from './patienter';

export interface Patient {
  id: number;
  patientId?: string;
  patienter?: Patienter;
  hospitalize?: string;
  discharge?: string;
  reason?: string;
  treatments?: string;
  doctor?: string;
}
