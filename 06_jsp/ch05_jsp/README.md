## [05] JSP 웹프로그래밍

Servlet은 JAVA언어를 이용하여 문서를 작성하고, 출력객체(PrintWriter객체)를 이용하여 HTML코드를 삽입한다. JSP는 Servlet과 반대로 HTML코드에 JAVA언어를 삽입하여 동적 문서를 만들 수 있다.

| 정의            | 코드                         | 설명                                                         |
| --------------- | ---------------------------- | ------------------------------------------------------------ |
| 스크립트릿      | <%      %>                   | JAVA 코드                                                    |
| 선언            | <%!     %>                   | 변수 또는 메소드 선언할 때 사용. 여기서 선언된 변수 및 메소드는 페이지 어느곳에서나 사용가능한 전역의 의미로 사용된다. |
| 표현식          | <%=    %>                    | JSP 페이지 내에서 사용되는 변수의 값 또는 메소드 호출 결과값을 출력하기 위해 사용. `;`을 사용하지 않는다. |
| 지시자          | <%@    %>                    | JSP페이지의 전체적인 속성을 지정할 때 사용.<br>page, include, taglib 가 있으며 <%@속성 %>형태로 사용한다.<br>**page**: 해당 페이지의 전체적인 속성 지정. 주로 사용되는 언어 지정 및 import문을 많이 사용, 문서 타입(html, excel..)<br/>**include**: 별도의 페이지를 현재 페이지에 사용 (footer 등 모든 페이지에서 반복되는 작업들에 이용)<br>**taglib**: 태그 라이브러리(사용자가 만든 tag들)의 태그 사용. |
| 주석            | <%--    --%>                 | 응답페이지에서 보이지 않는 주석<br>WAS에서 이 주석은 제거하고 응답페이지를 만든다. |
| 액션태그        | \<jsp:action> \</jsp:action> | 표준액션태그 (ex.파일연결 및 자바빈 연결)                    |
| 커스텀 액션태그 | \<c:set> \</c:set>           | 커스텀 액션태그                                              |



### JSP 내부객체

- 객체를 생성하지 않고 바로 사용할 수 있는 객체
- JSP에서 제공되는 내부객체는 JSP 컨테이너에 의해 Servlet으로 변화될 때 자동으로 객체가 생성
- 대표적인 내부 객체

| 분류        | 객체                      |
| ----------- | ------------------------- |
| 입출력 객체 | request, response, out    |
| 서블릿 객체 | application, page, config |
| 세션 객체   | session                   |
| 예외 객체   | exception                 |

#### request 객체

웹브라우저를 통해 서버에 어떤 정보를 요청하는 것을 request라 하며, 이러한 요청 정보는 request 내부객체가 관리한다.

**request 객체 메소드**

1. **getRemoteAddr()** :  웹서버에 연결한 클라이언트의 IP주소
2. **getContextPath()** : 웹어플리케이션의 컨텍스트 패스(contextPath)를 리턴
3. **getParameter(String name)** : name에 해당하는 파라미터 값을 리턴
4. **getParameterNames()** : 모든 파라미터 이름을 배열로 리턴
5. **getParameterValues(String name)** : name에 해당하는 파라미터값들을 구한다.
6. **getMethod()** : get방식과 post방식을 구분할 수 있다.
7. **getSession()** : 세션 객체를 얻는다.
8. **getProtocol()** : 해당 프로토콜을 얻는다.
9. **getRequestURL()** : 요청 URL를 얻는다.
10. **getRequestURI()** : 요청 URI를 얻는다.
11. **getServerPort() ** : 포트번호를 얻는다.



💡**ip가 0:0:0:0:0:0:0:1로 나올 때**

request.getRemoteAddr()를 출력했을 때 127.0.0.1 이 아닌 0:0:0:0:0:0:0:1 으로 나오는 현상이 있다. 127.0.0.1 은 IPV4 체계이고, 0:0:0:0:0:0:0:1 는 IPV6 체계이다.

클라이언트 ip를 IPV4 체계로 가져오기 위해서는 자바 실행 옵션으로 `-Djava.net.preferIPv4Stack=true` 값을 부여하면 된다. 이클립스에서는 tomcat 실행 시 VM arguments 항목에 `-Djava.net.preferIPv4Stack=true` 값을 추가하면 된다.

----



#### response 객체

브라우저의 요청에 응답하는 것을 response한다고 하며, 이러한 응답(response)의 정보는 response 내부객체가 갖고 있다. doGet, doPost 메서드의 두번째 파라미터와 동일하다.

1. **getCharacterEncoding()** : 응답할때 문자의 인코딩.
2. **addCookie(Cookie)** : 쿠키를 지정.
3. **sendRedirect(URL)** : 지정한 URL로 이동



#### Out 객체

웹 브라우저로 HTML 코드를 출력하는 기능

- PrintWriter처럼 스트림 형태로 데이터를 출력하는 클래스는 송신측과 수신측 사이에 가상의 통로를 만든다. out 내장 객체는 이 통로를 관리하는 변수이다.
- page 지시자의 BufferAttribute를 이용하면 출력 버퍼의 크기를 바꿀 수 있다. BufferAttribute는 버퍼의 크기를 kb 단위의 정수로 써야 하며, kb라는 단위 표시를 붙여 써야 한다.