package kr.co.seoulit.erp.logistic.production.servicefacade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.co.seoulit.erp.logistic.production.domain.ProductionPerformance;
import kr.co.seoulit.erp.logistic.production.domain.WorkOrderInfo;
import kr.co.seoulit.erp.logistic.production.to.*;
import org.springframework.ui.ModelMap;

public interface ProductionPerformanceServiceFacade {

    public List<ProductionPerformance> getProductionPerformanceInfoList();

    ModelMap getProductionProcessList();

    ModelMap getWorkplaceList();


//    public List<ProductionPerformance> getItemClassifiction(String itemClassifiction);
}
