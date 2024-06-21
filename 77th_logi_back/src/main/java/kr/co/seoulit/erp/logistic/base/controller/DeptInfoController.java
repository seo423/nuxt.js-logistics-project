package kr.co.seoulit.erp.logistic.base.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import kr.co.seoulit.erp.logistic.base.servicefacade.DeptInfoServiceFacade;
import kr.co.seoulit.erp.logistic.base.to.DeptInfoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Tag(name = "부서정보")
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/*")
public class DeptInfoController {

    @Autowired
    private DeptInfoServiceFacade deptSF;
    @Operation(summary = "부서정보 조회")
    @RequestMapping(value = "/base/getdeptInfo", method = RequestMethod.GET)
    public ModelMap getDeptInfo() {
        return deptSF.getDeptInfo();
    }

}
