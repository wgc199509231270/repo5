function saveNews(zanid,ntype,nitemtype,ntext,nitemid) {
    if(ntype==="现场管理"){
        ntype="工作圈"
    }
    var meuserid="";
    //获取当前用户
    $.ajax({
        url: "/tuser/queryIdTuser",
        type: "post",
        dataType: 'json',
        async:false,
        success: function (data) {
            console.log(data)
            meuserid = data.id;
        }
    })
    console.log(meuserid+","+zanid+","+ntext+","+nitemtype+","+nitemid+","+ntype)
   /* if(ntype==="02"){
        var id=meuserid
        meuserid=zanid;
        zanid=id;
    }*/
    if(meuserid===zanid){

    }else{
        //保存消息
        $.ajax({
            url: "/tnews/saveTnews",
            dataType: 'json',
            async:false,
            data:{"nitemuserid":meuserid,"nuserid":zanid,"ntext":ntext,"nitemid":nitemid,"nitemtype":nitemtype,"ntype":ntype},
            success: function (data) {

            }
        })
    }

}
//权限设置
function setQuanx() {
    var sta=true;
    $.ajax({
        url: "/tuser/queryIdTuser",
        type: "post",
        dataType: 'json',
        async:false,
        success: function (data) {
            $.ajax({
                url: "/Tjobinfo/queryTuserByIdTjobinfo",
                type: "post",
                dataType: 'json',
                async:false,
                data:{"userid":data.id},
                success: function (data) {
                    var jobname = data[0].jobname;
                    if(jobname === "董事长"||jobname === "总经理"){
                    }else{
                        sta=false;
                    }
                }
            })
        }
    })
    return sta;
}