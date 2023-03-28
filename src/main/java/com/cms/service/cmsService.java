package com.cms.service;

import java.util.List;

import com.cms.request.cmsRequest;
import com.cms.response.cmsResponse;

public interface cmsService {
	cmsResponse createOrUpdateContact(cmsRequest request);

	List<cmsResponse> readContact(String firstName, String lastName, String email);

	Object deleteContact(Long id);
}
