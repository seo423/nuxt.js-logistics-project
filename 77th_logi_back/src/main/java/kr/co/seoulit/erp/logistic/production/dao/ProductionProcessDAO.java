package kr.co.seoulit.erp.logistic.production.dao;

import kr.co.seoulit.erp.logistic.production.to.ProductionProcessTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface ProductionProcessDAO {
	ArrayList<ProductionProcessTO> ProductionProcessList();
}
