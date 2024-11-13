import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { FutbolComponent } from './futbol.component';
import { FutbolService } from './futbol.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Futbol } from './futbol';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, FutbolComponent,CommonModule],
  templateUrl: './form.component.html',

})
export class FormComponentF {

public futbol:Futbol=new Futbol();

titulo:string="formulario de ingreso de futbol"


constructor(private futbolService:FutbolService,
  private router:Router,private activatedRouted: ActivatedRoute){}

ngOnInit(){
  this.cargarFutbol()
}
//cargar la tarea actual
cargarFutbol():void{
  this.activatedRouted.params.subscribe(params=>{
    let id=params['id']
    if(id){
      this.futbolService.getFutboll(id).subscribe((futbol)=> this.futbol = futbol)
    }
  })
}

  //actualizar dato baloncesto
update():void{
this.futbolService.update(this.futbol).subscribe(futbol=>{
  this.router.navigate(['/futbol'])
  Swal.fire('dato de futbol actualizado' , `Futbol: ${futbol.nombre} Actualizada con éxito!`, 'success')
})
}

public create():void{


  this.futbolService.create(this.futbol).subscribe(futbol=>{
    this.router.navigate(["/futbol"])
Swal.fire('Nuevo dato de futbol' , `Futbol:${futbol.nombre} creado con éxito`, 'success')
  }
);
}
}