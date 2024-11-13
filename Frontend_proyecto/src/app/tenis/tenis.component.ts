import { Component, OnInit } from '@angular/core';
import { Tenis } from './tenis';
import { TenisService } from './tenis.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-tenis',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './tenis.component.html',
  styleUrl: './tenis.component.css'
})
export class TenisComponent implements OnInit {

  tenis:Tenis[];
  
  constructor(private tenisService: TenisService){

  }
  ngOnInit(): void {
    this.tenisService.getTenis().subscribe(
      tenis => this.tenis = tenis
    )
  }
  //invocando el metodo eliminar
delete(tenis:Tenis):void{
  Swal.fire({
    title:"esta segur@?",
    text:`Seguro deseas eliminar el dato: ${tenis.nombre} !`,
    icon:"warning",
    showCancelButton:true,
    confirmButtonColor:"#3085d6",
    cancelButtonColor:"#d33",
    confirmButtonText:"si,Eliminar!"
  }).then((result)=>{
    if(result.isConfirmed){
      this.tenisService.delete(tenis.id).subscribe(
        response=>{
          this.tenis=this.tenis.filter(tar =>tar !==  tenis)
          Swal.fire({
            title:"borrada!",
            text:`Tu dato ha sido eliminada: ${tenis.nombre}`,
            icon:"success"
          })
        }
      )
    }
  });
}
}
