CREATE TABLE transaction
(
    id                 BIGSERIAL PRIMARY KEY,                -- Otomatik artan birincil anahtar
    transaction_number VARCHAR(255)   NOT NULL UNIQUE,       -- Benzersiz işlem numarası
    transaction_type   VARCHAR(50)    NOT NULL,              -- VARCHAR türü kullanılarak işlem türü
    amount             DECIMAL(20, 2) NOT NULL,              -- İşlem tutarı
    from_account       VARCHAR(255)   NOT NULL,              -- Gönderen hesap numarası
    to_account         VARCHAR(255)   NOT NULL,              -- Alıcı hesap numarası
    transaction_date   TIMESTAMP      NOT NULL DEFAULT NOW() -- İşlem tarihi, varsayılan olarak şu anki tarih
);