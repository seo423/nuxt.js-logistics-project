import { defineStore } from 'pinia'
import {
  getUnitPriceOfEstimate,
  addNewEstimates,
  getEstimateContractInfo,
  addNewContract,
  getContract,
  getContractDetail,
  getSalesPlan,
  getDeliverableContractList,
  addDelivery,
  putModifyEstimate,
  getSearchEstimatesList,
  getEstimateDetail,
  deleteEstimate,
  deleteContract,
} from '@/api/logi/sales'

export const salesStore = defineStore('salesStore', {
  state: () => ({
    unitPriceOfEstimate: 0 as number, 
    estimateContractInfo: [] as any, 
    contractInfo: [] as any, 
    contractDetailInfo: [] as any, // 행사정보
    salesPlanInfo: [] as any,
    deliverableContractListInfo: [] as any,
    addDeliveryStatus: '' as string,
    putModifyEstimate: [] as any,
    SearchEstimatesList: [] as any, //견적조회
    estimateDetailInfo: [] as any,
    deleteEstimate: [] as any, //견적삭제
    deleteContract: [] as any, //수주삭제
  }),
  actions: {
    // 제품 단가 조회
    async GET_UNITPRICE(itemCode: string) {
      try {
        const res = await getUnitPriceOfEstimate(itemCode)

        console.log('Response', res)
        console.log('Response.data', res.data)

        this.unitPriceOfEstimate = res.data.unitPriceOfEstimate
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },
   // 견적 추가
   async ADD_NEW_ESTIMATE(newEstimateInfo: object) {
    try {
      const res = await addNewEstimates(newEstimateInfo)

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },
  // 등록된 견적 조회
  async GET_ESTIMATE_CONTRACT_INFO(startDate: string, endDate: string) {
    try {
      const res = await getEstimateContractInfo(startDate,endDate)

      console.log('Response', res)
      console.log('Response.data', res.data)

      this.estimateContractInfo = res.data.gridRowJson
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  // 수주 추가
  async ADD_NEW_CONTRACT(newContractTO: object) {
    try {
      const res = await addNewContract(newContractTO)

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  // 수주 조회
  async SEARCH_CONTRACT(searchCondition: string, customerCode: string, startDate: string, endDate: string) {
    try {
      const res = await getContract(searchCondition,customerCode, startDate, endDate)
      this.contractInfo = res.data.gridRowJson

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  // 수주 상세 조회
  async SEARCH_CONTRACT_DETAIL(contractNo: string) {
    try {
      const res = await getContractDetail(contractNo)
      this.contractDetailInfo = res.data.gridRowJson

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  //판매계획 조회
  async SEARCH_SALES_PLAN() {
    try {
      const res = await getSalesPlan()
      this.salesPlanInfo = res.data

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  //납품가능한 수주 리스트 조회
  async SEARCH_DELIVERABLE_CONTRACT_LIST(startDate: string, endDate: string, searchCondition: string, customerCode: string) {
    try {
      const res = await getDeliverableContractList(startDate, endDate, searchCondition, customerCode)
      this.deliverableContractListInfo = res.data.gridRowJson

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
  },

  //납품 추가
  async ADD_DELIVERY(contractDetailNo: string) {
    try {
      const res = await addDelivery(contractDetailNo)

      console.log('Response', res)
      console.log('Response.data', res.data)

      const { errorMsg } = res.data;
      this.addDeliveryStatus = errorMsg;

    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
    },
  
  // 견적수정
  async PUT_MODIFY_ESTIMATE_URL(estimateTO: object) {
    try {
      const res = await putModifyEstimate(estimateTO)

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
    },
  
    //견적조회
    async SEARCH_ESTIMATES_LIST_URL(startDate: string, endDate: string, selectedItem: any) {
    try {
      const res = await getSearchEstimatesList(startDate, endDate, selectedItem)
      this.SearchEstimatesList = res.data.gridRowJson

      console.log('SearchEstimatesList Response', res.data.gridRowJson)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
    },
    
//견적 상세 조회
  async SEARCH_ESTIMATE_DETAIL(estimateNo: string) {
    try {
      const res = await getEstimateDetail(estimateNo)
      this.estimateDetailInfo = res.data.gridRowJson

      console.log('Response', res)
      console.log('Response.data', res.data)
    }
    catch (error) {
      console.error('Error fetching data:', error)
    }
    },
  
      // 견적 삭제
    async DELETE_ESTIMATE_URL(estimateNo: string) {
      try {
        const res = await deleteEstimate(estimateNo)

        console.log('견적삭제 : ', res)
        console.log('견적삭제 : ', res.data)

        this.deleteEstimate = res.data.estimateNo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

      // 수주삭제
    async DELETE_CONTRACT_URL(contractNo: string) {
      try {
        const res = await deleteContract(contractNo)

        console.log('수주삭제 : ', res)
        console.log('수주삭제 : ', res.data)

        this.deleteContract = res.deleteContract.contractNo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },



  },
})
