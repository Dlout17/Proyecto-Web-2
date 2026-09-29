import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { EnviarServicio } from '../servicio/enviar-servicio';

@Component({
  imports: [CommonModule, RouterLink ],
  selector: 'app-home',
  styleUrl: './home.css',
  templateUrl: './home.html',
})
export class Home {dataService = inject(EnviarServicio);}
