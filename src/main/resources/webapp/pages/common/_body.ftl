
<div class="layui-body">
    <div class="layui-tab" lay-allowClose="true" lay-filter="admin-pagetabs">
        <ul class="layui-tab-title">
        </ul>
        <div class="layui-tab-content">
        </div>
    </div>
    <div class="layui-icon admin-tabs-control layui-icon-prev" ew-event="leftPage"></div>
    <div class="layui-icon admin-tabs-control layui-icon-next" ew-event="rightPage"></div>
    <div class="layui-icon admin-tabs-control layui-icon-down">
        <ul class="layui-nav admin-tabs-select" lay-filter="admin-pagetabs-nav">
            <li class="layui-nav-item" lay-unselect>
                <a href="javascript:;"></a>
                <dl class="layui-nav-child layui-anim-fadein">
                    <dd ew-event="closeThisTabs" lay-unselect><a href="javascript:;">关闭当前标签页</a></dd>
                    <dd ew-event="closeOtherTabs" lay-unselect><a href="javascript:;">关闭其它标签页</a></dd>
                    <dd ew-event="closeAllTabs" lay-unselect><a href="javascript:;">关闭全部标签页</a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>