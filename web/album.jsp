<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/6/13
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册</title>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/jquery.min.js"></script>
    <script src="jquery/jquery-migrate-1.2.1.min.js"></script>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
    <script src="jquery/cropper.js"></script>
    <script src="jquery/sitelogo.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container-fluid bg" style="margin: 0;padding: 0">
    <div class="row-fluid">
        <div class="tree">
            <div class="fence">
                <ul class="my-album" hidden>
                    <c:forEach var="map" items="${set}">
                        <li class="album-li">
                            <div class="thumbnail">
                                <img src="${map.value}"
                                     alt="还没有照片哦！">
                                <div class="caption">
                                    <h4>${map.key.albumName}</h4>
                                    <p>${map.key.description}</p>
                                    <p>
                                        <button type="button" class="btn btn-primary add-image" value="${map.key.id}">
                                            上传照片
                                        </button>
                                        <button type="button" class="btn btn-default look-image" value="${map.key.id}">
                                            查看相册
                                        </button>
                                    </p>
                                </div>
                            </div>
                        </li>
                    </c:forEach>
                    <li class="new-album-li">
                        <div class="thumbnail">
                            <img src="image/add-album.png"
                                 alt="还没有照片哦！">
                            <div class="caption">
                                <p>
                                    <a href="#" class="btn btn-primary" role="button" data-toggle="modal"
                                       data-target="#newAlbum-information">
                                        新建相册
                                    </a>
                                </p>
                                <%--相册信息模态框--%>
                                <div class="modal fadeIn" id="newAlbum-information" tabindex="-1" role="dialog"
                                     aria-labelledby="newAlbum-informationModal" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h2 class="modal-title" id="newAlbum-informationModal">
                                                    相册信息
                                                </h2>
                                            </div>
                                            <div class="modal-body">
                                                <form id="albumform" action="/addAlbum" method="post" class="form-horizontal" role="form">
                                                    <div class="form-group">
                                                        <label for="album-name" class="col-sm-1 control-label sr-only">name</label>
                                                        <div class="col-sm-6">
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><span
                                                                        class="glyphicon glyphicon-book"></span></span>
                                                                <input name="albumName" type="text" class="form-control"
                                                                       id="album-name"
                                                                       placeholder="请输入相册名">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="album-information"
                                                               class="col-sm-1 control-label sr-only">information</label>
                                                        <div class="col-sm-6">
                                                            <div class="input-group">
                                                                <span class="input-group-addon"><span
                                                                        class="glyphicon glyphicon-pencil"></span></span>
                                                                <input name="description" type="text"
                                                                       class="form-control" id="album-information"id="album-information"
                                                                       placeholder="请填写对此相册的描述">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                                                </button>
                                                <button type="submit" class="btn btn-primary add-album"
                                                        data-dismiss="modal">
                                                    确认新建
                                                </button>
                                            </div>
                                        </div><!-- /.modal-content -->
                                    </div><!-- /.modal -->
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
                <div class="album" hidden>
                    <div class="album-border">
                        <table cellspacing="10">
                            <tr>
                                <td align="center" valign="center">
                                    <img src="image/goleft.gif" id="goleft"/>
                                </td>
                                <td width="515">
                                    <img src="image/bj1.jpg" id="main_img" rel="image/bj1.jpg"
                                         link="http://www.mobanwang.com"/>
                                </td>
                                <td width="120" align="center" valign="top">
                                    <img src="image/gotop.gif" id="gotop"/>
                                    <div id="showArea">
                                        <img src="image/bj1.jpg" class="thumb_img"
                                             rel="images/bj1.jpg" link="http://www.mobanwang.com"/>
                                    </div>
                                    <img src="image/gobottom.gif" id="gobottom"/>
                                </td>
                                <td align="center" valign="center">
                                    <img src="image/goright.gif" id="goright"/>
                                </td>
                            </tr>
                        </table>
                        <button type="button" class="off-album"><span class="glyphicon glyphicon-off"></span></button>
                        <div class="album-information">
                            <h3>你和我</h3>
                            <p>own买电脑就是脑残</p>
                        </div>
                    </div>
                </div>
                <div class="choose-image" hidden>
                    <div id="div_imgfile"></div>
                    <!--图片预览容器-->
                    <div id="div_imglook">
                        <div style="clear: both;"></div>
                    </div>
                    <!--确定上传按钮-->
                    <input type="button" value="确定上传" id="btn_ImgUpStart"/>
                    <input type="hidden" name="albumId">
                    <input type="button" value="退出" class="exit-chooseImage">
                </div>
                <div class="rope-paper">
                    <div class="paper">
                        <h3 style="font-style: italic">晒一晒你们的甜蜜瞬间……</h3>
                        <button class="look-album animated bounceInDown">My Album</button>
                    </div>
                    <div class="right-photo user_pic">
                        <div class="img-border">
                        </div>
                        <button type="button" class="change-img1" data-toggle="modal" data-target="#avatar-modal">
                        </button>
                        <img src="image/add-image.png" class="left-img"/>
                        <button type="button" class="change-img2" data-toggle="modal" data-target="#avatar-modal">
                        </button>
                        <img src="image/add-image.png" class="right-img"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog"
         tabindex="-1">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <!--<form class="avatar-form" action="upload-logo.php" enctype="multipart/form-data" method="post">-->
                <form class="avatar-form">
                    <div class="modal-header">
                        <button class="close" data-dismiss="modal" type="button">&times;</button>
                        <h4 class="modal-title" id="avatar-modal-label">上传图片</h4>
                    </div>
                    <div class="modal-body">
                        <div class="avatar-body">
                            <div class="avatar-upload">
                                <input class="avatar-src" name="avatar_src" type="hidden">
                                <input class="avatar-data" name="avatar_data" type="hidden">
                                <label for="avatarInput" style="line-height: 35px;">图片上传</label>
                                <button class="btn btn-danger" type="button" style="height: 35px;"
                                        onclick="$('input[id=avatarInput]').click();">请选择图片
                                </button>
                                <span id="avatar-name"></span>
                                <input class="avatar-input hide" id="avatarInput" name="avatar_file" type="file"></div>
                            <div class="row">
                                <div class="col-md-9">
                                    <div class="avatar-wrapper"></div>
                                </div>
                                <div class="col-md-3">
                                    <div class="avatar-preview preview-lg" id="imageHead"></div>
                                    <!--<div class="avatar-preview preview-md"></div>
                            <div class="avatar-preview preview-sm"></div>-->
                                </div>
                            </div>
                            <div class="row avatar-btns">
                                <div class="col-md-4">
                                    <div class="btn-group">
                                        <button class="btn btn-danger fa fa-undo" data-method="rotate" data-option="-90"
                                                type="button" title="Rotate -90 degrees"> 向左旋转
                                        </button>
                                    </div>
                                    <div class="btn-group">
                                        <button class="btn  btn-danger fa fa-repeat" data-method="rotate"
                                                data-option="90"
                                                type="button" title="Rotate 90 degrees"> 向右旋转
                                        </button>
                                    </div>
                                </div>
                                <div class="col-md-5" style="text-align: right;">
                                    <button class="btn btn-danger fa fa-arrows" data-method="setDragMode"
                                            data-option="move"
                                            type="button" title="移动">
							            <span class="docs-tooltip" data-toggle="tooltip" title=""
                                              data-original-title="$().cropper(&quot;setDragMode&quot;, &quot;move&quot;)">
							            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-search-plus" data-method="zoom"
                                            data-option="0.1" title="放大图片">
							            <span class="docs-tooltip" data-toggle="tooltip" title=""
                                              data-original-title="$().cropper(&quot;zoom&quot;, 0.1)">
							              <!--<span class="fa fa-search-plus"></span>-->
							            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-search-minus" data-method="zoom"
                                            data-option="-0.1" title="缩小图片">
							            <span class="docs-tooltip" data-toggle="tooltip" title=""
                                              data-original-title="$().cropper(&quot;zoom&quot;, -0.1)">
							              <!--<span class="fa fa-search-minus"></span>-->
							            </span>
                                    </button>
                                    <button type="button" class="btn btn-danger fa fa-refresh" data-method="reset"
                                            title="重置图片">
								            <span class="docs-tooltip" data-toggle="tooltip" title=""
                                                  data-original-title="$().cropper(&quot;reset&quot;)"
                                                  aria-describedby="tooltip866214">
                                            </span>
                                    </button>
                                </div>
                                <div class="col-md-3">
                                    <button class="btn btn-danger btn-block avatar-save fa fa-save" type="button"
                                            data-dismiss="modal"> 保存修改
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
</div>
<script src="jquery/html2canvas.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
    //做个下简易的验证  大小 格式
    $('#avatarInput').on('change', function (e) {
        var filemaxsize = 1024 * 5;//5M
        var target = $(e.target);
        var Size = target[0].files[0].size / 1024;
        if (Size > filemaxsize) {
            alert('图片过大，请重新选择!');
            $(".avatar-wrapper").childre().remove;
            return false;
        }
        if (!this.files[0].type.match(/image.*/)) {
            alert('请选择正确的图片!')
        } else {
            var filename = document.querySelector("#avatar-name");
            var texts = document.querySelector("#avatarInput").value;
            var teststr = texts; //你这里的路径写错了
            testend = teststr.match(/[^\\]+\.[^\(]+/i); //直接完整文件名的
            filename.innerHTML = testend;
        }

    });

    $('.user_pic button').click(function () {
        var index = $('.user_pic button').index($(this));
        $(".avatar-save").unbind('click');
        $(".avatar-save").click(function () {
            var img_lg = document.getElementById('imageHead');
            // 截图小的显示框内的内容
            html2canvas(img_lg, {
                allowTaint: true,
                taintTest: false,
                onrendered: function (canvas) {
                    canvas.id = 'mycanvas';
                    //生成base64图片数据
                    var dataUrl = canvas.toDataURL("image/jpeg");
                    var newImg = document.createElement("img");
                    newImg.src = dataUrl;
                    imagesAjax(dataUrl, index);
                }
            });
        });
    });


    function imagesAjax(src, index) {
        var data = {};
        data.img = src;
        data.jid = $('#jid').val();
        data.index = index;
        $('.user_pic img:eq(' + index + ')').attr('src', src);


        /*$.ajax({
         url: "upload-logo.php",
         data: data,
         type: "POST",
         dataType: 'json',
         success: function (re) {
         if (re.status == '1') {
         $('.user_pic img:eq(0)').attr('src', src);
         }
         }
         });*/
    }
</script>
<script src="jquery/IMGUP.js"></script>
</body>
</html>
