CREATE TABLE `profiles` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT 'PK.',
	`header`	BIGINT(11)	NULL	COMMENT '헤더 이미지 파일.',
	`nickname`	VARCHAR(255)	NULL	COMMENT '닉네임.',
	`photo`	VARCHAR(255)	NULL	COMMENT '프사.',
	`location`	VARCHAR(255)	NULL	COMMENT '거주지.',
	`website`	VARCHAR(255)	NULL	COMMENT '개인 웹사이트 주소.',
	`birth`	DATETIME	NULL	COMMENT '생년월일.',
	`introduce`	VARCHAR(255)	NULL	COMMENT '자기소개.',
	`modified_at`	DATETIME	NOT NULL	COMMENT '계정 정보 변경 일시. 기본값은 계정 생성일시'
);

CREATE TABLE `tweets` (
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT 'PK. 트윗 id.',
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '트윗 작성자의 id.',
	`circle`	BOOLEAN	NOT NULL	DEFAULT FALSE	COMMENT '서클 트윗 여부.',
	`content`	VARCHAR(255)	NULL	COMMENT '트윗의 글 내용.',
	`created_at`	DATETIME	NOT NULL	COMMENT '작성 시간.'
);

CREATE TABLE `messages` (
	`id`	BIGINT(11)	NOT NULL	COMMENT '해당 DM 객체의 id.',
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`created_at`	DATETIME	NULL	COMMENT 'DM 인스턴스가 생성된 시각.'
);

CREATE TABLE `medias` (
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT '해당 컬럼이 속한 트윗의 id',
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '트윗 작성자의 id',
	`filename`	VARCHAR(255)	NULL	COMMENT '파일 명칭. front-end 단위에서 파일명 복호화 후 CREATE.',
	`format`	VARCHAR(255)	NULL	COMMENT '확장자.',
	`created_at`	DATETIME	NULL	COMMENT '작성일자.'
);

CREATE TABLE `blocks` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 해당 리스트의 사용자.',
	`block_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 블락 된 사용자.',
	`blocked_at`	DATETIME	NULL	COMMENT '블락 일시.'
);

CREATE TABLE `follows` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '해당 팔로우 리스트의 사용자.',
	`follow_id`	BIGINT(11)	NULL	COMMENT '팔로우 중인 사용자.',
	`friend`	BOOLEAN	NOT NULL	DEFAULT FALSE	COMMENT '맞팔 여부 체크.'
);

CREATE TABLE `lists` (
	`id`	BIGINT(11)	NOT NULL,
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 해당 리스트의 사용자.',
	`member`	BIGINT(11)	NULL	COMMENT 'FK. 해당 리스트에 있는 사용자.',
	`title`	VARCHAR(255)	NULL	DEFAULT ""	COMMENT '리스트 명칭. UNIQUE 처리.',
	`open`	BOOLEAN	NOT NULL	DEFAULT TRUE	COMMENT '공개 여부.',
	`listed_at`	DATETIME	NOT NULL	COMMENT '리스트 생성 일시.'
);

CREATE TABLE `bookmarks` (
	`id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT 'PK. 트윗 id.',
	`marked_at`	DATETIME	NOT NULL	COMMENT '북마크 된 일시.'
);

CREATE TABLE `account_status` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호.',
	`open`	BOOLEAN	NULL	DEFAULT TRUE	COMMENT '계정 비공개 여부.',
	`banned`	BOOLEAN	NULL	DEFAULT FALSE	COMMENT '계정이 정지됐는지 여부.',
	`verified`	BOOLEAN	NULL	DEFAULT FALSE	COMMENT '인증 여부.',
	`premium_verifed`	BOOLEAN	NULL	DEFAULT FALSE	COMMENT '파란 딱지.'
);

CREATE TABLE `logins` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`password`	VARCHAR(255)	NULL,
	`log_in_at`	TIMEDATE	NULL,
	`log_out_at`	TIMEDATE	NULL
);

CREATE TABLE `messages_contents` (
	`id`	VARCHAR(255)	NOT NULL,
	`dm_id`	VARCHAR(255)	NOT NULL	COMMENT 'DM 인스턴스',
	`content`	VARCHAR(255)	NULL	COMMENT '내용. 글 및 이것 저것.',
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`created_at`	VARCHAR(255)	NULL	COMMENT '작성일자'
);

CREATE TABLE `accounts` (
	`id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`account_id`	VARCHAR(255)	NOT NULL	COMMENT '계정 id.',
	`email`	VARCHAR(255)	NULL	COMMENT 'email 주소. 수정 가능.',
	`password`	VARCHAR(255)	NULL	COMMENT '비밀번호.',
	`pn`	TINYINT(11)	NULL	COMMENT '계정 전화번호.',
	`acc_created_at`	DATETIME	NOT NULL	COMMENT '계정 생성일시.'
);

CREATE TABLE `retweets` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT 'PK. 트윗 id.',
	`retweeted_at`	DATETIME	NOT NULL	COMMENT 'RT된 시간.',
	`referenced`	BOOLEAN	NULL	DEFAULT FALSE	COMMENT '인용RT 여부.'
);

CREATE TABLE `favorites` (
	`id`	BIGINT(11)	NOT NULL	COMMENT '계정 고유번호. LONG으로 입력',
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT '마음에 들어요!가 된 트윗의 id.',
	`favorited_at`	DATETIME	NOT NULL	COMMENT '마음에 들어요!가 된 시간.'
);

CREATE TABLE `mentions` (
	`twit_id`	BIGINT(11)	NOT NULL	COMMENT 'PK. 트윗 id.',
	`from_user`	BIGINT(11)	NOT NULL	COMMENT '트윗 작성자의 id.',
	`to_user`	BIGINT(11)	NOT NULL	COMMENT '멘션한 상대의 id.'
);

CREATE TABLE `notifications` (

);

CREATE TABLE `circles` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 해당 리스트의 사용자.',
	`member_id`	BIGINT(11)	NOT NULL	COMMENT '서클에 속한 사용자.'
);

CREATE TABLE `CopyOfmedias` (
	`content_id`	VARCHAR(255)	NOT NULL	COMMENT '해당 메시지의 아이디',
	`filename`	VARCHAR(255)	NULL	COMMENT '파일 명칭. front-end 단위에서 파일명 복호화 후 CREATE.',
	`format`	VARCHAR(255)	NULL	COMMENT '확장자.',
	`created_at`	DATETIME	NULL	COMMENT '작성일자.'
);

CREATE TABLE `reports` (
	`id`	VARCHAR(255)	NOT NULL,
	`category`	VARCHAR(255)	NULL,
	`Field2`	VARCHAR(255)	NULL,
	`Field3`	VARCHAR(255)	NULL,
	`Field4`	VARCHAR(255)	NULL
);

CREATE TABLE `mutes` (
	`origin_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 해당 리스트의 사용자.',
	`mute_id`	BIGINT(11)	NOT NULL	COMMENT 'FK. 뮤트 된 사용자.'
);

