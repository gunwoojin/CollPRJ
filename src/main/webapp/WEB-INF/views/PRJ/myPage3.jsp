<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공유내역</title>
    <link rel="stylesheet" href="/css/myPage3.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
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
                    <a href="PRJ/myPage">회원정보 수정</a>
                </li>
                <li>
                    <a href="PRJ/myPage2" class="active">예약 내역</a>
                </li>

                <li>
                    <a href="PRJ/myPage3" class="active">공유 내역</a>
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
                            <li><a href="#">예약 내역</a></li>
                            <input type="submit" value="선택 삭제">
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <div class="reservation">
                        <img src="#">
                        <div class="descript">
                            <a1>주차장 명</a1>
                            <input type="checkbox">
                            <a2>주소 기입</a2>
                            <a3>시작시간</a3>~<a3>끝 시간</a3>

                            <div class="button">
                                <button class="mapicon"><i class="fas fa-map-marker-alt"></i></button>
                            </div>
                        </div>
                        <div class="map">
                        </div>
                    </div>

                    <div class="reservation">
                        <img src="#">
                        <div class="descript">
                            <a1>주차장 명</a1>
                            <input type="checkbox">
                            <a2>주소 기입</a2>
                            <a3>시작시간</a3>~<a3>끝 시간</a3>
                            <div class="button">
                                <button class="mapicon"><i class="fas fa-map-marker-alt"></i></button>
                            </div>
                        </div>
                        <div class="map">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>