/* <!--刷新当前页面  -->
    <script type="text/javascript">
        laydate.render({
            elem: '#Begtime'
        });
        laydate.render({
            elem: '#Endtime'
        });
        laydate.render({
            elem: '#Searchtime'
        });
    </script>
    <script th:inline="javascript">
        var bs = [[${bs}]]
        var sign_id;
        var plan_id;
        var mood_id;
        $(function () {
            $("a").tooltip();
            $(":button").tooltip();
            $("#big").show();
            $("#donghua").remove();
            $("#toolbar2").hide();
            $("#example").hide();
            $("#paiming").hide();
            $("#paimingtable").hide();
            $("#tongji").show();
            $("#tongjitable").show();
            $("#sliders").show();
            if (bs==1){
                $("#example").show();
                $("#tongji").hide();
                $("#tongjitable").hide();
                $("#sliders").hide();
            }
            $("#jump").click(function () {
                $.ajax({
                    url:"/clock/queryclock",
                    data: {"cltype":"01"},
                    async:false,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data.code==404){
                            $("#jump").attr("href","");
                            alert("亲，您已签到");
                        }
                    },
                    error:function (error) {
                        alert("网络状况不佳，用户登录失败！" + error.status);
                    }
                });
            })
            personname();
            $("#name1").searchableSelect();
            tsignid();
            planid();
            moodid();
            now();
            before();
            list1();
            c();
            table1();
            list();
            table();
            personLinePic();
            search();
            biaoqingbao();
            //调用
             //上传图片
            picUpload('#fileList',100,100,'#filePicker',10000);
            picUpload1('#fileList1',100,100,'#filePicker1',10000);
            picUpload2('#fileList2',100,100,'#filePicker2',10000);
            // $('#testTable').bootstrapTable('refresh', { url: '/Home/GetPaginationData2' });
        });

        var name ;
        function personname() {
            $.ajax({
                url:"/tuser/queryIdTuser",
                data:{},
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    name=data.username
                },
                error:function (error) {
                    alert("数据丢失了，刷新下试试吧" + error.status);
                }
            });
            $.ajax({
                url:"/login/queryUsername",
                data:{},
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    var a = "";
                    for(var i=0;i<data.length;i++){
                        if(name == data[i].username){
                        a=a+"<option part="+data[i].loginname+" value="+data[i].username+">"+data[i].username+"</option>"
                        }
                    }
                    for(var i=0;i<data.length;i++){
                        if(name != data[i].username){
                            a=a+"<option part="+data[i].loginname+" value="+data[i].username+">"+data[i].username+"</option>"
                        }
                    }
                    $("#name1").append(a);
                },
                error:function (error) {
                    alert("数据丢失了，刷新下试试吧" + error.status);
                }
            });
        }

        //获取主键signid
        function tsignid() {
            $.ajax({
                url:"/random/randomid",
                data:{},
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    sign_id=data.randomid;
                },
                error:function (error) {
                    alert("计划图片上传失败" + error.status);
                }
            });
        }
        //获取主键planid
        function planid() {
            $.ajax({
                url:"/random/randomid",
                data:{},
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    plan_id=data.randomid;
                },
                error:function (error) {
                    alert("计划图片上传失败" + error.status);
                }
            });
        }
        //获取主键planid
        function moodid() {
            $.ajax({
                url:"/random/randomid",
                data:{},
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    mood_id=data.randomid;
                },
                error:function (error) {
                    alert(error.status);
                }
            });
        }
        //格式化现在日期
        function now() {
            // 给input  date设置默认值
            var now = new Date();
            //格式化日，如果小于9，前面补0
            var day = ("0" + now.getDate()).slice(-2);
            //格式化月，如果小于9，前面补0
            var month = ("0" + (now.getMonth() + 1)).slice(-2);
            //拼装完整日期格式
            var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
            //完成赋值
            $('#Endtime').val(today);
            $('#Searchtime').val(today);
            $('#orderId').val(today);

        }
        //格式化15天前的日期
        function before() {
            //十五天毫秒值：1209600000
            var date = new Date();
            var time = date.getTime();
            console.info("time-----"+time);
            var times = time-1209600000;
            console.info("times====="+times);
            var now = new Date(times);

            //格式化日，如果小于9，前面补0
            var day = ("0" + now.getDate()).slice(-2);
            //格式化月，如果小于9，前面补0
            var month = ("0" + (now.getMonth() + 1)).slice(-2);
            //拼装完整日期格式
            var today = now.getFullYear()+"-"+(month)+"-"+(day) ;
            //完成赋值
            $('#Begtime').val(today);

        }
        //签到接口
        function sign(){
            var Clform = "01";
            var Cltyp = "01";
            var clremark = "";
            var data;
            if($("#xcjl").html()!="记录您现场的文字说明..."){
                clremark = $("#xcjl").html() ;
            }
            data  = {"clform":Clform,"cltype":Cltyp,"Clremark":clremark,"tsignid":sign_id};
            var plantext = $("#plan").html();
            var moodtext = $("#mood").html();
            var monumber = $("#moodpic").attr("num");
            if(plantext!="记录您今日的工作计划..." || $("#fileList").html()!="") {
                var workhour = $("#hours").val();
                var re = /^[0-9]+.?[0-9]*$/; //判断字符串是否为数字 //判断正整数 /^[1-9]+[0-9]*]*$/
                if (!re.test(workhour)) {
                    alert("工作量请输入数字");
                    return ;
                }
                data = {"clform":Clform,"cltype":Cltyp,"Clremark":clremark,"tsignid":sign_id,"plantext": plantext, "workhour": workhour, "plantype": "01", "tplanid": plan_id};
                if(moodtext!="记录您现在的心情..."|| $("#fileList1").html()!="" ) {
                    data = {"clform":Clform,"cltype":Cltyp,"Clremark":clremark,"tsignid":sign_id,"motext": moodtext, "monumber": monumber, "tmoodid": mood_id,"plantext": plantext, "workhour": workhour, "plantype": "01", "tplanid": plan_id};
                }
            }else if(moodtext!="记录您现在的心情..."|| $("#fileList1").html()!="" ) {
                data = {"clform":Clform,"cltype":Cltyp,"Clremark":clremark,"tsignid":sign_id,"motext": moodtext, "monumber": monumber, "tmoodid": mood_id};
            }
            $.ajax({
                url:"/clock/insertClock",
                data: data,
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    if(data.code!=404){
                        //reload
                        list1();
                        c();
                        list();
                        $('#table1').bootstrapTable('load',datatable1);
                        $('#table').bootstrapTable('load',datatable);
                        personLinePic();
                        //tab
                        alert(data.msg);
                        paiming();
                        $("#modal-form").modal('hide');
                        $("#xcjl").html("记录您现场的文字说明...");
                        $("#plan").html("记录您今日的工作计划...");
                        $("#mood").html("记录您现在的心情...");
                        $("#hours").val("");
                        $("#moodpic").attr("num","4");
                    }else{
                        alert(data.msg);
                    }
                },
                error:function (error) {
                    alert("网络状况不佳，用户登录失败！" + error.status);
                }
            });
        }
        //选择表情表
        function biaoqingbao() {
            $("#moodpic").click(function () {
                $("#biaoqingbao1").toggle();
            })
            $("#4").click(function () {
                $("#moodpic").attr("src",$("#4").attr("src"));
                $("#moodpic").attr("num","4");
                $("#biaoqingbao1").hide();
            });
            $("#3").click(function () {
                $("#moodpic").attr("src",$("#3").attr("src"));
                $("#moodpic").attr("num","3");
                $("#biaoqingbao1").hide();
            })
            $("#2").click(function () {
                $("#moodpic").attr("src",$("#2").attr("src"));
                $("#moodpic").attr("num","2");
                $("#biaoqingbao1").hide();
            })
            $("#1").click(function () {
                $("#moodpic").attr("src",$("#1").attr("src"));
                $("#moodpic").attr("num","1");
                $("#biaoqingbao1").hide();
            })

        }
        //选项卡设置
        function page(url, title) {
            var nav = $(window.top.document).find('.J_menuTabs .page-tabs-content ');
            $(window.top.document).find('.J_menuTabs .page-tabs-content ').find(".J_menuTab.active").removeClass("active");
            $(window.top.document).find('.J_mainContent').find("iframe").hide();
            var iframe = '<iframe class="J_iframe" name="iframe10000" width="100%" height="100%" src="' + url + '" frameborder="0" data-id="' + url
                + '" seamless="" style="display: inline;"></iframe>';
            $(window.top.document).find('.J_menuTabs .page-tabs-content ').append(
                ' <a href="javascript:;" class="J_menuTab active" data-id="'+url+'">' + title + ' <i class="fa fa-times" style="font-size: 1px;color:#D8D9DA;float: right;margin-left: 5px;"></i></a>');
            $(window.top.document).find('.J_mainContent').append(iframe);
        }
        //搜索、重置按钮
        function search() {
            $('#search1').click(function () {
                list();
                personLinePic();
                $('#table').bootstrapTable('load',datatable);
            });
            $('#reset1').click(function() {
                $(".searchable-select-holder").html(name);
                now();
                before();
                list();
                personLinePic();
                $('#table').bootstrapTable('load',datatable);
            });

            $('#search2').click(function () {
                list1();
                $('#table1').bootstrapTable('load',datatable1);
                c();
            });
            $('#reset2').click(function() {
                now();
                list1();
                $('#table1').bootstrapTable('load',datatable1);
                c();
            });


        }
        //切换按钮
        function tab(){
            if($("#example").is(":hidden")){
                $("#toolbar1").show();
                $("#example").show();
                $("#tongji").hide();
                $("#tongjitable").hide();
                $("#sliders").hide();
                $("#paiming").hide();
                $("#toolbar2").hide();
                $("#paimingtable").hide();

            }else{
                $("#example").hide();
                $("#paiming").hide();
                $("#tongji").show();
                $("#tongjitable").show();
                $("#sliders").show();
                $("#toolbar2").hide();

            }
        }
        //排名图表切换按钮
        function paiming() {
            if($("#paiming").is(":hidden")){
                $("#example").hide();
                $("#tongji").hide();
                $("#paiming").show();
                $("#tongjitable").show();
                $("#sliders").show();
                $("#toolbar2").show();
                $("#toolbar1").hide();
                $("#paimingtable").hide();
            }else{
                $("#tongjitable").hide();
                $("#sliders").hide();
                $("#example").hide();
                $("#paiming").hide();
                $("#paimingtable").show();
                $("#toolbar1").hide();

            }

        }

         个人列表和折线图
        var datatable;
        //ajax获取个人签到数据 传给datatable
        function list(){
            var name = $(".searchable-select-holder").html();
            var Begtime1 = $("#Begtime").val();
            var Endtime1 =$("#Endtime").val();
            var arr = Begtime1.split('-');
            var arr1 = Endtime1.split('-');
            var Begtime ="";
            var Endtime ="";
            for(var i=0;i<arr.length;i++){
                Begtime += arr[i]+"/";
            }
            Begtime = Begtime.substr(0, Begtime.length - 1);
            for(var i=0;i<arr1.length;i++){
                Endtime += arr1[i]+"/";
            }
            Endtime = Endtime.substr(0, Endtime.length - 1);
            var Cltype = '01';
            var data = {"Username":name,"Begtime":Begtime,"Endtime":Endtime,"Cltype":Cltype};
            $.ajax({
                url:"/clock/queryListTsig",
                data: data,
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    console.log("-------------个人表格");
                    console.log(data);
                    datatable=data;
                },
                error:function (error) {
                    alert("网络状况不佳，用户登录失败！" + error.status);
                }
            });
        }
        //初始化表格
        function table() {
            var id;
            var name;
            function operateFormatter(value, row, index) {
                if(row.dz=='0'||typeof(row.dz)=='undefined'){
                    return [
                        "<button  type='button' onclick=\"zan('"+row.id+"')\" class='RoleOfdelete btn btn-primary  btn-sm' style='width: 50.69px;height:30px;background-color: #0099CC;' ><i id='zan"+row.id+"' class='glyphicon glyphicon-heart-empty' style='float:left;margin-left:7%;font-size:14px;'></i><p id='zan1"+row.id+"' style='float:left;margin-left:12%' >"+row.tpranum+"</p></button>"+
                        "<button type='button' class='RoleOfdelete btn btn-primary  btn-sm' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\" style='margin-left: 5px;width: 50.69px;height:30px;background-color: #0099CC;' ><i class='glyphicon glyphicon-comment' ></i>  "+row.comnum+"</button>"
                    ].join('');
                }else{
                    return [
                        "<button  type='button' onclick=\"zan('"+row.id+"')\" class='RoleOfdelete btn btn-primary  btn-sm' style='width: 50.69px;height:30px;background-color: #0099CC;' ><i id='zan"+row.id+"' class='glyphicon glyphicon-heart' style='float:left;margin-left:7%;font-size:14px;'></i><p id='zan1"+row.id+"' style='float:left;margin-left:12%' >"+row.tpranum+"</p></button>"+
                        "<button type='button' class='RoleOfdelete btn btn-primary  btn-sm' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\" style='margin-left: 5px;width: 50.69px;height:30px;background-color: #0099CC;' ><i class='glyphicon glyphicon-comment' ></i>  "+row.comnum+"</button>"
                    ].join('');
                }
            }
            function aFormatter(value, row, index) {
                index=index+1;
                return [
                    '<a href="/mail_detail?id='+row.id+'  "style="color: black" class="J_menuTabs">'+row.id+'</a>'
                    "<a class='J_menuItem' data-index='0' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\">"+row.username+"</a>"
                ].join("")
            }
            function clfrom(value, row, index) {
                if(row.clform=="01"){
                    return value = "PC端"
                }else {
                    return value = "手机端"
                }

            }
            function clstatus(value, row, index) {
                if(row.clstatus=='01'){
                    return value = "正常"
                }else if(row.clstatus=='02'){
                    return value = "迟到"
                }
            }
            function place(value, row, index){
                if(row.clform=="01"){
                    return value = row.clpcip;
                }else{
                    return value = row.clplace;
                }
            }
            window.operateEvents = {
                'click .RoleOfdelete': function (e, value, row, index) {
                    alert(row.dno);
                },
                'click .RoleOfedit': function (e, value, row, index) {
                    $("#editModal").modal('show');

                }
            };
            $('#table').bootstrapTable({
                showToggle:!0,
                showColumns:!0,
                iconSize:"outline",
                toolbar:"#exampleTableEventsToolbar",
                 icons:{refresh:"glyphicon-repeat",toggle:"glyphicon-list-alt",columns:"glyphicon-list"},
                url: "<%=request.getContextPath()%>/api/getDataList.do", // 获取表格数据的url
                showRefresh:true,
                cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
                striped: true,  //表格显示条纹，默认为false
                pagination: true, // 在表格底部显示分页组件，默认false
                pageList: [5,10, 20], // 设置页面可以显示的数据条数
                pageSize: 5, // 页面数据条数
                pageNumber: 1, // 首页页码
                columns: [
                    {
                        field: 'number',
                        title: '序号',
                        width:'5px' ,
                        align:'center',
                        formatter: function (value,row,index){
                            return index+1; //序号正序排序从1开始
                        }
                    },
                    {
                        field: 'username',
                        title: '姓名',
                        align:'center',
                        formatter: aFormatter //添加超链接的方法
                    }, {
                        field: 'rtime',
                        title: '签到日期',
                        align:'center',
                    },{
                        field: 'mtime',
                        title: '签到时间',
                        align:'center',
                    },{
                        field: 'clplace',
                        title: '签到地点',
                        align:'center',
                        formatter: place
                    },
                    {
                        field: 'clform',
                        title: '签到方式',
                        align:'center',
                        formatter:clfrom
                    },
                    {
                        field: 'clstatus',
                        title: '签到状态',
                        align:'center',
                        formatter:clstatus
                    }, {
                        field: 'price',
                        title: '赞',
                        align: 'center',
                        width: '140px',
                        formatter: operateFormatter

                    }],
                data:datatable
            });
        }
        //初始化图形
        function personLinePic() {
            var data1=[];
            var data2=[];
            var month;
            var day;
            for(var i=datatable.length-1;i>=0;i--){
                var data3=[] = datatable[i].cltime.substr(11, 5).split(':');
                if(data3[0]>12){
                    data3[0]=12;
                    data3[1]=0;
                }
                var data4=[] = datatable[i].cltime.substr(5, 5).split('/');
                if(typeof(day)!='undefined'){
                    if(parseInt(data4[1])<(parseInt(day)+1)){
                        if(parseInt(data4[0])==(parseInt(month))){
                            continue;
                        }
                    }
                    while(parseInt(data4[1])!=(parseInt(day)+1)&&(parseInt(day)+1)<32) {
                        if (parseInt(data4[0]) == (parseInt(month) + 1)) {
                            console.log("--------月份补充");
                            var month1 = ['1', '3', '5', '7', '8', '10', '12'];
                            var year = new Date().getFullYear();
                            if ($.inArray(month, month1)) {
                                console.log("--------+135781012");
                                while ((parseInt(day) + 1) <= 32) {
                                    if ((parseInt(day) + 1) < 10) {
                                        data1.push(month + "/0" + (parseInt(day) + 1));
                                    } else {
                                        data1.push(month + "/" + (parseInt(day) + 1));
                                    }
                                    data2.push(parseFloat(data3[0]+"."+data3[1]));
                                    day = (parseInt(day) + 1);
                                    console.log(month + "/" + (day) + "-----加入");
                                }
                                month = parseInt(month) + 1;
                                day = 0;
                            } else if ((year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)) {
                                if (month == '2') {
                                    console.log("二月+135781012");
                                    while ((parseInt(day) + 1) <= 28) {
                                        if ((parseInt(day) + 1) < 10) {
                                            data1.push(month + "/0" + (parseInt(day) + 1));
                                        } else {
                                            data1.push(month + "/" + (parseInt(day) + 1));
                                        }
                                        data2.push(parseFloat(data3[0]+"."+data3[1]));
                                        day = (parseInt(day) + 1);
                                    }
                                    month = parseInt(month) + 1;
                                    day = 0;
                                } else {

                                    while ((parseInt(day) + 1) <= 29) {
                                        if ((parseInt(day) + 1) < 10) {
                                            data1.push(month + "/0" + (parseInt(day) + 1));
                                        } else {
                                            data1.push(month + "/" + (parseInt(day) + 1));
                                        }
                                        data2.push(parseFloat(data3[0]+"."+data3[1]));
                                        day = (parseInt(day) + 1);
                                    }
                                    month = parseInt(month) + 1;
                                    day = 0;
                                }
                            } else {
                                console.log("其他月份");
                                while ((parseInt(day) + 1) <= 30) {
                                    if ((parseInt(day) + 1) < 10) {
                                        data1.push(month + "/0" + (parseInt(day) + 1));
                                    } else {
                                        data1.push(month + "/" + (parseInt(day) + 1));
                                    }
                                    data2.push(parseFloat(data3[0]+"."+data3[1]));
                                    day = (parseInt(day) + 1);
                                }
                                month = parseInt(month) + 1;
                                day = 0;
                            }
                        }
                        if (parseInt(data4[1]) != (parseInt(day) + 1)) {
                            if ((parseInt(day) + 1) < 10) {
                                if (typeof(month) == 'number'&&month<10) {
                                    data1.push("0" + month + "/0" + (parseInt(day) + 1));
                                } else {
                                    data1.push(month + "/0" + (parseInt(day) + 1));
                                }
                            } else {
                                data1.push(month + "/" + (parseInt(day) + 1));
                            }
                            data2.push(parseFloat(data3[0]+"."+data3[1]));
                            day = (parseInt(day) + 1) + "";
                            }
                        }
                }

                data1.push(datatable[i].cltime.substr(5, 5))
                month = datatable[i].cltime.substr(5,5).split("/")[0];
                day = datatable[i].cltime.substr(5,5).split("/")[1];
                data2.push(parseFloat(data3[0]+"."+data3[1]))
            }
            if(datatable.length==0){
                var a = {"username":"暂无"};
                datatable.push(a);
            }

            $("#R0").val(10);
            $("#R1").val(5);

            $("#tongji").highcharts(
                {
                    chart : {
                        type : 'column',// 柱状图
                        // type:'spline',//曲线图
                        // type : 'line',// 折现图
                        // type:'pie',//饼状图
                        // renderTo : 'tongji', // 在哪个区域呈现，对应HTML中的DIV元素ID
                        width : 1100,
                        height : 450,
                        marginTop:50,
                        options3d : {
                            enabled : true,// 是否使用3D渲染图表功能
                            alpha : 10,
                            beta : 0,
                            depth : 50,
                            viewDistance : 25,
                        },
                        plotBackgroundColor : null, // 绘图区的背景颜色
                        plotBorderWidth : null, // 绘图区边框宽度
                        plotShadow : false
                        // 绘图区是否显示阴影
                    },

                    title : {
                        text : '业绩排名',
                        align: 'left',
                        y:20,
                        x:40
                    },
                    xAxis : {
                        title : {
                            text : '时间段(月.日)'
                        },
                        categories : []
                    },
                    yAxis : {
                        tickPositions : [ 7, 8, 9, 10 ],
                        min : 0,
                        title : {
                            text : '业绩量(h)'
                        },
                    },
                    legend : { //设置圆点点的位置
                       // enabled : true;
	                    layout: 'vertical',
	            		align: 'right',
	            		verticalAlign: 'bottom'
                    },
                    credits : {
                        enabled : false
                        // 去掉官网的超链接
                    },
                    exporting : {
                        enabled : false
                        // 用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示
                    },
                    lang : {
                        printChart : "打印图片",
                        downloadJPEG : "导出JPEG 图片",
                        downloadPDF : "导出PDF 文档",
                        downloadPNG : "导出PNG 图片",
                        downloadSVG : "导出SVG 矢量图",
                        contextButtonTitle : "导出"
                    },
                    tooltip : {
                        pointFormatter : function() {
                            return '<span style="color:{' + this.series.data
                                + '}"></span>签到时间:'+this.y+'<br/>.'
                        }
                    },

                    series : [ {
                        name : '业绩量',
                        
                       data : [],
                        
                    } ]
                });
            console.log($("#tongji").highcharts());
            $('#R0').on('change', function() {
                $("#tongji").highcharts().options.chart.options3d.alpha = this.value;
                showValues();
                $("#tongji").highcharts().redraw(false);
            });

                $('#R1').on('change', function() {
                    $("#tongji").highcharts().options.chart.options3d.beta = this.value;
                    showValues();
                    $("#tongji").highcharts().redraw(false);
                });

            function showValues() {
                $('#R0-value').html(
                    $("#tongji").highcharts().options.chart.options3d.alpha);
                $('#R1-value').html(
                    $("#tongji").highcharts().options.chart.options3d.beta);
            }

            showValues();
            $("#tongji").highcharts().xAxis[0].setCategories(data1);
            $("#tongji").highcharts().series[0].setData(data2);

        }
         点赞
        function zan(id) {
            if($("#zan"+id).hasClass("glyphicon glyphicon-heart-empty")){
                var data = {"itemid":id,"itemtype":"tsign"};
                $.ajax({
                    url:"/tpraise/savetpraise",
                    data: data,
                    async:false,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data.code!='404'){
                            $("#zan"+id).attr("class","glyphicon glyphicon-heart");
                            var a =$("#zan1"+id).text();
                            var num = parseInt(a)+1;
                            $("#zan1"+id).text(num);
                        }else{
                            alert(data.msg);
                        }
                    },
                    error:function (error) {
                        alert("网络状况不佳，用户登录失败！" + error.status);
                    }
                });
            }else {
                var data = {"itemid":id};
                $.ajax({
                    url:"/tpraise/deleteIdTpraise",
                    data: data,
                    async:false,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data.code!='404'){
                            $("#zan"+id).attr("class","glyphicon glyphicon-heart-empty");
                            var a = $("#zan1"+id).text();
                            var num = parseInt(a)-1;
                            $("#zan1"+id).text(num);
                        }else{
                            alert(data.msg);
                        }
                    },
                    error:function (error) {
                        alert("网络状况不佳，用户登录失败！" + error.status);
                    }
                });


            }

        }
         排名点赞
        function zan2(id) {
            if($("#zan2"+id).hasClass("glyphicon glyphicon-heart-empty")){
                var data = {"itemid":id,"itemtype":"tsign"};
                $.ajax({
                    url:"/tpraise/savetpraise",
                    data: data,
                    async:false,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data.code!='404'){
                            $("#zan2"+id).attr("class","glyphicon glyphicon-heart");
                            var a =$("#zan3"+id).text();
                            var num = parseInt(a)+1;
                            $("#zan3"+id).text(num);
                        }else{
                            alert(data.msg);
                        }
                    },
                    error:function (error) {
                        alert("网络状况不佳，用户登录失败！" + error.status);
                    }
                });
            }else {
                var data = {"itemid":id};
                $.ajax({
                    url:"/tpraise/deleteIdTpraise",
                    data: data,
                    async:false,
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        if(data.code!='404'){
                            $("#zan2"+id).attr("class","glyphicon glyphicon-heart-empty");
                            var a = $("#zan3"+id).text();
                            var num = parseInt(a)-1;
                            $("#zan3"+id).text(num);
                        }else{
                            alert(data.msg);
                        }

                    },
                    error:function (error) {
                        alert("网络状况不佳，用户登录失败！" + error.status);
                    }
                });


            }

        }
         签到排名和折线图
        var datatable1;
        //ajax 获取排序数据 传给datatable1
        function list1(){
            var Searchtime1 =$("#Searchtime").val();
            var arr1 = Searchtime1.split('-');
            var Searchtime ="";
            for(var i=0;i<arr1.length;i++){
                Searchtime += arr1[i]+"/";
            }
            Searchtime = Searchtime.substr(0, Searchtime.length - 1);
            var Cltype = '01';
            var data = {"Begtime":Searchtime,"Endtime":Searchtime,"Cltype":Cltype,"sqtsgin":"sq"};
            $.ajax({
                url:"/clock/queryListTsig",
                data: data,
                async:false,
                dataType:"json",
                type:"post",
                success:function (data) {
                    console.log("-------------排名表格");
                    console.log(data);
                    datatable1=data;
                },
                error:function (error) {
                    alert("网络状况不佳，用户登录失败！" + error.status);
                }
            });
        }
        //初始化图形#
        function c(){
            var data1=[];
            var data2=[];
            var month;
            var day;
            for(var i=datatable1.length-1;i>=0;i--){
                data1.push(datatable1[i].username)
                var data3=[] = datatable1[i].cltime.substr(11, 5).split(':')
                data2.push(parseFloat(data3[0]+"."+data3[1]));
            }
            $("#R0").val(10);
            $("#R1").val(5);
            var chart = new Highcharts.Chart({
                chart: {
//     		type:'column',
                    //type:'spline',//曲线图
                    type:'line',//折现图
                    //type:'pie',//饼状图
                    renderTo: 'paiming',        //在哪个区域呈现，对应HTML中的DIV元素ID
                    width : 1100,
                    height : 450,
                    marginTop:50,
                    options3d: {
                        enabled: true,//是否使用3D渲染图表功能
                        alpha: 10,
                        beta: 0,
                        depth: 50,
                        viewDistance: 25
                    },
                    plotBackgroundColor: null,    //绘图区的背景颜色
                    plotBorderWidth: null,        //绘图区边框宽度
                    plotShadow: false        //绘图区是否显示阴影
                },

                title: {
                    text: '签到排名',
                    align:'left',
                    y:20,
                    x:40
                },
                xAxis: {
                    title: {
                        text: ''
                    },
                    categories: []
                },
                yAxis: {
                    tickPositions: [7,8,9,10],
                    min: 0,
                    title: {
                        text: '签到时间(h)'
                    }
                },
                legend: {
                	layout: 'vertical',
            		align: 'right',
            		verticalAlign: 'bottom'
                    
                },
                credits: {
                    enabled: false//去掉官网的超链接
                },
                exporting:{
                    enabled:false //用来设置是否显示‘打印’,'导出'等功能按钮，不设置时默认为显示
                },
                lang:{
                    printChart: "打印图片",
                    downloadJPEG: "导出JPEG 图片",
                    downloadPDF: "导出PDF 文档",
                    downloadPNG: "导出PNG 图片",
                    downloadSVG: "导出SVG 矢量图",
                    contextButtonTitle: "导出"
                },
                tooltip: {
                    pointFormatter: function() {
                        return '<span style="color:{'+this.series.data+'}">签到时间：'+this.y+'</span><br/>.'
                    }
                },

                series:[{
                    name: '签到',
                    data:[]
                }]
            });

            // Activate the sliders
            $('#R0').on('change', function(){
                $("#paiming").highcharts().options.chart.options3d.alpha = this.value;
                showValues();
                $("#paiming").highcharts().redraw(false);
            });
            $('#R1').on('change', function(){
                $("#paiming").highcharts().options.chart.options3d.beta = this.value;
                showValues();
                $("#paiming").highcharts().redraw(false);
            });

            function showValues() {
                $('#R0-value').html($("#paiming").highcharts().options.chart.options3d.alpha);
                $('#R1-value').html($("#paiming").highcharts().options.chart.options3d.beta);
            }
            showValues();
            chart.xAxis[0].setCategories(data1);
            chart.series[0].setData(data2);

        }
        //初始化表格
        function table1() {
            var id;
            var name;
            function operateFormatter(value, row, index) {
                if(row.dz=='0'||typeof(row.dz)=='undefined'){
                    return [
                        "<button  type='button' onclick=\"zan2('"+row.id+"')\" class='RoleOfdelete btn btn-primary  btn-sm' style='background-color: #0099CC;width: 50.69px;height:30px;' ><i id='zan2"+row.id+"' class='glyphicon glyphicon-heart-empty' style='float:left;margin-left:7%;font-size:14px;'></i><p id='zan3"+row.id+"' style='float:left;margin-left:12%' >"+row.tpranum+"</p></button>"+
                        "<button type='button' class='RoleOfdelete btn btn-primary  btn-sm' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\" style='margin-left: 5px;width: 50.69px;height:30px;background-color: #0099CC;' ><i class='glyphicon glyphicon-comment' ></i>  "+row.comnum+"</button>"
                    ].join('');
                }else{
                    return [
                        "<button  type='button' onclick=\"zan2('"+row.id+"')\" class='RoleOfdelete btn btn-primary  btn-sm' style='background-color: #0099CC;width: 50.69px;height:30px;' ><i id='zan2"+row.id+"' class='glyphicon glyphicon-heart' style='float:left;margin-left:7%;font-size:14px;'></i><p id='zan3"+row.id+"' style='float:left;margin-left:12%' >"+row.tpranum+"</p></button>"+
                        "<button type='button' class='RoleOfdelete btn btn-primary  btn-sm' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\" style='margin-left: 5px;width: 50.69px;height:30px;background-color: #0099CC;' ><i class='glyphicon glyphicon-comment' ></i>  "+row.comnum+"</button>"
                    ].join('');
                }
            }
            function aFormatter(value, row, index) {
                index=index+1;
                return [
                    '<a href="/mail_detail?id='+row.id+'  "style="color: black" class="J_menuTabs">'+row.id+'</a>'
                    "<a class='J_menuItem'  data-index='0' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\">"+row.username+"</a>"
                ].join("")
            }
            function bFormatter(value, row, index) {
                index=index+1;
                return [
                    '<a href="/mail_detail?id='+row.id+'  "style="color: black" class="J_menuTabs">'+row.id+'</a>'
                    "<a class='J_menuItem'  data-index='0' onclick=\"page('/sign/signMess?id="+row.id+"&number="+index+"&dz="+row.dz+"','"+row.username+"')\"><img src="+row.ip+row.txfilename+" style='width:40%;border-radius:50%;'></a>"
                ].join("")
            }
            function place(value, row, index){
                if(row.clform=="01"){
                    return value = row.clpcip;
                }else{
                    return value = row.clplace;
                }
            }
			function cltype(value, row, index){
                if(row.cltype=='01'){
                    return value = "签到";
                }else if(row.cltype=='02'){
                    return value =  "签退";
                }
            }

            window.operateEvents = {
                'click .RoleOfdelete': function (e, value, row, index) {
                    alert(row.dno);
                },
                'click .RoleOfedit': function (e, value, row, index) {
                    $("#editModal").modal('show');

                }
            };
            $('#table1').bootstrapTable({
                showToggle:!0,
                showColumns:!0,
                iconSize:"outline",
                toolbar:"#exampleTableEventsToolbar",
                 icons:{refresh:"glyphicon-repeat",toggle:"glyphicon-list-alt",columns:"glyphicon-list"},
                url: "<%=request.getContextPath()%>/api/getDataList.do", // 获取表格数据的url
                showRefresh:true,
                cache: false, // 设置为 false 禁用 AJAX 数据缓存， 默认为true
                striped: true,  //表格显示条纹，默认为false
                pagination: true, // 在表格底部显示分页组件，默认false
                pageList: [5,10, 20], // 设置页面可以显示的数据条数
                pageSize: 5, // 页面数据条数
                pageNumber: 1, // 首页页码
                columns: [
                    {
                        field: 'number',
                        title: '序号',
                        width:'5px' ,
                        align:'center',
                        formatter: function (value,row,index){
                            return index+1; //序号正序排序从1开始
                        }
                    },  {
                        field: 'txfilename',
                        title: '头像',
                        width:'100px',
                        align:'center',
                        formatter: bFormatter //添加超链接的方法
                    },{
                        field: 'username',
                        title: '姓名',
                        width:'100px',
                        align:'center',
                        formatter: aFormatter //添加超链接的方法
                    }, {
                        field: 'rtime',
                        title: '签到日期',
                        width:'140px',
                        align:'center',
                    }, {
                        field: 'mtime',
                        title: '签到时间',
                        width:'140px',
                        align:'center',
                    },{
                        field: 'clplace',
                        title: '签到地点',
                        align:'center',
                        formatter: place
                    },
                    {
                        field: 'cltype',
                        title: '签到类型',
                        align:'center',
                        formatter:cltype
                    }, 
                    {
                        field: 'price',
                        title: '赞',
                        align: 'center',
                        width: '140px',
                        formatter: operateFormatter

                    }],
                data: datatable1
            });
        }

        //id -> 存放图片  width，height  存放图片尺寸宽高  id2 按钮  allMaxSize图片大小
        function picUpload(id,width,height,id2,allMaxSize){
            var $ = jQuery,
                $list = $(id),
                // 优化retina, 在retina下这个值是2
                ratio = window.devicePixelRatio || 1,

                // 缩略图大小
                thumbnailWidth = width * ratio,
                thumbnailHeight = height * ratio,

                allMaxSize = 8,//限制图片大小

                // Web Uploader实例
                uploader;

            // 初始化Web Uploader
            uploader = WebUploader.create({

                // 自动上传。
                auto: false,

                // swf文件路径
                swf: '/static/js/plugins/webuploader/Uploader.swf',

                // 文件接收服务端。
                server: '/file/saveFileupload',
                formData:{'itemtype':'tsign','itemid':plan_id,"attfrom":"01"},

                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: id2,

                duplicate :true,//是否可以重复上传

                fileSizeLimit: allMaxSize*1024*1024, //限制图片大小，不可以超过

                compress: null,

                // 只允许选择文件，可选。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/jpg,image/jpeg,image/png'   //修改这行，加快上传文件框的打开速度
                }
            });

            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
                // $list.empty(); //清空之前上传的文件

                var $li = $(
                    '<li id="' + file.id + '" class="file-item thumbnail" style="float:left;">' +
                    '<div class="delete" style="overflow: hidden;height:0px;width: 100px;position: fixed;background-color: black;opacity: 0.6"><i class="fa fa-facebook" style="float: right;cursor: pointer">关闭</i></div>' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                    '</li>'
                    ),
                    $img = $li.find('img');
                $list.append( $li );

                // 创建缩略图
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }

                    //去掉默认的头像，清空图片名字的信息
                    $('.webuploader-pick img').attr('src','')
                    $('.file-item .info').empty();

                    $img.attr( 'src', src );
                }, thumbnailWidth, thumbnailHeight );

                $li.on( 'mouseenter', function() {
                    $(".delete").stop().animate({height: 15});
                });

                $li.on( 'mouseleave', function() {
                    $(".delete").stop().animate({height: 0});
                });

                $li.on('click','.fa.fa-facebook' , function() {
                    uploader.removeFile( file,true );
                    $li.remove();
                    $(".delete").stop().animate({height: 0});
                })
            });


            // 文件上传过程中创建进度条实时显示。
            uploader.on( 'uploadProgress', function( file, percentage ) {
                var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress span');

                // 避免重复创建
                if ( !$percent.length ) {
                    $percent = $('<p class="progress"><span></span></p>')
                        .appendTo( $li )
                        .find('span');
                }

                $percent.css( 'width', percentage * 100 + '%' );
            });

            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file ) {
                $( '#'+file.id ).addClass('upload-state-done');
            });

            // 文件上传失败，现实上传出错。
            uploader.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');

                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }

                //$error.text('上传失败');

            });

            // 完成上传完了，成功或者失败，先删除进度条。
            uploader.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });

            //  验证大小
            uploader.on("error",function (type){

                if(type == "Q_EXCEED_SIZE_LIMIT"){
                    window.alert("系统提示:所选图片总大小不可超过" + allMaxSize + "个哦！");
                }

              
            });

            //绑定提交事件
            $("#commit").click(function() {
                if($("#fileList").html()!=""){
                console.log("上传...");
                uploader.upload();   //执行手动提交
                console.log("上传成功");
                }
                planid();
                $("#fileList").html("");
            });


        }

        function picUpload1(id,width,height,id2,allMaxSize){
            var $ = jQuery,
                $list = $(id),
                // 优化retina, 在retina下这个值是2
                ratio = window.devicePixelRatio || 1,

                // 缩略图大小
                thumbnailWidth = width * ratio,
                thumbnailHeight = height * ratio,

                allMaxSize = 8,//限制图片大小

                // Web Uploader实例
                uploader;

            // 初始化Web Uploader
            uploader = WebUploader.create({

                // 自动上传。
                auto: false,

                // swf文件路径
                swf: '/static/js/plugins/webuploader/Uploader.swf',

                // 文件接收服务端。
                server: '/file/saveFileupload',
                formData:{'itemtype':'plan','itemid':mood_id,"attfrom":"01"},
                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: id2,

                duplicate :true,//是否可以重复上传

                fileSizeLimit: allMaxSize*1024*1024, //限制图片大小，不可以超过

                compress: null,

                // 只允许选择文件，可选。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/jpg,image/jpeg,image/png'   //修改这行，加快上传文件框的打开速度
                }
            });

            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
                // $list.empty(); //清空之前上传的文件

                var $li = $(
                    '<li id="' + file.id + '" class="file-item thumbnail" style="float:left;">' +
                    '<div class="delete1" style="overflow: hidden;height:0px;width: 100px;position: fixed;background-color: black;opacity: 0.6"><i class="fa fa-facebook" style="float: right;cursor: pointer">关闭</i></div>' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                    '</li>'
                    ),
                    $img = $li.find('img');
                $list.append( $li );

                // 创建缩略图
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }

                    //去掉默认的头像，清空图片名字的信息
                    $('.webuploader-pick img').attr('src','')
                    $('.file-item .info').empty();

                    $img.attr( 'src', src );
                }, thumbnailWidth, thumbnailHeight );

                $li.on( 'mouseenter', function() {
                    $(".delete1").stop().animate({height: 15});
                });

                $li.on( 'mouseleave', function() {
                    $(".delete1").stop().animate({height: 0});
                });

                $li.on('click','.fa.fa-facebook' , function() {
                    uploader.removeFile( file,true );
                    $li.remove();
                    $(".delete1").stop().animate({height: 0});
                })
            });


            // 文件上传过程中创建进度条实时显示。
            uploader.on( 'uploadProgress', function( file, percentage ) {
                var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress span');

                // 避免重复创建
                if ( !$percent.length ) {
                    $percent = $('<p class="progress"><span></span></p>')
                        .appendTo( $li )
                        .find('span');
                }

                $percent.css( 'width', percentage * 100 + '%' );
            });

            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file ) {
                $( '#'+file.id ).addClass('upload-state-done');
            });

            // 文件上传失败，现实上传出错。
            uploader.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');

                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }

               
            });

            // 完成上传完了，成功或者失败，先删除进度条。
            uploader.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });

            //  验证大小
            uploader.on("error",function (type){

                if(type == "Q_EXCEED_SIZE_LIMIT"){
                    window.alert("系统提示:所选图片总大小不可超过" + allMaxSize + "个哦！");
                }

             
            });

            //绑定提交事件
            $("#commit").click(function() {
                if($("#fileList1").html()!=""){
                    console.log("上传...");
                    uploader.upload();   //执行手动提交
                    console.log("上传成功");
                }
                moodid();
                $("#fileList1").html("");
            });


        }

        function picUpload2(id,width,height,id2,allMaxSize){
            var $ = jQuery,
                $list = $(id),
                // 优化retina, 在retina下这个值是2
                ratio = window.devicePixelRatio || 1,

                // 缩略图大小
                thumbnailWidth = width * ratio,
                thumbnailHeight = height * ratio,

                allMaxSize = 8,//限制图片大小

                // Web Uploader实例
                uploader;

            // 初始化Web Uploader
            uploader = WebUploader.create({

                // 自动上传。
                auto: false,

                // swf文件路径
                swf: '/static/js/plugins/webuploader/Uploader.swf',

                // 文件接收服务端。
                server: '/file/saveFileupload',
                formData:{'itemtype':'tsign','itemid':sign_id,"attfrom":"01"},

                // 选择文件的按钮。可选。
                // 内部根据当前运行是创建，可能是input元素，也可能是flash.
                pick: id2,

                duplicate :true,//是否可以重复上传

                fileSizeLimit: allMaxSize*1024*1024, //限制图片大小，不可以超过

                compress: null,

                // 只允许选择文件，可选。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/jpg,image/jpeg,image/png'   //修改这行，加快上传文件框的打开速度
                }
            });

            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
                // $list.empty(); //清空之前上传的文件

                var $li = $(
                    '<li id="' + file.id + '" class="file-item thumbnail" style="float:left;">' +
                    '<div class="delete2" style="overflow: hidden;height:0px;width: 100px;position: fixed;background-color: black;opacity: 0.6"><i class="fa fa-facebook" style="float: right;cursor: pointer">关闭</i></div>' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                    '</li>'
                    ),
                    $img = $li.find('img');
                $list.append( $li );

                // 创建缩略图
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }

                    //去掉默认的头像，清空图片名字的信息
                    $('.webuploader-pick img').attr('src','')
                    $('.file-item .info').empty();

                    $img.attr( 'src', src );
                }, thumbnailWidth, thumbnailHeight );

                $li.on( 'mouseenter', function() {
                    $(".delete2").stop().animate({height: 15});
                });

                $li.on( 'mouseleave', function() {
                    $(".delete2").stop().animate({height: 0});
                });

                $li.on('click','.fa.fa-facebook' , function() {
                    uploader.removeFile( file,true );
                    $li.remove();
                    $(".delete2").stop().animate({height: 0});
                })
            });


            // 文件上传过程中创建进度条实时显示。
            uploader.on( 'uploadProgress', function( file, percentage ) {
                var $li = $( '#'+file.id ),
                    $percent = $li.find('.progress span');

                // 避免重复创建
                if ( !$percent.length ) {
                    $percent = $('<p class="progress"><span></span></p>')
                        .appendTo( $li )
                        .find('span');
                }

                $percent.css( 'width', percentage * 100 + '%' );
            });

            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file ) {
                $( '#'+file.id ).addClass('upload-state-done');
            });

            // 文件上传失败，现实上传出错。
            uploader.on( 'uploadError', function( file ) {
                var $li = $( '#'+file.id ),
                    $error = $li.find('div.error');

                // 避免重复创建
                if ( !$error.length ) {
                    $error = $('<div class="error"></div>').appendTo( $li );
                }

              

            });

            // 完成上传完了，成功或者失败，先删除进度条。
            uploader.on( 'uploadComplete', function( file ) {
                $( '#'+file.id ).find('.progress').remove();
            });

            //  验证大小
            uploader.on("error",function (type){

                if(type == "Q_EXCEED_SIZE_LIMIT"){
                    window.alert("系统提示:所选图片总大小不可超过" + allMaxSize + "个哦！");
                }

               
            });

            //绑定提交事件
            $("#commit").click(function() {
                if($("#fileList2").html()!="" ){
                    console.log("上传...");
                    uploader.upload();   //执行手动提交
                    console.log("上传成功");
                }
                tsignid();
                $("#fileList2").html("");
            });


        }

    </script>*/