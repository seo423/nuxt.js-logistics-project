package kr.co.seoulit.erp.logistic.sales.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.seoulit.erp.logistic.sales.entity.ClientDelivery;
import kr.co.seoulit.erp.logistic.sales.servicefacade.SalesServiceFacade;
import kr.co.seoulit.erp.logistic.sales.to.ClientDeliveryTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 이곳은 물류센터로 납품된 품목들을 고객들에게 배송하는 배송관리페이지임

@Tag(name = "배송관리")
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/logi/sales/*", produces = "application/json")
public class ClientDeliveryController {
    @Autowired
    private SalesServiceFacade salesSF;

    private ModelMap modelMap = new ModelMap();

    @Operation(summary = "배송조회")
    @RequestMapping("/getClientDelivery")
    public ModelMap getClientDeliveryList(){
        return salesSF.getClientDeliveryList();
    }

    @Operation(summary = "배송 등록")
    @PostMapping("/addClientDelivery")
    public Map<String, Object> addNewClientDelivery(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        try {
            // 출고 등록을 위한 퍼사드 메소드 호출
            result = salesSF.addNewClientDelivery(params);

            // 반환된 결과에 'generatedOutputNumber'가 있을 경우 클라이언트로 전송
            if (result.containsKey("generatedClientDeliveryNumber")) {
                return result;
            } else {
                result.put("errorCode", -2);
                result.put("errorMsg", "Internal Server Error");
            }
        } catch (Exception e) {
            result.put("errorCode", -2);
            result.put("errorMsg", e.getMessage());
        }

        return result;
    }

    @Operation(summary = "배송 수정")
    @PutMapping("/updateClientDelivery")
    public void updateClientDelivery(@RequestBody @Parameter(description = "배송JSON") ClientDelivery clientDelivery){
        salesSF.updateClientDelivery(clientDelivery);
    }

    @Operation(summary = "배송삭제")
    @DeleteMapping(value = "/deleteClientDelivery/{deliveryNumber}")
    public void deleteClientDelivery(@PathVariable @Parameter(description = "배송JSON")String deliveryNumber) {
        salesSF.deleteClientDelivery(deliveryNumber);
    }

}
