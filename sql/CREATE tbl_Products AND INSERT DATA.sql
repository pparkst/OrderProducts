CREATE TABLE [dbo].[tbl_Products](
	[no] [int] NOT NULL,
	[type] [varchar](7) NOT NULL,
	[name] [nvarchar](200) NOT NULL,
	[price] [money] NOT NULL,
	[stockCnt] [int] NOT NULL
) ON [PRIMARY]
GO



INSERT INTO tbl_Products VALUES (89506,'EVENT',N'[선주문예약상품] 비스트킹덤 MEA-018SP 스파이더맨 / 아이언맨 베놈버젼 미니에그어택',37000,500)
INSERT INTO tbl_Products VALUES (89505,'EVENT',N'[선주문예약상품] 비스트킹덤 토이스토리 "햄" 저금통',99000,500)
INSERT INTO tbl_Products VALUES (89504,'EVENT',N'[10일 8시 마감] [code10] 코드텐 방수 롤탑백',99000,0)
INSERT INTO tbl_Products VALUES (89503,'EVENT',N'[선주문예약상품] 비스트킹덤 토이스토리 "알린" 저금통',99000,500)
INSERT INTO tbl_Products VALUES (89502,'PRODUCT',N'피스포츠 X 라이크라스포츠 맨즈 매직 스페이스 드로즈 10종 세트',25900,200)
INSERT INTO tbl_Products VALUES (89501,'EVENT',N'[10일 8시 마감] POUT 알루미늄 노트북 거치대 EYES4',29900,497)
INSERT INTO tbl_Products VALUES (89500,'PRODUCT',N'젠틀맨 우산',23000,1500)
INSERT INTO tbl_Products VALUES (89499,'EVENT',N'[선주문예약상품] 비스트킹덤 토이스토리 "렉스" 저금통',99000,500)
INSERT INTO tbl_Products VALUES (89498,'PRODUCT',N'체리 MC 9620 FPS 스나이퍼 마우스',79000,99)
INSERT INTO tbl_Products VALUES (89497,'EVENT',N'[선주문예약상품] 비스트킹덤 DS-069 스타크래프트2 짐 레이너 10주년 피규어',43000,489)
INSERT INTO tbl_Products VALUES (89496,'EVENT',N'[선주문예약상품] 비스트킹덤 DS-070 스타크래프트2 사라 케리건 10주년 피규어',43000,491)
INSERT INTO tbl_Products VALUES (89495,'EVENT',N'[얼리버드특가] 1NMC 리넨 루즈핏 헨리넥 쿨 셔츠',53000,90)
INSERT INTO tbl_Products VALUES (89494,'PRODUCT',N'1NMC 리넨 루즈핏 헨리넥 쿨 셔츠',59000,90)
INSERT INTO tbl_Products VALUES (89493,'PRODUCT',N'하이브리드 홈시스템 루미르 H',65800,986)
INSERT INTO tbl_Products VALUES (89492,'PRODUCT',N'체리 MX 3.0S 블랙 게이밍 기계식 키보드',89000,100)
INSERT INTO tbl_Products VALUES (89491,'EVENT',N'[10일 8시 마감] 파우트 휴대용 접이식 알루미늄 노트북 거치대 EYES3 ANGLE',19900,500)
INSERT INTO tbl_Products VALUES (89490,'PRODUCT',N'모락 모쿠 마우스 손목 받침대',7600,50)
INSERT INTO tbl_Products VALUES (89489,'EVENT',N'[리미티드 10일 8시 마감] 언리미트 베이직 로고 티셔츠 6종',10000,100)
INSERT INTO tbl_Products VALUES (89488,'EVENT',N'[10일 8시 마감] 코비 콘덴서 방송용 스탠드마이크',37900,494)
INSERT INTO tbl_Products VALUES (89487,'PRODUCT',N'기분내기 딱 좋은 핑크부탄&레몬부탄',7000,500)
INSERT INTO tbl_Products VALUES (89486,'PRODUCT',N'롯데알미늄 7L 멀티 제습기',179000,500)
INSERT INTO tbl_Products VALUES (89485,'PRODUCT',N'바람불어도 불타오르는 스토브',49900,1000)
INSERT INTO tbl_Products VALUES (89484,'PRODUCT',N'아이패드프로4세대 마그네틱 폴리오 스마트커버 케이스 / 11인치,12.9인치',23900,100)
INSERT INTO tbl_Products VALUES (89483,'PRODUCT',N'휴대용 스테리 모기 퇴치기',28900,50)


INSERT INTO tbl_Products VALUES (99998,'PRODUCT',N'Thread TEST 상품',37000,30)
INSERT INTO tbl_Products VALUES (99999,'PRODUCT',N'TEST 상품',37000,99999)