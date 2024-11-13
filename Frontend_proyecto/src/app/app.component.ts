import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FutbolComponent } from './futbol/futbol.component';
import { BaloncestoComponent } from './baloncesto/baloncesto.component';
import { TenisComponent } from './tenis/tenis.component';
import { FormComponentF } from './futbol/form.component';
import { FormComponentB } from './baloncesto/form.component';
import { FormComponentT } from './tenis/form.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, HeaderComponent, FooterComponent, FutbolComponent, BaloncestoComponent,TenisComponent,
    FormComponentF,FormComponentB,FormComponentT],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'proyectodeportes';
}
