

<div class="layui-header" @block="header">
    <div class="layui-logo">
   <img src="${ctx}/webapp/assets/common/images/logo.png"/>
        <i class="layui-icon layui-icon-component"></i>
        <cite>&nbsp;${systemName}&emsp;</cite>
    </div>
    <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item" lay-unselect>
            <a ew-event="flexible" title="侧边伸缩"><i class="layui-icon layui-icon-shrink-right"></i></a>
        </li>
        <li class="layui-nav-item" lay-unselect>
 <a ew-event="refresh" title="刷新"><i class="layui-icon layui-icon-refresh-3"></i></a>
        </li>

    </ul>
    <ul class="layui-nav layui-layout-right">
        <li class="layui-nav-item" lay-unselect>
            <a ew-event="message" title="消息"><i class="layui-icon layui-icon-notice"></i></a>
        </li>
        <li class="layui-nav-item layui-hide-xs" lay-unselect>
            <a ew-event="fullScreen" title="全屏"><i class="layui-icon layui-icon-screen-full"></i></a>
        </li>
        <li class="layui-nav-item" lay-unselect>
            <a>
<#--                <img src="${avatar!}" class="layui-nav-img">-->
<#--                <cite>${name!"用户"}</cite>-->
            </a>
            <dl class="layui-nav-child">
                <dd lay-unselect>
                   <a ew-href="${ctx}/webapp/system/user_info">个人中心</a>
                </dd>
                <dd lay-unselect>
                    <a id="setPsw">修改密码</a>
                </dd>
                <hr>
                <dd lay-unselect>
                    <a id="btnLogout">退出</a>
                </dd>
            </dl>
        </li>
        <li class="layui-nav-item" lay-unselect>
            <a ew-event="theme" title="主题"><i class="layui-icon layui-icon-more-vertical"></i></a>
        </li>
    </ul>
</div>