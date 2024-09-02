CREATE TABLE account
(
    id                     BIGSERIAL PRIMARY KEY,
    account_number         VARCHAR(255)   NOT NULL UNIQUE,
    account_type           VARCHAR(255)   NOT NULL,
    balance                DECIMAL(20, 2) NOT NULL,
    account_holder_name    VARCHAR(255)   NOT NULL,
    account_holder_contact VARCHAR(255)   NOT NULL,
    is_closed              BOOLEAN        NOT NULL
);
