import { Component, OnInit } from '@angular/core';
import { Baloncesto } from './baloncesto';
import { BaloncestoService } from './baloncesto.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-baloncesto',
  standalone: true,
  imports: [CommonModule,RouterModule],
  templateUrl: './baloncesto.component.html',
  styleUrl: './baloncesto.component.css'
})
export class BaloncestoComponent implements OnInit {
  
  
  baloncesto:Baloncesto[];
  


  constructor(private baloncestoService: BaloncestoService){

  } 

  
  ngOnInit(): void {
    this.baloncestoService.getBaloncesto().subscribe(
      baloncesto => this.baloncesto = baloncesto
    )
  }
  //invocando el metodo eliminar
  delete(baloncesto:Baloncesto):void{
    Swal.fire({
      title:"esta segur@?",
      text:`Seguro deseas eliminar el dato: ${baloncesto.nombre} !`,
      icon:"warning",
      showCancelButton:true,
      confirmButtonColor:"#3085d6",
      cancelButtonColor:"#d33",
      confirmButtonText:"si,Eliminar!"
    }).then((result)=>{
      if(result.isConfirmed){
        this.baloncestoService.delete(baloncesto.id).subscribe(
          response=>{
            this.baloncesto=this.baloncesto.filter(tar =>tar !==  baloncesto)
            Swal.fire({
              title:"borrada!",
              text:`Tu dato ha sido eliminada: ${baloncesto.nombre}`,
              icon:"success"
            })
          }
        )
      }
    });
  }
}
