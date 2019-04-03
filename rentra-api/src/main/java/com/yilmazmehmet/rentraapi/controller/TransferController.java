package com.yilmazmehmet.rentraapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.exception.NoSuchEntityFoundException;
import com.yilmazmehmet.rentraapi.model.Transfer;
import com.yilmazmehmet.rentraapi.service.TransferService;

@PreAuthorize("hasRole('ADMIN')")
@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class TransferController {

	@Autowired
	private TransferService transferService;

	@PostMapping("/transfer")
	public ResponseEntity<Transfer> createCustomer(@RequestBody Transfer transfer) {

		Transfer addedTransfer = transferService.addTransfer(transfer);
		return ResponseEntity.ok(addedTransfer);

	}

	@GetMapping("/transfer")
	public ResponseEntity<List<Transfer>> getAllTransfer() {

		List<Transfer> transferList = transferService.getAllTransfer();

		if (transferList.isEmpty()) {

			throw new NoSuchEntityFoundException("Transfers not found");
		}

		return ResponseEntity.ok(transferList);
	}

	@PutMapping("/transfer/{id}")
	public ResponseEntity<Transfer> updateTransfer(@PathVariable(value = "id") Long transferId,
			@RequestBody Transfer transfer) {

		Optional<Transfer> optional = transferService.findTransferById(transferId);

		if (!optional.isPresent()) {

			throw new NoSuchEntityFoundException("Transfer Id not found ->" + transferId);

		} else {

			transfer.setId(transferId);

			return ResponseEntity.ok(transferService.updateTransfer(transfer));
		}

	}

}
