<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>����Ʈ ��</title>
    <link rel="stylesheet" href="/css/myPage2.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
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
                    <a href="#">ȸ������ ����</a>
                </li>
                <li>
                    <a href="#">���� ����</a>
                </li>
                <li>
                    <a href="#" class="active">����/����Ʈ</a>
                </li>
            </ul>
        </nav>
        <div class="align_rt">
            <div class="notice">
                <!-- Tab -->
                <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li><a href="#">����/����Ʈ</a></li>
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <ul class="point">
                        <li>
                            <span>��밡�� ����Ʈ</span>
                            <input type="text" value="#P" readonly>
                        </li>
                    </ul>
                    <ul class="coupon">
                        <li>
                            <span>���� ����</span>
                            <input type="text" value="#��" readonly>
                        </li>
                        <div class="coupon_name">
                            <a1>������</a1>
                            <a2>����������</a2>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>