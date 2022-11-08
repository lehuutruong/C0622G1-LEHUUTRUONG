package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.model.contract.Contract;
import com.codegym.service.contract.IContractService;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.facility.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IContractService iContractService;

    @GetMapping
    public String list(Model model,
                       @PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractPage = iContractService.findAll(pageable);
        model.addAttribute("facilityList", iFacilityService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        Page<ContractDto> contractDtoPage = contractPage.map(new Function<Contract, ContractDto>() {
            @Override
            public ContractDto apply(Contract contract) {
                ContractDto contractDto = new ContractDto();
                BeanUtils.copyProperties(contract, contractDto);
                contractDto.getTotalCost();
                return contractDto;
            }
        });
        model.addAttribute("contractList", contractDtoPage);
        return "contract/contractList";
    }
}
