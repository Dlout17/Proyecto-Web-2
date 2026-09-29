import { TestBed } from '@angular/core/testing';
import { Vehiculoadmin } from './vehiculoadmin';

describe('Vehiculoadmin', () => {
  let service: Vehiculoadmin;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Vehiculoadmin);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
