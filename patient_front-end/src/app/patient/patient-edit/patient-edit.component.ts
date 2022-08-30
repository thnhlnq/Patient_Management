import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {PatientService} from '../patient.service';
import {PatienterService} from '../patienter.service';
import {Patienter} from '../patienter';
import {Patient} from '../patient';
import {checkDay, checkEnd, checkStart} from '../../../checkDate';
import {ToastrService} from 'ngx-toastr';

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
              private toast: ToastrService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.patientService.findById(this.id).subscribe(patient => {
        this.patientForm = new FormGroup({
          id: new FormControl(patient.id, [Validators.required]),
          patientId: new FormControl(patient.patientId, [Validators.required]),
          idPatienter: new FormControl(patient.patienter.id, [Validators.required]),
          patienterId: new FormControl(patient.patienter.patienterId, [Validators.required]),
          patienterName: new FormControl(patient.patienter.patienterName, [Validators.required, Validators.pattern('^[A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*(?:[ ][A-ZÀÁẠẢÃÂẦẤẬẨẪĂẰẮẶẲẴÈÉẸẺẼÊỀẾỆỂỄÌÍỊỈĨÒÓỌỎÕÔỒỐỘỔỖƠỜỚỢỞỠÙÚỤỦŨƯỪỨỰỬỮỲÝỴỶỸĐ][a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ]*)*$')]),
          hospitalize: new FormControl(patient.hospitalize, [Validators.required, checkStart]),
          discharge: new FormControl(patient.discharge, [Validators.required, checkEnd]),
          reason: new FormControl(patient.reason, [Validators.required]),
          treatments: new FormControl(patient.treatments, [Validators.required]),
          doctor: new FormControl(patient.doctor, [Validators.required])
        }, checkDay);
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

    this.patienterService.findById(this.patientForm.value.idPatienter).subscribe(patienter => {
      patienter = {
        id: this.patientForm.value.idPatienter,
        patienterId: this.patientForm.value.patienterId,
        patienterName: this.patientForm.value.patienterName
      };
      patient = {
        id: this.patientForm.value.id,
        patientId: this.patientForm.value.patientId,
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
      this.patienterService.editPatienter(patienter.id, patienter).subscribe(() => {
      });
      this.patientService.editPatient(id, patient).subscribe(() => {
        this.router.navigate(['/']);
        this.toast.success('Edit Patient Success..', 'Notification..');
      }, e => {
        console.log(e);
      });
    });
  }
}
