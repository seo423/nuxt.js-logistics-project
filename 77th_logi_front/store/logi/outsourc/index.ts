import { defineStore } from 'pinia'
import {
  getForwardableList,
  getStandardUnitPrice,
  
} from '@/api/logi/outsourc'

export const outsourcStore = defineStore('outsourcStore', {
  state: () => ({
    getForwardableList: [] as any, //외주관리에 외주자채 출고관리 페이지에서 외주자재 발주 필요목록 조회 하는 url
    getStandardUnitPrice: [] as any, //outsourc 테이블의 standard_unit_price 를 가져오기위한 api
  }),



  actions: {
        //외주관리에 외주자채 출고관리 페이지에서 외주자재 발주 필요목록 조회 하는 url
    async GET_FORWARDABLE_LIST(searchDateCondition: string, startDate: string, endDate: string) {
      try {
        const res = await getForwardableList(searchDateCondition, startDate, endDate)

        console.log('외주자재 발주 필요목록 조회', res)
        console.log('외주자재 발주 필요목록 조회 res.data', res.data)

        this.getForwardableList = res.data
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

            //outsourc 테이블의 standard_unit_price 를 가져오기위한 api
    async GET_STANDARD_UNIT_PRICE(itemCode: string) {
      try {
        const res = await getStandardUnitPrice(itemCode)

        console.log('standard_unit_price', res)
        console.log('standard_unit_price res.data', res.data)

        this.getStandardUnitPrice = res.data
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },


  }
})
