#뇌를 자극하는 

- 웹 브라우저 에서 url을 넘겨주면 웹서버에서 html을 반환해준다 이때 웹서버가 html 문서를 생성하는 프로그램을 호출(웹어플리케이션)하는 방법을 동적html문서 라고 하며 그냥 반환해주는 경우를 정적html문서라고 한다

- 현재는 웹서버에 모듈인 웹 애플리케이션 형태를 사용한다.

- 서블릿은 자바중심코드에 html이 들어간 것이고  jsp는 html 중심의 코드 구조이므로 현재는 둘은 혼용해서 사용한다

- 프로그램의 복잡한 로직을 구사하는 코드는 서블릿 클래스안에 기술하고, 프로그램의 결과를 보여주는 html 중심의 코드는 jsp에 기술


- web.xml 작성하기
- post와 get의 차이 이해하기

		Get은 가져오는 것이고 Post는 수행하는 것이다  라는 틀을 이해
		get은 서버에서 어떤 데이터를 가져와서 보여준다거나 하는 용도
		post는 서버의 값이나 상태를 바꾸기 위해서 사용
		


##jsp

- jsp 페이지에 있는 html코드는 웹브라우저로 그대로 전달되지만 jsp 문법의 코드는 웹컨테이너 쪽에서 실행되고 그 결과만 웹 브라우저로 전송

- jsp페이지 ->변환->서블릿 클래스의 소스 코드->서블릿 클래스의 클래스 파일->인스턴스화->서블릿 객체->초기화->서블릿



###jsp 문법의 3가지 형태

- % %>

		지시자 와 스트립팅 요소로 나뉘어짐 // 자바코드활용


- ${} %= >

		익스프레션 언어 // 웹 디자이너의 이해를 위해
		
- jsp:forward> c:if>

		액션이라고 부름 // 최근엔 스트립팅 요소를 전혀 쓰지 않고 액션과 익스프레션언어로만 작상하는 방법을 권장한다.
		
		
		
##


- 지시자 
	
		%@page, include, taglib 애트리뷰트_목록 %> 
		
		

##jsp 내장변수

- request

		getparameter메서드로 데이터 가져오기
- out

		printf , println 사용
		
- response

		sendRedirect 사용하여 현재 실행중인 jsp페이지 중단 하고 다른 웹 자원 호출
		

- application

		getContextPath() : url경로명을 리턴하는 메소드
		getRealPath() : 절대 경로명55 
		
		

#sendRedirect와 forward의 차이

- forward

		- 같은 웹 서버 같은 웹 어플리케이션 디렉터리에 속하는 웹 자원만 호출할 수 있다
		- request 내장 변수를 통해 데이터를 전달한다
		
		상대적 장점
		- 같은 웹 서버안에 있는 jsp페이지를 직접 호출하기 때문에 자원이 절약되고 빠르다
		- 네트워크 회선을 거치지 않고 데이터를 전달하여 보안이 우수하다

		
		
- sendRedirect

		- 다른 웹 서버에 있는 자원도 호출이 가능하다
		- 호출할 jsp 페이지의 url뒤에 데이터를 붙여서 전달한다

		상대적 장점
		- 웹페이지를 다른곳으로 이동한 다음에 사용자들을 새로운 url로 유도할 때 유용하게 사용될 수 있다
		- 새로고침 버튼을 눌었을 때 일어나는 같은 동작의 중복을 막기 위해 효과적으로 사용된다
	
	
	
#04 쿠키와 세션

- 웹컴포넌트는 jsp페이지와 서블릿 클래스를 통칭

- 웹 컴포넌트가 데이터를 주고받고록 하기 위해서 쿠키와 세션이 필요하다

- 둘의 가장 큰 차이는 저장장소 , 보안의 문제로 세션의 사용을 선호하지만 둘다 적절하게 사용함

##쿠키

데이터를 브라우저에 저장!!

Cookie cookie = new Cookie(이름, 값)
response.addcookie(cookie);

-  쿠기문은 html코드보다 위에 오는것이 바람직하다

		
		데이터 읽기
		Cookie[] cookie = request.getCookie;
		
		삭제
		cookie.setMaxAge(int);   int값이 0 이면 즉시삭제 -1이면 브라우저 종료시 삭제
		
		특정경로 전송
		
		cookie.setPath()
		cookie.setDomain() 



##세션

데이터를 웹 서버에 저장!!

- 서블릿에서오 jsp에서의 사용법이 다름

서블릿

		세션 시작
		HttpSession session = request.getSession();
		session.setAttribute(이름,값);
		
		값 가져오기 
		*  object 타입으로 리턴되기 때문에 캐스트가 필요
 		String string = (String) session.getAttribute(이름);
 		
 		삭제
 		session.removeAttribute(이름)
 		
 		세션종료
 		session.invalidate();
 		
 		* 강제로 세션종료를 하지않아도 일정시간 후에 종료 하지만 메모리가 낭비됨
 		


jsp

		getSession이 자동으로 추가되어 바로 session객체를 사용가능
		
		강제로 세션을 사용하지 않는 방법
		%@page session="false"%>
		
		나머지는 서블릿과 일치
		


## url 재작성 메커니즘

세션 기술에서도 세션아이디를 쿠키형태로 전송하는데  그 쿠키의 이름은 JSESSIONID 이다.

하지만 쿠키를 사용할 수 없는 웹 환경에서는 url 재작성 매커니즘을 사용한다.

이는 url 뒤에 세션아이디를 붙여서 보내는 방식으로


response.encodeURL("url.jsp") 의 형태로 사용한다



##05 익셉션 처리

- jsp

%@page --- ----- --- --   inErrorPage="true"%>  exception내장 변수를 활성화 시키는 코드이다

% response.setStatus(200) %>
 http 상태코드를 고정하여 일정한 에러발생결과를 얻을 수 있다
 
 에러메세지는 exception.getMessage()를 통하여 자세한 에러 메세지를 얻을수 있다
 
 
 
 수행페이지에서는 지시자에 errorPage="--.jsp"를 작성함으로써 에러발생시 해당페이지로 이동한다
 
 
- 서블릿

서블릿의 경우 web.xml에

error-page>
	exception-type>404 or  java.lang.NullPointException /exception-type>
	location>---.jsp/location>
/error-page>		
		





#06 서블릿 라이프 사이클

서블릿 클래스 -인스턴스화> 서블릿 객체 -초기화> 서블릿 - 웹브라우저 호출 > 마무리 제거


이 과정 중 서블릿 객체를 생성하고 초기화하는 단계 인스턴스화와 초기화 단계는 컴퓨터 자원을 많이 사용하므로 부담이 커 만들어진 서블릿을 메몰에 남겨두었다가 요청시 호출하여 사용한다.


 초기화 작업과 마무리 작업때의 동작을 정의하는 방법
 
 서블릿- init 메소드 / destroy 메소드
 
 jsp - jspInit 메소드  / jspDestroy 메소드
 
 
 ##서블릿 초기화 파라미터
 
 서블릿의 초기화 작업에 필요한 데이터를 의미
 
 web.xml에 다음 형태로 저장하여 이름을 불러와서 사용할 수 있다.
 
		init-param>
			param-name>name/>
			param-value>value/>
		/init-param>
		
		
		
##서블릿이 환경을 표현하는 ServletContext객체

ServletContext context = getServletContext();

로 객체를 만들어서 불러올 수 있다

jsp에서는 application. 을 통해서 바로 불러올 수 있다.


* application.log();를 통해서 로그 호출 및 저장도 가능하다




# 07 익스프레션 언어

${식} 과 같은 형태로 사용하며 이를  EL식이라고 한다.

${ 식1 }과 %= 식2 %> 은 같아보이지만 안에 식의 의미가 다르다

식2의 경우 자바 프로그래밍 언어의 변수 이름이지만 식1의 경우 애트리뷰트의 이름으로 해석된다.

식에서는 데이터, 데이터+연산, 정적 메소드 호출 3가지가 들어갈 수 있다.



##정적 메소드 el함수로 등록하는 법

taglib 작성 -> web.xml에 등록

prefix :  접두어 설정


#08 표준 액션

xml기술을 이용해 기존 jsp 문법을 확장하는 메커니즘을 액션이라고 하며 이는 표준 액션과 커스텀 액션으로 나뉜다 표준은 jsp페이지에서 바로 사용이 가능하며 커스텀 액션은 별도의 라이브러리를 설치해야지만 사용이 가능하다.

구분방법은 표준 액션은 jsp:---->으로 시작하며 커스텀은 접두어가 다르다.


표준액션

- jsp:include page="--.jsp"/>
- jsp:forward page="--.jsp"/>
- 자바 빈


자바빈

- 시작  jsp:useBean id="obj" class=""/>
		
		scope=" " 을 이용해서 자바빈 객체의 생존 범위를 지정하는 애트리뷰트 page, session, request, application 데이터 영역에 저장되도록 지시한다
		
- 값 저장 jsp : setAttribute name="obj" property="" value=""/>

		웹브라우저로부터 입력된 데이털르 설정하는 방법으로는 value대신 param을 사용하여 값을 받는다 단, param 과 value는  동시에 사용이 불가능하다.
		
		애트리뷰트를 모두 쓰지 않고 입력된 모든 데이터가 똑같은 이름을 갖는 자바빈 프로퍼티에 설정되는 방법은  property="*"로 지정하면 된다.
		
- 값 호출 jsp : getAttribute name="" property""/>













