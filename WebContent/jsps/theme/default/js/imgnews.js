// JavaScript Document
$(function(){
 var i=0;
 var j=0;
 var li = $(".lxfscroll li");
 var tli = $(".textscroll li");
 var n=li.length-1;
 var speed = 300;
 li.not(":first").css({left:"160px"});
 li.eq(n).css({left:"-160px"});
 tli.not(":first").css({left:"160px"});
 tli.eq(n).css({left:"-160px"});
 
 lxfNext=function (){
  if (!li.is(":animated")) {
   if (i>=n){i=0;li.eq(n).animate({left:"-160px"},speed);
    li.eq(i).animate({left:"0px"},speed);
   }else{i++;li.eq(i-1).animate({left:"-160px"},speed);li.eq(i).animate({left:"0px"},speed);};
   li.not("eq(i)").css({left:"160px"});
   $("i").text(i+1);
  }else{};
  
  if (!tli.is(":animated")) {
   if (j>=n){j=0;tli.eq(n).animate({left:"-160px"},speed);
    tli.eq(j).animate({left:"0px"},speed);
   }else{j++;tli.eq(j-1).animate({left:"-160px"},speed);tli.eq(j).animate({left:"0px"},speed);};
   tli.not("eq(j)").css({left:"160px"});
  }else{};
 };
 
 lxfLast=function (){
  if (!li.is(":animated")) {
   if (i<=0){i=n;li.eq(0).animate({left:"160px"},speed);li.eq(n).animate({left:"0px"},speed);
   }else{i--;li.eq(i+1).animate({left:"160px"},speed);li.eq(i).animate({left:"0px"},speed);}
   li.not("eq(i)").css({left:"-160px"});
   $("i").text(i+1);
  };
  
   if (!tli.is(":animated")) {
   if (j<=0){j=n;tli.eq(0).animate({left:"160px"},speed);tli.eq(n).animate({left:"0px"},speed);
   }else{j--;tli.eq(j+1).animate({left:"160px"},speed);tli.eq(j).animate({left:"0px"},speed);}
   tli.not("eq(j)").css({left:"-160px"});
  };
 };
});