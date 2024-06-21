package kr.co.seoulit.erp.logistic.production.dao;


import kr.co.seoulit.erp.logistic.production.to.WorkSiteLogTO;
import kr.co.seoulit.erp.logistic.production.to.WorkSiteTO;
import kr.co.seoulit.erp.logistic.production.to.WorkplaceListTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.ArrayList;

@Mapper
public interface WorkPlaceDAO {

    public ArrayList<WorkplaceListTO> workplaceTOList();


    public ArrayList<WorkSiteTO> selectWorkSiteList();

    public void insertWorkPlaceList(WorkSiteLogTO newWorkPlaceList);

    public void deleteWorkPlaceList(WorkSiteLogTO newWorkPlaceList);
}
