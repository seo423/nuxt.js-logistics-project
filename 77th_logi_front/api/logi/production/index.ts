import { logiApi } from "@/api";

const WORKORDER_MRP_LIST_URL = "/production/getWorkOrderableMrpList";
const ADD_WORKORDER_DIALOG_URL = "/production/showWorkOrderDialog";
const ACTUAL_WORKORDER_BUTTON_URL = "/production/workOrder";
const WORKORDER_LIST_STATUS_URL = "/production/getWorkOrderInfoListStatus";
const EDIT_ACTUAL_AMOUNT_URL = "production/editActualAmount";
const WORKORDER_COMPLETION_URL = "production/workOrderCompletion";
const WORK_PERFORMANCE_MANAGEMENT_URL = "production/getProductionPerformanceInfoList";
const WORKPLACE_URL = "/production/getWorkSiteList";
const SEARCH_CONTRACT_AVAILABLE_URL = "production/searchContractDetailInMpsAvailable";

//MPS 등록가능한 수주 조회
const WORKPLACE_LOG_URL = "/production/getProductionProcessCode";
//MPS 등록
const CONTRACT_TO_MPS_URL = "/production/convertContractDetailToMps";

// //작업지시 모의전개 모달창에서 작업장 조회
const GET_PRODUCTION_PROCESS_LIST = "/production/ProductionProcessList";
// //작업지시 모의전개 모달창에서 지점 조회
const GET_WORKPLACE_LIST = "/production/WorkplaceList";
//MRP 소요량전개 페이지에서 수주 조회 
const SEARCH_MPS_INFO_URL = '/production/searchMpsInfo'
//MRP 품목별 소요량 취합 실행
const GET_MRP_GATHERING_LIST_URL = '/production/mrpGathering/getMrpGatheringList'
//소요량 취합 조회
const GET_SEARCH_MRP_GATHERING_URL = '/production/mrpGathering/searchMrpGathering'
//품목별 조달계획 디폴트 테이블
const GET_MRP_LIST_URL = '/production/mrpGathering/getMrpList'
//MRP 모의전개
const OPEN_MRP_URL = '/production/openMrp'
//MRP 등록
const REGISTER_MRP_URL = '/production/registerMrp'

///////////////////////////////////////////////////

//작업지시 필요항목 조회
function getWorkOrderMrpList(startDate: string, endDate: string) {
  return logiApi.get(`${WORKORDER_MRP_LIST_URL}`, {
    params: {
      startDate,
      endDate
    },
  });
}

//작업지시 모의전개
function getAddWorkOrderDialog(mrpNo:string, mrpGatheringNo:string) {
  return logiApi.get(`${ADD_WORKORDER_DIALOG_URL}`, {
    params: {
      mrpNo,
      mrpGatheringNo,
    },
  });
}

//실제 작업지시
function getActualWorkOrderButton( mrpGatheringNo: string, workPlaceCode: string, productionProcessCode: string ) {
  return logiApi.get(`${ACTUAL_WORKORDER_BUTTON_URL}`, {
    params: {
      mrpGatheringNo, 
      workPlaceCode, 
      productionProcessCode,
    },
  });
}

//작업지시현황 조회 
function getWorkOrderListStatus() {
  return logiApi.get(`${WORKORDER_LIST_STATUS_URL}`);
}

//작업완료된 수량 입력
function putActualAmount(workOrderInfoTO: any) {
  return logiApi.put(`${EDIT_ACTUAL_AMOUNT_URL}`, workOrderInfoTO);
}

//작업완료 등록
function getWorkOrderCompletion(workOrderNo:string, actualCompletionAmount:any ) {
  return logiApi.get(`${WORKORDER_COMPLETION_URL}`, {
    params: {
      workOrderNo, 
      actualCompletionAmount, 
    },
  });
}

//생산실적 조회 
function getWorkPerformanceManagement() {
  return logiApi.get(`${WORK_PERFORMANCE_MANAGEMENT_URL}`);
}

//작업장 조회
function getWorkPlace() {
  return logiApi.get(`${WORKPLACE_URL}`);
}

//작업장로그 조회
function getWorkPlaceLog(productionProcessCode:string, workSiteName:string) {
  return logiApi.get(`${WORKPLACE_LOG_URL}`, {
    params: {
      productionProcessCode,
      workSiteName,
    },
  });
}

//MPS 등록가능한 수주 조회
function getContractAvailable(startDate : string, endDate : string, searchCondition : string) {
  return logiApi.get(`${SEARCH_CONTRACT_AVAILABLE_URL}`, {
    params: {
      startDate,
      endDate,
      searchCondition,
    },
  });
}

// //MPS 등록
function postContractToMps(mpsData : any) {
  return logiApi.post(`${CONTRACT_TO_MPS_URL}`, mpsData);
}

// //작업지시 모의전개 모달창에서 작업장 조회
function getProductionProcessList() {
  console.log('logiApi.get(`${GET_PRODUCTION_PROCESS_LIST}`)   ', logiApi.get(`${GET_PRODUCTION_PROCESS_LIST}`));
  return logiApi.get(`${GET_PRODUCTION_PROCESS_LIST}`);
}

// //작업지시 모의전개 모달창에서 지점 조회
function getWorkplaceList() {
  console.log('logiApi.get(`${GET_WORKPLACE_LIST}`)   ', logiApi.get(`${GET_WORKPLACE_LIST}`));

  return logiApi.get(`${GET_WORKPLACE_LIST}`);
}

 //MRP 소요량전개 페이지에서 수주 조회 
function getSearchMpsInfo(startDate : string, endDate : string, classification:string) {
  return logiApi.get(`${SEARCH_MPS_INFO_URL}`, {
    params: {
      startDate,
      endDate,
      classification
    },
  });
}

 //MRP 품목별 소요량 취합 실행 --api만 만들어놓음
function getMrpGatheringList(mpsNoList : string) {
  return logiApi.get(`${GET_MRP_GATHERING_LIST_URL}`, {
    params: {
      mpsNoList
    },
  });
}

 //소요량 취합 조회 --api만 만들어놓음
function getSearchMrpGathering(startDate : string, endDate : string, classification:string) {
  return logiApi.get(`${GET_SEARCH_MRP_GATHERING_URL}`, {
    params: {
      startDate,
      endDate,
      classification
    },
  });
}

 //품목별 조달계획 디폴트 테이블 --api만 만들어놓음
function getMrpList(mrpGatheringStatusCondition : string) {
  return logiApi.get(`${GET_MRP_LIST_URL}`, {
    params: {
      mrpGatheringStatusCondition
    },
  });
}

 //MRP 모의전개 --api만 만들어놓음
function openMrp(mpsNo : string) {
  return logiApi.get(`${OPEN_MRP_URL}`, {
    params: {
      mpsNo
    },
  });
}

 //MRP 등록 --api만 만들어놓음
function registerMrp(body: any) {
  return logiApi.put(`${REGISTER_MRP_URL}`, body)
}



export {
  getWorkPlace,
  getWorkPlaceLog,
  getWorkOrderMrpList,
  getAddWorkOrderDialog,
  getActualWorkOrderButton,
  getWorkOrderListStatus,
  putActualAmount,
  getWorkOrderCompletion,
  getWorkPerformanceManagement,
  getContractAvailable,
  postContractToMps,
  getProductionProcessList,
  getWorkplaceList,
  getSearchMpsInfo,
  getMrpGatheringList,
  getSearchMrpGathering,
  getMrpList,
  openMrp,
registerMrp,
}
