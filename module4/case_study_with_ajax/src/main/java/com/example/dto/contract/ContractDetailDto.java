package com.example.dto.contract;

import com.example.model.contract.AttachFacility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;

public class ContractDetailDto implements Validator {
    private AddContractDto contract;
    private AttachFacility attachFacility;
    @Min(value = 1, message = "Số lượng phải là số nguyên dương")
    private int quantity;
    public ContractDetailDto() {
    }

    public AddContractDto getContract() {
        return contract;
    }

    public void setContract(AddContractDto contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        if (contractDetailDto.getQuantity() <=0) {
            errors.rejectValue("quantity", "quantity", "The quantity must greater than 0");
        }
    }
}
