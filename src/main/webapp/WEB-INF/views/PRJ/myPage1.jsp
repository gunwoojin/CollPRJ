<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<%
    String SS_ADDRESS = CmmUtil.nvl((String) session.getAttribute("SS_ADDRESS"));
    String SS_USER_PHONE = CmmUtil.nvl((String) session.getAttribute("SS_USER_PHONE"));

%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ȸ������ </title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/myPage.css">
</head>
<body class="pc">

<div class="wrap show">
    <div class="sub_top_wrap">
        <div class="sub_top">
            <h1>MY������</h1>
        </div>
    </div>
    <div id="content" class="sub_wrap">
        <nav>
            <ul>
                <li>
                    <a href="myPage" class="active">ȸ������ ����</a>
                </li>
                <li>
                    <a href="myPage2">���� ����</a>
                </li>
                <li>
                    <a href="myPage3">���� ����</a>
                </li>
                <li>
                    <a href="/PRJmain">Home</a>
                </li>
            </ul>
        </nav>
        <div class="align_rt">
            <div class="notice">
                <!-- Tab -->
                <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li>ȸ������</li>
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <ul>
                        <li>
                            <div>
                                <span>�ּ�  :</span>
                                <a1><%=SS_ADDRESS%></a1>
                            </div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>
                                <span>�޴��� ��ȣ  :</span>
                                <a1><%=SS_USER_PHONE%></a1>
                            </div>
                        </li>
                        <br>


                        <button type="button" onclick="location.href='/PRJ/updateUserMove'">�����ϱ�</button>

                    </ul>

                    <hr>

                        <button type="button" onclick="location.href='/PRJ/updatePassword'">��й�ȣ �����ϱ�</button>

                    <hr>

                </div>
            </div>
        </div>
    </div>
</div>



</body>