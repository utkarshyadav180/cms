package com.cms.service.impl;

import static com.cms.constants.cmsConstant.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.entity.cmsDataEntity;
import com.cms.exceptions.InvalidInputException;
import com.cms.repository.cmsRepository;
import com.cms.request.cmsRequest;
import com.cms.response.cmsResponse;
import com.cms.service.cmsService;

@Service
public class cmsServiceImpl implements cmsService {

	@Autowired
	cmsRepository cmsRepository;

	/**
	 * With this method user can create contact by giving null Id and if user giving
	 * any id then it can update that data
	 */
	@Override
	public cmsResponse createOrUpdateContact(cmsRequest request) {
		cmsDataEntity cmsEntity = new cmsDataEntity();

		if (request.getId() != null) {
			cmsEntity = cmsRepository.findById(request.getId())
					.orElseThrow(() -> new InvalidInputException(INVALID_CONTACT_ID, INVALID_CONTACT_ID_ERROR_CODE,
							INVALID_CONTACT_ID_ERROR_MESSAGE));
		}

		cmsEntity.setFirstName(request.getFirstname());
		cmsEntity.setLastName(request.getLastName());
		cmsEntity.setEmail(request.getEmail());
		cmsEntity.setPhoneNumber(request.getPhoneNumber());

		return responseConverter(cmsRepository.save(cmsEntity));
	}

	@Override
	public List<cmsResponse> readContact(String firstName, String lastName, String email) {
		List<cmsDataEntity> entities = cmsRepository.findContactByFilter(firstName, lastName, email);

		return entities.stream().map(this::responseConverter).collect(Collectors.toList());
	}

	@Override
	public Object deleteContact(Long id) {
		cmsDataEntity cmsEntity = cmsRepository.findById(id)
				.orElseThrow(() -> new InvalidInputException(INVALID_CONTACT_ID, INVALID_CONTACT_ID_ERROR_CODE,
						INVALID_CONTACT_ID_ERROR_MESSAGE));
		cmsEntity.setActive(false);
		cmsRepository.save(cmsEntity);

		return CONTACT_DELETED_SUCCESSFULLY;
	}

	private cmsResponse responseConverter(cmsDataEntity entity) {
		return cmsResponse.builder().id(entity.getId()).email(entity.getEmail()).firstname(entity.getFirstName())
				.lastName(entity.getLastName()).phoneNumber(entity.getPhoneNumber()).build();

	}
}
