import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../../../../environments/environment';

@Injectable({
	providedIn: 'root'
})
export class BusinessUnitService {
	constructor(private http: HttpClient) {}

	public getBusinessUnits() {
		const url = `${ environment.baseUrl }businessUnit/all`;

		return this.http.get(url);
	}
}
