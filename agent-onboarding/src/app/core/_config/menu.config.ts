export class MenuConfig {
	public defaults: any = {
		header: {
			self: {},
			items: [
				{
					title: 'Dashboards',
					root: true,
					alignment: 'left',
					page: '/dashboard',
					translate: 'MENU.DASHBOARD',
				},
				{
					title: 'Hierarchy Template', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/hierarchy-template', // <= URL
					translate: 'MENU.HIERARCHY_TEMPLATE',
					icon: 'flaticon-line-graph' // <= Choose the icon
				},
				{
					title: 'Individual Hierarchy', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/individual-hierarchy', // <= URL
					translate: 'MENU.INDIVIDUAL_HIERARCHY',
					icon: 'flaticon-line-graph' // <= Choose the icon
				},
				{
					title: 'Parent Hierarchy', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/parent-hierarchy', // <= URL
					translate: 'MENU.PARENT_HIERARCHY',
					icon: 'flaticon-line-graph' // <= Choose the icon
				}

			]
		},
		aside: {
			self: {},
			items: [
				{
					title: 'Dashboard',
					root: true,
					icon: 'flaticon2-architecture-and-city',
					page: '/dashboard',
					translate: 'MENU.DASHBOARD',
					bullet: 'dot',
				},
				{
					title: 'Hierarchy Template', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/hierarchy-template', // <= URL
					translate: 'MENU.HIERARCHY_TEMPLATE',
					icon: 'flaticon-line-graph' // <= Choose the icon
				},
				{
					title: 'Individual Hierarchy', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/individual-hierarchy', // <= URL
					translate: 'MENU.INDIVIDUAL_HIERARCHY',
					icon: 'flaticon-line-graph' // <= Choose the icon
				}
				,
				{
					title: 'Parent Hierarchy', // <= Title of the page
					desc: 'Some my description goes here', // <= Description of the page
					root: true,
					page: '/parent-hierarchy', // <= URL
					translate: 'MENU.PARENT_HIERARCHY',
					icon: 'flaticon-line-graph' // <= Choose the icon
				}
			]
		},
	};

	public get configs(): any {
		return this.defaults;
	}
}
