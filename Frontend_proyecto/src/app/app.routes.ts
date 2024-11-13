import { Routes } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FutbolComponent } from './futbol/futbol.component';
import { BaloncestoComponent } from './baloncesto/baloncesto.component';
import { TenisComponent } from './tenis/tenis.component';
import { FormComponentF } from './futbol/form.component'; 
import { FormComponentB } from './baloncesto/form.component'; 
import { FormComponentT } from './tenis/form.component';

export const routes: Routes = [
    {path:'', redirectTo:'/futbol', pathMatch:'full'},
    {path:'header', component: HeaderComponent},
    {path:'footer', component: FooterComponent},
    {path:'futbol', component: FutbolComponent},
    {path:'baloncesto', component:BaloncestoComponent},
    {path:'tenis', component:TenisComponent},
    {path:'futbol/form', component:FormComponentF},
    {path:'baloncesto/form', component:FormComponentB},
    {path:'tenis/form', component:FormComponentT},
    {path: 'futbol/form/:id',component:FormComponentF},
    {path: 'baloncesto/form/:id',component:FormComponentB},
    {path: 'tenis/form/:id',component:FormComponentT},


];
