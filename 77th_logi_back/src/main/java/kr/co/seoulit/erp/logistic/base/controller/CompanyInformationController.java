package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import kr.co.seoulit.erp.logistic.base.servicefacade.CompanyInfoServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.CompanyInfoTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Tag(name = "회사정보")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/*")
public class CompanyInformationController {

    @Autowired
    private CompanyInfoServiceFacade companySF;
    @Operation(summary = "회사정보 조회")
    @RequestMapping(value = "/base/getcompanyInfo", method = RequestMethod.GET)
    public ModelMap getCompanyInfo(){
        return companySF.getCompanyInfo();
    }

}
