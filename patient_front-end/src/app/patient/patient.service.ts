import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Patient} from './patient';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Patient[]> {
    return this.http.get<Patient[]>(API_URL + '/patient');
  }

  savePatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(API_URL + '/patient', patient);
  }

  findById(id: number): Observable<Patient> {
    return this.http.get<Patient>(`${API_URL}/patient/${id}`);
  }

  editPatient(id: number, patient: Patient): Observable<Patient> {
    return this.http.put<Patient>(`${API_URL}/patient/${id}`, patient);
  }

  deletePatient(id: number): Observable<Patient> {
    return this.http.delete<Patient>(`${API_URL}/patient/${id}`);
  }

  searchPatient(name1: string, name2: string): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${API_URL}/patient?name_like=` + name1 + '&patienter.patienterName_like=' + name2);
  }
}
