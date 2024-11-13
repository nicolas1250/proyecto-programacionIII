import { Component, OnInit } from '@angular/core';
import { Futbol } from './futbol';
import { FutbolService } from './futbol.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-futbol',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './futbol.component.html',
  styleUrl: './futbol.component.css'
})
export class FutbolComponent implements OnInit {
  
  futbol:Futbol[];

  constructor(private futbolService: FutbolService){

  }
  
  ngOnInit(): void {
    this.futbolService.getFutbol().subscribe(
      futbol => this.futbol = futbol
    )
  }
//invocando el metodo eliminar
delete(futbol:Futbol):void{
  Swal.fire({
    title:"esta segur@?",
    text:`Seguro deseas eliminar el dato: ${futbol.nombre} !`,
    icon:"warning",
    showCancelButton:true,
    confirmButtonColor:"#3085d6",
    cancelButtonColor:"#d33",
    confirmButtonText:"si,Eliminar!"
  }).then((result)=>{
    if(result.isConfirmed){
      this.futbolService.delete(futbol.id).subscribe(
        response=>{
          this.futbol=this.futbol.filter(tar =>tar !==  futbol)
          Swal.fire({
            title:"borrada!",
            text:`Tu dato ha sido eliminada: ${futbol.nombre}`,
            icon:"success"
          })
        }
      )
    }
  });
}
}
