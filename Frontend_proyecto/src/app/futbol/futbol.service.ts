import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { Futbol } from './futbol';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FutbolService {
  
 
  private urlEndpoint: string='http://localhost:8080/api/futbol'
  
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})
  
  constructor(private http:HttpClient) { }

getFutbol():Observable<Futbol[]>{
  
  //return of (FUTBOL);
  return this.http.get(this.urlEndpoint).pipe(
  map((response)=>response as Futbol[])
  )
  
}
  create(futbol:Futbol):Observable<Futbol>{
    return this.http.post<Futbol>(this.urlEndpoint,futbol, {headers:this.httpHeaders})
  }
//metodo de editar dato
getFutboll(id:any):Observable<Futbol>{
  return this.http.get<Futbol>(`${this.urlEndpoint}/${id}`)
}
//edicion final
update(futbol:Futbol):Observable<Futbol>{
return this.http.put<Futbol>(`${this.urlEndpoint}/${futbol.id}`,futbol,{headers:this.httpHeaders})
}
//eliminar
delete(id:number):Observable<Futbol>{
return this.http.delete<Futbol>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
}
}
