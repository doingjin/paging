# paging
게시글 댓글 페이징처리
0915> 좋아요 기능 구현 (대신 로그인한 유저만 사용 가능)
      게시글에 댓글이 하나도 없을 때 작성된 댓글 없다고 나타나게 함
      굵직한 기능 custom tag로 묶어서 보관
      
0916> 총 게시글 수만큼까지만 더보기 a tag 나타나게 구현함!
      오른쪽에 광고 사진 3개 부착 with css-float
      ol_li 삭제하고 왼쪽 상단 로고 이미지 넣고 로그인 기능 오른쪽 상단으로 옮김
       (이것도 float로)
       hr 색 바꿈
       Post 테이블에 안쓰는 컬럼인 comcnt 제거하고 PostVO에만 변수로 보관
       main.jsp 안에 있던 내부 스타일 시트를 외부 스타일 시트로 바꿈
0924> control.jsp =>> FrontController & Action.java 파일로 다 변경!!
      Action명.do로 받아서 FrontController에서 분배
