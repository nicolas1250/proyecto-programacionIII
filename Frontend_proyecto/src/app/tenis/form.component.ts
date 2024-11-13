import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TenisComponent } from './tenis.component';
import { TenisService } from './tenis.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Tenis } from './tenis';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, TenisComponent,CommonModule],
  templateUrl: './form.component.html'
})
export class FormComponentT {
public tenis:Tenis=new Tenis();

titulo:string="formulario de ingreso de tenis"

constructor(private tenisService:TenisService,
  private router:Router,private activatedRouted:ActivatedRoute
){}
  
ngOnInit(){
    this.cargarTenis()
}
//cargar el dato actual
cargarTenis():void{
  this.activatedRouted.params.subscribe(params=>{
    let id=params['id']
    if(id){
      this.tenisService.getTeniss(id).subscribe((tenis)=> this.tenis = tenis)
    }
  })
}

  //actualizar dato tenis
update():void{
this.tenisService.update(this.tenis).subscribe(tenis=>{
  this.router.navigate(['/tenis'])
  Swal.fire('dato de tenis actualizado',`Tenis: ${tenis.nombre} Actualizada con éxito!`, 'success')
})
}

public create():void{


  this.tenisService.create(this.tenis).subscribe(tenis=>{
    this.router.navigate(["/tenis"])
Swal.fire('Nuevo dato de tenis',`Tenis:${tenis.nombre} creado con éxito`, 'success')
  }
);
}
}