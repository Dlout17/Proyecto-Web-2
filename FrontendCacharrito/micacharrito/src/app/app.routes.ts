import { Routes } from '@angular/router';
import { Login } from './login/login';
import { Vehiculo } from './componente/vehiculo/vehiculo';
import { VehiculoAdmin } from './componente/vehiculoadmin/vehiculoadmin';
import { Alquileres } from './componente/alquileres/alquileres';
import { Home } from './home/home';


export const routes: Routes = [
    { path: '', component: Home },
    { path: 'login', component: Login},
    { path: 'catalogo', component: Vehiculo},
    { path: 'paneladmin', component: VehiculoAdmin},
    { path: 'alquileres', component: Alquileres},

];
