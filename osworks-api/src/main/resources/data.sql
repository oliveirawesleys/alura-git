INSERT INTO Cliente(id, nome, email, telefone) VALUES(1, 'Joao', 'joao@email.com', '(11) 2323-1111');
INSERT INTO Cliente(id, nome, email, telefone) VALUES(2, 'Maria', 'maria@email.com', '(21) 1122-5566');

INSERT INTO ordem_servico(id, cliente_id, descricao, preco, status, data_abertura, data_finalizacao) VALUES(1, 1, 'Bola de futebol', 25, 'ABERTA', 20200810, 20200819);
INSERT INTO ordem_servico(id, cliente_id, descricao, preco, status, data_abertura, data_finalizacao) VALUES(2, 2, 'Bola de futebol', 25, 'ABERTA', 20200810, 20200819);

INSERT INTO Comentario(id, ordem_servico_id, descricao, data_envio) VALUES(2, 2, 'Pedido efetuado.', 20200803);
