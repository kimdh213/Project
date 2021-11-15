function DateCheck() {
    var arySrtDt = document.frm.start_date.value.split("-");
    var aryEndDt = document.frm.end_date.value.split("-");

    if( arySrtDt.length != 3 || aryEndDt.length != 3){
        alert("날짜 형식이 잘못되었습니다.");
        return false;
    }
    var startDt = new Date(Number(arySrtDt[0]),Number(arySrtDt[1])-1,Number(arySrtDt[2]));
    var endDt = new Date(Number(aryEndDt[0]),Number(aryEndDt[1])-1,Number(aryEndDt[2]));

    resultDt = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));

    if(resultDt < 0 ){
        alert("조회 시작일이 종료일 보다 큽니다.");
        return false;
    }
    if(resultDt > 30){
        alert("조회기간은 30일을 초과할 수 없습니다.");
        return false;
    }
    return true;
}

function DateCheck2() {
    var arySrtDt = document.frm.start_date.value.split("-");
    var aryEndDt = document.frm.end_date.value.split("-");

    if( arySrtDt.length != 3 || aryEndDt.length != 3){
        alert("날짜 형식이 잘못되었습니다.");
        return false;
    }
    var startDt = new Date(Number(arySrtDt[0]),Number(arySrtDt[1])-1,Number(arySrtDt[2]));
    var endDt = new Date(Number(aryEndDt[0]),Number(aryEndDt[1])-1,Number(aryEndDt[2]));

    resultDt = Math.floor(endDt.valueOf()/(24*60*60*1000)- startDt.valueOf()/(24*60*60*1000));

    if(resultDt < 0 ){
        alert("조회 시작일이 종료일 보다 큽니다.");
        return false;
    }
    return true;
}