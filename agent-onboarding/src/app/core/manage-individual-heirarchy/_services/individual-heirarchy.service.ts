import { Injectable } from '@angular/core';
import { environment } from './../../../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';

@Injectable({
	providedIn: 'root'
})
export class IndividualHeirarchyService {
	public baseUrl: string = environment.localApiUrl;

	constructor(
		private http: HttpClient
	) { }

	getAllBussinessUnit() {
		return this.http.get(this.baseUrl + 'businessUnit/all')
			.pipe(map(res => {
				return res;
			},
				error => {
					catchError(error);
				}));
	}

	getAgentFromAgent(agentId, businessUnitId) {
		const url = this.baseUrl + 'hierarchyTransferDetail/findHierarchyTransferDetail?agentId=' + agentId + '&businessUnitId=' + businessUnitId;
		return this.http.get(url)
			.pipe(map(res => {
				return res;
			},
				error => {
					catchError(error);
				}));
	}

	getAllDesignation() {
		return this.http.get(this.baseUrl + 'designation/all')
			.pipe(map(res => {
				return res;
			},
				error => {
					catchError(error);
				}));
	}

	updateIhData(ihData) {
		return this.http.post(this.baseUrl + 'hierarchyTransferDetail/update ', ihData)
			.pipe(map(res => {
				return res;
			},
				error => {
					catchError(error);
				}));
	}

	createNewIhRecord(ihData) {
		return this.http.post(this.baseUrl + 'hierarchyTransferDetail/create ', ihData)
			.pipe(map(res => {
				return res;
			},
				error => {
					catchError(error);
				}));
	}

	getParentList(businessUnitId, designationId) {
		const url = this.baseUrl + 'hierarchyTransferDetail/getParent?businessUnitId=' + businessUnitId + '&designationId=' + designationId;
		return this.http.get(url)
		.pipe(map(res => {
			return res;
		},
		error => {
			catchError(error);
		}));
	}

}
