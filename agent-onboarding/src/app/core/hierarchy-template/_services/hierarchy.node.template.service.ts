import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { environment } from '../../../../environments/environment';
import { BusinessUnit } from '../_models/business-unit.model';
import { HierarchyNode } from '../_models/hierarchy-node.model';

@Injectable({
	providedIn: 'root'
})
export class HierarchyNodeTemplateService {

	constructor(private http: HttpClient) { }

	public getHierarchyTemplateByBusinessId(businessUnitId: BusinessUnit, hierarchyType: string) {
		const url = `${ environment.baseUrl }hierarchyNode/findByBusinessUnitAndHierarchyType?businessUnitId=${ businessUnitId.businessUnitId }&hierarchyType=${ hierarchyType }`;

		return this.http.get(url);
	}

	public saveHierarchyTemplate(hierarchyList: HierarchyNode[]) {
		const url = `${ environment.baseUrl }hierarchyNode/save`;

		return this.http.post(url, hierarchyList);
	}

}
