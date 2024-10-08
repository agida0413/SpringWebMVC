# SpringWebMVC_advanced
> [!TIP]
>
> 1. 웹 애플리케이션 이해
> 2. 서블릿
> 3. 서블릿, jsp,mvc 패턴
> 4. mvc 프레임워크 제작
> 5. mvc 구조 이해
> 6. mvc 심화
> 7. mvc 웹 페이지 제작 

# 스프링 아키텍처 



> [!NOTE]
>
> 1. **Request** : 클라이언트 요청
>
> 2. **DispatcherServlet**  : 모든 요청을 수신
>
> 3. **HandlerMapping **: 빈에 등록된 handler에 맞는 객체 반환 (url 패턴) 
>
>    = >  존재하지 않으면 EXCEPTION
>
>    **3-1 . 인터셉터 prehandle 호출** 
>
> 4. **HandlerAdapter** :  RequestMappingHandlerAdapter 등 타입에 맞는 adapter 선택 
>
>    **4-1. ArgumentResolver 호출** : 실제 컨트롤러(핸들러) 에 맞는 매개변수 세팅 
>
>    **4-2. HttpMessageConverter 호출** : String , Json ,바이트 등 변환이 필요할 때  타입에 맞게 변환 해준다. 
>
>    **4-3 .handle 메소드 수행** 
>
> 5. **실제 handler 및 로직 수행** 
>
>    **5 - 1 . 뷰 템플릿 반환 시 ModelAndView 객체 반환** 
>
>    ​	**5 - 1 - 1.  ViewResolver 가 Model을 랜더링 후 실제 View를 클라이언트에게 반환** 
>
>    **5 - 2 . Http 메시지 바디에 데이터를 전송하는 경우** 
>
>    ​	**5 - 2 - 1 . returnValueHandler 수행 : 반환 값 세팅** 
>
>    ​	**5 - 2 - 2 . MessageConverter 수행 : 반환 값 변환 필요 시 Json,String 등 타입으로 변환**    
>
>    ​	**5 - 2 - 3 . 데이터 반환** 

****
