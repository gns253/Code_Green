# Code_Green
비건 쇼핑몰 사이트
### 소개

- 개발기간 2022. 10. 06 ~ 2022. 12. 07
- 샵인샵 방식의 식품 쇼핑몰 사이트
- 참여인원 6명
- 비건 쇼핑몰 사이트

![1](https://user-images.githubusercontent.com/114043149/209318907-65d54382-bfeb-4a89-9572-325300be43de.png)

## 💻개발 환경

- 개발언어 : **Java, JavaScript, HTML5, CSS3, jQuery, Ajax, JSTL, Bootstrap**
- 프레임 워크 : **Spring Legacy, MyBatis**
- 서버 : **ApacheTomcat 9.0**
- DB : **MySQL**
- IDE : **Spring Tools 4**
- 형상관리 : **GitHub**

## ⌨️상세내용

개발 기간 
    22.10.06 ~ 22.12.07

[베지터틀 비건 쇼핑몰_상세내용.pdf][포트폴리오_김영훈.pdf](https://github.com/gns253/Code_Green/files/10294339/_.pdf)


- **간트차트**
    ![2간트차트](https://user-images.githubusercontent.com/114043149/209319128-b2e41c1a-1ba0-4200-ab83-c12d6c0bcddc.png)

    
- **회의록**
    ![3](https://user-images.githubusercontent.com/114043149/209319170-5b310558-52ac-49d1-8a5d-b7d797aef3c4.png)

   
    
- **진행현황판**
    ![4](https://user-images.githubusercontent.com/114043149/209319207-04f440dc-9d7b-403a-a6d8-d62dcfceaa57.png)

 
    
- **DB**
    ![5](https://user-images.githubusercontent.com/114043149/209319215-292f5295-78e0-4899-a1fc-241d4a0187c7.png)

   
    

### 💾**회원가입 로그인**

- 아이디,메일 중복체크,유효성 검사
- 메일 인증 기능
- 네이버 로그인 API를 이용한 로그인 (검수필요)
- 다음지도 API 사용하여 조회 후 자동입력
- 회원 정보 수정 및 탈퇴 (탈퇴시 계정 비활성화)

![6](https://user-images.githubusercontent.com/114043149/209319238-ef1450a2-e8ca-47da-8112-e5106ad59064.png)![8](https://user-images.githubusercontent.com/114043149/209319319-98177226-4452-41e2-bc57-5b1608282bf1.png)![10](https://user-images.githubusercontent.com/114043149/209319335-36e93aeb-a175-4df2-9001-5835a6d0de47.png)

![7](https://user-images.githubusercontent.com/114043149/209319258-26a8c155-b19f-49eb-a0e0-2712834d6421.png)
![9](https://user-images.githubusercontent.com/114043149/209319312-00a5d884-fb7f-46a0-bd1b-3ea5336a2d9e.png)






### 📝**아이디 패스워드 찾기**

- 아이디, 패스워드 찾기를 위한 이메일 인증
- 이메일 인증을 통한 임시 비밀번호 발급

![11](https://user-images.githubusercontent.com/114043149/209319355-00e6d0a3-278e-40df-882a-b89afd7c4d4e.png)

![12](https://user-images.githubusercontent.com/114043149/209319360-e3ee7a5d-05a2-4f0e-bf14-1a395aff29c0.png)

![13](https://user-images.githubusercontent.com/114043149/209319366-ad1d84da-645c-4995-959b-2d3a312feb73.png)


### 💻장바구니 기능

- 카테고리별 게시판, 제품상세 정보에서 장바구니 담기
- 
- 장바구니 추가,수량변경,삭제에 대한 가격 변동과 아이콘 숫자 변화


![14](https://user-images.githubusercontent.com/114043149/209320028-54a3f596-69aa-4093-a84f-1ba77e5045b8.png)


![15](https://user-images.githubusercontent.com/114043149/209320036-6a2fada3-24cc-47b3-be2e-cc8efecc02e9.png)


![16](https://user-images.githubusercontent.com/114043149/209320045-1bf89a44-1078-4e7f-871c-6a84fbba4132.png)


### 힘들었던점,문제

- 문제

장바구니에 같은 상품을 담으면 장바구니에서 갯수가 증가하는게 아니라 같은 상품 목록이 새로 생기는 문제가 생겼다 

- 해결
    
    ON DUPLICATE KEY를 사용하여 중복시 UPDATE를 해주어 갯수만 늘릴 수 있는것을  MySQL workbench 를 통해 상품,회원,장바구니 번호에 복합키를 걸어 식별에 용이하게 하였다 
    

### 느낀 점과 향후 계획

- **S**pring을 배우기 시작하면서 시작했기 때문에 이해도가 부족했지만 Spring의 DI 처럼 편의성이 좋아 적응을 할 수 있었고 Spring에 대해 더 공부하여 Spring의 장점을 끌어올리고 싶었습니다
- 네이버 로그인은 아이디만 가져와 세션만 유지하게 만들었지만 기존계정과 연동하게끔 할 예정입니다 그리고 이를 바탕으로 카카오,페이스북,구글 등의 다양한 간편로그인도 구현 할 계획입니다
