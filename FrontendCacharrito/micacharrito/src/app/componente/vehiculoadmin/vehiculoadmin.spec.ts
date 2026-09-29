import { ComponentFixture, TestBed } from '@angular/core/testing';
import { VehiculoAdmin} from './vehiculoadmin';

describe('Vehiculoadmin', () => {
  let component: VehiculoAdmin;
  let fixture: ComponentFixture<VehiculoAdmin>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VehiculoAdmin],
    }).compileComponents();

    fixture = TestBed.createComponent(VehiculoAdmin);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
