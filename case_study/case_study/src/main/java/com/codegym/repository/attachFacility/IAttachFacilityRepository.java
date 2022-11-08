package com.codegym.repository.attachFacility;

import com.codegym.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility,Integer> {
}
