# 이미지 갤러리 프로젝트
* 2020-01-03

### WYSWYG(What you see What you Get) Editor
* summernote : https://summernote.org/

* textarea에 id 값을 설정하고 id에 jq를 이용해서 속성을
설정해주면 간편하게 WysWyg 방식으로 문서를 작성 할 수 있다

### Drag and Drop으로 파일 올리기
1 Drag And Drop을 수행할 box를 만들기
2 jq drag over, drop event를 설정
3 e.originalEvent.dataTransfer로 부터 files 객체추출

4 files 객체의 0번째 file 객체를 추출

5 ajax를 사용해서 서버로 파일을 업로드 수행하고
6 파일이름등을 다시 response로 되돌려 받아서
7 form img_file input box에 저장을 하고

8 내용을 form post로 upload하면 나머지 정보를 db에 저장

### Drag and Drop으로 여러개 파일 올리기
* 1 ~ 3 까지는 single file upload와 동일
4. files 객체에 담긴 모든 file 객체를 formData에 append()

5. ajax를 사용해서 서버로 업로드를 수행하고
6. 컨트롤러는 수신된 파일들을 서버에 저장하고
7. 저장된 파일이름을 리스트로 생성하고
8. 생성된 파일이름 리스트와 리스트를 표현할 jsp를 rendering 하여 다시 return하고
9. ajax success 코드에서는 return 받은 html 코드를
10. 리스트를 표현할 box에 보인다

#### 이때 리스트를 만들때
* hidden으로 파일리스트를 담을 input box를 만들고
* 각각의 파일이름을 input box에 value에 추가해 둔다

#### 저장을 하면
* 다시 컨트롤러에서는 본문(text)과 함께 hidden input box에
담긴 파일이름을 수신하는데
* String[] mFile : 문자열 배열로 수신하면 된다.