$(function() {
    if ($('#category_name').attr('value') != null) {
        getSearchList('');
    }
});

function getSearchList(category) {
    // 입력값 변수화
    var start_date = $("#start_date").val();
    var end_date = $("#end_date").val();

    // 전송 json
    var list = {
        "start_date": start_date,
        "end_date": end_date,
        "c_category": category
    };

    // ajax 통신
    $.ajax({
        type: "get",
        url: "/getAjaxArea.do",
        contentType: "application/json",
        data: list,
        dataType: "json", // 수신 json
    })

        // 통신 성공 시 리스트 추출
        .done(function (jsonAreaChart) {

            // 조회년도
            var date = JSON.parse(jsonAreaChart[0].categories);
            var count = JSON.parse(jsonAreaChart[1].data);
            var avgTY = JSON.parse((jsonAreaChart[4]));

            // 조회1년전
            var dately = JSON.parse(jsonAreaChart[2].categories);
            var countly = JSON.parse(jsonAreaChart[3].data);
            var avgLY = JSON.parse((jsonAreaChart[5]));

            Highcharts.chart('container', {
                chart: {
                    type: 'area'
                },
                title: {
                    text: ''
                },
                subtitle: {
                    text: '',
                    align: 'right',
                    verticalAlign: 'bottom'
                },
                legend: {
                    layout: 'vertical',
                    align: 'left',
                    verticalAlign: 'top',
                    x: 100,
                    y: 70,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor:
                        Highcharts.defaultOptions.legend.backgroundColor || '#FFFFFF'
                },
                xAxis: {
                    categories: date
                },
                yAxis: {
                    title: {
                        text: '키워드 수'
                    },
                    plotLines: [
                        {//기준점 사용 옵션.
                            color: '#fa219c',
                            width: 2,
                            value: avgTY,
                            dashStyle: 'shortdash',//라인 스타일 지정 옵션
                            zIndex: 5,
                            label: {
                                text: '조회연도: '+avgTY,
                                align: 'right',
                                x: -10,
                                y: -6,
                                style: {
                                    color:'#fa219c',
                                    fontWeight: '700',
                                }
                            }
                        },
                        {
                            color: '#1aba00',
                            width: 2,
                            value: avgLY,
                            dashStyle: 'shortdash',
                            zIndex: 5,
                            label: {
                                text:'조회전연도: '+avgLY,
                                align: 'right',
                                x: -10,
                                y: -6,
                                style: {
                                    color:'#1aba00',
                                    fontWeight: '700',
                                },
                                //useHTML: true,
                            }
                        }]
                },
                plotOptions: {
                    area: {
                        fillOpacity: 0.5
                    }
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: '조회연도',
                    data: count
                }, {
                    name: '조회전연도',
                    data: countly
                }]
            });
        })


}