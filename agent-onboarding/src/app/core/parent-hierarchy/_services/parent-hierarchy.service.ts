import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../../../../environments/environment';
import { HierarchyNode } from '../../hierarchy-template/_models/hierarchy-node.model';
import { ParentHierarchySaveNodeModel } from '../_models/parent-hierarchy-node.model';

@Injectable({
	providedIn: 'root'
})
export class ParentHierarchyService {

	constructor(private http: HttpClient) { }

	public getHierarchyTemplateByBusinessId(businessUnitId: any) {
		const url = `${ environment.baseUrl }hierarchyNode/findByBusinessUnit?businessUnitId=${ businessUnitId }`;

		return this.http.get(url);
	}

	public saveHierarchyParentNode(hierarchyParentNode: any) {
		const url = `${ environment.baseUrl }hierarchyNodeDetail/saveAll`;

		return this.http.post(url, hierarchyParentNode);
	}

}
