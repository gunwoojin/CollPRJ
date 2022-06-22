<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="kopo.poly.dto.ShareDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%
    ShareDTO rDTO = (ShareDTO) request.getAttribute("rDTO");

    if (rDTO==null){
        rDTO = new ShareDTO();
    }

    String ss_user_id = CmmUtil.nvl((String)session.getAttribute("SS_USER_ID"));

    int edit = 1;

    if (ss_user_id.equals("")){
        edit = 3;
    }
    else if (ss_user_id.equals(CmmUtil.nvl(rDTO.getReg_id()))){
        edit = 2;
    }

    System.out.println("user_id :" + CmmUtil.nvl(rDTO.getReg_id()));
    System.out.println("ss_user_id:" +ss_user_id);
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주차장 상세보기</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="..//css/myPage.css">
    <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../css/ruang-admin.min.css" rel="stylesheet">

    <style>
        .w-btn {
            position: relative;
            border: none;
            display: inline-block;
            padding: 15px 30px;
            border-radius: 15px;
            font-family: "paybooc-Light", sans-serif;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
            text-decoration: none;
            font-weight: 600;
            transition: 0.25s;
        }
        .w-btn-blue {
            background-color: #6aafe6;
            color: #d4dfe6;
        }
    </style>

    <script type="text/javascript">


        function doEdit(){
        if ("<%=edit%>"==2){
            location.href="/ParkEditInfo?sSeq=<%=CmmUtil.nvl(rDTO.getSp_seq())%>";
        }else if ("<%=edit%>"==3){
            alert("로그인 하세요")
        }else {
            alert("본인이 등록한 것만 수정 가능합니다")
        }
        }

        function doDelete(){
            if ("<%=edit%>" == 2){if (confirm("삭제하시겠습니까?")){
                location.href = "/share/ParkDelete?sSeq=<%=CmmUtil.nvl(rDTO.getSp_seq())%>";
            }
            }else if ("<%=edit%>" == 3){
                alert("로그인 하시길 바랍니다");
            }else {
                alert("본인이 등록한것만 삭제 가능합니다.");
            }
        }
        function doList(){
            location.href = "/spMap_test";
        }
    </script>
</head>
<body class="pc">

<div class="wrap show">
    <div class="sub_top_wrap">
        <div class="sub_top">
            <h1>주차장 정보</h1>
        </div>
    </div>
    <div id="content" class="sub_wrap">
        <div class="align_rt">
            <div class="notice">
                <!-- Tab -->
                <div class="tab">
                    <div class="tab_btn">
                        <ul>
                            <li><%=CmmUtil.nvl(rDTO.getSp_title())%>의 정보</li>
                        </ul>
                    </div>
                </div>
                <div class="tab_each">
                    <ul>
                        <li>
                            <div>
                                <span>설명  :</span>
                                <a1><%=CmmUtil.nvl(rDTO.getSp_contents())%></a1>
                            </div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>
                                <span>주소  :</span>
                                <a1><%=CmmUtil.nvl(rDTO.getSp_place())%></a1>
                            </div>
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <div>
                                <span>주차 가능시간  :</span>
                                <a1><%=CmmUtil.nvl(rDTO.getStart_time())%> ~ <%=CmmUtil.nvl(rDTO.getEnd_time())%></a1>
                            </div>
                        </li>
                    </ul>

                    <div>
                        <form action="/share/reservation" method="post">
                        <input type="hidden" id="sSeq" name="sSeq" value="<%=CmmUtil.nvl(rDTO.getSp_seq())%>"></input>
                            <button class="w-btn w-btn-blue" onclick="location.href='/spMap_test'">목록으로 돌아가기</button >
                            <button class="w-btn w-btn-blue" type="submit" data-target="#reservation" data-toggle="modal" href="/share/reservation" data-toggle="modal">예약하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


</div>

<div class="modal fade" id="reservation" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelLogout"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabelDeleteUser">Alert</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>이 주차장을 예약하시겠습니까?</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Cancel</button>
                <a href="/share/reservation" class="btn btn-primary">Reservation</a>
            </div>
        </div>
    </div>
</div>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="../js/ruang-admin.min.js"></script>
<script src="../vendor/chart.js/Chart.min.js"></script>
<script src="../js/demo/chart-area-demo.js"></script>
</body>

</html>
