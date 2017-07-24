/**
 * Created by xiasu on 2017/6/7.
 */


$(function () {
    $(".sex button").click(function () {
        var sex=$(this).val();
        if(sex=="男"){
            $("#user").addClass("boy-information");
            $("#lover").addClass("girl-information")
        }else {
            $("#user").addClass("girl-information");
            $("#lover").addClass("boy-information")
        }
        $.post("/setSex",{"sex":sex},function (data) {
            if (data=="ok"){
                if(sex=="男"){
                    $("#men").addClass("col-md-pull-9")
                    $("#women").addClass("col-md-push-9")
                }
                $(".sex").hide();
                $(".information").show();
            }
        })
    });
    $(".back").click(function (event) {
            $(".back").addClass("fadeOutUp");
    })
    $(".back div").click(function () {
        return false;
    })
    $(".edit").click(function () {
        $(".back").css("display", "block").removeClass("fadeOutUp");
        $(".information-title").addClass("bounceInUp");
        $(".girl-information").addClass("fadeInDown");
        $(".boy-information").addClass("fadeInUp");
        $(".arrow").delay(2000).addClass("fadeInLeft");
    });
    $(".save").click(function () {
        var userName=$("#user input").val();
        $.post("/updateDetail",{"nickName":userName},function (data) {
            if (data=="ok"){
                $(".user-name").text(userName);
                $(".back").addClass("fadeOutUp");
                $(".information-title").removeClass("bounceInUp");
                $(".girl-information").removeClass("fadeInDown");
                $(".boy-information").removeClass("fadeInUp");
                $(".arrow").removeClass("fadeInLeft");
            }
        })
    });
    $("#loverAccount").keyup(function () {
        var loverAccount=$(this).val();
        $.post("/queryAccount",{"nameOrPhoneOrEmail":loverAccount},function (data) {
            if (data!=null&&data!="error"){
                var info=data.split("|");
                $("#loverNickName").css('color','#615c5d').text(info[0]).next().val(info[1]);
                $(".bind").removeAttr('disabled');
            }else{
                $("#loverNickName").css('color','red').text("此用户不存在!");
                $(".bind").attr('disabled','disabled');
            }
        })
    });
    $(".bind").click(function () {
        var receiverId=$("#loverNickName").next().val();
        $.post("/sendMessage",{"receiverId":receiverId,"type":"0"},function (data) {
            if (data=="ok"){
                alert("已发送绑定邀请");
            }else {
                alert("发送失败")
            }
        })
    })
    $("a").focus(function () {
        if (this.blur) {
            this.blur();
        }
    });
    $(".change").click(function () {
       var x=$(this).attr("data-target");
       var y=$(this).attr("data-miss");
       $(x).show();
       $(y).hide();
    });
    //消息中心
    $(".news a").hover(function () {
        $("span", this).css("color", "#e56b82");
        $(".textMain", this).css("border-color", "#e56b82");
        $(".corrow", this).css("background-position", "-60px -14px");
        $(".textMainRead", this).css("border-color", "#e56b82");
        $(".corrowRead", this).css("background-position", "-60px -14px");
    }, function () {
        var state = $(this).prev().val();
        if (!state) {
            $("span", this).css("color", "black");
            $(".textMain", this).css("border-color", "#efb9c2");
            $(".corrow", this).css("background-position", "-60px 0px");
        } else {
            $("span", this).css("color", "black");
            $(".textMainRead", this).css("border-color", "#dcd4cc");
            $(".corrowRead", this).css("background-position", "-60px -28px");
        }
    });
    $(".btnAgree").click(function () {
        $.post("/agreeBind", {"id": $(".btnAgree").val()}, function (data) {
            var ids = data.split("|");
            location.href="/bind?id="+ids[0]+"&loverId="+ids[1];
        })
    })
    $(".btnRefuse").click(function () {
        location.href="/refuseBind?id"+ $(".btnRefuse").val();
    })
    //注册
    $("#rbtn").click(function () {
        var x=$("#setUser").parent(".input-group");
        var y=$("#setPassword").parent(".input-group");
        var z=$("#checkPassword").parent(".input-group");
        if (x.hasClass("has-success")&&y.hasClass("has-success")&&z.hasClass("has-success")){
            $.post("/register", $("#rform").serialize(), function (data) {
                if (data == "phone") {
                    $(".alert").html("手机号已被注册！").fadeIn(200).delay(1000).fadeOut(200);
                } else if (data == "email") {
                    $(".alert").html("邮箱已被注册！").fadeIn(200).delay(600).fadeOut(200);
                } else {
                    $(".alert").html("恭喜！注册成功！").fadeIn(200).delay(1000).fadeOut(200);
                    location.href = "/index";
                }
            })
        }else {
            x.trigger("blur");
            y.trigger("blur");
            z.trigger("blur");
        }

    });
    //登录
    $("#lbtn").click(function () {
        $.post("/login", $("#lform").serialize(), function (data) {
            if (data == "accountError") {
                $(".alert").html("用户名或密码错误！").fadeIn(200).delay(1000).fadeOut(200);
            } else {
                location.href = "/index";
            }
        })
    })
});
//注册验证
$(function () {
    var reg1 = /^1[0-9]{10}/;
    var reg2 = /[a-zA-Z0-9]{1,10}@[a-zA-Z0-9]{1,5}\.[a-zA-Z0-9]{1,5}/;
    var reg3 = /\W/;
    var reg4 = /^_/;
    //用户名判断
    $("#setUser").focus(function () {
        $(".help-block:eq(0)").empty();
        $(this).parent(".input-group").removeClass("has-error has-success");
    });
    $("#setUser").blur(function () {
        var m = $(this).val();
        if (reg1.test(m) == true) {
            $(this).parent(".input-group").addClass("has-success");
        } else if (reg2.test(m) == true) {
            $(this).parent(".input-group").addClass("has-success");
        } else {
            $(this).parent(".input-group").addClass("has-error");
            if (m.length == 0) {
                $(".help-block:eq(0)").html("用户名不可为空！");
            } else {
                $(".help-block:eq(0)").html("请输入手机号/邮箱的正确格式!");
            }
        }
    });
    //密码判断
    $("#setPassword").focus(function () {
        $(".help-block:eq(1)").empty();
        $(this).parent(".input-group").removeClass("has-error has-success");
    });
    $("#setPassword").blur(function () {
        var n = $(this).val();
        if (n.length == 0) {
            $(this).parent(".input-group").addClass("has-error");
            $(".help-block:eq(1)").html("密码不可为空！");
        } else if (n.length < 5 || n.length > 20) {
            $(this).parent(".input-group").addClass("has-error");
            $(".help-block:eq(1)").html("密码长度不符合要求！")
        } else {
            if (reg3.test(n) == true) {
                $(this).parent(".input-group").addClass("has-error");
                $(".help-block:eq(1)").html("密码由字母、数字和“_”组成！")
            } else if (reg4.test(n) == true) {
                $(this).parent(".input-group").addClass("has-error");
                $(".help-block:eq(1)").html("密码不可以“_”开头！")
            } else {
                $(this).parent(".input-group").addClass("has-success");
            }
        }
        //确认密码
        var o = $("#checkPassword").val();
        if (o.length != 0) {
            if (o != n) {
                $("#checkPassword").parent(".input-group").removeClass("has-success")
                    .addClass("has-error");
                $(".help-block:eq(2)").html("确认密码不正确！");
            } else {
                $(".help-block:eq(2)").empty();
                $("#checkPassword").parent(".input-group").removeClass("has-error")
                    .addClass("has-success");
            }
        }
    });
    //确认密码
    $("#checkPassword").focus(function () {
        $(".help-block:eq(2)").empty();
        $(this).parent(".input-group").removeClass("has-error has-success");
    });
    $("#checkPassword").blur(function () {
        var o = $(this).val();
        if (o.length == 0) {
            $(this).parent(".input-group").addClass("has-error");
            $(".help-block:eq(2)").html("确认密码不可为空！");
        } else if (o != $("#setPassword").val()) {
            $(this).parent(".input-group").addClass("has-error");
            $(".help-block:eq(2)").html("确认密码不正确！");
        } else {
            $(this).parent(".input-group").addClass("has-success");
        }
    })
});

//获取日期
function date() {
    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var day = date.getDate();
    var week = date.getDay();
    switch (week) {
        case 1:
            week = "星期一 ";
            break;
        case 2:
            week = "星期二 ";
            break;
        case 3:
            week = "星期三 ";
            break;
        case 4:
            week = "星期四 ";
            break;
        case 5:
            week = "星期五 ";
            break;
        case 6:
            week = "星期六 ";
            break;
        case 0:
            week = "星期日 ";
            break;
        default:
            week = "";
            break;
    }
    document.getElementById("date").innerHTML = year + "-" + month + "-" + day;
    document.getElementById("week").innerHTML = week;
}
setInterval("date()", 1000);

//日记模块
function writeContent() {
    var content1 = document.getElementById("content1");
    var content2 = document.getElementById("content2");
    var n = content1.value;
    var count = 0;
    var reg = /[^\\x0000-\\x00ff]/;
    for (var i = 0; i < n.length; i++) {
        if (reg.test(n.charAt(i))) {
            count += 375 / 52;
        } else {
            count += 375 / 47;
        }
    }
    if (event.keyCode == 13) {

    }
    alert(count);
    if (count >= 375) {
        content2.focus();
    }
}

$(function () {
    //写日记、看日记切换
    $("#write").click(function () {
        changeToWrite();
    });
    //保存日记
    $("#saveDiary").click(function () {
        $.post("/saveDiary", {
                "title": $("#writeTitle").val(),
                "content1": $("#writeContent1").val(),
                "content2": $("#writeContent2").val()
            },
            function (data) {
                if (data == "ok") {
                    alert("保存成功！");
                    //跳转到年目录
                    changeToList();
                    $("#writeTitle").empty();
                    $("#writeContent1").empty();
                    $("#writeContent2").empty();
                } else {
                    alert("保存失败！")
                }
            }
        )
    });
    //查看年目录
    $(document).on('click', ".showYear", function () {
        changeToList();
    });
    //查看月份目录
    $(document).on('click', ".showMonth", function () {
        //返回上一级功能
        $("#return").show().addClass("showYear").text("返回上一级");
        //显示月份目录
        var year = $(this).find("span").text();
        show("目录-" + year, "showDay", "/showDiaryMonthList", {"year": year.substring(0, 4)});
    });
    //查看日目录
    $(document).on('click', ".showDay", function () {
        //返回上一级功能
        $("#return").removeClass("showYear").addClass("returnMonth").text("返回上一级");
        //显示日目录
        var month = $(this).find("span").text();
        var year = $("#diaryList").find(".bookTitle:eq(0)").text();
        show(year + "-" + month, "showContent", "/showDiaryDayList", {"yearMonth": year + month});
    });
    //日目录返回至月目录
    $(document).on('click', ".returnMonth", function () {
        var year = $("#diaryList").find(".bookTitle:eq(0)").text().substring(0, 8);
        show(year, "showDay", "/showDiaryMonthList", {"year": year.substring(3, 7)});
        $("#return").removeClass("returnMonth").addClass("showYear");
    });
    //查看日记内容
    $(document).on('click', ".showContent", function () {
        //返回上一级功能
        $("#return").removeClass("returnMonth").addClass("returnDay").text("返回上一级");
        //显示日记内容
        var year = $("#diaryList").find(".bookTitle:eq(0)").text();
        var date = $(this).find("em").text();
        $.post("/showDiaryContent", {"time": year.substring(5, 7) + date}, function (data) {
            if (data.length != 0) {
                $("#diaryList").hide();
                $("#readDiary").show().find(".bookTitle:eq(0)").text(data.title);
                $("#readDiary").find("#leftContent").text(data.leftContent);
                $("#readDiary").find("#rightContent").text(data.rightContent);
                $(".details").text(year.substring(3, 7) + "-" + date.substring(0, 2) + "-" + date.substring(2))
            }
        }, "JSON")
    });
    //日记内容返回至日目录
    $(document).on('click', ".returnDay", function () {
        var date = $(".details").text();
    });

    //切换至目录模块方法
    function changeToList() {
        show("目录", "showMonth", "/showDiaryYearList");
        $("#writeDiary").attr("hidden", "hidden");//写日记模块隐藏
        $("#readDiary").attr("hidden", "hidden");//读日记模块隐藏
        $("#diaryList").removeAttr("hidden");//目录模块显示
        $("#return").hide().removeClass("showYear showMonth showDay");
    }

    //切换至写日记模块方法
    function changeToWrite() {
        $("#writeDiary").removeAttr("hidden");//写日记模块显示
        $("#diaryList").attr("hidden", "hidden");//目录模块隐藏
        $("#readDiary").attr("hidden", "hidden");//日记内容模块隐藏
        $("#return").show().removeClass("showMonth showDay").addClass("showYear").text("返回目录");
    }

    //年月日目录切换方法
    function show(title, liClass, url, e) {
        $.post(url, e, function (data) {
            if (data.length != 0) {
                var m = data.split(("$"));
                $("#diaryList").find(".bookTitle:eq(0)").text(title);
                $("#list-left-left").empty();
                $("#list-left-right").empty();
                $("#list-right-left").empty();
                $("#list-right-right").empty();
                for (i = 0; i < m.length; i++) {
                    var n = m[i].split(",");
                    var $li = $("<li class=" + liClass + ">" + "</li>");
                    var $div = $("<div class='box'>" + "<div class='middle'>" + "</div>" + "</div>"
                        + "<div class='item'>" + "<span>" + n[0] + "</span>" + "<em>" + n[1] + "</em>" + "<div class='line'>" + "</div>" + "</div>");
                    $div.appendTo($li);
                    if (i < 8) {
                        $li.appendTo($("#list-left-left"));
                    } else if (i < 16) {
                        $li.appendTo($("#list-left-right"));
                    } else if (i < 24) {
                        $li.appendTo($("#list-right-left"));
                    } else {
                        $li.appendTo($("#list-right-right"));
                    }
                }
            }
        })
    }

    //心情字数监控
    $(".mood-text").keyup(function () {
        var n = 140 - $(this).text().length;
        if (n > 0) {
            $(".word-limit").text("（你还能输入" + n + "个字符）").css("color", "black");
        } else {
            $(".word-limit").html("（字数超过限制啦！）").css("color", "red");
        }
    }).blur(function () {
        $(".word-limit").empty();
    });
    //心情发表功能
    $(".publish").click(function () {
        var x = $(".mood-text").text();
        var n = 140 - x.length;
        if (n < 0) {
            alert("字数超过限制，发表失败！")
        } else {
            $.post("/saveMood", {"content": x}, function (data) {
                if (data == "ok") {
                    var date = new Date();
                    var year = date.getFullYear();
                    var month = date.getMonth() + 1;
                    var day = date.getDate();
                    var hour = date.getHours();
                    if (month < 10) {
                        month = "0" + month;
                    }
                    if (hour < 10) {
                        hour = "0" + hour;
                    }
                    var minute = date.getMinutes();
                    if (minute < 10) {
                        minute = "0" + minute;
                    }
                    var $li = $("<li class='mood-li'>" + "<div class='mood-block'>" + "<span>" + year + "-" + month + "-" + day + " " + hour + ":" + minute + "</span>" + "</div>" + "<p>" + x + "</p>" + "<button class='delete' type='button'>" + "<span class='delete-span' hidden>" + "<span class='glyphicon glyphicon-trash'>" + "</span>" + "</span>" + "</button>" + "</li>");
                    $li.prependTo(".mood-ul");
                    $(".mood-text").empty();
                } else {
                    alert("发表失败！");
                }
            })
        }
    });
    $(document).on('mouseover mouseout', ".mood-li", function (event) {
        if (event.type == "mouseover") {
            $(this).find(".delete-span").show();
        } else {
            $(this).find(".delete-span").hide();
        }
    });
    /*$(".mood-li").hover(function () {
        $(this).find(".delete-span").show();
    }, function () {
        $(this).find(".delete-span").hide();
    });*/

    //纪念日模块
    $(".add-memory").click(function () {
        var memoryName = $("#memoryName").val();
        var memoryTime = $("#memoryTime").val();
        var addType = "新增";
        if (memoryName.length != 0 && memoryTime.length != 0) {
            $(this).parents("form").submit();
        } else if (memoryName.length == 0) {
            alert("你忘记填写纪念日名字啦！")
        } else if (memoryTime.length == 0) {
            alert("你忘记填写纪念日时间啦！")
        }
    });
    $(".add").click(function () {
        var $li = $(this).parents("li");
        var memoryName = $li.find(".memory-name").text();
        $("#memoryName").val(memoryName);
        $("#memoryTime").val($(this).text().trim());
    });

    //情书模块
    function letterChange(e) {
        var x=$(".letter-content");
        if (e==3){
            x.find("h4").text("To My Lover");
            x.find(".write").text("寄出");
            x.find(".save-letter").css("display","block");
            x.find("button").attr("disabled","disabled");
            x.find("p").hide();
            x.find("table").hide();
            x.find("textarea").show();
        } else if (e==4 ){
            alert("保存至草稿箱并刷新页面");
            var y=$(".letter-content textarea").val();
            $.post("/saveLoveLetter",{"content":y},function (data) {
                if (data=="ok"){
                    location.href="/navToBox?state=2";
                }else {
                    alert("保存失败")
                }
            })

        } else{
            x.find(".size").empty();
            x.find(".write").text("写情书");
            x.find(".write").removeAttr("disabled","disabled");
            x.find(".save-letter").css("display","none");
            x.find("textarea").empty().hide();
            x.find("p").hide();
            x.find("table").show();
            /*if (e == 0 ){
                x.find("h4").text("我收到的情书");
            }else if (e == 1 ){
                x.find("h4").text("我寄出的情书");
            }else if (e == 2 ){
                x.find("h4").text("我的草稿箱");
            }*/
        }
    }
    $("#love-letter button").click(function () {
        var e=$("#love-letter button").index($(this));
        if (e ==3){
            var x=$(".letter-content").find(".write");
            if (x.text() =="寄出"){
                var y=$(".letter-content textarea").val();
                $.post("/saveAndSendLoveLetter",{"content":y},function (data) {
                    if (data =="ok"){
                        alert("发送成功");
                        location.href="/navToBox?state=1";
                    }else if (data=="error"){
                        alert("尚未绑定对象");
                        location.href="/navToBox?state=2";
                    }else {
                        alert("发送失败");
                    }
                })
            }else if (x.text() =="编辑"){
                var y= $(".letter-content").find("p");
                letterChange(3);
                $(".letter-content textarea").val(y.text());
                alert("从数据库删掉此条草稿");
                var m=$("#getId").val();
                $.post("/deleteLetter",{"id":m})
            }else{
                letterChange(3);
            }
        }else {
            letterChange(e);
        }
    });
    $(".letter-content tr").click(function () {
            var x=$(".letter-content");
            var m=$(this).find(".content").text();
            var n=x.find("h4").text();
            if (n =="我收到的情书"){
                x.find("h4").text("From My Lover");
            }else {
                if (n =="我的草稿箱"){
                    x.find(".write").text("编辑");
                }
                x.find("h4").text("To My Lover");
                var y=$(this).find(".delete-letter").next().val();
                $("#getId").val(y);
            }
            x.find("table").hide();
            x.find("textarea").hide();
            x.find("p").show();
            x.find("p").html(m);
    });
    $(".letter-content tr").hover(function () {
        $(this).find(".delete-letter").css("display","inline-block");
    },function () {
        $(this).find(".delete-letter").css("display","none");
    });
    $(".delete-letter").click(function () {
        var tr=$(this).parents("tr");
        var id=$(this).next().val();
        $.post("/deleteLetter",{"id":id},function (data) {
            if (data =="ok"){
                tr.remove();
            }else {
                alert("删除失败！")
            }
        });
        return false;
    });
    $(".letter-content textarea").keydown(function () {
        var n=800-$(this).text().length;
        var x= $(".letter-content").find(".size");
        var y=$(".letter-content").find("button");
        if (n>=0&&n<=800){
            x.css("color","black");
            y.removeAttr("disabled","disabled");
            x.text("你还可以输入"+n+"个字符！");
        }else {
            x.css("color","red");
            y.attr("disabled","disabled");
            x.text("字符数超出限制！");
        }
    });

    //愿望墙模块
    $(".wish-content").find(".save-wish").click(function () {
        var x=$(".wish-content").find("textarea");
        var date=new Date();
        var $li1=$("<li>"+"<div>"+"<span>"+"<span class='glyphicon glyphicon-time'>"+"</span>"+date+"</span>"+"<p>"+x.text()+"</p>"+"</div>"+"<input type='checkbox'/>"+"已完成"+"</li>");
        var $ul1=$("#oursWish").find("ul");
        $li1.prependTo($ul1);
        var $li2=$("<li>"+"<div>"+"<span>"+"<span class='glyphicon glyphicon-time'>"+"</span>"+date+"</span>"+"<p>"+x.text()+"</p>"+"</div>"+"<input type='checkbox'/>"+"已完成"+"</li>");
        var $ul2=$("#myWish").find("ul");
        $li2.prependTo($ul2);
        x.empty();
        $(".wish-title a:eq(0)").trigger("click");
        $.post("/saveWish",{"content":x.text()},function (data) {
            if (data =="ok"){
                alert("保存成功");
            }else{
                alert("保存失败");
            }
        })
    });
    $(".wish-content textarea").keydown(function () {
        var n=100-$(this).text().length;
        var x= $(".wish-content").find(".size");
        var y=$(".wish-content").find("button");
        if (n>=0&&n<=100){
            x.css("color","white");
            y.removeAttr("disabled","disabled");
            x.text("你还可以输入"+n+"个字符！");
        }else {
            x.css("color","yellow");
            y.attr("disabled","disabled");
            x.text("字符数超出限制！");
        }
    })
});



