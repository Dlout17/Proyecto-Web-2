import { TestBed } from '@angular/core/testing';
import { EnviarServicio } from './enviar-servicio';

describe('EnviarServicio', () => {
  let service: EnviarServicio;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnviarServicio);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
