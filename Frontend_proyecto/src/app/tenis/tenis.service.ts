
import { Injectable } from '@angular/core';
import { map, Observable, of } from 'rxjs';
import { Tenis } from './tenis';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TenisService {


private urlEndpoint: string='http://localhost:8080/api/tenis'

private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'})



  constructor(private http:HttpClient) { }

  getTenis():Observable<Tenis[]>{

  //return of (TENIS);
  return this.http.get(this.urlEndpoint).pipe(
    map((response)=>response as Tenis[]))
    
}
  create(tenis:Tenis):Observable<Tenis>{
    return this.http.post<Tenis>(this.urlEndpoint,tenis,{headers:this.httpHeaders})
  }
  //metodo de editar dato
getTeniss(id:any):Observable<Tenis>{
  return this.http.get<Tenis>(`${this.urlEndpoint}/${id}`)
}
//edicion final
update(tenis:Tenis):Observable<Tenis>{
return this.http.put<Tenis>(`${this.urlEndpoint}/${tenis.id}`,tenis,{headers:this.httpHeaders})
}
//eliminar
delete(id:number):Observable<Tenis>{
return this.http.delete<Tenis>(`${this.urlEndpoint}/${id}`, {headers:this.httpHeaders})
}
}

