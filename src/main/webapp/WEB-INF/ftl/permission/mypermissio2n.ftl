<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>我的权限  —个人中心</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="${basePath}/css/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="${basePath}/css/favicon.ico" />
		<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>
		
		<link href="${basePath}/css/bootgrid/jquery.bootgrid.css" rel="stylesheet"/>
		
	</head>
	<body data-target="#one" data-spy="scroll">
		
		<@_top.top 1/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<#--row-->
			<div class="row">
				<@_left.user 2/>
				<div class="col-md-10">
					<h2>我的权限</h2>
					<hr>
					<!--
					<div id="getPermissionTree" >loding... ...</div>
					-->
					<!-- bootgrid start -->
					<table id="grid-keep-selection" class="table table-condensed table-hover table-striped">
					    <thead>
					        <tr>
					            <th data-column-id="id" data-type="numeric" data-identifier="true"></th>
					            <th data-column-id="url">权限名称</th>
					            <th data-column-id="name" data-order="desc">角色类型</th>
					            <th data-column-id="link" data-formatter="link" data-sortable="false">操作</th>
					        </tr>
					    </thead>
					</table>
					<!-- bootgrid end -->
					
				</div>
			</div>
			<#--/row-->
		</div>
		<script  src="http://open.sojson.com/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="${basePath}/js/common/layer/layer.js"></script>
		<script  src="${basePath}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script  src="${basePath}/js/shiro.demo.js"></script>
		
		<!-- jquery bootgrid -->
		<script src="${basePath}/js/common/bootgrid/moderniz.2.8.1.js"></script>
		<script src="${basePath}/js/common/bootgrid/jquery.bootgrid.js"></script>
		<script>
			$("#grid-keep-selection").bootgrid({
			    ajax: true,
			    ajaxSettings: {
			        method: "GET",
			        cache: false
			    },
			    post: function ()
			    {
			        /* To accumulate custom parameter with the request object */
			        return {
			            id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
			        };
			    },
			    url: "/shiro.demo/data/permission/page",
			    selection: true,
			    multiSelect: true,
			    rowSelect: true,
			    keepSelection: true,
			    formatters: {
			        "link": function(column, row)
			        {
			            return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
			        }
			    }
			}).on("selected.rs.jquery.bootgrid", function(e, rows)
			{
			    var rowIds = [];
			    for (var i = 0; i < rows.length; i++)
			    {
			        rowIds.push(rows[i].id);
			    }
			    alert("Select: " + rowIds.join(","));
			}).on("deselected.rs.jquery.bootgrid", function(e, rows)
			{
			    var rowIds = [];
			    for (var i = 0; i < rows.length; i++)
			    {
			        rowIds.push(rows[i].id);
			    }
			    alert("Deselect: " + rowIds.join(","));
			}).on("removed.rs.jquery.bootgrid",function(e,removedRows){
				console.log(removedRows);
			});
		</script>
	</body>
</html>