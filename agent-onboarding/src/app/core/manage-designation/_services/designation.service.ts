import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../../environments/environment';

@Injectable({
	providedIn: 'root'
})
export class DesignationService {

	constructor(private http: HttpClient) { }

	public getDesignations() {
		const url = `${ environment.baseUrl }designation/all`;
		return this.http.get(url);
	}
}
