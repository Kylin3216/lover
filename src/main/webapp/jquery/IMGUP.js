//相册切换

$(function () {
    $(".look-album").click(function () {
        $(".rope-paper").hide();
        $(".my-album").show();
    });
    $(document).on("click", ".add-image", function () {
        $(".choose-image input[name='albumId']").val($(this).val());
        $(".choose-image").slideDown(300);
    });
    $(".exit-chooseImage").click(function () {
        $(".choose-image").slideUp(400);
    });
    $(document).on("click", ".look-image", function () {
        $(".album").fadeIn(400);
        function lookAlbum() {
            function $(e) {
                return document.getElementById(e);
            }

            document.getElementsByClassName = function (cl) {
                var retnode = [];
                var myclass = new RegExp('\\b' + cl + '\\b');
                var elem = this.getElementsByTagName('*');
                for (var i = 0; i < elem.length; i++) {
                    var classes = elem[i].className;
                    if (myclass.test(classes)) retnode.push(elem[i]);
                }
                return retnode;
            };
            var MyMar;
            var speed = 1; //速度，越大越慢
            var spec = 1; //每次滚动的间距, 越大滚动越快
            var ipath = 'image/'; //图片路径
            var thumbs = document.getElementsByClassName('thumb_img');
            for (var i = 0; i < thumbs.length; i++) {
                thumbs[i].onclick = function () {
                    $('main_img').src = this.src;
                    $('main_img').link = this.link;
                    for (var i = 0; i < thumbs.length; i++) {
                        thumbs[i].style.border = "none";
                    }
                    this.style.border = "blue 2px solid";
                };
                /*thumbs[i].onclick = function () {location = this.link}*/
            }
            $('goleft').onclick = function () {
                for (var i = 0; i < thumbs.length; i++) {
                    if ($('main_img').src == thumbs[i].src) {
                        $('main_img').src = thumbs[i - 1].src;
                        $('main_img').link = thumbs[i - 1].link;
                        thumbs[i].style.border = "none";
                        thumbs[i - 1].style.border = "blue 2px solid";
                        break;
                    }
                }
            };
            $('goright').onclick = function () {
                for (var i = 0; i < thumbs.length; i++) {
                    if ($('main_img').src == thumbs[i].src) {
                        $('main_img').src = thumbs[i + 1].src;
                        $('main_img').link = thumbs[i + 1].link;
                        thumbs[i].style.border = "none";
                        thumbs[i + 1].style.border = "blue 2px solid";
                        break;
                    }
                }
            };
            $('main_img').onclick = function () {
                location = this.link;
            };
            $('gotop').onmouseover = function () {
                this.src = ipath + 'gotop2.gif';
                MyMar = setInterval(gotop, speed);
            };
            $('gotop').onmouseout = function () {
                this.src = ipath + 'gotop.gif';
                clearInterval(MyMar);
            };
            $('gobottom').onmouseover = function () {
                this.src = ipath + 'gobottom2.gif';
                MyMar = setInterval(gobottom, speed);
            }
            $('gobottom').onmouseout = function () {
                this.src = ipath + 'gobottom.gif';
                clearInterval(MyMar);
            }
            $('goleft').onmouseover = function () {
                this.src = ipath + 'goleft2.gif';
            };
            $('goleft').onmouseout = function () {
                this.src = ipath + 'goleft.gif';
            };
            $('goright').onmouseover = function () {
                this.src = ipath + 'goright2.gif';
            };
            $('goright').onmouseout = function () {
                this.src = ipath + 'goright.gif';
            };

            function gotop() {
                $('showArea').scrollTop -= spec;
            }

            function gobottom() {
                $('showArea').scrollTop += spec;
            }
        }

        lookAlbum();
    });
    $(".off-album").click(function () {
        $(this).parents(".album").hide(300);
    });
    $(document).on('click', '.add-album', function () {
        $("#albumform").submit();
        /*var $li=$("<li class='album-li'>"+ "<div class='thumbnail'>"+"<img src='/image/gab3.png' alt='还没有照片哦！'>"+"<div class='caption'>"+"<h4>"+albumName.val()+"</h4>"+"<p>"+albumInformation.val()+"</p>"+"<p>"+"<button type='button' class='btn btn-primary add-image'>"+"上传照片"+"</button>"+" "+"<button type='button' class='btn btn-default look-image'>"+"查看相册"+"</button>"+"</p>"+"</div>"+"</div>"+"</li>");
         $li.insertBefore($(".new-album-li"));*/
        albumName.empty();
        albumInformation.empty();
    })
});

//*******************************************
$(function () {
    var IMG_LENGTH = 1;//图片最大1MB
    var IMG_MAXCOUNT = 9;//最多选中图片张数
    var IMG_AJAXPATH = "/addPhoto";//异步传输服务端位置
    var UP_IMGCOUNT = 0;//上传图片张数记录
    $("#btn_ImgUpStart").click(function () {
        if ($(".lookimg").length <= 0) {
            alert("还未选择需要上传的图片");
            return;
        }

        //全部图片上传完毕限制
        if ($(".lookimg[ISUP=1]").length == $(".lookimg").length) {
            alert("图片已全部上传完毕！");
            return;
        }
        var albumId = $(".choose-image input[name='albumId']").val();
        //循环所有已存在的图片对象，准备上传
        for (var i = 0; i < $(".lookimg").length; i++) {
            var NOWLOOK = $(".lookimg").eq(i);//当前操作的图片预览对象
            NOWLOOK.index = i;
            //如果当前图片已经上传，则不再重复上传
            if (NOWLOOK.attr("ISUP") == "1")
                continue;

            //上传图片准备
            var photoName = NOWLOOK.children("input").eq(0).val();
            var IMG_BASE = NOWLOOK.children("img").eq(0).attr("src"); //要上传的图片的base64编码
            var IMG_IND = NOWLOOK.attr("num");
            var IMG_ROUTE = $(".imgfile[num=" + IMG_IND + "]").eq(0).val();//获取上传图片路径，为获取图片类型使用
            var IMG_ENDFOUR = IMG_ROUTE.substr(IMG_ROUTE.length - 4, 4);//截取路径后四位，判断图片类型
            var IMG_FOMATE = "jpeg"; //图片类型***
            if (IMG_ENDFOUR.trim() == ".jpg")
                IMG_FOMATE = "jpg";
            else if (IMG_ENDFOUR.trim() == ".png")
                IMG_FOMATE = "png";

            //图片正式开始上传
            $.ajax({
                type: "POST",
                url: IMG_AJAXPATH,
                data: {
                    'photoName': photoName,
                    'albumId': albumId,
                    'imgBase': IMG_BASE, /* 'imgFormat': IMG_FOMATE,*/
                    'lookIndex': NOWLOOK.index
                },//图片base64编码，图片格式（当前仅支持jpg,png,jpeg三种），图片对象索引
                dataType: "json",
                success: function (data) {
                    if (data.isok == "true") {
                        //图片上传成功回调
                        var UPTIME = Math.ceil(Math.random() * 400) + 400;//生成一个400-800的随机数，假设进图条加载时间不一致
                        $(".lookimg").eq([data.ind]).attr("ISUP", "1");//记录此图片已经上传
                        $(".lookimg").eq([data.ind]).children(".lookimg_progress").eq(0).children("div").eq(0).animate({width: "100%"}, UPTIME, function () {
                            $(this).css("background-color", "#00FF00").text('上传成功');
                        });
                    }
                    else {//图片未上传成功回调
                        $(".lookimg")[data.ind].children(".lookimg_progress").eq(0).children("div").eq(0).css("width", "100%").css("background-color", "red").text("上传失败");
                    }
                },
                error: function (err) {
                    //服务器连接失败报错处理
                    alert("error");
                    //alert(err.responseText);
                },
                beforeSend: function () {
                    //图片上传之前执行的操作，当前为进度条显示
                    NOWLOOK.children(".lookimg_progress").eq(0).css("display", "block");//进度条显示
                }
            });
        }
    });
//打开文件选择对话框
    $("#div_imgfile").click(function () {
        if ($(".lookimg").length >= IMG_MAXCOUNT) {
            alert("一次最多上传" + IMG_MAXCOUNT + "张图片");
            return;
        }

        var _CRE_FILE = document.createElement("input");
        if ($(".imgfile").length <= $(".lookimg").length) {//个数不足则新创建对象
            _CRE_FILE.setAttribute("type", "file");
            _CRE_FILE.setAttribute("class", "imgfile");
            _CRE_FILE.setAttribute("accept", ".png,.jpg,.jpeg");
            _CRE_FILE.setAttribute("num", UP_IMGCOUNT);//记录此对象对应的编号
            $("#div_imgfile").after(_CRE_FILE);
        }
        else { //否则获取最后未使用对象
            _CRE_FILE = $(".imgfile").eq(0).get(0);
        }
        return $(_CRE_FILE).click();//打开对象选择框
    });

//创建预览图，在动态创建的file元素onchange事件中处理
    $(document).on("change", ".imgfile", function () {
        if ($(this).val().length > 0) {//判断是否有选中图片
            //判断图片格式是否正确
            var FORMAT = $(this).val().substr($(this).val().length - 3, 3);
            if (FORMAT != "png" && FORMAT != "jpg" && FORMAT != "peg") {
                alert("文件格式不正确！！！");
                return;
            }
            var path = $(this).val().split("\\");
            var photoName = path[path.length - 1];
            //判断图片是否过大，当前设置1MB
            var file = this.files[0];//获取file文件对象
            if (file.size > (IMG_LENGTH * 1024 * 1024)) {
                alert("图片大小不能超过" + IMG_LENGTH + "MB");
                $(this).val("");
                return;
            }
            //创建预览外层
            var _prevdiv = document.createElement("div");
            _prevdiv.setAttribute("class", "lookimg");
            //创建内层img对象
            var preview = document.createElement("img");
            $(_prevdiv).append(preview);
            //input hidden photoname
            var _input = document.createElement("input");
            _input.setAttribute("type", "hidden");
            _input.setAttribute("name", "photoName");
            _input.setAttribute("value", photoName);
            $(_prevdiv).append(_input);
            //创建删除按钮
            var IMG_DELBTN = document.createElement("div");
            IMG_DELBTN.setAttribute("class", "lookimg_delBtn");
            IMG_DELBTN.innerHTML = "移除";
            $(_prevdiv).append(IMG_DELBTN);
            //创建进度条
            var IMG_PROGRESS = document.createElement("div");
            IMG_PROGRESS.setAttribute("class", "lookimg_progress");
            $(IMG_PROGRESS).append(document.createElement("div"));
            $(_prevdiv).append(IMG_PROGRESS);
            //记录此对象对应编号
            _prevdiv.setAttribute("num", $(this).attr("num"));
            //对象注入界面
            $("#div_imglook").children("div:last").before(_prevdiv);
            UP_IMGCOUNT++;//编号增长防重复

            //预览功能 start
            var reader = new FileReader();//创建读取对象
            reader.onloadend = function () {
                preview.src = reader.result;//读取加载，将图片编码绑定到元素
            };
            if (file) {//如果对象正确
                reader.readAsDataURL(file);//获取图片编码
            } else {
                preview.src = "";//返回空值
            }
            //预览功能 end
        }
    });

//删除选中图片
    $(".lookimg_delBtn").live("click", function () {
        $(".imgfile[num=" + $(this).parent().attr("num") + "]").remove();//移除图片file
        $(this).parent().remove();//移除图片显示
    });

//删除按钮移入移出效果
    $(".lookimg").live("mouseover", function () {
        if ($(this).attr("ISUP") != "1")
            $(this).children(".lookimg_delBtn").eq(0).css("display", "block");
    });
    $(".lookimg").live("mouseout", function () {
        $(this).children(".lookimg_delBtn").eq(0).css("display", "none");
    });

//确定上传按钮

});
