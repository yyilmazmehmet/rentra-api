package com.yilmazmehmet.rentraapi.service;

import java.util.List;
import java.util.Optional;

import com.yilmazmehmet.rentraapi.model.Transfer;

public interface TransferService {
	
	Transfer addTransfer(Transfer transfer);
	List<Transfer> getAllTransfer();
	Transfer updateTransfer(Transfer transfer);
	Optional<Transfer> findTransferById(Long id);

}
