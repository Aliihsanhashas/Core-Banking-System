CREATE TABLE loan
(
    id                BIGSERIAL PRIMARY KEY,   -- Otomatik olarak artan birincil anahtar
    account_number    VARCHAR(50)    NOT NULL, -- Hesap numarası
    loan_amount       DECIMAL(15, 2) NOT NULL, -- Kredi miktarı
    creation_date     TIMESTAMP      NOT NULL, -- Kredi oluşturulma tarihi
    due_date          TIMESTAMP      NOT NULL, -- Geri ödeme tarihi
    status            VARCHAR(50)    NOT NULL, -- Durum, 'P', 'A', 'R' gibi değerlerle depolanabilir (Pending, Approved, Repaid)
    interest_rate     DECIMAL(5, 2)  NOT NULL, -- Faiz oranı
    remaining_balance DECIMAL(15, 2) NOT NULL  -- Kalan bakiye
);