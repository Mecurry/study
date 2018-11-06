<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <head>
        <meta charset="utf-8">
        <title>信息列表</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- basic styles -->

        <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="/assets/css/font-awesome.min.css">

        <!--[if IE 7]>
        <link rel="stylesheet" href="/assets/css/font-awesome-ie7.min.css"/>
        <![endif]-->

        <!-- page specific plugin styles -->
        <link rel="stylesheet" href="/assets/css/dropzone.css">
        <!-- fonts -->

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300">

        <!-- ace styles -->

        <link rel="stylesheet" href="/assets/css/ace.min.css">
        <link rel="stylesheet" href="/assets/css/ace-rtl.min.css">
        <link rel="stylesheet" href="/assets/css/ace-skins.min.css">


        <!--[if lte IE 8]>
        <link rel="stylesheet" href="/assets/css/ace-ie.min.css"/>
        <![endif]-->

        <!-- inline styles related to this page -->

        <!-- ace settings handler -->

        <script src="/assets/js/jquery-2.0.3.min.js"></script>
        <script src="/assets/js/ace-extra.min.js"></script>

        <script src="/assets/layer/layer.js"></script>

        <!--[if lt IE 9]>
        <script src="/assets/js/html5shiv.js"></script>
        <script src="/assets/js/respond.min.js"></script>

        <![endif]-->


    </head>

</head>
<body>


<div id="dropzonediv">


    <div >
        <div  id="dropzone"  class="dropzone dz-clickable">

            <div class="dz-default dz-message">
                <span>
                    <span class="bigger-150 bolder">
                        <i class="icon-caret-right red"></i>
                       拖拽文件到此处
                    </span>

                    <span class="smaller-80 grey">(或点击此处上传文件)</span>
                    <br>
                    <i class="upload-icon icon-cloud-upload blue icon-3x"></i>
                </span>
            </div>
        </div>
    </div>


</div>

</body>

<script src="/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<script src="/assets/js/dropzone.min.js"></script>

<!-- ace scripts -->

<script src="/assets/js/ace-elements.min.js"></script>

<script type="text/javascript">
    //获取url路径参数
    function GetQueryString(id) {
        var reg = new RegExp("(^|&)"+ id +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]);return null;
    }


    var file_id=GetQueryString("row_id");





    Dropzone.autoDiscover = false;
        $("#dropzone").dropzone({
            url: "/index/upload?file_id="+file_id,
            dictDefaultMessage: '<span class="bigger-150 bolder"><i class="icon-caret-right red"></i> 拖动文件至该处</span><span class="smaller-80 grey">(或点击此处)</span> <br /><i class="upload-icon icon-cloud-upload blue icon-3x"></i>',
            dictResponseError: '网络错误请稍后重试!',
            parallelUploads: 5,//有多少文件将上载到并行处理
            maxFileSize: 3072,//以MB为单位[上传文件的大小限制]
            autoProcessQueue: true,//关闭自动上传功能，默认会true会自动上传,也就是添加一张图片向服务器发送一次请求
            addRemoveLinks:true,//在每个预览文件下面添加一个remove[删除]或者cancel[取消](如果文件已经上传)上传文件的链  接
            uploadMultiple: true,//允许上传多文件
            dictCancelUpload: '取消',
            autoDiscover:false,
            dictRemoveFile: '删除',
            dictRemoveLinks: "删除",
            acceptedFiles: ".jpg,JPG,.jpeg,.doc,.docx,.ppt,.pptx,.txt,.avi,.pdf,.mp3,.zip,.mp4",
            dictFallbackMessage: '不好意思，您的浏览器不支持！',//如果浏览器不支持,默认消息将被替换为这个文本。默认为 “Your browser does not support drag'n'drop file uploads.”。
            dictInvalidFileType: '该文件不允许上传',
            previewTemplate: "<div class=\"dz-preview dz-file-preview\">\n  <div class=\"dz-details\">\n    <div class=\"dz-filename\"><span data-dz-name></span></div>\n    <div class=\"dz-size\" data-dz-size></div>\n    <img data-dz-thumbnail />\n  </div>\n  <div class=\"progress progress-small progress-striped active\"><div class=\"progress-bar progress-bar-success\" data-dz-uploadprogress></div></div>\n  <div class=\"dz-success-mark\"><span></span></div>\n  <div class=\"dz-error-mark\"><span></span></div>\n  <div class=\"dz-error-message\"><span data-dz-errormessage></span></div>\n</div>",


            init: function() {

                var _this=this;
                $(".up_btn").click(function () {
                    _this.removeAllFiles();
                });



                this.on("success", function (file) {


                });
                this.on("removedfile", function (file) {
                    //删除文件

                    console.log("File " + file.name + "removed");
                });

            }


        });








</script>
</html>