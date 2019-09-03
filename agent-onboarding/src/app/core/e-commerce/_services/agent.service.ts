import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment';
import { HttpUtilsService } from '../../_base/crud';
import { BusinessUnitModel } from '../_models/business-unit.model';
import { DesignationModel } from '../_models/designation.model';

const API_BUSINESS_UNIT_URL = `${ environment.localApiUrl }businessUnit`;
const API_DESIGNATION_URL = `${ environment.localApiUrl }designation`;

@Injectable()
export class AgentService {

	constructor(private http: HttpClient, private httpUtils: HttpUtilsService) { }

	// Get all business units
	getAllBusinessUnits(): Observable<BusinessUnitModel[]> {
		return this.http.get<BusinessUnitModel[]>(`${ API_BUSINESS_UNIT_URL }/all`);
	}

	// Get all designations
	getAllDesignations(): Observable<DesignationModel[]> {
		return this.http.get<DesignationModel[]>(`${ API_DESIGNATION_URL }/all`);
	}

}
