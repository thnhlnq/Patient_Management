import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {Patienter} from '../patienter';
import {PatientService} from '../patient.service';
import {PatienterService} from '../patienter.service';
import {checkDay, checkEnd, checkStart} from '../../../checkDate';

@Component({
  selector: 'app-patient-create',
  templateUrl: './patient-create.component.html',
  styleUrls: ['./patient-create.component.css']
})
export class PatientCreateComponent implements OnInit {

  patientForm: FormGroup = new FormGroup({
    id: new FormControl(''),
    patientId: new FormControl('', [Validators.required]),
    patienter: new FormControl('', [Validators.required]),
    hospitalize: new FormControl('', [Validators.required, checkStart]),
    discharge: new FormControl('', [Validators.required, checkEnd]),
    reason: new FormControl('', [Validators.required]),
    treatments: new FormControl('', [Validators.required]),
    doctor: new FormControl('', [Validators.required])
  }, checkDay);

  patienters: Patienter[] = [];

  constructor(private patientService: PatientService,
              private patienterService: PatienterService,
              private toast: ToastrService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getPatienter();
  }

  submit(): void {
    const patient = this.patientForm.value;
    this.patienterService.findById(patient.patienter).subscribe(patienter => {
      patient.patienter = {
        id: patienter.id,
        patienterId: patienter.patienterId,
        patienterName: patienter.patienterName
      };
      this.patientService.savePatient(patient).subscribe(() => {
        this.patientForm.reset();
        this.toast.success('Add Patient Success..', 'Notification');
        this.router.navigate(['/']);
      }, e => {
        console.log(e);
      });
    });
  }

  getPatienter(): void {
    this.patienterService.getAll().subscribe(patienters => {
      this.patienters = patienters;
    });
  }
}
