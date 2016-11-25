<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<%
	// 세션에 저장된 글 목록을 꺼낸다.
	BoardVO board=(BoardVO)request.getAttribute("board");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>인턴 글 상세</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="" />
<meta name="author" content="http://bootstraptaste.com" />
<!-- css -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<link href="resources/bootstrap/css/fancybox/jquery.fancybox.css" rel="stylesheet">
<link href="resources/bootstrap/css/jcarousel.css" rel="stylesheet" />
<link href="resources/bootstrap/css/flexslider.css" rel="stylesheet" />
<link href="resources/bootstrap/css/style.css" rel="stylesheet" />


<!-- Theme skin -->
<link href="resources/bootstrap/skins/default.css" rel="stylesheet" />

</head>
<body>
<div id="wrapper">
	<!-- start header -->
	<header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#"><span>N</span>exmotion 인턴</a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li><a href="#">Home</a></li>
                        <li class="dropdown ">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown" data-delay="0" data-close-others="false">test <b class=" icon-angle-down"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">test1</a></li>
                                <li><a href="#">test2</a></li>
								<li><a href="#">test3</a></li>
                            </ul>
                        </li>
                        <li><a href="getBoardList.do">Board</a></li>
                        <li><a href="#">About</a></li>
                        <li class="active"><a href="logout.do">Logout</a></li>
                    </ul>
                </div>
            </div>
        </div>
	</header>
	<!-- end header -->
	<section id="inner-headline">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i></a><i class="icon-angle-right"></i></li>
					<li class="active">Board</li>
				</ul>
			</div>
		</div>
	</div>
	</section>
	<section id="content">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>인턴 게시판</h1>
				
				<form action="updateBoard.do" method="post">
				<input name="seq" type="hidden" value=<%= board.getSeq() %> />
				<table class="table table-bordered">
					<tr>
						<td>제목</td>
						<td align="left"><input class="form-control" name="title" type="text" value="<%= board.getTitle() %>" /></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td align="left"><%= board.getWriter() %></td>
					</tr>
					<tr>
						<td>내용</td>
						<td align="left"><textarea class="form-control" name="content" cols="40" rows="10"><%= board.getContent() %></textarea>
					</tr>
					<tr>
						<td>등록일</td>
						<td align="left"><%= board.getRegDate() %></td>
					</tr>
					<tr>
						<td>조회수</td>
						<td align="left"><%= board.getCnt() %></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="글 수정" class="btn btn-default"/>
						</td>
					</tr>
				</table>
				</form>
				
				<a href="insertBoard.jsp" class="btn btn-default">글등록</a>&nbsp;&nbsp;&nbsp;
				<a href="deleteBoard.do?seq=<%= board.getSeq() %>" class="btn btn-default">글삭제</a>&nbsp;&nbsp;&nbsp;
				<a href="getBoardList.do" class="btn btn-default">글목록</a>
			</div>
		</div>
	</div>
	</section>
	<footer>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 text-center">
				재밌는 개발자 이정훈
			</div>
		</div>
	</div>
	<div id="sub-footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div class="copyright">
						<p>&copy; made by Bootstrap</p>
					</div>
				</div>
				<div class="col-lg-6">
					<ul class="social-network">
						<li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a></li>
						<li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
						<li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
						<li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a></li>
						<li><a href="#" data-placement="top" title="Google plus"><i class="fa fa-google-plus"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="resources/bootstrap/js/jquery.js"></script>
<script src="resources/bootstrap/js/jquery.easing.1.3.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/bootstrap/js/jquery.fancybox.pack.js"></script>
<script src="resources/bootstrap/js/jquery.fancybox-media.js"></script>
<script src="resources/bootstrap/js/google-code-prettify/prettify.js"></script>
<script src="resources/bootstrap/js/portfolio/jquery.quicksand.js"></script>
<script src="resources/bootstrap/js/portfolio/setting.js"></script>
<script src="resources/bootstrap/js/jquery.flexslider.js"></script>
<script src="resources/bootstrap/js/animate.js"></script>
<script src="resources/bootstrap/js/custom.js"></script>

</body>
</html>