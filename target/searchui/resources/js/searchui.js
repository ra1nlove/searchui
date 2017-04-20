/**
 * Created by zjl on 17-4-12.
 */

function searchMsg(){
    var keywords =$('#keywords').val();
    openPostWindow("result.jsp",keywords,"_self");
}

function openPostWindow(url, keywords, name)
{

    var tempForm = document.createElement("form");
    tempForm.id="tempForm1";
    tempForm.method="post";
    tempForm.action=url;
    tempForm.target=name;


    var hideInput = document.createElement("input");
    hideInput.type="hidden";
    hideInput.name= "keywords";
    hideInput.value= keywords;
    tempForm.appendChild(hideInput);

    tempForm.addEventListener("submit",function(){  window.open(name); });
    document.body.appendChild(tempForm);

    tempForm.submit();
    document.body.removeChild(tempForm);
}
