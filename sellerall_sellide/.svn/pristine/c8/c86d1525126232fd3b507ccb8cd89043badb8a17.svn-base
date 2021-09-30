-----------------------------------------------------------------------------------
---------------------------------- 계정 생성 및 권한 처리 ------------------------------
-----------------------------------------------------------------------------------
mysql -u root -p 
elepdl14154
--root 계정 접속
use mysql;
create user sellerall@localhost identified by 'elepdl14154';
create user 'sellerall'@'%' identified by 'elepdl14154';

select user, host ,authentication_string from user;

--사용자 계정 삭제
--drop user sellerall@localhost;
--drop user 'sellerall'@'%';

create database glc default character set utf8; --DB 생성됨
create database sellerall_yyh default character set utf8; --DB 생성됨
create database sellerall_hhe default character set utf8; --DB 생성됨
--DB 스키마 정보 확인
--SELECT default_character_set_name, DEFAULT_COLLATION_NAME FROM information_schema.SCHEMATA WHERE schema_name = "gls";


-- 권한 부여 
--ex) grant all privileges on test.* to userid@'%' identified by '비밀번호';
grant all privileges on glc.* to sellerall@'%';  				--모든 원격지에서 접속 권한 추가 
grant all privileges on glc.* to sellerall@localhost;			--gls 데이터 베이스 모든 테이블에 대한 권한 부여
grant select, insert, update on glc.* to sellerall@localhost;	--gls 데이터베이스 모든 테이블에 select, insert, update 권한 부여
-- user 에게 모든 데이터베이스 모든 테이블에 권한 부여 (전역 권한은 모두 광범위한 보안문제가 수반되므로 권한을 허용하는 경우 신중해야 함)
-- grant all privileges on *.* to sellerall@localhost identified by '비밀번호' with grant option;
flush privileges;     -- 변경된 내용을 메모리에 반영(권한 적용)

grant all privileges on sellerall.* to sellerall@'%';  				--모든 원격지에서 접속 권한 추가 
grant all privileges on sellerall.* to sellerall@localhost;			--gls 데이터 베이스 모든 테이블에 대한 권한 부여
grant select, insert, update on sellerall.* to sellerall@localhost;	--gls 데이터베이스 모든 테이블에 select, insert, update 권한 부여
-- ALTER USER 'sellerall'@'%' IDENTIFIED WITH mysql_native_password BY 'elepdl14154';  --클라이언트 프로그램에서 mysql 패스워드 플러그인 "caching_sha2_password"을 소화하지 못해서 오류가 생길경우
-- user 에게 모든 데이터베이스 모든 테이블에 권한 부여 (전역 권한은 모두 광범위한 보안문제가 수반되므로 권한을 허용하는 경우 신중해야 함)
-- grant all privileges on *.* to sellerall@localhost identified by '비밀번호' with grant option;
flush privileges;     -- 변경된 내용을 메모리에 반영(권한 적용)

grant all privileges on sellerall_yyh.* to sellerall@'%';  				--모든 원격지에서 접속 권한 추가 
grant all privileges on sellerall_yyh.* to sellerall@localhost;			--gls 데이터 베이스 모든 테이블에 대한 권한 부여
grant select, insert, update, delete on sellerall_yyh.* to sellerall@localhost;	--gls 데이터베이스 모든 테이블에 select, insert, update 권한 부여
-- ALTER USER 'sellerall'@'%' IDENTIFIED WITH mysql_native_password BY 'elepdl14154';  --클라이언트 프로그램에서 mysql 패스워드 플러그인 "caching_sha2_password"을 소화하지 못해서 오류가 생길경우
-- user 에게 모든 데이터베이스 모든 테이블에 권한 부여 (전역 권한은 모두 광범위한 보안문제가 수반되므로 권한을 허용하는 경우 신중해야 함)
-- grant all privileges on *.* to sellerall@localhost identified by '비밀번호' with grant option;
flush privileges;     -- 변경된 내용을 메모리에 반영(권한 적용)

grant all privileges on sellerall_hhe.* to sellerall@'%';  				--모든 원격지에서 접속 권한 추가 
grant all privileges on sellerall_hhe.* to sellerall@localhost;			--gls 데이터 베이스 모든 테이블에 대한 권한 부여
grant select, insert, update, delete on sellerall_hhe.* to sellerall@localhost;	--gls 데이터베이스 모든 테이블에 select, insert, update 권한 부여
-- ALTER USER 'sellerall'@'%' IDENTIFIED WITH mysql_native_password BY 'elepdl14154';  --클라이언트 프로그램에서 mysql 패스워드 플러그인 "caching_sha2_password"을 소화하지 못해서 오류가 생길경우
-- user 에게 모든 데이터베이스 모든 테이블에 권한 부여 (전역 권한은 모두 광범위한 보안문제가 수반되므로 권한을 허용하는 경우 신중해야 함)
-- grant all privileges on *.* to sellerall@localhost identified by '비밀번호' with grant option;
flush privileges;     -- 변경된 내용을 메모리에 반영(권한 적용)

--사용자에게 부여된 권한 확인
SHOW GRANTS FOR sellerall@localhost;  -- userid 와 host명까지 붙여서 검색해야 함
SHOW GRANTS FOR sellerall@'%';
SELECT Host,User,plugin,authentication_string FROM mysql.user;

--revoke all on DB명.테이블명 from 사용자ID;     // 모든 권한을 삭제
-----------------------------------------------------------------------------------
-------------------------------------테이블 생성 -------------------------------------
-----------------------------------------------------------------------------------
CREATE TABLE sellerall.`tb_user_info` (
  `user_seq` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '사용자 번호',
  `user_id` varchar(80) NOT NULL COMMENT '사용자 아이디',
  `user_pwd` char(128) NOT NULL COMMENT '사용자 비밀번호',
  `user_token` char(32) DEFAULT NULL COMMENT '사용자 임시 발급 토큰',
  `auth_code` char(8) NOT NULL DEFAULT '0000' COMMENT '권한 코드',
  `use_yn` char(1) NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
  `note` varchar(50) DEFAULT NULL COMMENT '비고',
  `crt_name` varchar(50) NOT NULL COMMENT '생성자 이름',
  `crt_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성 일시',
  `upt_name` varchar(50) NOT NULL COMMENT '수정자 이름',
  `upt_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '수정 일시',
  PRIMARY KEY (`user_seq`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='사용자 정보';

CREATE TABLE sellerall.`tb_partner` (
  `PARTNER_IDX` int NOT NULL AUTO_INCREMENT COMMENT '거래처INDEX',
  `PARTNER_CD` varchar(10) NOT NULL COMMENT '거래처코드',
  `PARTNER_NM` varchar(20) NOT NULL COMMENT '거래처명',
  `PARTNER_URL` varchar(200) DEFAULT NULL COMMENT '거래처URL',
  `PRODUCT_URL` varchar(200) DEFAULT NULL COMMENT '상품URL',
  `ORDER_URL` varchar(200) DEFAULT NULL COMMENT '주문URL',
  `LOGIN_URL` varchar(200) DEFAULT NULL COMMENT '로그인URL',
  `ORDER_NUM` varchar(2) DEFAULT NULL COMMENT '정렬순서',
  PRIMARY KEY (`PARTNER_IDX`),
  UNIQUE KEY `TM_PARTNER_UI01` (`PARTNER_CD`)
) ENGINE=MyISAM AUTO_INCREMENT=223 DEFAULT CHARSET=utf8 COMMENT='거래처정보'

CREATE TABLE sellerall.`tb_product` (
  `PROD_IDX` int NOT NULL AUTO_INCREMENT COMMENT '사용자상품INDEX',
  `USER_ID` varchar(50) NOT NULL COMMENT '사용자아이디',
  `PARTNER_CD` varchar(10) NOT NULL COMMENT '거래처코드',
  `PROD_CD` varchar(50) NOT NULL COMMENT '상품코드',
  `PROD_NM` varchar(255) NOT NULL COMMENT '상품명',
  `CATEGORY_CD` varchar(50) NOT NULL COMMENT '카테고리코드',
  `CATEGORY_L_CD` varchar(50) DEFAULT NULL COMMENT '카테고리코드대',
  `CATEGORY_L_NM` varchar(50) DEFAULT NULL COMMENT '카테고리코드대',
  `CATEGORY_M_CD` varchar(50) DEFAULT NULL COMMENT '카테고리코드중',
  `CATEGORY_M_NM` varchar(50) DEFAULT NULL COMMENT '카테고리코드중',
  `CATEGORY_S_CD` varchar(50) DEFAULT NULL COMMENT '카테고리코드소',
  `CATEGORY_S_NM` varchar(50) DEFAULT NULL COMMENT '카테고리코드소',
  `UPROD_NM` varchar(255) DEFAULT NULL COMMENT '사용자수정상품명',
  `WDM_CD` varchar(50) DEFAULT NULL COMMENT '왕도매 카테고리 코드',
  `GMK_CD` varchar(50) DEFAULT NULL COMMENT 'G마켓 카테고리 코드',
  `AUC_CD` varchar(50) DEFAULT NULL COMMENT '옥션 카테고리 코드',
  `EST_CD` varchar(50) DEFAULT NULL COMMENT '11번가 카테고리 코드',
  `ITP_CD` varchar(50) DEFAULT NULL COMMENT '인터파크 카테고리 코드',
  `STP_CD` varchar(50) DEFAULT NULL COMMENT '스토어팜 카테고리 코드',
  `COU_CD` varchar(50) DEFAULT NULL COMMENT '쿠팡 카테고리 코드',
  `PROD_PRICE` int DEFAULT NULL COMMENT '상품가격',
  `UPROD_PRICE` int DEFAULT NULL COMMENT '사용자상품가격',
  `USALE_PRICE` int DEFAULT NULL COMMENT '사용자판매가격',
  `CONSUMER_PRICE` int DEFAULT NULL COMMENT '소비자가격',
  `UCONSUMER_PRICE` int DEFAULT NULL COMMENT '사용자소비자가격',
  `CONSUMER_YN` varchar(1) NOT NULL COMMENT '가격자율여부(Y:준수, N:자율)',
  `DELI_FLAG` varchar(1) NOT NULL COMMENT '배송구분(H:선/착불, F:무료, G:착불, S:선불)',
  `UDELI_FLAG` varchar(1) DEFAULT NULL COMMENT '사용자배송구분(H:선/착불, F:무료, G:착불, S:선불)',
  `DELI_PRICE` int DEFAULT NULL COMMENT '배송비',
  `UDELI_PRICE` int DEFAULT NULL COMMENT '사용자배송비',
  `RETURN_YN` varchar(1) NOT NULL COMMENT '반품여부',
  `URETURN_YN` varchar(1) DEFAULT NULL COMMENT '사용자반품여부',
  `URETURN_PRICE` int DEFAULT NULL COMMENT '사용자반품배송비',
  `URETURN_PLACE` varchar(10) DEFAULT NULL COMMENT '사용자반품배송지코드(오너클랜제공)',
  `MADE_PLACE` varchar(50) DEFAULT NULL COMMENT '원산지',
  `UMADE_PLACE` varchar(50) DEFAULT NULL COMMENT '사용자원산지',
  `MAKER` varchar(50) DEFAULT NULL COMMENT '제조사',
  `BRAND` varchar(50) DEFAULT NULL COMMENT '브랜드',
  `UBRAND` varchar(50) DEFAULT NULL COMMENT '사용자브랜드',
  `MODEL` varchar(50) DEFAULT NULL COMMENT '모델명',
  `LIST_IMG` varchar(255) NOT NULL COMMENT '리스트이미지',
  `ULIST_IMG` varchar(255) DEFAULT NULL COMMENT '사용자리스트이미지',
  `CONTENT` mediumtext COMMENT '상세설명',
  `UCONTENT` mediumtext COMMENT '사용자상세설명',
  `UINTRO` mediumtext COMMENT '사용자상단설명',
  `L_OPTION_CNT` int COMMENT '옵션개수',
  `L_OPTION` text COMMENT '옵션',
  `UL_OPTION` text COMMENT '사용자옵션',
  `L_OPTION_PRICE` text COMMENT '옵션가격',
  `UL_OPTION_PRICE` text COMMENT '사용자옵션가격',
  `BOX_QTY` int DEFAULT NULL COMMENT '묶음수량',
  `UBOX_QTY` int DEFAULT NULL COMMENT '사용자묶음수량',
  `UKEYWORD` text COMMENT '사용자키워드',
  `PROD_STATUS` varchar(1) DEFAULT NULL COMMENT '상품상태(1:정상, 8:품절)',
  `ADULT_YN` varchar(1) DEFAULT NULL COMMENT '성인용품여부',
  `UADULT_YN` varchar(1) DEFAULT NULL COMMENT '사용자성인용품여부',
  `TAX_YN` varchar(1) NOT NULL COMMENT '과세여부',
  `USE_YN` varchar(1) NOT NULL COMMENT '사용여부',
  `AUTH_INFO1` varchar(255) DEFAULT NULL COMMENT '인증정보1',
  `AUTH_INFO2` varchar(255) DEFAULT NULL COMMENT '인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품)',
  `AUTH_INFO3` varchar(255) DEFAULT NULL COMMENT '인증정보3',
  `REG_DATE` datetime NOT NULL COMMENT '등록일',
  `REG_NAME` varchar(50) NOT NULL COMMENT '등록아이디',
  `UPT_DATE` datetime DEFAULT NULL COMMENT '수정일',
  `UPT_NAME` varchar(50) DEFAULT NULL COMMENT '수정아이디',

  `SH_EXPLAN` mediumtext DEFAULT NULL COMMENT '짧은설명',
  `AS_FLAG` varchar(50) DEFAULT NULL COMMENT 'A/S가능여부',
  `DELI_AREA` varchar(50) NOT NULL COMMENT '배송가능지역',
  `DELI_AREA_EXPLAN` varchar(50) DEFAULT NULL COMMENT '배송가능지역추가설명',
  `PRICE_SUB` varchar(50) DEFAULT NULL COMMENT '가격대체문구',
  `INVEN_TYPE` varchar(50) NOT NULL COMMENT '재고적용타입(0:무제한, 1:한정)',
  `INVEN_CNT` int DEFAULT NULL COMMENT '재고수량',
  `INVEN_NT_CNT` int DEFAULT NULL COMMENT '재고통보수량',
  `MIN_ORDER_LIMIT` int DEFAULT NULL COMMENT '최소주문한도',
  `MAX_ORDER_LIMIT` int DEFAULT NULL COMMENT '최대주문한도',
  `RESERVES` varchar(100) DEFAULT NULL COMMENT '적립금',
  `SALES_ST_DATE` varchar(50) DEFAULT NULL COMMENT '판매기간 시작일 (YYYY-MM-DD)',
  `SALES_ED_DATE` varchar(50) DEFAULT NULL COMMENT '판매기간 종료일 (YYYY-MM-DD)',
  `IMPO_LEVEL` varchar(50) NOT NULL COMMENT '구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)',
  `PRICE_OPEN` varchar(50) NOT NULL COMMENT '가격공개(0:사용안함, 1:사용함)',
  `DELI_TYPE` varchar(50) NOT NULL COMMENT '배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송)',
  `DELI_PAY` varchar(50) NOT NULL COMMENT '배송비결제 (0: 선불, 1:착불)',
  `IMG_EN_TYPE` varchar(50) NOT NULL COMMENT '이미지등록방식(0:직접 업로드, 1:URL 입력)',
  `IMG_1` varchar(255) DEFAULT NULL COMMENT '이미지1',
  `IMG_2` varchar(255) DEFAULT NULL COMMENT '이미지2',
  `IMG_3` varchar(255) DEFAULT NULL COMMENT '이미지3',
  `IMG_4` varchar(255) DEFAULT NULL COMMENT '이미지4',
  `IMG_5` varchar(255) DEFAULT NULL COMMENT '이미지5',
  `IMG_6` varchar(255) DEFAULT NULL COMMENT '이미지6',
  `ADMIN_MEMO` mediumtext DEFAULT NULL COMMENT '관리자메모',  
  PRIMARY KEY (`PROD_IDX`),
  UNIQUE KEY `M001_PRODUCT_UI01` (`PARTNER_CD`,`PROD_CD`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='사용자상품정보';

CREATE TABLE sellerall.`tb_category` (
  `CATEGORY_IDX` int NOT NULL AUTO_INCREMENT COMMENT '카테고리INDEX',
  `PARTNER_CD` varchar(4) NOT NULL COMMENT '거래처코드',
  `CATEGORY_CD` varchar(50) NOT NULL COMMENT '카테고리코드',
  `CATEGORY_NM` varchar(255) NOT NULL COMMENT '카테고리명',
  `REG_DATE` datetime NOT NULL COMMENT '등록일',
  `UPT_DATE` datetime NOT NULL COMMENT '수정일',
  `USE_YN` varchar(1) DEFAULT 'Y' COMMENT '사용유무',
  PRIMARY KEY (`CATEGORY_IDX`),
  UNIQUE KEY `M001_CATEGORY_UI01` (`PARTNER_CD`,`CATEGORY_CD`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='카테고리정보';


CREATE TABLE sellerall.`tb_product_option` (
  `OPTION_IDX` int NOT NULL AUTO_INCREMENT COMMENT '옵션INDEX',
  `PARTNER_CD` varchar(10) NOT NULL COMMENT '거래처코드',
  `PROD_CD` varchar(50) NOT NULL COMMENT '상품코드',
  `OPTION_NM` varchar(50) NOT NULL COMMENT '옵션명',
  `OPTION_ITEM_CD` varchar(100) DEFAULT NULL COMMENT '옵션항목코드',
  `OPTION_ITEM_NM` varchar(100) DEFAULT NULL COMMENT '옵션항목명',
  `OPTION_PRICE` int DEFAULT NULL COMMENT '옵션가격',
  `INVEN_CNT` int DEFAULT NULL COMMENT '재고수량',
  `INVEN_NT_CNT` int DEFAULT NULL COMMENT '통보수량',
  `OPTION_FORM` varchar(1) DEFAULT '0' COMMENT '옵션형식',
  `TOP_OPTION_FLAG` varchar(1) DEFAULT 'N' COMMENT '상위옵션플래그',
  `TOP_OPTION_CD` varchar(100) DEFAULT NULL COMMENT '상위옵션코드',
  `TOP_OPTION_NM` varchar(100) DEFAULT NULL COMMENT '상위옵션명',
  `REG_DATE` datetime NOT NULL COMMENT '등록일',
  `UPT_DATE` datetime NOT NULL COMMENT '수정일',
  `USE_YN` varchar(1) DEFAULT 'Y' COMMENT '사용여부',
  PRIMARY KEY (`OPTION_IDX`),
  FOREIGN KEY (PROD_CD) REFERENCES sellerall.`tb_product`(PROD_CD),
  UNIQUE KEY `M001_OPTION_UI01` (`PARTNER_CD`,`PROD_CD`,`OPTION_NM`,`OPTION_ITEM_CD`,`OPTION_ITEM_NM`)
) ENGINE=MyISAM AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='상품옵션정보';


`RESERVES` varchar(100) DEFAULT NULL COMMENT '적립금',
 -- alter table sellerall.`tb_product` add `CATEGORY_L_CD` varchar(50) DEFAULT NULL COMMENT '카테고리코드대',
 -- alter table sellerall.`tb_product` modify `RESERVES` varchar(100) DEFAULT NULL COMMENT '적립금',