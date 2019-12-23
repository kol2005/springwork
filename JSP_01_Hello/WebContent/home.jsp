<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//여기는 JSP파일내에 Java코드를 작성하는 영역
	int num1 = 30;
	int num2 = 40;

	int sum = num1 + num2;

	System.out.println(sum);
%>
<!DOCTYPE html>
<html>
<!-- head tag는 페이지에 대한 정보등을 기록하는 부분
웹페이지에 표시되지는 않지만 웹페이지에 어떤 것을 표시하기 위한
다양한 설정등을 기록하는 부분 -->
<head>
<meta charset="UTF-8">
<!-- 웹페이지를 표시할때 제목으로 사용되는 문자열 -->
<title>나의 첫번째 홈페이지</title>
</head>
<!-- 웹페이지에 나타날 정보들을 표시하는 영역 
디자인과 관련된 문서표시를 하는 부분 -->
<body>
	<!-- h tag는 h1 ~ h6 까지 사용되며 본문보다 큰 글자를 표시 -->
	<h1>h1 글자</h1>
	<h2>나는 home.jsp입니다</h2>
	<h3>반갑습니다</h3>
	<h4>우리나라 만세</h4>
	<h4><%=sum%></h4>
	<p>paragraph</p>
	<p>문단tag</p>
	<p>본문tag</p>
	<p>웹페이지에서는 Enter의 의미가 없다</p>
	<p>한개의 문단내의 문자열이 매우 커서 한줄에 표시가 되지 않을때는
	자동으로 다음줄로 넘겨져서 표시가 된다
	이러한 현상을 Auto Word Wrap 이라고 한다</p>
	
	<p>문서를 작성하면서 Enter키를 입력해도 웹페이지에서는
	단지 1개의 빈칸으로 인식한다
	여러줄에 걸쳐 문서를 작성하기 위해 Enter를 입력하지만
	실제 웹페이지에서 볼때는 단지 1개의 빈칸으로만 인식한다</p>
	<p>문자열을 표시하면서 br tag를 사용하면 해당 위치에서 강제 줄바꿈이 된다
	br tag는 임의로 문단내에서 문자열을 여러줄에 표시하고자 할때 사용한다<br/>
	break의 약자</p>
	<p>br tag로 줄바꿈을 하면 문단내에서는<br/>
	 위아래 여백이 없는 상태로 문자열들이
	표시된다
		
	<p>우리나라 <br/>
	대한민국 <br/>
	Republic Of Korea</p>
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
		eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl
		tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem
		ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.
		Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi
		eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at
		imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis.
		Egestas integer eget aliquet nibh praesent. In hac habitasse platea
		dictumst quisque sagittis purus. Pulvinar elementum integer enim neque
		volutpat ac. Senectus et netus et malesuada. Nunc pulvinar sapien et
		ligula ullamcorper malesuada proin. Neque convallis a cras semper
		auctor. Libero id faucibus nisl tincidunt eget. Leo a diam
		sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod
		lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum
		posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non
		enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae
		auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec
		ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed.
		Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac
		tortor dignissim convallis aenean et tortor at. Pretium viverra
		suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio
		tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et
		magnis dis parturient montes nascetur. Est placerat in egestas erat
		imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
		Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum
		odio eu. Etiam erat velit scelerisque in dictum non consectetur a
		erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor
		posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas.
		Bibendum neque egestas congue quisque egestas diam. Laoreet id donec
		ultrices tincidunt arcu non sodales neque. Eget felis eget nunc
		lobortis mattis aliquam faucibus purus. Faucibus interdum posuere
		lorem ipsum dolor sit.
	<p>피가 무엇을 아니한 바로 같지 위하여, 내는 끓는 자신과 보라. 그들의 피가 든 놀이 쓸쓸하랴? 두손을 그들은 두기
		그들의 이상, 뜨거운지라, 그것을 그러므로 사막이다. 사랑의 그것을 열락의 사랑의 구할 청춘은 고동을 바이며, 운다. 가치를
		그들을 되는 유소년에게서 얼음에 현저하게 주며, 말이다. 피부가 꽃이 같으며, 같지 우리는 용기가 힘차게 예수는 뛰노는
		황금시대다. 인생에 이는 같은 이상 이상의 같이 꽃이 무한한 이것이다. 길지 무한한 것이다.보라, 거친 생생하며, 우는 하는
		품었기 그것은 약동하다. 위하여서 봄바람을 이 것은 쓸쓸하랴? 속에 사랑의 지혜는 방황하였으며, 가는 눈에 길지 사막이다.

		내는 곳이 위하여 피다. 너의 현저하게 아니한 그들은 않는 어디 반짝이는 교향악이다. 바이며, 때까지 무한한 그러므로 트고,
		것이다. 인도하겠다는 얼마나 목숨을 전인 뜨거운지라, 듣는다. 인생을 천고에 대고, 길지 따뜻한 무한한 바로 못하다
		봄바람이다. 희망의 새 같은 것은 대한 그들은 있다. 가는 되는 대중을 불어 이 소리다.이것은 부패뿐이다. 것은 천하를 청춘
		만물은 약동하다. 얼마나 간에 실현에 길을 유소년에게서 속잎나고, 동산에는 충분히 것이다. 얼음이 같이, 눈에 것은 것이다.
		우리의 인생에 천자만홍이 보이는 가치를 있다. 보이는 인류의 살 열락의 아름답고 가치를 많이 과실이 힘있다. 공자는 인생의
		광야에서 꽃이 있으랴? 능히 타오르고 투명하되 그러므로 발휘하기 가치를 가치를 그들은 약동하다. 품고 피고 피는 없으면,
		듣는다. 쓸쓸한 열락의 불어 시들어 위하여 같은 우리 아름다우냐? 청춘의 평화스러운 가치를 고행을 오직 있으랴? 생의 풀이
		피가 현저하게 가치를 넣는 있는가?
</body>
</html>