
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="${ctx}/webapp/assets/expand/images/favicon.ico" rel="icon">
    <title>${systemName}</title>
    <link rel="stylesheet" href="${ctx}/webapp/assets/common/layui/css/layui.css"/>
    <link rel="stylesheet" href="${ctx}/webapp/assets/common/module/admin.css"/>
</head>

<body class="layui-layout-body">

<div class="layui-layout layui-layout-admin">

  <#--头部-->
        <#include "/common/_header.ftl">
<#--    <!-- 侧边栏 &ndash;&gt;-->

<#--    @include("/common/_sidebar.ftl"){}-->

    <#include "/common/_sidebar.ftl">


<#--    <!-- 主体部分 &ndash;&gt;-->
<#--    @include("/common/_body.ftl"){}-->
    <#include "/common/_body.ftl">

<#--    <!-- 底部 &ndash;&gt;-->
<#--    @include("/common/_footer.ftl"){}-->
    <#include "/common/_footer.ftl">

</div>

<!-- 加载动画，移除位置在common.js中 -->
<#include "/common/loading.ftl">

@/* 加入contextPath属性和session超时的配置 */
<script type="text/javascript">
    var Feng = {
        ctxPath: "",
        addCtx: function (ctx) {
            if (this.ctxPath === "") {
                this.ctxPath = ctx;
            }
        }
    };
    Feng.addCtx("${ctx}");
</script>
<script type="text/javascript" src="${ctx}/webapp/assets/common/layui/layui.js"></script>
<script type="text/javascript" src="${ctx}/webapp/assets/common/js/common.js"></script>

<script>
    layui.use(['layer', 'element', 'admin', 'index'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var admin = layui.admin;
        var index = layui.index;

        // 默认加载主页
        index.loadHome({
            menuPath: '${ctx}/system/console',
            menuName: '<i class="layui-icon layui-icon-home"></i>'
        });

        // 修改密码点击事件
        $('#setPsw').click(function () {
            admin.open({
                id: 'pswForm',
                type: 2,
                title: '修改密码',
                shade: 0,
                content: '${ctx}/system/user_chpwd'
            });
        });

        // 退出登录点击事件
        $('#btnLogout').click(function () {
            layer.confirm('确定退出登录？', {
                skin: 'layui-layer-admin'
            }, function () {
                window.location.href = "${ctx}/logout";
            });
        });
    });
</script>
<script>

    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(admin-side-nav)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });



</script>

</body>

</html>