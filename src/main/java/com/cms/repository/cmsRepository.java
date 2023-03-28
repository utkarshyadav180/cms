package com.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cms.entity.cmsDataEntity;

public interface cmsRepository extends JpaRepository<cmsDataEntity, Long> {

	@Query("SELECT c FROM cmsDataEntity c WHERE active=true "
			+ "AND ( c.firstName IN (:firstName) OR coalesce(:firstName) IS null) "
			+ "AND ( c.lastName IN (:lastName) OR coalesce(:lastName) IS null) "
			+ "AND ( c.email IN (:email) OR coalesce(:email) IS null) ")
	List<cmsDataEntity> findContactByFilter(String firstName, String lastName, String email);
}
