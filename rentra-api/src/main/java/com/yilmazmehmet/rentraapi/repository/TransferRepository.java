package com.yilmazmehmet.rentraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yilmazmehmet.rentraapi.model.Transfer;

public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
