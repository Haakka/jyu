//得到焦点时触发事件
function OnFocusFun(element,elementvalue)
{
    if(element.value==elementvalue)
    {
        element.value="";
        element.style.color="#000";
    }
}
//离开输入框时触发事件
function OnBlurFun(element,elementvalue)
{
    if(element.value==""||element.value.replace(/\s/g,"")=="")
    {
        element.value=elementvalue;    
        element.style.color="#999";
    }
}