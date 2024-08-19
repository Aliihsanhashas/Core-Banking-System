CREATE TYPE loan_status AS ENUM ('PENDING', 'APPROVED', 'REJECTED', 'ACTIVE', 'CLOSED');
CREATE TABLE loan
(
    id                  BIGSERIAL PRIMARY KEY,
    loan_number         VARCHAR(255)   NOT NULL UNIQUE,
    amount              DECIMAL(19, 4) NOT NULL,
    balance             DECIMAL(19, 4) NOT NULL,
    account_holder_name VARCHAR(255)   NOT NULL,
    start_date          TIMESTAMP      NOT NULL,
    end_date            TIMESTAMP,
    status              loan_status    NOT NULL -- Enum türünü burada kullanıyoruz
);
