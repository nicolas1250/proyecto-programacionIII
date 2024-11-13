import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  autor:any= {nombres:'Karen Johana', apellidos:'Caicedo Arias'}
  autor2:any= {nombres:'Nicolas', apellidos:'Obregon Rojas'}

}
