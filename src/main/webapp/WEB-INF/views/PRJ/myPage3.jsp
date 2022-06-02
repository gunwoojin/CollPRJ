<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>���೻��</title>
    <link rel="stylesheet" href="/css/myPage3.css" type="text/css">
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
                    <a href="#" class="active">���� ����</a>
                </li>
                <li>
                    <a href="#">����/����Ʈ</a>
                </li>

            </ul>
        </nav>
        <div class="align_rt">
            <div class="notice">
                <!-- Tab -->
                <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li><a href="#">���� ����</a></li>
                            <input type="submit" value="���� ����">
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <div class="reservation">
                        <img src="#">
                        <div class="descript">
                            <a1>������ ��</a1>
                            <input type="checkbox">
                            <a2>�ּ� ����</a2>
                            <a3>���۽ð�</a3>~<a3>�� �ð�</a3>
                            <div class="detail">
                                <button class="cancel">���� ���</button>
                            </div>
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
                            <a1>������ ��</a1>
                            <input type="checkbox">
                            <a2>�ּ� ����</a2>
                            <a3>���۽ð�</a3>~<a3>�� �ð�</a3>
                            <div class="detail">
                                <button class="used">�̿� �Ϸ�</button>
                            </div>
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