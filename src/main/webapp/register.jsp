<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2018/3/10
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <base href="<%=request.getContextPath()%>/"/>
    <title>注册-回购网 -  手机回收网 | 二手手机交易 | 笔记本回收 | 平板回收</title>
    <link href="css/global.css" rel="stylesheet" type="text/css">
    <link rel="icon" href="${static_source}${small_logo}"/>
    <script type="text/javascript" src="js/jquery-1.4.2.js"></script>
    <script type="text/javascript" src="js/public.js"></script>
</head>
<body style=" background:#fff">
<style>
    .reg_tips{line-height:25px; height:25px; font-size:12px; color:#f97575; }
    .reg_ts_font{color:#599bff}
    .reg_ok_font{color:#009900}
</style>

<form method="post" id="regForm" action="">
    <input type="hidden" id="t" name="t" value="login" />
    <input type="hidden" id="istrue" name="istrue" value="0" />
    <input type="hidden" id="hidd_validate_code" name="hidd_validate_code" value="0ddc2edbac7d9d0db7ae5289772a6a00" />
    <input type="hidden" value="${user_token}" name="userToken" id="userToken"/>
    <!--注册-->
    <div class="regist_top page"><a href=""><img src="${static_source}${main_logo}"  style="vertical-align:middle"></a><span>免费注册</span></div>
    <div class="regist">
        <div class="regist_l"><img src="${static_source}${main_img}" /></div>
        <div class="regist_r">
            <div class="c1"><span >用户名</span>
                <div class="c1_bg">
                    <input type="text" name="userName" id="username"  class="input_txt3" onclick="clickFun(this,'用户名必须大小写字母开头,长度6~15位！')" onblur="checkInput(this)">
                </div>
                <div class="clear"></div>
            </div>
            <div class="c1_txt"><span class="reg_tips" id="tipusername"></span></div>
            <div class="c1"><span>设置密码</span>
                <div class="c1_bg">
                    <input type="password" name="userPassword" id="password"  class="input_txt5" onclick="clickFun(this,'请输入登录密码，并设置安全级别高的密码！')" onblur="checkInput(this)">
                </div>
                <div class="clear"></div>
            </div>
            <div class="c1_txt"><span class="reg_tips" id="tippassword"></span></div>

            <div class="c1"><span>确认密码</span>
                <div class="c1_bg">
                    <input type="password" name="confirmpassword" id="confirmpassword" class="input_txt5" onclick="clickFun(this,'请再次输入登录密码！')" onblur="checkInput(this)">
                </div>
                <div class="clear"></div>
            </div>
            <div class="c1_txt"><span class="reg_tips" id="tipconfirmpassword"></span></div>
            <div class="c1" style="background:none; margin-bottom:15px;"><span>&nbsp;</span>
                <input name="input2" type="button" id="regbtn" value="立即注册"  class="input_btn3" onclick="submitForm(this);">
                <div class="clear"></div>
            </div>
            <p>
                已有回购网账号，
                <a href="login.jsp">点此登录</a>
            </p>
        </div>
        <div class="clear"></div>
    </div>
</form>
<script type="text/javascript">
    function clickFun(obj,msg){
        var id		=	$(obj).attr("id");

        $("#tip"+id).html("<font class='reg_ts_font'>"+msg+"</font>");
    }


    function checkInput(obj){
        var id		=	$(obj).attr("id");
        var val		=	$(obj).val();
        var error_img	=	"<img src='images/error.gif'/>";
//        var yes_img = "<img src='/images/yes.gif'/>";
        //用户名检测
        if(id=='username'){
            if(val=='')	{
                $("#tip"+id).html("请输入用户名！");
                $("#istrue").val(0);
            }else{
                if(!check_username('username')){
                    $("#tip"+id).html(error_img+"用户名格式错误！");
                    $("#istrue").val(0);
                }else if(check_username('username')){
                    $.post("user/register",
                            {'userName':val
                            },function(data){
                                if(data=="failed"){
                                    $("#tip"+id).html(error_img+"对不起，该用户名已被注册！");
                                    $("#istrue").val(0);
                                }else{
                                    $("#tip"+id).html("<font class='reg_ok_font'>恭喜您，该用户名可以注册！</font>");
                                    $("#istrue").val(1);
                                }
                            });
                }else{
                    $("#tip"+id).html(error_img+"用户名必须大小写字母开头,长度6~15位！");
                    $("#istrue").val(0);
                }
            }
        }
        if(id=='password'){
            if(val==''	||	val.length<7){
                $("#tip"+id).html(error_img+"请输入6位以上密码！");
                $("#istrue").val(0);
            }
            else{
                $("#tip"+id).html("<font class='reg_ok_font'>OK！</font>");
                $("#istrue").val(1);
            }
        }
        if(id=='confirmpassword'){
            if(val==''){
                $("#tip"+id).html(error_img+"请再次输入登录密码！");
                $("#istrue").val(0);
            }else if(val!=$('#password').val()){
                $("#tip"+id).html(error_img+"两次输入密码不一致！");
                $("#istrue").val(0);
            }else{
                $("#tip"+id).html("<font class='reg_ok_font'>OK！</font>");
                $("#istrue").val(1);
            }
        }
    }

    function check_username(id){
        var username_val	=	$.trim($("#"+id).val());
        var usernameReg =/^[a-zA-Z]\w{5,14}$/;
        var flag = true;
        if( ! usernameReg.test(username_val)) {
            flag =	false;
        }
        return flag;
    }

    function submitForm(obj){
        var error_img	=	"<img src='/images/error.gif'/>";


        if($("#username").val()==''){
            $("#tipusername").html(error_img+"请输入用户名！");
            $("#istrue").val(0);
        }
        if($("#password").val()==''	||	$("#password").val().length<7){
            $("#tippassword").html(error_img+"请输入6位以上密码！");
            $("#istrue").val(0);
        }
        if($("#confirmpassword").val()==''){
            $("#tipconfirmpassword").html(error_img+"请再次输入登录密码！");
            $("#istrue").val(0);
        }else if($("#confirmpassword").val()!=$('#password').val()){
            $("#tipconfirmpassword").html(error_img+"两次输入密码不一致！")
            $("#istrue").val(0);
        }
        if($("#istrue").val()	==	0){
            return false;
        }
        var usernameStr = $("#username").val();
        var passwordStr = $("#password").val();
        var userTokenStr = $("#userToken").val();
        var id		=	$(obj).attr("id");
        $.post("user/register",
                {userName:usernameStr, userPassword:passwordStr, userToken:userTokenStr
                },function(data){
                    if(data=="failed"){
                        $("#tip"+id).html(error_img+"对不起，该用户名已被注册！");
                        $("#istrue").val(0);
                    }else if (data == "repeat"){
                        alert("请不要重复提交！")
                    }else {
                        window.location.href="good/home";
                    }
                });
    }
</script>
</body>
</html>
