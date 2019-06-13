//构建分页信息
function builder_pageInfo(result){
	 $("#page_info").empty();
	var res=result.returnResult.result;
	console.log(res);
	 $("#page_info").append("当前"+res.pageNum+"页,总"+res.pages+"页,总"+res.total+"条记录。");
}
//构建分页条
function builder_nav(result){
	$("#page_nav_area").empty();
	var ul=$("<ul></ul>").addClass("pagination");
	var date=result.returnResult.result;
	var firstPageLi=$("<li></li>").addClass("page-item").append($("<a></a>").append("首页").attr("href","#").addClass("page-link"));
	var previousLi=$("<li></li>").addClass("page-item").append($("<a></a>").attr("href","#").addClass("page-link").append($("<span></span>").append("&laquo;")).append($("<span></span>").addClass("sr-only")));
	if(date.hasPrevious==false){
		firstPageLi.addClass("disabled");
		previousLi.addClass("disabled");
	}else{
		 firstPageLi.click(function(){
			  to_page("1");
		  });
		previousLi.click(function(){
			 to_page(date.pageNum-1);
		});
	}
	var nextPageLi=$("<li></li>").addClass("page-item").append($("<a></a>").attr("href","#").addClass("page-link").append($("<span></span>").append("&raquo;")).append($("<span></span>").addClass("sr-only")));
	var lasttPageLi=$("<li></li>").addClass("page-item").append($("<a></a>").append("末页").attr("href","#").addClass("page-link"));
	if(date.hasNextPage==false){
		nextPageLi.addClass("disabled");
		lasttPageLi.addClass("disabled");
	}else{
		nextPageLi.click(function(){
			 to_page(date.pageNum+1);
		});
		lasttPageLi.click(function(){
			 to_page(date.pages);
		});
	}
	var datas=result.returnResult.result.navigatepageNums;
	ul.append(firstPageLi)
	  .append(previousLi)
	  
	 
	
	$.each(datas,function(index,item){
		var navNums= $("<li></li>").addClass("page-item").append($("<a></a>").attr("href","#").addClass("page-link").append(item));
		 if(item==date.pageNum){
			 navNums.addClass("active") 
		 }
		 navNums.click(function(){
			 to_page(item);
		 });
		ul.append(navNums);
	});
	ul.append(nextPageLi)
	  .append(lasttPageLi);
	var nav=$("<nav></nav>").append(ul);
	nav.appendTo("#page_nav_area");
}