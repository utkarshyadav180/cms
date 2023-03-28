package com.cms.constants;

public interface RestMappingConstant {

	String APP_BASE = "/cms/v1";

	public interface ContactManagementSystemUri {

		String CREATE_OR_UPDATE_CONTACT = APP_BASE + "/createOrUpdateContact";
		String DELETE_CONTACT = APP_BASE + "/deleteContact";
		String READ_CONTACT = APP_BASE + "/readContact";

	}
}
