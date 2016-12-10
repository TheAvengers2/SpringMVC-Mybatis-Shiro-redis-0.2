

var updatedRow;
$("#grid").bootgrid({
	ajax: true,
	ajaxSettings: {
		method: "POST",
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
	rowSelect: false,
	keepSelection: true,
	formatters: {
		"link": function(column, row)
		{
//			return "<a href=\"#\">" + column.id + ": " + row.id + "</a>";
			return "<a onclick=\"update('../data/permission/update',"+row.id+");\" href=\"#\">" + column.id + ": " + row.id + "</a>";
		}
	}
}).on("selected.rs.jquery.bootgrid", function(e, rows) {
		var rowIds = [];
		for (var i = 0; i < rows.length; i++)
		{
			rowIds.push(rows[i].id);
		}
		alert("Select: " + rowIds.join(","));
	}).on("deselected.rs.jquery.bootgrid", function(e, rows) {
			var rowIds = [];
			for (var i = 0; i < rows.length; i++)
			{
				rowIds.push(rows[i].id);
			}
			alert("Deselect: " + rowIds.join(","));
	}).on("click.rs.jquery.bootgrid",function(e,columns,row) {
			console.log(row);
			//update('shiro.demo/data/permission/update',row.id);
	}).on("removed.rs.jquery.bootgrid",function(e,removedRows){
			console.log("some rows are removed");
			console.log(removedRows);
	});


function update(postUrl,rowId){
	//var rowLoc = "tr[data-row-id='"+rowId+"'] > td";
	//var row = $(rowLoc);
	var req = $.ajax({
		type: "POST",
		url: postUrl,
		data: JSON.stringify({"id":rowId}),
		dataType: "json",
		contentType:"application/json",
		success: function(){
			console.log("update succefully @row " + rowId);
			$("#grid").bootgrid("reload");
		}
	});
}

$("#deleteData").on("click", function () {
					$("#grid").bootgrid("remove",4);
					update("",4);
				});

