<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원정보 수정</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/myPage.css">
</head>
<body class="pc">

<div class="wrap show">
    <div class="sub_top_wrap">
        <div class="sub_top">
            <h1>MY페이지</h1>
        </div>
    </div>
    <div id="content" class="sub_wrap">
        <nav>
            <ul>
                <li>
                    <a href="#" class="active">회원정보 수정</a>
                </li>
                <li>
                    <a href="#">예약 내역</a>
                </li>
                <li>
                    <a href="#">쿠폰/포인트</a>
                </li>
            </ul>
        </nav>
        <div class="align_rt">
            <div class="notice">
                <!-- Tab -->
                <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li>회원정보 수정</li>
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <ul>
                        <li>
                            <div>
                                <span>ID</span>
                                <input type="text" class="mod" value=":" readonly>
                            </div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>
                                <span>휴대폰 번호</span>
                                <input type="text" class="mod" value=":" readonly>
                            </div>
                        </li>
                        <br>
                        <li>
                            <a>개인정보 보호를 위해 내 정보는 모두 안전하게 암호화됩니다.</a>
                        </li>
                        <li>
                            <input type="button" class="modify">
                            </input>
                        </li>
                    </ul>
                    <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li>비밀번호 변경</li>
                        </ul>
                    </div>
                    </div>
                    <ul>
                        <li>
                            <div>
                                <span>Password</span>
                                <input type="text" class="mod" value=":" readonly>
                            </div>
                        </li>
                        <li>
                            <input type="button" class="modify">
                            </input>
                        </li>
                    </ul>
                </div>
                <a href="#" class="withdrawal">회원 탈퇴</a>
            </div>
        </div>
    </div>
</div>



</body>