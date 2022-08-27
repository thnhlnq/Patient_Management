import {AbstractControl} from '@angular/forms';

function dateDiff(first, second) {
  return Math.round((second - first) / (1000 * 60 * 60 * 24));
}

export function checkStart(control: AbstractControl) {
  const now = new Date();
  const start = new Date(control.value);

  if (dateDiff(start, now) <= 0) {
    return {checkStart: true};
  }
  return null;
}

export function checkEnd(control: AbstractControl) {
  const now = new Date();
  const end = new Date(control.value);

  if (dateDiff(end, now) <= 0) {
    return {checkEnd: true};
  }
  return null;
}

export function checkDay(control: AbstractControl) {
  const start = new Date(control.value.startDate);
  const end = new Date(control.value.endDate);

  if (dateDiff(start, end) <= 0) {
    return {checkDate: true};
  }
  return null;
}
