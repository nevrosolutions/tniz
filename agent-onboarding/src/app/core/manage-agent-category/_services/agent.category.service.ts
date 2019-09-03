import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../../../../environments/environment';

@Injectable({
	providedIn: 'root'
})
export class AgentCategoryService {
	constructor(private http: HttpClient) {
	}

	public getAgentCategory() {
		const url = `${ environment.baseUrl }agentGroupCategory/all`;

		return this.http.get(url);
	}
}
