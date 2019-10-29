# spring-boot-beginner

이 레포지토리는 스프링 부트를 이용한 RESTful API 를 구현하기 위한 레포지토리입니다.
요구사항은 아래와 같습니다.

## SpringBoot 프로젝트 생성
* [SpringBoot Initializr](https://start.spring.io/)를 이용합니다.
* 이 미션을 하기 위해 필요한 Dependency 는 SpringBoot Initializr 의 dependency 설정에서 추가할 수 있습니다.
  * Spring Web
  * Spring Data Jpa
* 필요한 의존성은 [MavenRepository](https://mvnrepository.com) 에서 검색하여 추가합니다.

## 요구사항

1. ``GET /delivery``

    * request query params
        * id (optional)
    
    * response
        1. id 가 없으면 모든 데이터를 반환
        2. id 가 있으면 해당 id 에 데이터를 반환

2. ``POST /delivery``

    * request body
        ```
        {
            "address": "delivery 주소",
            "orderer": "delivery 주문자",
            "menu": "주문한 메뉴"
        }
        ```
    
    * response data
        ```
        {
            "id": "1",
            "address": "서울시 송파구 루터회관 14층 우아한테크코스",
            "orderer": "루피",
            "menu": "삼계탕",
            "createdAt": "[timestamp]"
            "updatedAt": "[timestamp]"
        }
        ```

3. ``PATCH /delivery``

    * request body
        ```
        {
            "id": "변경할 id",
            "address": "변경할 주소"
        }
        ```
      
    * response data
        * ``200 OK``
        ```
        {
            "id": "1",
            "address": "변경된 주소",
            "orderer": "루피",
            "menu": "삼계탕",
            "createdAt": "[timestamp]"
            "updatedAt": "[timestamp_변경된_시간]"
        }
        ```
        * ``404 NOT FOUND``
        ```
        {
            "message": "문제가 발생하였습니다."
        }
        ```

4. ``DELETE /delivery``
    * request body
    ```
    {
        "id": "1"
    }
    ```
   
   * response data
       * ``200 OK``
       ```
       {
            "message": "배달이 완료되었습니다."
       }
       ```
       * ``404 NOT FOUND``
       ```
       {
            "message": "확인되지 않은 주문입니다."
       }
       ```

## 미션 수행

* 2일 마다 한번씩 오후 11시 PR 을 보냅니다.
* PR 의 메시지에는 이틀간 구현한 내용을 정리합니다.

## 참고 키워드

* SpringBoot RestController Annotation
* how to build json using GSON library
* [Spring Boot + Spring data JPA + MySQL](https://www.mkyong.com/spring-boot/spring-boot-spring-data-jpa-mysql-example/)

## 주의사항

* 구글링을 적극적으로 이용합니다.


