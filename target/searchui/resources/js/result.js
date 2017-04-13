/**
 * Created by zjl on 17-4-12.
 */
var keyword ;  //

function showResults(results){
    $(".resultList").empty();
    $.each(results,function(idx,obj){

        $("<div class='resultItem'>"+
        "<div class='itemHead'>"+
            "<a href='"+obj.url+"' target='_blank'>"+obj.title+"</a>"+
        "</div>"+
        "<div class='itemBody'>"+obj.text+"</div></div>").appendTo(".resultList");
    })
}
function showPage(totalResult,currentPage){
    $("#totalResult").text(totalResult);
    var totalPages = Math.ceil(totalResult/10 );
    $("#totalPage").text(totalPages);
    $(".pagination").pagination(totalResult, {
        current_page :currentPage, //当前页码
        items_per_page :10,
        display_msg :true,
        callback :pageselectCallback
    });
}


function pageselectCallback(page_id) {
    $.ajax({
        url:"/get?keyword="+keyword+"&page="+page_id,
        type:"get",
        success: function(data,status,jqxhr){
            showResults(data.pages);
            showPage(data.total,page_id);

        },
        error:function(jqxhr,status,errorMsg){
            alert("Status: "+status+" Error: "+errorMsg);
        }
    });
}

function searchMsgIn(){
    keyword =$('#keywords').val();
    $("#keywords").val(keyword);
    $.ajax({
        url:"/get?keyword="+keyword+"&page=0",
        type:"get",
        success: function(data,status,jqxhr){
            showResults(data.pages);
            showPage(data.total,0);

        },
        error:function(jqxhr,status,errorMsg){
            alert("Status: "+status+" Error: "+errorMsg);
        }
    });
}

