package kr.co.seoulit.erp.logistic.production.controller;

import java.util.List;


import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.servicefacade.ProductionPerformanceServiceFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Tag(name = "작업지시/생산실적관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping("/logi/production/*")
public class ProductionPerformanceController {

    @Autowired
    private ProductionPerformanceServiceFacade ProductionPerformanceSF;

    /*************************************
     생산실적관리 Tab - 생산실적조회(JPA)
     *************************************/
    @Operation(summary = "생산실적조회")
    @RequestMapping(value = "/getProductionPerformanceInfoList", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ProductionPerformance>> getWorkOrderInfoListStatus() {
        System.out.println("ProductionPerformanceController");
        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getProductionPerformanceInfoList();
        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
    }

    private ModelMap modelMap = new ModelMap();
    @Operation(summary = "작업장 조회")
    @RequestMapping("/ProductionProcessList")
    public ModelMap getProductionProcessList() {
        System.out.println("ProductionPerformanceController.ProductionProcessList 까지 왔나용~?");
        System.out.println("ProductionPerformanceSF.getProductionProcessList() " + ProductionPerformanceSF.getProductionProcessList());
        return ProductionPerformanceSF.getProductionProcessList();
    }

    @Operation(summary = "지점 조회")
    @RequestMapping("/WorkplaceList")
    public ModelMap getWorkplaceList() {
        System.out.println("ProductionPerformanceController.getWorkplaceList 까지 왔나용~?");
        System.out.println("ProductionPerformanceSF.getWorkplaceList " + ProductionPerformanceSF.getWorkplaceList());
        return ProductionPerformanceSF.getWorkplaceList();
    }

    /*************************************
     생산실적관리 Tab - 생산실적관리조회(Spring)
     *************************************/
//    @RequestMapping(value = "/productionperformance/itemClassification", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity<List<ProductionPerformance>> getItemClassifiction(@RequestParam String itemClassification) {
//        System.out.println("ProductionPerformanceController = " );
//        List<ProductionPerformance> ProductionPerformanceList = ProductionPerformanceSF.getItemClassifiction(itemClassification);
//        System.out.println("ProductionPerformanceController = " );
//        return new ResponseEntity<>(ProductionPerformanceList, HttpStatus.OK);
//    }
}
