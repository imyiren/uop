package com.imyiren.uop.convertor;

import com.imyiren.uop.application.write.cmd.CustomerSaveCmd;
import com.imyiren.uop.request.CustomerSaveRequest;

public abstract class CustomerConvertor{
    public static CustomerSaveCmd toCustomerSaveCmd(CustomerSaveRequest request) {
        CustomerSaveCmd customerSaveCmd = new CustomerSaveCmd();
        customerSaveCmd.setId(request.getId());
        customerSaveCmd.setName(request.getName());
        customerSaveCmd.setGender(request.getGender());
        customerSaveCmd.setCompany(request.getCompany());
        customerSaveCmd.setSourceType(request.getSourceType());
        customerSaveCmd.setPhone(request.getPhone());
        customerSaveCmd.setWechat(request.getWechat());
        customerSaveCmd.setQq(request.getQq());
        customerSaveCmd.setQqGroup(request.getQqGroup());
        customerSaveCmd.setEmail(request.getEmail());
        customerSaveCmd.setRequirement(request.getRequirement());
        customerSaveCmd.setMedicalDepartment(request.getMedicalDepartment());
        customerSaveCmd.setCustomerFileList(request.getCustomerFileList());
        customerSaveCmd.setResultFileList(request.getResultFileList());
        return customerSaveCmd;
    }
}
