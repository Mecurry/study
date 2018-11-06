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
<div class="page-header">
    <h1>
        附件列表

    </h1>
</div>
<div class="row">
    <div class="col-xs-12">
        <div class="table-responsive" style="background-color: white">
            <table id="fileList" class="table table-striped table-bordered table-hover" >
                <thead>
                <tr>

                    <th>序号</th>
                    <th>文件名称</th>
                    <th class="hidden-480">上传时间</th>


                    <th>
                        <i class="icon-time bigger-110 hidden-480"></i>
                        操作
                    </th>

                </tr>
                </thead>

                <tbody>
            <#list fileList as file>

            <tr>
                <td>
                    ${file.id}
                </td>

                <td>
                    ${file.fileName}
                </td>
                <td>
                    ${file.createTime}
                </td>

                <td>
                        <a class="btn btn-xs btn-success" href="/index/downloadFile?file_id=${file.id}">
                            <i class="icon-download bigger-120"></i>
                        </a>
                        <button class="btn btn-xs btn-danger" onclick="delFile('${file.id}')">
                            <i class="icon-trash bigger-120"></i>
                        </button>

                </td>
            </tr>
            </#list>

                </tbody>
            </table>
        </div><!-- /.table-responsive -->
    </div>
</div>
</body>

<script src="/assets/js/typeahead-bs2.min.js"></script>

<script src="/assets/js/dropzone.min.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script type="text/javascript">
    function delFile(file_id) {
        layer.confirm('确认删除？', {
            btn: ['确认','取消'] //按钮
        }, function(){
            $.ajax({
                url :  "deleteFile",
                type : 'POST',
                data : {
                    "file_id" :file_id
                },
                success : function(data) {
                    window.location.reload();
                },
                error : function() {
                    alert("网络错误请稍后重试!");
                }
            });
        });
    }

</script>
</html>