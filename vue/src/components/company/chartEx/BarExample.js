import { Bar } from './BaseCharts'
export default {
  extends: Bar,
  props:['data'],
  methods:{
    dataInit(revenue){
      this.renderChart({
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
        datasets: [
          {
            label: '판매액',
            backgroundColor: '#99ccff',
            data: revenue
          }
        ]
      }, {responsive: true, maintainAspectRatio: false})
    }

  },


}