//�õ�����ʱ�����¼�
function OnFocusFun(element,elementvalue)
{
    if(element.value==elementvalue)
    {
        element.value="";
        element.style.color="#000";
    }
}
//�뿪�����ʱ�����¼�
function OnBlurFun(element,elementvalue)
{
    if(element.value==""||element.value.replace(/\s/g,"")=="")
    {
        element.value=elementvalue;    
        element.style.color="#999";
    }
}