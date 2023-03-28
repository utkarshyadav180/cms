package com.cms.controller;

import static com.cms.constants.RestMappingConstant.ContactManagementSystemUri.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cms.request.cmsRequest;
import com.cms.response.BaseApiResponse;
import com.cms.response.ResponseBuilder;
import com.cms.service.cmsService;

@RestController
public class cmsController {

	@Autowired
	cmsService cmsService;

	@PostMapping(path = CREATE_OR_UPDATE_CONTACT)
	public ResponseEntity<BaseApiResponse> createContact(@RequestBody cmsRequest request) {
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(cmsService.createOrUpdateContact(request));
		return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);

	}

	@GetMapping(path = READ_CONTACT)
	public ResponseEntity<BaseApiResponse> viewContact(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String email) {
		BaseApiResponse baseApiResponse = ResponseBuilder
				.getSuccessResponse(cmsService.readContact(firstName, lastName, email));
		return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
	}

	@DeleteMapping(path = DELETE_CONTACT)
	public ResponseEntity<BaseApiResponse> deleteContact(@RequestParam Long id) {
		BaseApiResponse baseApiResponse = ResponseBuilder.getSuccessResponse(cmsService.deleteContact(id));
		return new ResponseEntity<>(baseApiResponse, HttpStatus.OK);
	}

}
