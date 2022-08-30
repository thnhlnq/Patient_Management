import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PatientRoutingModule } from './patient-routing.module';
import {PatientListComponent} from './patient-list/patient-list.component';
import {PatientEditComponent} from './patient-edit/patient-edit.component';
import {ReactiveFormsModule} from '@angular/forms';
import {PatientCreateComponent} from './patient-create/patient-create.component';
import {NgxPaginationModule} from 'ngx-pagination';


@NgModule({
  declarations: [
    PatientListComponent,
    PatientCreateComponent,
    PatientEditComponent
  ],
    imports: [
        CommonModule,
        PatientRoutingModule,
        ReactiveFormsModule,
        NgxPaginationModule
    ]
})
export class PatientModule { }
