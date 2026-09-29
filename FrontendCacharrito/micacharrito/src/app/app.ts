import { Component } from '@angular/core';
import { Vehiculo } from './componente/vehiculo/vehiculo';
import { Navegacion } from './navegacion/navegacion'; 

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ Navegacion],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {
  title = 'micacharrito';
}