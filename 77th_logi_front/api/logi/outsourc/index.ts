import { logiApi } from '@/api'

//외주관리에 외주자채 출고관리 페이지에서 외주자재 발주 필요목록 조회 하는 url
const GET_FORWARDABLE_LIST = 'outsourc/searchForwardableList'

//outsourc 테이블의 standard_unit_price 를 가져오기위한 api
const GET_STANDARD_UNIT_PRICE = 'outsourc/getStandardUnitPrice'


//외주관리에 외주자채 출고관리 페이지에서 외주자재 발주 필요목록 조회 하는 url
function getForwardableList(searchDateCondition: string, startDate: string, endDate: string) {
  return logiApi.get(`${GET_FORWARDABLE_LIST}`, {
    params: {
        searchDateCondition,
        startDate,
        endDate,
      },
  })
}

//outsourc 테이블의 standard_unit_price 를 가져오기위한 api
function getStandardUnitPrice(itemCode: string) {
  return logiApi.get(`${GET_STANDARD_UNIT_PRICE}`, {
    params: {
        itemCode,
      },
  })
}

export {
  getForwardableList,
  getStandardUnitPrice,
}



