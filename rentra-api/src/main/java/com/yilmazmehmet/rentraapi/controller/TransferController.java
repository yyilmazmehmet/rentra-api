package com.yilmazmehmet.rentraapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yilmazmehmet.rentraapi.model.Transfer;
import com.yilmazmehmet.rentraapi.service.TransferService;

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

}
