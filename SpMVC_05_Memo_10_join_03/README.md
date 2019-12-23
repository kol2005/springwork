# Spring MVC 메모장 프로젝트

### 한개의 테이블(tbl_memo)을 기준으로 CRUD를 구현하기
### list.jsp : 메모 리스트를 보여주기
* 메모추가 버튼을 클릭하여 메모 작성

### 메모리스트를 클릭하여 메모 세부내용을 보여주기
### 메모 세부내용 보기에서 수정, 삭제 버튼을 클릭하여
* 메모 내용 수정
* 메모 삭제를 구현

* web >> controller : ReqMapping >> Service >> Dao + mapper 합성하여 >> 
DBMS 적용
* 결과를 controller에서 views/*.jsp 파일과 합성 >> HTML 변환 >> web

### SessionAttributes Annotation, spring의 form tag를 결합하여 
*insert와 update의 코드를 다소 간소하게 작성

### context
* 서버 프로젝트를 생성하면 base-package를 설정하게 된다 : com.biz.memo
* 서버를 시작하면 http://localhost:8080/memo/ 라는 URL로 시작된다
* /memo/ : context라고 부른다. project의 root 라고 표현한다
* 이 프로젝트의 모든 URL은 /memo/~~~ 방식으로 시작을 한다.
* pageContext.request.contextPath 값을 사용하여야 하는데 변수사용이
너무 길어서 c:set tag를 사용하여 각 jsp 상단에 rootPath EL 변수를
만들고 그 변수를 사용하여 URL을 지정한다.
* a href="${rootPath}/memo/list" 라고 작성을 하면
* a href="/memo/memo/list" 형식으로 컴파일되어 웹페이지에 노출된다

### BCryptPasswordEncoder 를 사용한 비밀번호 암호화

* Spring Security Project에서 제공하는 암호화 클래스
* 단방향 암호화를 지원하는 클래스로 회원가입을 할때 비밀번호나, 
id(주민번호와 같은 민감한 정보)를 암호화하여 저장하는 용도로 사용된다

* 평문을 암호화하는 encode()는 지원하나 반대로 암호문을 평문으로
복호화하는 decode()는 지원하지 않는다.

* 보통 단방향 암호화에서는 암호문 비교할때
* 평문을 다시 encode() 하고 저장된 암호문과 equel() 비교를 수행한다
* 하지만 BCrypt 방식은 그 방법도 사용할수 없다.
* 왜냐하면 BCrypt 는 encode()를 수행할때 자체적으로 생성한 salt를
사용하는데 매번 encode를 수행할때마다 salt가 달라져서 암호화된 값이 달리 추출되기 때문이다

* encode(평문) == 저장된 암호문 방식으로 처리가 불가능하다
* 위방식으로 동작하는 암호저장에는 MD5 방식이 있다
* BCrypt에서는 별도로 matchs()라는 method를 통해서 암호문 비교를 수행하도록 만들어져 있다