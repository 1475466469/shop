
<div class="layui-side">
    <div class="layui-side-scroll">
  <#macro childMenus Menu>
        <ul class="layui-nav layui-nav-tree" lay-filter="admin-side-nav" style="margin-top: 15px;">
            <#list Menu as menus>
          <li class="layui-nav-item layui-nav-itemed">
                       <a lay-href="${menus.url}"><i class="${menus.icon}"></i>&emsp;<cite>${menus.name}</cite></a>
                        <#if menus.childrenMenu??>
                            <dl class="layui-nav-child">
                                <#list menus.childrenMenu as childrenMenu>
                                    <dd><a lay-href="${childrenMenu.url}">${childrenMenu.name}</a></dd>
                                    <#if childrenMenu.childrenMenu??>
                                        <@childMenus childrenMenu.childrenMenu></@childMenus>
                                    </#if>
                                </#list>
                            </dl>
                        </#if>
              </li>
            </#list>
        </ul>
            </#macro>
        <@childMenus Menu></@childMenus>

    </div>
</div>
