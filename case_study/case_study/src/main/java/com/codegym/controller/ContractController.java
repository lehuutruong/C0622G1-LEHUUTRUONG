package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.dto.FacilityDto;
import com.codegym.model.contract.AttachFacility;
import com.codegym.model.contract.Contract;
import com.codegym.model.contract.ContractDetail;
import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import com.codegym.service.attachFacility.IAttachFacilityService;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
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
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getListAttachFacility() {
        return iContractService.getAttachFacilities();
    }

    @ModelAttribute("facilityList")
    public List<Facility> getListFacility() {
        return iFacilityService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> getListEmployee() {
        return iEmployeeService.getEmployee();
    }

    @ModelAttribute("customerList")
    public List<Customer> getListCustomer() {
        return iCustomerService.getCustomer();
    }

    @ModelAttribute("contractDetailList")
    public List<ContractDetail> getListContractDetail() {
        return iContractService.getListContractDetail();
    }

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

    @PostMapping("/create-attach")
    public String createAttach(@RequestParam(value = "attachId") int attachId,
                               @RequestParam(value = "quantity") int quantity,
                               @RequestParam(value = "contractId") int contractId, RedirectAttributes redirectAttributes) {

        ContractDetail contractDetail = new ContractDetail();
        Contract contract = iContractService.findById(contractId);
        contractDetail.setContract(contract);
        contractDetail.setQuantity(quantity);
        contractDetail.setAttachFacility(iAttachFacilityService.findAttachFacilityId(attachId));
        iContractService.saveContractDetail(contractDetail);
        redirectAttributes.addFlashAttribute("message", "Add AttachFacility successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contractList", new ContractDto());
        return "contract/contractCreate";
    }

    @PostMapping("/save")
    public String create(ContractDto contractDto, RedirectAttributes redirectAttributes) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        iContractService.create(contract);
        redirectAttributes.addFlashAttribute("mess", "Add Success!!");
        return "redirect:/contract";
    }
}
