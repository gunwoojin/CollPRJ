<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ȸ������ ����</title>
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
                    <a href="#" class="active">ȸ������ ����</a>
                </li>
                <li>
                    <a href="#">���� ����</a>
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
                            <li>ȸ������ ����</li>
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
                                <span>�޴��� ��ȣ</span>
                                <input type="text" class="mod" value=":" readonly>
                            </div>
                        </li>
                        <br>
                        <li>
                            <a>�������� ��ȣ�� ���� �� ������ ��� �����ϰ� ��ȣȭ�˴ϴ�.</a>
                        </li>
                        <li>
                            <input type="button" class="modify">
                            </input>
                        </li>
                    </ul>
                    <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li>��й�ȣ ����</li>
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
                <a href="#" class="withdrawal">ȸ�� Ż��</a>
            </div>
        </div>
    </div>
</div>



</body>