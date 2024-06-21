import { sysApi } from '@/api'

//URL 적는곳

//MPS 등록
const FIND_PAY_STEP_CODE_DETAIL_LIST = "/findPayStepCodeDetailList";



// //MPS 등록
function getFindPayStepCodeDetailList(itemClassificationCondition : string) {
  return sysApi.get(`${FIND_PAY_STEP_CODE_DETAIL_LIST}`, {
    params: {
      itemClassificationCondition : itemClassificationCondition
    }
  })
  };

export {
  getFindPayStepCodeDetailList,
}
