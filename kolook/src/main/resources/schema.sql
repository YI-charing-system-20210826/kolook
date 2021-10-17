/* カスタマーテーブル */
CREATE TABLE IF NOT EXISTS customer (
  customer_id INTEGER(10) NOT NULL PRIMARY KEY UNIQUE KEY -- ユーザID
  , last_name VARCHAR(128) NOT NULL --姓
  , first_name VARCHAR(2128) NOT NULL -- 名
  , last_name_Kana VARCHAR(128) NOT NULL -- セイ
  , first_name_Kana VARCHAR(128) NOT NULL -- メイ
  , gender CHAR(1) NOT NULL -- 性別
  , birthday DATE NOT NULL -- 生年月日
  , tel_no INTEGER NOT NULL -- 電話番号
  , email VARCHAR(100) --メールアドレス
  , post_no INTEGER(7) NOT NULL -- 郵便番号
  , ken_code VARCHAR(4) NOT NULL -- 都道府県
  , address VARCHAR(128) NOT NULL -- 市区町村
  , address_detail VARCHAR(128) NOT NULL -- 番地以降
  , remarks VARCHAR(300)  -- 備考欄
  , contract_flg INTEGER(2)  -- 契約フラグ
);

/* 従業員テーブル */
CREATE TABLE IF NOT EXISTS employee (
  member_id INTEGER(10) NOT NULL PRIMARY KEY UNIQUE KEY
  , last_name VARCHAR(128) NOT NULL --姓
  , first_name VARCHAR(2128) NOT NULL -- 名
  , last_name_Kana VARCHAR(128) NOT NULL -- セイ
  , first_name_Kana VARCHAR(128) NOT NULL -- メイ
  , emp_status VARCHAR(128) NOT NULL
  , section VARCHAR(128) NOT NULL
  , position VARCHAR(128) NOT NULL
  , tel_no INTEGER NOT NULL -- 電話番号
  , email VARCHAR(100) --メールアドレス
  , post_no INTEGER(7) NOT NULL -- 郵便番号
  , ken_code VARCHAR(4) NOT NULL -- 都道府県
  , address VARCHAR(128) NOT NULL -- 市区町村
  , address_detail VARCHAR(128) NOT NULL -- 番地以降
  , birthday DATE NOT NULL -- 生年月日
  , gender CHAR(1) NOT NULL -- 性別
  , join_at INTEGER(2) --入社日
  , leave_at INTEGER(2) --退社日
  , role INTEGER NOT NULL --管理権限
  , password VARCHAR(8) NOT NULL --パスワード
  , member_img VARCHAR(255) --アイコン
  , created_at DATE --登録日時
  , updated_at DATE --更新日時
  , last_login DATE --最終ログイン日時
);