
<!DOCTYPE html>
<html>
<head>
    <title>${systemName}</title>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${ctx}/webapp/assets/common/layui/css/layui.css"/>
    <link rel="stylesheet" href="${ctx}/webapp/assets/common/css/login.css" media="all">
    <style>
        body {
            background-image: url("${ctx}/webapp/assets/common/images/bg_login2.svg");
            background-position: center 110px;
            background-repeat: no-repeat;
            background-size: 100%;
            background-color: #f0f2f5;
        }

        .login-header {
            color: rgba(0, 0, 0, .85) !important;
        }

        .login-footer {
            color: rgba(0, 0, 0, 0.7) !important;
        }

        .login-footer a {
            color: rgba(0, 0, 0, 0.7) !important;
        }

        .login-footer a:hover {
            color: rgba(0, 0, 0, 0.4) !important;
        }
    </style>
    <script>
        if (window != top)
            top.location.replace(location.href);
    </script>
</head>

<body>
<div class="login-wrapper">

    <div class="login-header">
        <img src="${ctx}/webapp/assets/expand/images/logo.png">
    </div>
    <div class=" login-body">
        <div class="layui-card">
            <div class="layui-card-header">
                <i class="layui-icon layui-icon-engine"></i>&nbsp;&nbsp;用户登录
            </div>
            <form class="layui-card-body layui-form layui-form-pane" >
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input name="username" type="text" lay-verify="required" id="username" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-block">
                        <input name="password" type="password" lay-verify="required" id="password" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item" pane="">
                    <label class="layui-form-label" lay-tips="7天内免登陆">记住我</label>
                    <div class="layui-input-block" >
                        <input type="radio" name="remember" value="on" title="是">
                        <input type="radio" name="remember" value="off" title="否" checked="">
                    </div>
                </div>
                <div class="layui-form-item">
                    <a href="javascript:;" class="layui-link">帐号注册</a>
                    <a href="javascript:;" class="layui-link pull-right">忘记密码？</a>
                </div>
                <div class="layui-form-item">
                    <button lay-filter="login-submit" class="layui-btn layui-btn-fluid" id="lay-submit" lay-submit>登 录</button>
                </div>

<#--                <div class="layui-form-item login-other">-->
<#--                    <label>第三方登录</label>-->
<#--                    <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>-->
<#--                    <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>-->
<#--                    <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>-->
<#--                </div>-->
            </form>
        </div>
    </div>

    <div class="login-footer">
        <p> <a href="https://www.stylefeng.cn" target="_blank"></a></p>
    </div>
</div>

<script type="text/javascript" src="${ctx}/webapp/assets/common/layui/layui.js"></script>


<script>
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        // 表单提交
        form.on('submit(login-submit)', function(data){
            var username=$("#username").val();
            var password=$("#password").val();
            var remember=$("[name=remember]").val();
                $.ajax({
                    type:'POST',
                    url:'/login',
                    data:{username:username,password:password,remember:remember},
                    success:function(data){
                       if(data.code==0){
                window.location.href="/"
                       }else {
                           layer.alert(data.msg);
                       }
                    }
                })
            return false;
        })




    });
</script>


</body>
</html>