package com.yilmazmehmet.rentraapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yilmazmehmet.rentraapi.model.Transfer;
import com.yilmazmehmet.rentraapi.repository.TransferRepository;
import com.yilmazmehmet.rentraapi.service.TransferService;

@Service
public class TransferServiceImpl implements TransferService {

	private TransferRepository transferRepository;

	@Autowired
	public TransferServiceImpl(TransferRepository transferRepository) {

		super();
		this.transferRepository = transferRepository;

	}

	@Override
	public Transfer addTransfer(Transfer transfer) {

		return transferRepository.save(transfer);

	}

}
