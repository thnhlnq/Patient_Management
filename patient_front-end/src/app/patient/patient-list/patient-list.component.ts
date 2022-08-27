import {Component, OnInit} from '@angular/core';
import {PatientService} from '../patient.service';
import {PatienterService} from '../patienter.service';
import {Patient} from '../patient';
import {Patienter} from '../patienter';

@Component({
  selector: 'app-patient-list',
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent implements OnInit {

  patients: Patient[] = [];

  patienter: Patienter[] = [];

  id: number;

  patientId: string;

  constructor(private patientService: PatientService,
              private patienterService: PatienterService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.patientService.getAll().subscribe(patient => {
      this.patients = patient;
    });
    this.patienterService.getAll().subscribe(patienter => {
      this.patienter = patienter;
    });
  }

  openDelete(id: number, patientId: string) {
    this.id = id;
    this.patientId = patientId;
  }

  deletePatient(id: number) {
    this.patientService.deletePatient(id).subscribe(() => {
      this.getAll();
    }, e => {
      console.log(e);
    });
  }
}
