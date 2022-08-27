import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';
import {Patienter} from './patienter';

const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class PatienterService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<Patienter[]> {
    return this.http.get<Patienter[]>(API_URL + '/patienter');
  }

  findById(id: number): Observable<Patienter> {
    return this.http.get<Patienter>(API_URL + `/patienter/${id}`);
  }

  editPatienter(id: number, patienter: Patienter): Observable<Patienter> {
    return this.http.put<Patienter>(`${API_URL}/patienter/${id}`, patienter);
  }
}
