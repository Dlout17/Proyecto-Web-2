import { Component } from '@angular/core';
import { Vehiculo } from './componente/vehiculo/vehiculo'; 

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Vehiculo
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {
  title = 'micacharrito';
}