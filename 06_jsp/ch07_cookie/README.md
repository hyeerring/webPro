## [07] Cookie 쿠키

💡**쿠키란?**

- 웹브라우저에서 서버로 어떤 데이터를 요청하면, 서버측에서는 알맞은 로직을 수행한 후 데이터를 웹브라우저에 html형태로 응답한다. 그리고, 서버는 웹브라우저와의 관계를 종료한다(무상태서버 or 무상태 로직). 이렇게, 웹브라우저에 응답 후 관계를 끊는 것은 http프로토콜의 특징.
- 위처럼 연결이 끊겼을 때 어떤 정보를 **지속적으로 유지하기 위한 수단**으로 쿠키라는 방식을 사용
- 쿠키는 서버에서 생성하여, 서버가 아닌 클라이언트측에 특정 정보를 저장(txt 파일 형태나 db파일 형태로 저장)한다. 그리고 서버에 요청 할 때 마다 쿠키의 속성값을 참조 또는 변경 할 수 있다.
- 쿠키는 4kb로 용량이 제한적이며, 300개까지 데이터 정보를 가질 수 있다.



### Cookie 문법

1. **쿠키 생성**

```java
// 쿠키 생성
Cookie cookie = new Cookie("cookieName", "value");
// 쿠키값 재설정
cookie.setValue("changeValue");
// 유지시간 설정(초단위)
cookie.setMaxAge(60*2);
// 쿠키를 클라이언트로 전송
response.addCookie(cookie);
```

쿠키 클래스를 이용한 객체 생성 과정에서 생성자에서는 **new Cookie("쿠키 이름", "값")**을 넣어 생성해준다. 

세션과 마찬가지로 쿠키의 **유지 시간을 설정**해줄 수 있는데, `setMaxAge()` 메소드의 파라미터에 **초 단위**로 계산된다.

2. **쿠키 읽어오기**

`request.getCookies()`로 클라이언트에서 쿠키 정보를 배열 형태로 받아온다.

```java
Cookie[] cookies = request.getCookie(); // client에서 쿠키를 받아옴

if(cookies == null){
	out.println("생성된 쿠키가 없습니다.");
}else{
    for(int i = 0 ; i < cookies.length ; i++){
        String name = cookies[i].getName();
        String value = cookies[i].getValue();
        out.println("<h2>쿠키 이름 : " + name + "</h2>");
        out.println("<h2>쿠키 값 : " + value + "</h2>");
    }
}
```

3. **쿠키 삭제하기**

쿠키 삭제는 `setMaxAge()` 메소드를 사용해 유지 시간을 0으로 설정해 만료시키는 방법이 있다. 만약 특정 쿠키를 삭제하려면 if문으로 원하는 쿠키 이름을 리턴 받은 후 설정하시면 된다.

마지막으로 만료시킨 쿠키를 클라이언트에 전달한 후 마무리한다.

```java
Cookie[] cookies = request.getCookie();
String cookieName = "삭제하려는 쿠키 이름";

for(int i=0 ; i<cookies.length ; i++){
	if(cookies[i].getName().equals("cookieName")){
		cookies[i].setMaxAge(0); // 쿠키의 유효시간을 0초로 셋팅
		response.addCookie(cookies[i]);
		out.println("쿠키 삭제 성공");
	}
}
```

