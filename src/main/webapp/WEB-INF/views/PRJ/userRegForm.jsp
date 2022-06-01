<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up page</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style> body {
        min-height: 100vh;
        background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
        background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
        background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
        background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
        background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
    }

    .input-form {
        max-width: 680px;
        margin-top: 80px;
        padding: 32px;
        background: #fff;
        -webkit-border-radius: 10px;
        -moz-border-radius: 10px;
        border-radius: 10px;
        -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
        box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
    } </style>

    <script type="text/javascript">
        // ȸ������ ��ȿ�� üũ
        function doRegUserCheck(f) {

            if (f.user_id.value === "") {
                alert("���̵� �Է��ϼ���");
                f.user_id.focus();
                return false;
            }
            if (f.email.value === "") {
                alert("�̸����� �Է��ϼ���");
                f.email.focus();
                return false;
            }
            if (f.password.value === "") {
                alert("��й�ȣ�� �Է��ϼ���");
                f.password.focus();
                return false;
            }
            if (f.password2.value === "") {
                alert("��й�ȣ�� Ȯ���ϼ���");
                f.password2.focus();
                return false;
            }
            if (f.address.value === "") {
                alert("�ּ��� �Է��ϼ���");
                f.address.focus();
                return false;
            }
            if (f.user_phone.value === "") {
                alert("��ȭ��ȣ�� �Է��ϼ���");
                f.user_phone.focus();
                return false;
            }
        }
    </script>
</head>

<body>

    <div class="container">
        <div class="input-form-backgroud row">
            <div class="input-form col-md-12 mx-auto">
                <h4 class="mb-3">Sign Up</h4>
                <form class="validation-form"  name="f" method="post" action="/user/insertUserInfo" onsubmit="return doRegUserCheck(this);" >

                    <div class="row">

                        <div class="col-md-6 mb-3">
                            <td>ID</td>
                            <input type="text" name="user_id" class="form-control">
                            <div class="invalid-feedback"> write name.</div>
                        </div>
                        <div class="col-md-6 mb-3">
                            <td>E-mail</td>
                            <input type="text" name="email" class="form-control" placeholder="you@example.com">
                            <div class="invalid-feedback"> write email.</div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <td>Password</td>
                        <input type="password" name="password" class="form-control">
                        <div class="invalid-feedback"> write password.</div>
                    </div>
                    <div class="mb-3">
                        <td>Check Password</td>
                        <input type="password" name="password2" class="form-control">
                        <div class="invalid-feedback"> password check.</div>
                    </div>
                    <div class="mb-3">
                        <td>Address</td>
                        <input type="text" name="address" class="form-control" placeholder="Seoul">
                        <div class="invalid-feedback"> your address.</div>
                    </div>
                    <div class="mb-3">
                        <td>Phone</td>
                        <input type="text" name="user_phone" class="form-control">

                        <div class="invalid-feedback"> your Phone.</div>
                    </div>
                    <hr class="mb-4">

                    <div class="mb-4"></div>
                    <input type="submit" class="btn btn-primary btn-lg btn-block"/>\


                </form>
            </div>
        </div>

    </div>

</body>


</html>

