import { defineStore } from 'pinia'
import {
  addFinanceClient,
  addGeneralClient,
  addWorkplace,
  deleteFinanceClient,
  deleteGeneralClient,
  deleteWorkplace,
  getCompanyInfo,
  getDeptInfo,
  getFinanceClient,
  getGeneralClient,
  getWorkplaceDetail,
  getWorkplaceList,
  updateFinanceClient,
  updateGeneralClient,
  updateWorkplace,
  getCodeList,
  getWarehouseList,
  getFinanceDetail,
  addWarehouseList,
  deleteWarehouseList,
  searchClientDetailList,
} from '@/api/logi/base'

export const baseStore = defineStore('baseStore', {
  state: () => ({
    companyInfo: [] as any, // 회사정보
    workplaceInfo: [] as any, // 사업장정보
    detailCodeList: [] as any, // 품목코드에 따른 품목명 리스트 
    workplaceDetailInfo: [] as any, // 사업장 상세정보
    addWorkplaceInfo: [] as any, // 사업장 추가
    updateWorkplaceInfo: [] as any, // 사업장 수정
    deleteWorkplaceInfo: [] as any[], // 사업장 식제
    deptInfo: [] as any, // 부서 정보
    generalClientInfo: [] as any, // 일반거래처 조회
    addGeneralClientInfo: [] as any, // 일반거래처 추가
    updateGeneralClientInfo: [] as any, // 일반거래처 수정
    deleteGeneralClientInfo: [] as any, // 일반거래처 삭제
    getFinanceClient: [] as any, // 금융거래처 조회
    addfinanceClientInfo: [] as any, // 금융거래처 추가
    updatefinanceClientInfo: [] as any, // 금융거래처 수정
    deletefinanceClientInfo: [] as any, // 금융거래처 삭제
    getWarehouseList: [] as any, // 창고 조회
    FinanceDetailInfo: [] as any, // 금융거래처 상세조회
    addWarehouse: [] as any, //창고추가
    deleteWarehouse: [] as any, //창고삭제
    clientDetailList : [] as any, //일반거래처 상세조회
  }),
  actions: {
    // 회사정보 조회
    async GET_COMPANY_INFO() {
      try {
        const res = await getCompanyInfo()

        this.companyInfo = res.data.companyInfo
      }
      catch (error: any) {
        console.error('Error fetching data:', error)
      }
    },

    /////////////////////////////////////////

    // 사업장정보 조회
    async GET_WORKPLACE_INFO() {
      try {
        const res = await getWorkplaceList()

        console.log('ddd', res)
        console.log('ddd', res.data)

        this.workplaceInfo = res.data.workplaceList
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 품목코드에 따른 품목명 조회
    async GET_CODELIST(divisionCode: string) {
      try {
        const res = await getCodeList(divisionCode)

        console.log('GET_CODELIST', res)
        console.log('GET_CODELIST', res.data)

        this.detailCodeList = res.data.detailCodeList
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 한 행클릭시 사업장 상세정보 조회
    async GET_WORKPLACE_DETAIL_INFO(workplaceCode: string) {
      try {
        const res = await getWorkplaceDetail(workplaceCode)

        console.log('vv', res)
        console.log('vv', res.data)

        this.workplaceDetailInfo = res.data.workplaceInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 사업장 추가
    async ADD_WORKPLACE_INFO(menudata: any) {
      try {
        const res = await addWorkplace(menudata)

        console.log('vv', res)
        console.log('vv', res.data)

        this.addWorkplaceInfo = res.data.workplaceInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 사업장 수정
    async UPDATE_WORKPLACE_INFO(updateDataList: any) {
      try {
        const res = await updateWorkplace(updateDataList)

        console.log('tt', res)
        console.log('tt', res.data)

        this.updateWorkplaceInfo = res.data.workplaceInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 사업장 삭제
    async DELETE_WORKPLACE_INFO(workplaceCode: string) {
      try {
        const res = await deleteWorkplace(workplaceCode)

        console.log('tt', res)
        console.log('tt', res.data)

        this.deleteWorkplaceInfo = res.data.workplaceCode
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    ////////////////////////////////////

    // 부서정보 조회
    async GET_DEPT_INFO() {
      try {
        const res = await getDeptInfo()

        console.log('ccc', res)
        console.log('ccc', res.data)

        this.deptInfo = res.data.deptInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    /////////////////////////////////////

    // 일반거래처 조회
    async GET_GENERAL_CLIENT_INFO() {
      try {
        const res = await getGeneralClient()

        console.log('general', res)
        console.log('general', res.data)

        this.generalClientInfo = res.data.clientInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 일반거래처 추가
    async ADD_GENERAL_CLIENT_INFO(clientdata: any) {
      try {
        const res = await addGeneralClient(clientdata)

        console.log('ㅁㅇㅇ', res)
        console.log('ㅁㅇㅇ', res.data)

        this.addGeneralClientInfo = res.data.clientInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 일반거래처 수정
    async UPDATE_GENERAL_CLIENT_INFO(updateDataList: any) {
      try {
        const res = await updateGeneralClient(updateDataList)

        console.log('pp', res)
        console.log('pp', res.data)

        this.updateGeneralClientInfo = res.data.clientInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 일반거래처 삭제
    async DELETE_GENERAL_CLIENT_INFO(customerCode: string) {
      try {
        const res = await deleteGeneralClient(customerCode)

        console.log('d', res)
        console.log('d', res.data)

        this.deleteGeneralClientInfo = res.data.clientInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    ////////////////////////////////////////

    // 금융거래처 조회
    async GET_FINANCE_CLIENT_INFO() {
      try {
        const res = await getFinanceClient()

        console.log('f', res)
        console.log('f', res.data)

        this.getFinanceClient = res.data.financeInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 금융거래처 추가
    async ADD_FINANCE_CLIENT_INFO(clientdata: any) {
      try {
        const res = await addFinanceClient(clientdata)

        console.log('ㅁㅇㅇ', res)
        console.log('ㅁㅇㅇ', res.data)

        this.addfinanceClientInfo = res.data.financeInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 금융거래처 수정
    async UPDATE_FINANCE_CLIENT_INFO(clientdata: any) {
      try {
        const res = await updateFinanceClient(clientdata)

        console.log('pp', res)
        console.log('pp', res.data)

        this.updateFinanceClient = res.data.financeInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 금융거래처 삭제
    async DELETE_FINANCE_CLIENT_INFO(accountAssociatesCode: string) {
      try {
        const res = await deleteFinanceClient(accountAssociatesCode)

        console.log('d', res)
        console.log('d', res.data)

        this.deletefinanceClientInfo = res.data.financeInfo
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 창고목록조회 78th추가 
    async GET_WAREHOUSE_LIST() {
      try {
        const res = await getWarehouseList()

        console.log('getWarehouseList', res)
        console.log('getWarehouseList', res.data)

        this.getWarehouseList = res.data.gridRowJson
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

    // 금융거래처 상세조회 78th추가
    async GET_FINANCE_DETAIL_INFO(code:string) {
      try {
        const res = await getFinanceDetail(code)

        console.log('FinanceDetailInfoㅁㅇㅇ', res)
        console.log('FinanceDetailInfo ㅁㅇㅇ', res.data)

        this.FinanceDetailInfo = res.data.financeDetailInfo[0]
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

        // 창고추가 78th추가 
    async ADD_WAREHOUSE_LIST(batchList:any) {
      try {
        const res = await addWarehouseList(batchList)

        console.log('addWarehouseList', res)
        console.log('addWarehouseList', res.data)

        this.addWarehouse = res.data
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

        // 창고삭제 78th추가 
    async DELETE_WAREHOUSE_LIST(deleteList:any) {
      try {
        const res = await deleteWarehouseList(deleteList)

        console.log('deleteWarehouseList', res)
        console.log('deleteWarehouseList', res.data)

        this.deleteWarehouse = res.data
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },

        // 일반거래처 상세조회 78th추가
    async SEARCH_CLIENT_DETAIL_URL(customerCodes:string) {
      try {
        const res = await searchClientDetailList(customerCodes)

        console.log('clientDetailList', res)
        console.log('clientDetailList ㅁㅇㅇ', res.data)

        this.clientDetailList = res.data.clientDetailInfo[0]
      }
      catch (error) {
        console.error('Error fetching data:', error)
      }
    },


  },
})
