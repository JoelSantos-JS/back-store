-- Inserir dados falsos para a tabela State
INSERT INTO State (name, initials, createdAt, updatedAt)
VALUES
    ('Alabama', 'AL', '2022-01-15 10:30:00', '2022-01-15 10:30:00'),
    ('Alaska', 'AK', '2022-02-20 12:45:00', '2022-02-20 12:45:00'),
    ('Arizona', 'AZ', '2022-03-25 14:15:00', '2022-03-25 14:15:00'),
    ('Arkansas', 'AR', '2022-04-10 09:20:00', '2022-04-10 09:20:00'),
    ('California', 'CA', '2022-05-05 08:10:00', '2022-05-05 08:10:00'),
    -- Adicione mais linhas conforme necessário
;

INSERT INTO City (name, createdAt, updatedAt, state_id)
VALUES
    ('City A', '2022-06-15 13:30:00', '2022-06-15 13:30:00', 1), -- 1 é o ID de Alabama
    ('City B', '2022-07-20 15:45:00', '2022-07-20 15:45:00', 2), -- 2 é o ID de Alaska
    ('City C', '2022-08-25 16:15:00', '2022-08-25 16:15:00', 3), -- 3 é o ID de Arizona
    ('City D', '2022-09-10 11:20:00', '2022-09-10 11:20:00', 4), -- 4 é o ID de Arkansas
    ('City E', '2022-10-05 09:10:00', '2022-10-05 09:10:00', 5)  -- 5 é o ID de California
    -- Adicione mais linhas conforme necessário
;
-- Inserir dados fictícios para a tabela Category
INSERT INTO Category (name, createdAt, updatedAt)
VALUES
    ('Category 1', '2022-01-15 10:30:00', '2022-01-15 10:30:00'),
    ('Category 2', '2022-02-20 12:45:00', '2022-02-20 12:45:00'),
    ('Category 3', '2022-03-25 14:15:00', '2022-03-25 14:15:00'),
    ('Category 4', '2022-04-10 09:20:00', '2022-04-10 09:20:00'),
    ('Category 5', '2022-05-05 08:10:00', '2022-05-05 08:10:00'),
    -- Adicione mais linhas conforme necessário
;

-- Inserir dados fictícios para a tabela Brand
INSERT INTO Brand (name, createdAt, updatedAt)
VALUES
    ('Brand A', '2022-01-15 10:30:00', '2022-01-15 10:30:00'),
    ('Brand B', '2022-02-20 12:45:00', '2022-02-20 12:45:00'),
    ('Brand C', '2022-03-25 14:15:00', '2022-03-25 14:15:00'),
    ('Brand D', '2022-04-10 09:20:00', '2022-04-10 09:20:00'),
    ('Brand E', '2022-05-05 08:10:00', '2022-05-05 08:10:00'),
    -- Adicione mais linhas conforme necessário
;
-- Inserir dados fictícios para a tabela Product
INSERT INTO Product (name, description, price, salePrice, category_id, createdAt, updatedAt)
VALUES
    ('Product 1', 'Description for Product 1', 50.00, 45.00, 1, '2022-01-15 10:30:00', '2022-01-15 10:30:00'),
    ('Product 2', 'Description for Product 2', 75.00, 65.00, 2, '2022-02-20 12:45:00', '2022-02-20 12:45:00'),
    ('Product 3', 'Description for Product 3', 30.00, 28.00, 3, '2022-03-25 14:15:00', '2022-03-25 14:15:00'),
    ('Product 4', 'Description for Product 4', 40.00, 36.00, 1, '2022-04-10 09:20:00', '2022-04-10 09:20:00'),
    ('Product 5', 'Description for Product 5', 60.00, 55.00, 2, '2022-05-05 08:10:00', '2022-05-05 08:10:00'),
    -- Adicione mais linhas conforme necessário
;
