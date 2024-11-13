import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Baloncesto } from './baloncesto';
import { BaloncestoService } from './baloncesto.service';
import { ActivatedRoute, Router } from '@angular/router';
import { BaloncestoComponent } from './baloncesto.component';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, BaloncestoComponent, CommonModule],
  templateUrl: './form.component.html'
})
export class FormComponentB {

public baloncesto:Baloncesto=new Baloncesto();

titulo:string="formulario de ingreso de baloncesto"
  

constructor(private baloncestoService:BaloncestoService,
  private router:Router,private activatedRouted: ActivatedRoute){}

ngOnInit(){
this.cargarBaloncesto()
}
  //cargar la tarea actual
cargarBaloncesto():void{
  this.activatedRouted.params.subscribe(params=>{
    let id = params['id']
    if(id){
      this.baloncestoService.getBaloncestoo(id).subscribe((baloncesto)=>this.baloncesto = baloncesto)
    }
  })
}

  //actualizar dato baloncesto
update():void{
this.baloncestoService.update(this.baloncesto).subscribe(baloncesto=>{
  this.router.navigate(['/baloncesto'])
  Swal.fire('dato de baloncesto actualizado',`Baloncesto: ${baloncesto.nombre} Actualizada con éxito!`, 'success')
})
}

public create():void{


  this.baloncestoService.create(this.baloncesto).subscribe(baloncesto=>{
    this.router.navigate(["/baloncesto"])
Swal.fire('Nuevo dato de baloncesto',`Baloncesto:${baloncesto.nombre}creado con éxito`, 'success')
  }
);
}
}
