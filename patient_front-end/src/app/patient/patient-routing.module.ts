import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PatientListComponent} from './patient-list/patient-list.component';
import {PatientEditComponent} from './patient-edit/patient-edit.component';
import {PatientCreateComponent} from './patient-create/patient-create.component';


const routes: Routes = [
  {
    path: '',
    component: PatientListComponent
  }, {
    path: 'create',
    component: PatientCreateComponent
  }, {
    path: 'edit/:id',
    component: PatientEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PatientRoutingModule {
}
