package com.codegym.controller;

import com.codegym.model.contract.ContractDetail;
import com.codegym.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/contract-detail/v1")
public class ContractDetailRestController {
    @Autowired
     private IContractService icontractService;

    @GetMapping("/{id}")
    public ResponseEntity<List<ContractDetail>> getListContractDetail(@PathVariable int id) {
        List<ContractDetail> contractDetailList = icontractService.getContractDetail(id);
        if (contractDetailList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
    }
}
