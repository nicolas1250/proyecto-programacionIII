import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Baloncesto } from './baloncesto';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BaloncestoService {
  
 
  private urlEndpoint: string='http://localhost:8080/api/baloncesto'

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  filter: any;
  
  constructor(private http:HttpClient) { }

  getBaloncesto():Observable<Baloncesto[]>{

  //return of (BALONCESTO);
  return this.http.get(this.urlEndpoint).pipe(
 map((response)=>response as Baloncesto[])
)
  }
  //metodo de crear dato
  create(baloncesto:Baloncesto):Observable<Baloncesto>{
    return this.http.post<Baloncesto>(this.urlEndpoint,baloncesto,{headers:this.httpHeaders})
  }
  //metodo de editar dato
  getBaloncestoo(id:any):Observable<Baloncesto>{
    return this.http.get<Baloncesto>(`${this.urlEndpoint}/${id}`)
  }
//edicion final
update(baloncesto:Baloncesto):Observable<Baloncesto>{
  return this.http.put<Baloncesto>(`${this.urlEndpoint}/${baloncesto.id}`,baloncesto,{headers:this.httpHeaders})
}
//eliminar
delete(id:number):Observable<Baloncesto>{
  return this.http.delete<Baloncesto>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
}
}
