import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {PatientService} from '../patient.service';
import {PatienterService} from '../patienter.service';
import {Patienter} from '../patienter';
import {Patient} from '../patient';

@Component({
  selector: 'app-patient-list-edit',
  templateUrl: './patient-edit.component.html',
  styleUrls: ['./patient-edit.component.css']
})
export class PatientEditComponent implements OnInit {

  patientForm: FormGroup;

  patienter: Patienter[] = [];

  id: number;

  constructor(private patientService: PatientService,
              private patienterService: PatienterService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.patientService.findById(this.id).subscribe(patient => {
        this.patientForm = new FormGroup({
          id: new FormControl(patient.id),
          patientId: new FormControl(patient.patientId),
          idPatient: new FormControl(patient.patienter.id),
          patienterId: new FormControl(patient.patienter.patienterId),
          patienterName: new FormControl(patient.patienter.patienterName),
          hospitalize: new FormControl(patient.hospitalize),
          discharge: new FormControl(patient.discharge),
          reason: new FormControl(patient.reason),
          treatments: new FormControl(patient.treatments),
          doctor: new FormControl(patient.doctor)
        });
      });
    });
  }

  getPatienter(): void {
    this.patienterService.getAll().subscribe(patienter => {
      this.patienter = patienter;
    });
  }

  ngOnInit(): void {
    this.getPatienter();
  }

  editPatient(id: number): void {
    let patient: Patient;

    // const patient = this.patientForm.value;
    this.patienterService.findById(this.patientForm.value.patienter).subscribe(patienter => {
      patienter = {
        id: this.patientForm.value.id,
        patienterId: this.patientForm.value.patienterId,
        patienterName: this.patientForm.value.patienterName
      };
      patient = {
        id: this.patientForm.value.id,
        patienter: {
          id: patienter.id,
          patienterId: patienter.patienterId,
          patienterName: patienter.patienterName
        },
        hospitalize: this.patientForm.value.hospitalize,
        discharge: this.patientForm.value.discharge,
        reason: this.patientForm.value.reason,
        treatments: this.patientForm.value.treatments,
        doctor: this.patientForm.value.doctor
      };
      this.patienterService.editPatienter(patienter.id, patient).subscribe(() => {
      });
      this.patientService.editPatient(id, patient).subscribe(() => {
        this.router.navigate(['/']);
        // this.toast.success('Edited Customer Success..', 'Notification..');
      }, e => {
        console.log(e);
      });
    });
  }
}
